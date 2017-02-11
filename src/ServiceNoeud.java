import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceNoeud extends Remote{
	
	public String rechercherMot(String l, String m) throws RemoteException;

}
