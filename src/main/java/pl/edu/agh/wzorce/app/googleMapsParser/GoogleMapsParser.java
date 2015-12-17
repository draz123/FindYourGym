package pl.edu.agh.wzorce.app.googleMapsParser;

import java.util.*;

import pl.edu.agh.wzorce.app.place.Place;

public class GoogleMapsParser {

	private String city;
	private String query;
	/*TODO OGARNAC CZYSZCZENIE LISTY PRZY ZMIANIE DANYCH!!!!!!!!*/
	private static ArrayList<Place> placeList;
	private static ArrayList<String> placeIdList;

	public static boolean flag = false;
	private int pageNumber;
	private final int pageSize = 20;
	private Director dir;
	
	public GoogleMapsParser(String _city, String _query) {
		this.city = PolishLetterRemover.substitutePolishLettersWithNormal(_city);
		this.query =PolishLetterRemover.substitutePolishLettersWithNormal(_query);
		this.placeList = new ArrayList<Place>();
		this.placeIdList = new ArrayList<String>();
		this.pageNumber = 0;
		dir = new Director();
	}
	
	public void startParsing() {

		obtain20Results();
		//obtain20Results();
		
		// TO-DO
		// Nbikod� zrobi przycisk Next Page i on ma znowu wywolac ponizsza metode:
		// obtain20Results();
		// kazde jej wywoalnie doda 20 id miejsc do placeIdList i 20 wynikow do placeList
		// WAZNE: przycisk ma DODAC wyswietlanie 20 kolejnych wynikow do juz wyswietlonych, a nie odswiezyc ekran tylko z 20 kolejnymi wynikami
		
	}
	
	private void obtain20Results() {
		
		// za�adowanie aplikacji  - wyswietlane pierwsze 20 wynik�w
		///////// DESIGN PATTERN - BUILDER
		dir.setBuilder( new PlaceListRequester(city, query, pageNumber) );
		dir.build();
		placeIdList.addAll( (ArrayList<String>)(dir.getResult()) );
		Place tmpPlace;
		
		for ( int i=0 ; i< pageSize ; i++ ) {
		
			///////// DESIGN PATTERN - BUILDER
			dir.setBuilder( 
					new PlaceDetailsRequester( city, query, placeIdList.get(i+pageNumber*pageSize) ));
			dir.build();

			tmpPlace = (Place)dir.getResult();
			/////////
			
			placeList.add(tmpPlace);
			System.out.println(tmpPlace.toString()+"\n\n");
			System.out.println("obecenie flaga = " + flag);
		}	
		
		pageNumber++;

		}			

	
	public static ArrayList<Place> getList() {
		return placeList;
	}
}
