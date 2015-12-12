package pl.edu.agh.wzorce.app.googleMapsParser;

import java.util.*;

public class GoogleMapsParser {

	private String city;
	private String query;
	
	public GoogleMapsParser(String _city, String _query) {
		this.city = _city;
		this.query = _query;
	}
	
	public void startParsing() {
		PlaceListRequester plr = new PlaceListRequester(city, query);
		ArrayList<String> placeIdList = plr.getIdList();			
		
		for (int i=0; i<20;i++) {
			
			PlaceDetailsRequester pdr = new PlaceDetailsRequester(city, query, placeIdList.get(i) );
			@SuppressWarnings("unused")
			Place place = pdr.getPlaceDetails();
			System.out.println(place.toString()+"\n\n");
		}			
	}
}
