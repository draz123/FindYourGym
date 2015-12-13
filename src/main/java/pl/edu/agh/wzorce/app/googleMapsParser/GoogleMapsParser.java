package pl.edu.agh.wzorce.app.googleMapsParser;

import java.util.*;

public class GoogleMapsParser {

	private String city;
	private String query;
	/*TODO OGARNAC CZYSZCZENIE LISTY PRZY ZMIANIE DANYCH!!!!!!!!*/
	private static ArrayList<Place> placeList;
	public static boolean flag = false;
	
	public GoogleMapsParser(String _city, String _query) {
		this.city = _city;
		this.query = _query;
	}
	
	public void startParsing() {
		PlaceListRequester plr = new PlaceListRequester(city, query);
		ArrayList<String> placeIdList = plr.getIdList();			
		
//		for (String s: placeIdList) 
//			System.out.println(s);
		
		for (int i=0; i<20;i++) {
			PlaceDetailsRequester pdr = new PlaceDetailsRequester(city, query, placeIdList.get(i) );
			Place currentPlace = pdr.getPlaceDetails();
			placeList = new ArrayList<Place>();
			placeList.add(currentPlace);
			System.out.println(currentPlace.toString()+"\n\n");
			System.out.println("obecenie flaga = " + flag);
		}			
	}
	
	public static ArrayList<Place> getList() {
		return placeList;
	}
}
