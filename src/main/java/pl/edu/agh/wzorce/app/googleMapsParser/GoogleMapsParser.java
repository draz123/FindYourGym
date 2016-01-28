package pl.edu.agh.wzorce.app.googleMapsParser;

import java.util.*;

import pl.edu.agh.wzorce.app.PlaceSorter;
import pl.edu.agh.wzorce.app.place.Place;

/////// DESIGN PATTERN - SINGLETON
public final class GoogleMapsParser {
	
	private static class SingletonHolder {
		private static final GoogleMapsParser theOnlyInstance = new GoogleMapsParser();
	}
	
	private String city;
	private String query;
	
	//TO-DO zlikwidowac to
	public static boolean flag = false;
	
	private ArrayList<Place> placeList;
	private ArrayList<String> placeIdList;
	
	private int hoursFrom;
	private int hoursTo;
	
	private int pageNumber;
	private final int pageSize = 5;
	
	private Director dir;
	
	private GoogleMapsParser() {
		this.placeList = new ArrayList<Place>();
		this.placeIdList = new ArrayList<String>();

		dir = new Director();
	}
	
	public static GoogleMapsParser getInstance() {
		return SingletonHolder.theOnlyInstance;
	}
	
	public void setParameters(String _city, String _query, int _hoursFrom, int _hoursTo) {
		this.city = PolishLetterRemover.substitutePolishLettersWithNormal(_city);
		this.query = PolishLetterRemover.substitutePolishLettersWithNormal(_query);
		this.pageNumber = 0;
		this.hoursFrom = _hoursFrom;
		this.hoursTo = _hoursTo;	
	}
	
	public void startParsing() {

		if (!placeIdList.isEmpty()) {
			placeIdList.clear();
			placeList.clear();
		}
		obtain20Results();
		//obtain20Results();
				
	}
	
	private void obtain20Results() {	
		
		Builder placeListBuilder = new PlaceListRequester(city, query, pageNumber);
		
		///////// DESIGN PATTERN - BUILDER
		dir.setBuilder( placeListBuilder );
		dir.buildResult();
		
		placeIdList.addAll( (ArrayList<String>)(dir.getResult()) );
		Place tmpPlace;
		
		for ( int i=0 ; i< pageSize ; i++ ) {
		
			///////// DESIGN PATTERN - BUILDER
			Builder placeDetailsBuilder = new PlaceDetailsRequester( placeIdList.get(i+pageNumber*pageSize) );
			dir.setBuilder( placeDetailsBuilder );				
			dir.buildResult();

			tmpPlace = (Place)dir.getResult();			
			placeList.add(tmpPlace);
		}	
		
		pageNumber++;
		
		System.out.println("Przed sortem liczba miejsc: " + placeList.size());
		placeList = PlaceSorter.sort(placeList, hoursFrom , hoursTo );
		System.out.println("Po sorcie liczba miejsc: " + placeList.size());
		
	}
		
	public ArrayList<Place> getList() {
		return placeList;
	}
}
