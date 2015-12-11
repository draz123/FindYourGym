package pl.edu.agh.wzorce.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class InitialBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message = "Czesc zlamasy";
	private String userCity;
	private int hoursFrom;
	private int hoursTo;
	
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
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

}
