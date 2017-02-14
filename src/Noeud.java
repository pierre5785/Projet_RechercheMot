import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Noeud implements ServiceNoeud {

	
	public String rechercherMot(String l, String m){
		int a;
		String alphabet[] ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
				"u","v","w","x","y","z"};
		ArrayList<String> le=new ArrayList<String>();
		
		for(int i=0;i<alphabet.length;i++){
			le.add(alphabet[i]);
		}
		
		System.out.println("ok");
		if(l.contains(m)){
			a=l.indexOf(m);
			if(!le.contains(l.substring(a-1,a)) && !le.contains(l.substring(a+m.length(),a+m.length()+1))){
				
				return l;
			}
		}			

		return null;

	}
	
	public static void main (String[] args) throws RemoteException, NotBoundException, ServerNotActiveException{
	
		String serveur="localhost"; 
		int port=1099; 
		if(args.length > 0)
			serveur=args[0];
		if(args.length > 1)
			port=Integer.parseInt(args[1]);
		
    	Registry reg = LocateRegistry.getRegistry(serveur,port);
        ServiceDistributeur serverRef = (ServiceDistributeur) reg.lookup("Centralisateur");

		Noeud n = new Noeud();
		ServiceNoeud stb=(ServiceNoeud) UnicastRemoteObject.exportObject(n,0);
		serverRef.enregistrerNoeud(stb);
	}


}
