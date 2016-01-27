package pl.edu.agh.wzorce.app.googleMapsParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

abstract class Builder {

	protected String outputFormat = "json";
	protected final String key = "AIzaSyD1GpXkz6W-GOVC6xUtLdX13OIoMy5_KtU";
	protected URL url =null;
	protected JSONObject jsonResponse = null;
	
	abstract public void buildURL() throws MalformedURLException;
	
	abstract protected void buildJSONProcesser() throws JSONException;	
	
	public void sendQuery() {

		try {
			String response = getStringResponse( this.url );
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