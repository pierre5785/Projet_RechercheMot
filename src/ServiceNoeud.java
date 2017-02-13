import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServiceNoeud extends Remote{
	
	public String rechercherMot(String l, String m) throws RemoteException;

}
