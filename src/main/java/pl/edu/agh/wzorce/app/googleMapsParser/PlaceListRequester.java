package pl.edu.agh.wzorce.app.googleMapsParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

class PlaceListRequester extends RequestHandler {
	
	private ArrayList<String> idList = null;
	// TO-DO - next/previous page jumping
	//private String nextPageId = null;
	
	public PlaceListRequester(String _city, String _query) {
		
		super(_city, _query);
		this.idList = new ArrayList();
	}
	
	public ArrayList<String> getIdList() {
			
		try {
			
			sendQuery( formURL() );
			jsonProcessing();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return idList;
	}
	
	protected void jsonProcessing() throws JSONException {
		
		JSONArray jsonResults = jsonResponse.getJSONArray("results");
		//nextPageId = (String)jsonResponse.get("next_page_token");
		
		for (int i=0; i<jsonResults.length(); i++) {
			String singleResult = (String)jsonResults.getJSONObject(i).get("place_id");
			idList.add(singleResult.toString());			
		}
	}

	protected URL formURL() throws MalformedURLException {
		
		String searchText = city+"+"+query.replace(' ', '+');
		String params = "query=" + searchText
						+"&key=" + key;						
		
		return new URL("https://maps.googleapis.com/maps/api/place/textsearch/"
						+outputFormat
						+"?"
						+params);	
	}	
}