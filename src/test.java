import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Noeud n =new Noeud();
		
		String r = n.rechercherMot("un chat et un chien", "un");
		
		System.out.println(r);
		
		LireTexte lf = new LireTexte("texte.rtf");
		ArrayList<String> l = lf.lire();
		
		for(int i=0; i<l.size(); i++){
			System.out.println(n.rechercherMot(l.get(i), "un"));
		}
	}

}
