import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LancerDistributeur{

	public static void main(String[] args) throws RemoteException {
		
		String serveur="localhost";
		int port=1099;
		if(args.length > 0)
			serveur=args[0];
		if(args.length > 1)
			port=Integer.parseInt(args[1]);

		Registry reg = LocateRegistry.getRegistry(serveur,port); 
		Distributeur lc = new Distributeur();
        ServiceDistributeur sa = (ServiceDistributeur) UnicastRemoteObject.exportObject(lc,0);
		reg.rebind("Centralisateur", sa);	
		System.out.println("Serveur en marche");
		
	}

	

}
