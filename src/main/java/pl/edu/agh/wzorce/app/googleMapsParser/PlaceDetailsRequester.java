package pl.edu.agh.wzorce.app.googleMapsParser;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PlaceDetailsRequester extends Builder {
	
	private String placeId = null;
	private Place place = null;
	
	public PlaceDetailsRequester(String _city, String _query, String _placeId) {

		this.placeId = _placeId;

	}
	
	public Place getPlaceDetails() {
		
		try {		
			sendQuery();		
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return place;
				
	}
	
	public void buildJSONProcesser() throws JSONException {
		
		JSONObject result = jsonResponse.getJSONObject("result");
		Day[] week = getWeeklyHours(result);
		JSONObject locationResult = result.getJSONObject("geometry").getJSONObject("location");
				
		this.place = new Place(
					getPlaceProperty("name", result),
					getPlaceProperty("formatted_address", result),
					getPlaceProperty("formatted_phone_number", result),
					new WeeklyHours(week),
					getPlaceProperty("rating", result),
					getPlaceProperty("website", result),
					getPlaceProperty("lng", locationResult),
					getPlaceProperty("lat", locationResult)
				);		
	}

	private String getPlaceProperty(String propertyName, JSONObject json) {
		
		String result;
		try {
			result = json.get(propertyName).toString();
		} catch (JSONException jE) {
			result = "lel";
		}
		
		return result;
	}

	private Day[] getWeeklyHours(JSONObject result) {
		Day[] week = new Day[7];
		JSONArray periods;
		try {
			periods = result.getJSONObject("opening_hours").getJSONArray("periods");
		} catch (JSONException e) {
			for (int i=0; i<7; i++) {
				week[i] = new Day();
			}
			return week;
		}
		
		for (int i=0; i<7; i++) {
			try {
				week[i] = new Day(
						(String)periods.getJSONObject(i).getJSONObject("open").get("time"),
						(String)periods.getJSONObject(i).getJSONObject("close").get("time")
						);
			} catch (JSONException e) {
				
				week[i] = new Day();
			}
		}
		
		return week;
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