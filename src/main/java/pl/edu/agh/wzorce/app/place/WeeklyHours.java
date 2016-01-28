package pl.edu.agh.wzorce.app.place;

import java.io.Serializable;

public class WeeklyHours implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1925656957938928978L;
	Day[] week = new Day[7]; 
	
	public Day getDay(int i){
		return week[i];
	}
	
	public WeeklyHours(Day[] _week) {
		week[0] = new Day("Sunday", _week[0].fromHour, _week[0].toHour);
		week[1] = new Day("Monday", _week[1].fromHour, _week[1].toHour);
		week[2] = new Day("Tuesday", _week[2].fromHour, _week[2].toHour);
		week[3] = new Day("Wednesday", _week[3].fromHour, _week[3].toHour);
		week[4] = new Day("Thursday", _week[4].fromHour, _week[4].toHour);
		week[5] = new Day("Friday", _week[5].fromHour, _week[5].toHour);
		week[6] = new Day("Saturday", _week[6].fromHour, _week[6].toHour);		
	}
	
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		for (int i=0; i<1; i++)
			result.append(	week[i].toString()	);
				
		return result.toString(); 
	}	
}
