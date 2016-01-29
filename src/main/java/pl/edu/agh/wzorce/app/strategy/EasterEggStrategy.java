package pl.edu.agh.wzorce.app.strategy;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class EasterEggStrategy implements Strategy {

	@Override
	public void task() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("https://www.youtube.com/watch?feature=player_detailpage&v=ruhFmBrl4GM#t=11");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Easter egg");
	}

	@Override
	public Object getResults() {
		// TODO Auto-generated method stub
		return null;
	}

}
