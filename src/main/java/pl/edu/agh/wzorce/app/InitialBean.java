package pl.edu.agh.wzorce.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import java.io.Serializable;
import pl.edu.agh.wzorce.app.googleMapsParser.*;
@ManagedBean
@SessionScoped
public class InitialBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message = "Czesc zlamasy";
	private String userCity;
	private String userQuery;
	private int hoursFrom;
	private int hoursTo;
	
	
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserQuery() {
		return userQuery;
	}
	public void setUserQuery(String userQuery) {
		this.userQuery = userQuery;
	}
	public int getHoursFrom() {
		return hoursFrom;
	}
	public void setHoursFrom(int hoursFrom) {
		this.hoursFrom = hoursFrom;
	}
	public int getHoursTo() {
		return hoursTo;
	}
	public void setHoursTo(int hoursTo) {
		this.hoursTo = hoursTo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String result() {
		return "gowno";
	}
	public void runUserQuery(ActionEvent event) {
		System.out.println(userCity + userQuery);
		GoogleMapsParser tmp = new GoogleMapsParser(userCity, userQuery);
		tmp.startParsing();
	}

}
