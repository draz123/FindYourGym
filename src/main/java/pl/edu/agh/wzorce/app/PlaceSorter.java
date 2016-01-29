package pl.edu.agh.wzorce.app;

import java.util.ArrayList;

import pl.edu.agh.wzorce.app.googleMapsParser.place.Place;

public class PlaceSorter {
		
	public static ArrayList<Place> sort(ArrayList<Place> input, int from, int to){
		ArrayList<Place> results=new ArrayList<Place>();
		System.out.println(input.size());
		System.out.println("From: "+from+"To:"+to);		
		for(Place p:input){
			if(!p.getOpeningHours().getDay(0).fromHour.isEmpty() && !p.getOpeningHours().getDay(0).toHour.isEmpty()){				
				if(results.isEmpty()){
					results.add(p);
				}
				else{
					findPlaceToAdd(p,results,from,to,0);
				}
			}
		}
		return results;
	}
	
	private static void findPlaceToAdd(Place p, ArrayList<Place> results,int from,int to,int place) {
		if(newIsBetter(results.get(results.size()-1),p,from,to) || (results.size()-1==place)){
			results.add(place, p);	
		}
		else{
			place++;
			findPlaceToAdd(p,results,from,to,place);
		}	
		
	}

	private static boolean newIsBetter(Place oldRecord, Place newRecord,int from,int to){
		return (absFrom(oldRecord,from)+absTo(oldRecord,to)<absFrom(newRecord,from)+absTo(newRecord,to));		
	}
		
	private static int absFrom(Place p,int from){
		if (from-(Integer.parseInt(p.getOpeningHours().getDay(0).fromHour)/100)<0){
			return Math.abs(from-Integer.parseInt(p.getOpeningHours().getDay(0).fromHour)/100);
		}
		else
			return Math.abs(from-(Integer.parseInt(p.getOpeningHours().getDay(0).fromHour)/100));
	}
	
	private static int absTo(Place p,int to){
		if (to-(Integer.parseInt(p.getOpeningHours().getDay(0).toHour)/100)<0){
			return Math.abs(to-Integer.parseInt(p.getOpeningHours().getDay(0).toHour)/100);
		}
		else
			return Math.abs(to-(Integer.parseInt(p.getOpeningHours().getDay(0).toHour)/100));
	}	

}
