package pl.edu.agh.wzorce.app.googleMapsParser;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pl.edu.agh.wzorce.app.googleMapsParser.builder.Builder;
import pl.edu.agh.wzorce.app.googleMapsParser.place.Day;
import pl.edu.agh.wzorce.app.googleMapsParser.place.Json2PlaceAdapter;
import pl.edu.agh.wzorce.app.googleMapsParser.place.Place;
import pl.edu.agh.wzorce.app.googleMapsParser.place.WeeklyHours;

public class PlaceDetailsRequester extends Builder {
	
	private String placeId = null;
	private Place place = null;
	
	public PlaceDetailsRequester(String _placeId) {
		this.placeId = _placeId;
	}
	
	public Place getPlaceDetails() {
		sendQuery();		
		return place;				
	}
	
    public void buildJSONProcesser() throws JSONException {
        
        JSONObject result = jsonResponse.getJSONObject("result");
        
        this.place = new Json2PlaceAdapter(result);
    }

	public void buildURL() throws MalformedURLException {
		
		String params = "placeid=" + placeId
						+ "&key=" + key;
		
		this.url =  new URL("https://maps.googleapis.com/maps/api/place/details/"
					+ outputFormat
					+ "?"
					+ params);
	}	
	
	public Place getPlace() {
		return place;
	}
	
}