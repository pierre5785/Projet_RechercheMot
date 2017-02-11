
public class Noeud implements ServiceNoeud {
	
	
	public String rechercherMot(String l, String m){
		if(l.contains(m))
			return l;
		
		return null;
		
	}
}
