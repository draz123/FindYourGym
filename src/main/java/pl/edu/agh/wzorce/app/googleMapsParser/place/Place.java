package pl.edu.agh.wzorce.app.googleMapsParser.place;

public interface Place {
    
    public String getName();
    
    public String getAddress();
    
    public String getHours();
    
    public String getRating();
    
    public String getWebsite();
    
    public String getCoordinates();
    
    public String getDescription();
    
    public WeeklyHours getOpeningHours();
    
    public String toString();
    
}