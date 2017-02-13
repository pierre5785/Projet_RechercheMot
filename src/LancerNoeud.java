import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

public class LancerNoeud {

	public static void main (String[] args) throws RemoteException, NotBoundException, ServerNotActiveException{
		/* adresse du serveur de calcul depuis la ligne de commande */ 
		String serveur="localhost"; // par défaut le serveur est sur la même machine
		int port=1099; // le port de la rmiregistry part défaut 
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
