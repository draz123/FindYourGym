package pl.edu.agh.wzorce.app.place;

import java.io.Serializable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Json2PlaceAdapter implements Place, Serializable {
    static final long serialVersionUID = -4989659586970989521L;
    public String name;
    public String address;
    public String phoneNumber;
    public WeeklyHours openingHours;
    public String rating;
    public String website;
    public String longitude;
    public String latitude;
    private String description;

    public Json2PlaceAdapter(JSONObject result) throws JSONException {
        Day[] week = getWeeklyHours(result);
        JSONObject locationResult = 
                result.getJSONObject("geometry").getJSONObject("location");

        this.name = getPlaceProperty("name", result);
        this.address = getPlaceProperty("formatted_address", result);
        this.phoneNumber = getPlaceProperty("formatted_phone_number", result);
        this.openingHours = new WeeklyHours(week);
        this.rating = getPlaceProperty("rating", result);
        this.website = getPlaceProperty("website", result);
        this.longitude = getPlaceProperty("lng", locationResult);
        this.latitude = getPlaceProperty("lat", locationResult);
        this.description = this.toString();
    }
    
    public String getName() {
        return name;
    }
    
    public WeeklyHours getOpeningHours() {
        return openingHours;
    }
    
    public String getCoordinates() {
        return this.latitude + ", " + this.longitude;
    }
      
    public String getDescription() {
        return this.description;
    }
      
    public String toString() {
        return "Name: " + name + "\n" 
            + "Address: " + address + "\n" 
            + "Phone number: " + phoneNumber + "\n" 
            + "Opening hours:\n " + openingHours.toString() + "\n" 
            + "Rating: " + rating + "\n" 
            + "Website: " + website + "\n" 
            + "Longitude: " + longitude + "\n"
            + "Latitude: " + latitude + "\n"; 
    }

    private String getPlaceProperty(String propertyName, JSONObject json) {
        String result;
        try {
            result = json.get(propertyName).toString();
        } catch (JSONException jE) {
            result = "";
        }
        
        return result;
    }

    private Day[] getWeeklyHours(JSONObject result) {
        Day[] week = new Day[7];
        JSONArray periods;
        try {
            periods = result.getJSONObject("opening_hours").getJSONArray("periods");
        } catch (JSONException e) {
            for (int i=0; i<7; i++) {
                week[i] = new Day();
            }
            return week;
        }
        
        for (int i=0; i<7; i++) {
            try {
                week[i] = new Day(
                    (String)periods.getJSONObject(i).getJSONObject("open").get("time"),
                    (String)periods.getJSONObject(i).getJSONObject("close").get("time")
                    );
            } catch (JSONException e) {
                week[i] = new Day();
            }
        }
        
        return week;
    }
    
}
