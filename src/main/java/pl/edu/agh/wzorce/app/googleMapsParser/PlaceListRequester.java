package pl.edu.agh.wzorce.app.googleMapsParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

class PlaceListRequester extends Builder {
	
	protected String city = null;
	protected String query = null;
	private ArrayList<String> idList = null;
	// TO-DO - next/previous page jumping
	private String nextPageToken = null;
	private int pageNumber;
	
	public PlaceListRequester(String _city, String _query, int _pageNumber) {
		
		this.city = _city;
		this.query = _query;
		this.idList = new ArrayList<String>();
		this.outputFormat = "json";
		this.pageNumber = _pageNumber;
	}
	
	public void buildJSONProcesser() throws JSONException {
		
		JSONArray jsonResults = jsonResponse.getJSONArray("results");
		nextPageToken = (String)jsonResponse.get("next_page_token");
		
		for (int i=0; i<jsonResults.length(); i++) {
			String singleResult = (String)jsonResults.getJSONObject(i).get("place_id");
			idList.add(singleResult.toString());			
		}
	}

	public void buildURL() throws MalformedURLException {
		
		String searchText = city+"+"+query.replace(' ', '+');
		String params;
		
		if (this.pageNumber == 0) {
			params = "query=" + searchText
						+"&key=" + key;						
		} else {
			params = "query=" + searchText
					+"&key=" + key
					+"&nextpage=" + nextPageToken;	
		}		
		
		this.url =  new URL("https://maps.googleapis.com/maps/api/place/textsearch/"
						+outputFormat
						+"?"
						+params);	
	}	
	
	public ArrayList<String> getIDList() {
		return idList;
	}
}