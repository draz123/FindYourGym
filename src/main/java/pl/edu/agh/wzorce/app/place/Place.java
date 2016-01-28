package pl.edu.agh.wzorce.app.place;

public interface Place {
    
    public String getName();
    
    public String getCoordinates();
    
    public String getDescription();
    
    public WeeklyHours getOpeningHours();
    
    public String toString();
    
}