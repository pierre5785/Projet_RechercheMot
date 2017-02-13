import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LancerDistributeur{

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		/* adresse du serveur de calcul depuis la ligne de commande */ 
		String serveur="localhost"; // par défaut le serveur est sur la même machine
		int port=1099; // le port de la rmiregistry part défaut 
		if(args.length > 0)
			serveur=args[0];
		if(args.length > 1)
			port=Integer.parseInt(args[1]);

		Registry reg = LocateRegistry.getRegistry(serveur,port); 
		Distributeur lc = new Distributeur();
        ServiceDistributeur sa = (ServiceDistributeur) UnicastRemoteObject.exportObject(lc,0);
		reg.rebind("Centralisateur", sa);
		
		

	//	ArrayList<String> l = lf.lire("ex.txt");
	//	ArrayList<String> lres=n.rechercherMot(l, "un");
		//for(int i=0;i<lres.size();i++){
			//System.out.println(lres.get(i));
		//}
		
		
	}

	

}
