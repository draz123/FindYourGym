package pl.edu.agh.wzorce.app.googleMapsParser;

import java.util.*;

public class GoogleMapsParser {

	private String city;
	private String query;
	
	GoogleMapsParser(String _city, String _query) {
		this.city = _city;
		this.query = _query;
	}
	
	public void main(String[] args) {
						
		PlaceListRequester plr = new PlaceListRequester(city, query);
		ArrayList<String> placeIdList = plr.getIdList();			
		
		for (int i=0; i<20;i++) {
			
			PlaceDetailsRequester pdr = new PlaceDetailsRequester(city, query, placeIdList.get(i) );
			Place place = pdr.getPlaceDetails();
			//System.out.println(place.toString()+"\n\n");
		}			
	}
}
