package pl.edu.agh.wzorce.app.googleMapsParser;

import java.util.*;

import pl.edu.agh.wzorce.app.place.Place;

public class GoogleMapsParser {

	private String city;
	private String query;
	/*TODO OGARNAC CZYSZCZENIE LISTY PRZY ZMIANIE DANYCH!!!!!!!!*/
	private static ArrayList<Place> placeList = new ArrayList<Place>();
	public static boolean flag = false;
	
	public GoogleMapsParser(String _city, String _query) {
		this.city = PolishLetterRemover.substitutePolishLettersWithNormal(_city);
		this.query =PolishLetterRemover.substitutePolishLettersWithNormal(_query);
	}
	
	public void startParsing() {

		Director dir = new Director();
		dir.setBuilder( new PlaceListRequester(city, query) );
		dir.build();
		ArrayList<String> placeIdList = (ArrayList<String>)(dir.getResult());
		
		for ( int i=0; i<20; i++) {
		
			dir.setBuilder( 
					new PlaceDetailsRequester(
							city, query, placeIdList.get(i) 
							) 
					);
			dir.build();
			Place currentPlace = (Place)dir.getResult();

			placeList.add(currentPlace);
//			System.out.println(currentPlace.toString()+"\n\n");
//			System.out.println("obecenie flaga = " + flag);
		}			
	}
	
	public static ArrayList<Place> getList() {
		return placeList;
	}
}
