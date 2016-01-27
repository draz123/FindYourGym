package pl.edu.agh.wzorce.app.place;

import java.io.Serializable;

public class Place implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4989659586970989521L;
	public String name;
	public String address;
	public String phoneNumber;
	public WeeklyHours openingHours;
	public String rating;
	public String website;
	public String longitude;
	public String latitude;
	
	public Place(String _name, String _address, String _phoneNumber, WeeklyHours _openingHours, String _rating, String _website, String _longitude, String _latitude) {
		this.name = _name;
		this.address = _address;
		this.phoneNumber = _phoneNumber;
		this.openingHours = _openingHours;
		this.rating = _rating;
		this.website = _website;
		this.latitude = _latitude;
		this.longitude = _longitude;
	}
	
	public String getCoordinates() {
		return this.latitude + ", " + this.longitude;
	}
	
	public String toString() {
		return "Name: " +name + "\n" 
				+ "Address: " + address + "\n" 
				+ "Phone number: " + phoneNumber + "\n" 
				+ "Opening hours:\n " + openingHours.toString() + "\n" 
				+ "Rating: " + rating + "\n" 
				+ "Website: " + website + "\n" 
				+ "Longitude: " + longitude + "\n"
				+ "Latitude: " + latitude + "\n"; 
	}
	
}