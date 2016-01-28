package pl.edu.agh.wzorce.app.strategy;

import pl.edu.agh.wzorce.app.googleMapsParser.GoogleMapsParser;

public class SearchEngineStrategy implements Strategy{
	private String userCity;
	private String userQuery;
	private int hoursFrom;
	private int hoursTo;
	
	public SearchEngineStrategy(String userCity,String userQuery,int hoursFrom,int hoursTo) {
		this.userCity=userCity;
		this.userQuery=userQuery;
		this.hoursFrom=hoursFrom;
		this.hoursTo=hoursTo;
	}
	GoogleMapsParser parser;
	@Override
	public void task() {
		parser = GoogleMapsParser.getInstance(); 
		parser.setParameters(userCity, userQuery, hoursFrom, hoursTo);
		parser.startParsing();
		
	}

	@Override
	public Object getResults() {
		return parser;
	}
	

}
