import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;

public interface ServiceDistributeur extends Remote{
	 
	
    public ArrayList<String> lireText(ArrayList<String> s, String m) throws RemoteException;
    
    /**
     * Abonnement aupres du serveur
     * @param ibc la reference du noeud qui s'abonne
     * @throws ServerNotActiveException 
     */
    public void enregistrerNoeud(ServiceNoeud ibc) throws RemoteException, ServerNotActiveException;
}
