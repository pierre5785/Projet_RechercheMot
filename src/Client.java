import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		
		String serveur="localhost"; 
		int port=1099;  
		if(args.length > 2)
			serveur=args[3];
		
		ArrayList<String> lLigne = new ArrayList<String>();

		try{
			String ligne;
			BufferedReader fichier = new BufferedReader(new FileReader(args[0]));
			while ((ligne = fichier.readLine()) != null){
				lLigne.add(ligne);
			}
			fichier.close();
		}catch (IOException e) {
			e.printStackTrace();
		}



		Registry reg = LocateRegistry.getRegistry(serveur,port);
		ServiceDistributeur serverRef = (ServiceDistributeur) reg.lookup("Centralisateur");
		ArrayList<String> res=serverRef.lireText(lLigne, args[1]);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}

}
