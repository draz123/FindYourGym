package pl.edu.agh.wzorce.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import java.io.Serializable;
import java.util.List;

import pl.edu.agh.wzorce.app.googleMapsParser.*;
import pl.edu.agh.wzorce.app.place.Place;

@ManagedBean
@SessionScoped
public class InitialBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message = "Czesc zlamasy";
	private String userCity;
	private String userQuery;
	private int hoursFrom;
	private int hoursTo;
	private boolean listNotEmpty = false;
	private List<Place> ntlist_wyrzuc_pozniej;
	private String str1 = new String("");
	private String str2 = new String("");
	private String str3 = new String("");
	private String str4 = new String("");
	private String str5 = new String("");
//	private String str6 = new String("");
//	private String str7 = new String("");
//	private String str8 = new String("");
//	private String str9 = new String("");
//	private String str10 = new String("");
//	private String str11 = new String("");
//	private String str12 = new String("");
//	private String str13 = new String("");
//	private String str14 = new String("");
//	private String str15 = new String("");
//	private String str16 = new String("");
	private String cords = new String("");
	

	public String getCords() {
		return cords;
	}

	public void setCords(String cords) {
		this.cords = cords;
	}

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

	public List<Place> getNtlist_wyrzuc_pozniej() {
		return ntlist_wyrzuc_pozniej;
	}

	public void setNtlist_wyrzuc_pozniej(List<Place> ntlist_wyrzuc_pozniej) {
		this.ntlist_wyrzuc_pozniej = ntlist_wyrzuc_pozniej;
	}

	// public String result() {
	// return "gowno";
	// }
	public void runUserQuery(ActionEvent event) {
		System.out.println(userCity + " " + userQuery);
		GoogleMapsParser tmp = new GoogleMapsParser(userCity, userQuery, hoursFrom, hoursTo); //tutaj trzeba to przekaza jakos do instan
		tmp.startParsing();
		
		this.listNotEmpty = true;
		System.out.println("obecnie interesujaca nas flaga = " + this.listNotEmpty);
		ntlist_wyrzuc_pozniej = tmp.getList();
		System.out.println("ROZMIAR = " + ntlist_wyrzuc_pozniej.size());
		if(ntlist_wyrzuc_pozniej.size() > 0)
			this.str1 = ntlist_wyrzuc_pozniej.get(0).toString() + "\n";		//System.out.println("DUPA123: " + ntlist_wyrzuc_pozniej.get(0).toString());
		if(ntlist_wyrzuc_pozniej.size() > 1)
			this.str2 = ntlist_wyrzuc_pozniej.get(1).toString() + "\n";  	//System.out.println("DUPA1234: " + ntlist_wyrzuc_pozniej.get(1).toString());
		if(ntlist_wyrzuc_pozniej.size() > 2)
			this.str3 = ntlist_wyrzuc_pozniej.get(2).toString() + "\n";		//System.out.println("DUPA12345: " + ntlist_wyrzuc_pozniej.get(2).toString());
		if(ntlist_wyrzuc_pozniej.size() > 3)
			this.str4 = ntlist_wyrzuc_pozniej.get(3).toString() + "\n";
//		this.str5 = ntlist_wyrzuc_pozniej.get(4).toString() + "\n";
		this.cords = ntlist_wyrzuc_pozniej.get(0).latitude + ", " +  ntlist_wyrzuc_pozniej.get(0).longitude;
		System.out.println("kooooordy = " + this.cords);
//		this.str6 = ntlist_wyrzuc_pozniej.get(5).toString() + "\n";
//		this.str7 = ntlist_wyrzuc_pozniej.get(6).toString() + "\n";
//		this.str8 = ntlist_wyrzuc_pozniej.get(7).toString() + "\n";
//		this.str9 = ntlist_wyrzuc_pozniej.get(8).toString() + "\n";
//		this.str10 = ntlist_wyrzuc_pozniej.get(9).toString() + "\n";
//		this.str11 = ntlist_wyrzuc_pozniej.get(10).toString() + "\n";
//		this.str12 = ntlist_wyrzuc_pozniej.get(11).toString() + "\n";
//		this.str13 = ntlist_wyrzuc_pozniej.get(12).toString() + "\n";
//		this.str14 = ntlist_wyrzuc_pozniej.get(13).toString() + "\n";
//		this.str15 = ntlist_wyrzuc_pozniej.get(14).toString() + "\n";
//		this.str16 = ntlist_wyrzuc_pozniej.get(15).toString() + "\n";
	}

	public boolean isListNotEmpty() {
		return listNotEmpty;
	}

	public void setListNotEmpty(boolean listNotEmpty) {
		this.listNotEmpty = listNotEmpty;
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}
	
	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public String getStr3() {
		return str3;
	}

	public void setStr3(String str3) {
		this.str3 = str3;
	}

	public String getStr4() {
		return str4;
	}

	public void setStr4(String str4) {
		this.str4 = str4;
	}

	public String getStr5() {
		return str5;
	}
//
//	public void setStr5(String str5) {
//		this.str5 = str5;
//	}

//	public String getStr6() {
//		return str6;
//	}
//
//	public void setStr6(String str6) {
//		this.str6 = str6;
//	}
//
//	public String getStr7() {
//		return str7;
//	}
//
//	public void setStr7(String str7) {
//		this.str7 = str7;
//	}
//
//	public String getStr8() {
//		return str8;
//	}
//
//	public void setStr8(String str8) {
//		this.str8 = str8;
//	}
//
//	public String getStr9() {
//		return str9;
//	}
//
//	public void setStr9(String str9) {
//		this.str9 = str9;
//	}
//
//	public String getStr10() {
//		return str10;
//	}
//
//	public void setStr10(String str10) {
//		this.str10 = str10;
//	}
//
//	public String getStr11() {
//		return str11;
//	}
//
//	public void setStr11(String str11) {
//		this.str11 = str11;
//	}
//
//	public String getStr12() {
//		return str12;
//	}
//
//	public void setStr12(String str12) {
//		this.str12 = str12;
//	}
//
//	public String getStr13() {
//		return str13;
//	}
//
//	public void setStr13(String str13) {
//		this.str13 = str13;
//	}
//
//	public String getStr14() {
//		return str14;
//	}
//
//	public void setStr14(String str14) {
//		this.str14 = str14;
//	}
//
//	public String getStr15() {
//		return str15;
//	}
//
//	public void setStr15(String str15) {
//		this.str15 = str15;
//	}
//
//	public String getStr16() {
//		return str16;
//	}
//
//	public void setStr16(String str16) {
//		this.str16 = str16;
//	}

}