package pl.edu.agh.wzorce.app.place;

import java.io.Serializable;

public class Day implements Serializable {
	
	public String nameOfDay;
	public String fromHour;
	public String toHour;
	
	public Day(String _nameOfDay, String _fromHour, String _toHour) {
		this.nameOfDay = _nameOfDay;
		this.fromHour = _fromHour;
		this.toHour = _toHour;
	}
	
	public Day(String _fromHour, String _toHour) {
		this.nameOfDay ="";
		this.fromHour = _fromHour;
		this.toHour = _toHour;
	}
	
	public Day() {
		this.nameOfDay = "";
		this.fromHour = "";
		this.toHour = "";
	}
	
	public String toString() {
		return "\t" + 
				nameOfDay + ": " 
				+ fromHour + "-" 
				+ toHour +"\n";			
	}			
}