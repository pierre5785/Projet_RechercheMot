import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LireTexte implements ServiceLireTexte {
	
	private String source;
	private ArrayList<String> lLigne = new ArrayList<String>();

	public LireTexte(String src) {
		    this.source = src;
		}
	
	public ArrayList<String> lire(){
		try{
			String ligne;
			BufferedReader fichier = new BufferedReader(new FileReader(source));
			while ((ligne = fichier.readLine()) != null){
				lLigne.add(ligne);
		    }
			fichier.close();
		}catch (IOException e) {
		      e.printStackTrace();
	    }
		
		return lLigne;
	}
	


}
