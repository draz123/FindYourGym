package pl.edu.agh.wzorce.app;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pl.edu.agh.wzorce.app.googleMapsParser.*;
import pl.edu.agh.wzorce.app.googleMapsParser.place.Place;
 
@ManagedBean
@ViewScoped
public class CarouselView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Place> placesList;
    
    private Place selectedPlace;
     
//    @ManagedProperty("org.primefaces.showcase.service.CarService@b2e8c0")
//    private CarService service;
//     
//    @PostConstruct
//    public void init() {
//        placesList = GoogleMapsParser.getList();
//    }
  
    public List<Place> getPlacesList() {
        return placesList;
    }
 
//    public void setService(CarService service) {
//        this.service = service;
//    }
 
    public Place getSelectedPlace() {
        return selectedPlace;
    }
 
    public void setSelectedPlace(Place selectedPlace) {
        this.selectedPlace = selectedPlace;
    }
}