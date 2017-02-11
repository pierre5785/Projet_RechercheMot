import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServiceLireTexte extends Remote{
	
	public ArrayList<String> lire() throws RemoteException;

}
