import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;

@ManagedBean(name="barcelona")
@ApplicationScoped
public class Barcelona  implements Serializable{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	
	
	 private List<Player> players;  
	  
	    private List<Player> selectedPlayers;  
	  
	    public Barcelona() {  
	        players = new ArrayList<Player>();  
	        selectedPlayers = new ArrayList<Player>();  
	  
	        players.add(new Player("Messi", 10, "messi.PNG", "forward"));  
	        players.add(new Player("Villa", 7, "alesil.png", "forward"));  
	        players.add(new Player("Pedro", 17, "alesil.png", "forward"));  
	        players.add(new Player("Bojan", 9, "alesil.png", "forward"));  
	        players.add(new Player("Xavi", 6, "alesil.png", "midfield"));  
	        players.add(new Player("Iniesta", 8, "alesil.png", "midfield"));  
	    }  
	  
	    public List<Player> getPlayers() {  
	        return players;  
	    }  
	  
	    public List<Player> getSelectedPlayers() {  
	        return selectedPlayers;  
	    }  
	  
	    public void onDrop(DragDropEvent event) {  
	        Player player = (Player) event.getData();  

	        selectedPlayers.add(player);  
	  
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(player.getNome() + " added", "Position:" + event.getDropId()));  
	    }  
}
