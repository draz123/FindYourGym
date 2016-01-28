package pl.edu.agh.wzorce.app.googleMapsParser;

import java.net.MalformedURLException;

import org.json.JSONException;

public class Director {
	
	public Builder builder;
	
	public Object result;
	
	public Director() {}
	
	public void setBuilder(Builder _builder) {
		this.builder = _builder;
	}
	
	public Object getResult() {
			
		if (builder instanceof PlaceListRequester) {
			return ((PlaceListRequester) builder).getIDList();
		}
		
		if (builder instanceof PlaceDetailsRequester) {
			return ((PlaceDetailsRequester) builder).getPlace();
		}
		
		return null;
	}

	public void buildResult() {
					
		try {
			builder.buildURL();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}			
		
		builder.sendQuery();
		
		try {
			builder.buildJSONProcesser();			
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
	}	
	
}


