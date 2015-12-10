package pl.edu.agh.wzorce.app.googleMapsParser;

class Day {
	
	public String nameOfDay;
	public String fromHour;
	public String toHour;
	
	Day(String _nameOfDay, String _fromHour, String _toHour) {
		this.nameOfDay = _nameOfDay;
		this.fromHour = _fromHour;
		this.toHour = _toHour;
	}
	
	Day(String _fromHour, String _toHour) {
		this.nameOfDay ="";
		this.fromHour = _fromHour;
		this.toHour = _toHour;
	}
	
	Day() {
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

class WeeklyHours {

	Day[] week = new Day[7]; 
	
	WeeklyHours(Day[] _week) {
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
		for (int i=0; i<7; i++)
			result.append(	week[i].toString()	);
				
		return result.toString(); 
	}	
}


class Place {
	
	public String name;
	public String address;
	public String phoneNumber;
	public WeeklyHours openingHours;
	public String rating;
	public String website;
	
	public Place(String name, String address, String phoneNumber, WeeklyHours openingHours, String rating, String website) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.openingHours = openingHours;
		this.rating = rating;
		this.website = website;		
	}
	
	public String toString() {
		return "Name: " +name + "\n" 
				+ "Address: " + address + "\n" 
				+ "Phone number: " + phoneNumber + "\n" 
				+ "Opening hours:\n " + openingHours.toString() + "\n" 
				+ "Rating: " + rating + "\n" 
				+ "Website: " + website + "\n" ;
	}
	
}