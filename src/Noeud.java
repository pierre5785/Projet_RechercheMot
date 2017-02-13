import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Noeud implements ServiceNoeud {

	
	public String rechercherMot(String l, String m){
		int a;
		ArrayList<String> lres=new ArrayList<String>();
		String alphabet[] ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
				"u","v","w","x","y","z"};
		ArrayList<String> le=new ArrayList<String>();
		for(int i=0;i<alphabet.length;i++){
			le.add(alphabet[i]);
		}
		
		System.out.println("ok");
		if(l.contains(m)){
			a=l.indexOf(m);
			if(!le.contains(l.substring(a-1,a)) && !le.contains(l.substring(a+2,a+3))){
				
				return l;
			}
		}			

		return null;

	}


}
