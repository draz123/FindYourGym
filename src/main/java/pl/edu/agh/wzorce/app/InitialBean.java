package pl.edu.agh.wzorce.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import java.io.Serializable;
import pl.edu.agh.wzorce.app.googleMapsParser.*;
@ManagedBean
@SessionScoped
public class InitialBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message = "Czesc zlamasy";
	private String userCity;
	private String userQuery;
	private int hoursFrom;
	private int hoursTo;
	private boolean listNotEmpty = false;
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
//	public String result() {
//		return "gowno";
//	}
	public void runUserQuery(ActionEvent event) {
		System.out.println(userCity +" "+ userQuery);
		if(userCity!=null && userCity!="" && userQuery!="" && userQuery!=null){
			GoogleMapsParser tmp = new GoogleMapsParser(userCity, userQuery);
			tmp.startParsing();
			this.listNotEmpty = true;
//			if(tmp.getList().get(1).openingHours.getDay(1).fromHour!="" && tmp.getList().get(1).openingHours.getDay(1).fromHour!=null)

			System.out.println(PlaceSorter.sort(tmp.getList(),hoursFrom,hoursTo).toString());
		}
		
		System.out.println("Godziny: "+ hoursFrom + " " + hoursTo);
		System.out.println("obecnie interesujaca nas flaga = " + this.listNotEmpty);
	}
	
	public boolean isListNotEmpty() {
		return listNotEmpty;
	}
	
	public void setListNotEmpty(boolean listNotEmpty) {
		this.listNotEmpty = listNotEmpty;
	}

}
