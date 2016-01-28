package pl.edu.agh.wzorce.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import pl.edu.agh.wzorce.app.strategy.EasterEggStrategy;
import pl.edu.agh.wzorce.app.strategy.SearchEngineStrategy;
import pl.edu.agh.wzorce.app.strategy.Strategy;
import java.io.Serializable;
import java.util.List;

import pl.edu.agh.wzorce.app.googleMapsParser.*;
import pl.edu.agh.wzorce.app.place.Place;

@ManagedBean
@SessionScoped
public class InitialBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Strategy strategy;
	private String userCity;
	private String userQuery;
	private int hoursFrom;
	private int hoursTo;
	private boolean listNotEmpty = false;
	private List<Place> ntlist_wyrzuc_pozniej;
	private List<Place> placeList;
	
	private transient DataModel dmPlaceList;
	private Place selectedPlace;
	private String cords = "36.171650, -115.146431";
	
	public DataModel getDmPlaceList() {
		return dmPlaceList;
	}

	public void setDmPlaceList(DataModel dmPlaceList) {
		this.dmPlaceList = dmPlaceList;
	}
	
	public Place getSelectedPlace() {
		return selectedPlace;
	}

	public void doSetSelectedPlace() {
		this.selectedPlace = (Place)dmPlaceList.getRowData();
		System.out.println("Najpierw kordynaty = " + this.getCords());
		String a = this.selectedPlace.getCoordinates();
		System.out.println("Nowe kordy = " + a);
		this.setCords(this.selectedPlace.getCoordinates());
	}

	public List<Place> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<Place> placeList) {
		this.placeList = placeList;
	}

	public String getCords() {
		return cords;
	}

	public void setCords(String cords) {
		this.cords = cords;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserQuery() {
		return userQuery;
	}

	public void setUserQuery(String userQuery) {
		this.userQuery = userQuery;
	}

	public int getHoursFrom() {
		return hoursFrom;
	}

	public void setHoursFrom(int hoursFrom) {
		this.hoursFrom = hoursFrom;
	}

	public int getHoursTo() {
		return hoursTo;
	}

	public void setHoursTo(int hoursTo) {
		this.hoursTo = hoursTo;
	}

	public List<Place> getNtlist_wyrzuc_pozniej() {
		return ntlist_wyrzuc_pozniej;
	}

	public void setNtlist_wyrzuc_pozniej(List<Place> ntlist_wyrzuc_pozniej) {
		this.ntlist_wyrzuc_pozniej = ntlist_wyrzuc_pozniej;
	}

	public void setStrategy(Strategy strategy){
		this.strategy=strategy;
	}
	
	public void runUserQuery(ActionEvent event) {
		System.out.println(userCity + " " + userQuery);
		if(userQuery.equals("wdwp")){
			setStrategy(new EasterEggStrategy());
		}
		else{
			setStrategy(new SearchEngineStrategy(userCity, userQuery, hoursFrom, hoursTo));
		}

		System.out.println(userCity + " " + userQuery);
		

		strategy.task();
		GoogleMapsParser parser = GoogleMapsParser.getInstance(); 
		parser.setParameters(userCity, userQuery, hoursFrom, hoursTo);
		parser.startParsing();
		
		this.listNotEmpty = true;
		System.out.println("obecnie interesujaca nas flaga = " + this.listNotEmpty);
		ntlist_wyrzuc_pozniej = parser.getList();
		
		this.setPlaceList(ntlist_wyrzuc_pozniej);
		this.setDmPlaceList(new ListDataModel(this.getPlaceList()));
		
		
		System.err.println("\n\n############## this.getPlaceList().size() = " + this.getPlaceList().size() + "\n\n");
		
		
		this.setCords(ntlist_wyrzuc_pozniej.get(0).getCoordinates());
		
		System.out.println("kooooordy = " + this.cords);
	}

	public boolean isListNotEmpty() {
		return listNotEmpty;
	}

	public void setListNotEmpty(boolean listNotEmpty) {
		this.listNotEmpty = listNotEmpty;
	}


}