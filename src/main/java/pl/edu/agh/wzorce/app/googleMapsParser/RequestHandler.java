package pl.edu.agh.wzorce.app.googleMapsParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

abstract class RequestHandler {

	protected String city = null;
	protected String query = null;
	protected String outputFormat = null;
	protected final String key = "AIzaSyBMSpHVfdCYlzZALEVkcanN-w1qY2CoLkU";
	protected JSONObject jsonResponse = null;
	
	protected RequestHandler(String _city, String _query) {
		
		this.city = _city;
		this.query = _query;
		this.outputFormat = "json";
	}
	
	abstract protected URL formURL() throws MalformedURLException;
	
	abstract protected void jsonProcessing() throws JSONException;	
	
	protected void sendQuery(URL url) {

		try {
			
			String response = this.getStringResponse(url);
			this.jsonResponse = new JSONObject(response);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	protected String getStringResponse(URL url) throws IOException {
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		BufferedReader in = new BufferedReader(
		        					new InputStreamReader(
		        							con.getInputStream(), "UTF-8")
		        					);
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();	
		
		
		return response.toString();
	}	
	
	// to delete - debug only
	public JSONObject getJsonResponse() {
		return this.jsonResponse;
	}
}