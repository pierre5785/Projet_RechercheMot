import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;

public class Distributeur implements ServiceDistributeur{
	protected ArrayList<ServiceNoeud> noeuds;
	public Distributeur() {
		this.noeuds=new ArrayList<ServiceNoeud>();
	}

	@Override
	public ArrayList<String> lireText(ArrayList<String> ls, String m) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> lres = new ArrayList<String>();
		String sr="Noeuds inéxistants";
		if(this.noeuds.size()>0){
			int i=0;
			int x=0;
			while(i<ls.size()){
				sr=this.noeuds.get(x).rechercherMot(ls.get(i), m);
				if(sr!=null){
					lres.add(ls.get(i));
				}
				x++;
				if(x==this.noeuds.size())
					x=0;
				
				i++;
			}			

		}else{
			lres.add(sr);
		}

		if(lres.size()==0){
			lres.add("mot recherché introuvable...");
		}

		return lres;
	}

	@Override
	public void enregistrerNoeud(ServiceNoeud ibc) throws RemoteException, ServerNotActiveException {
		// TODO Auto-generated method stub
		this.noeuds.add(ibc);	

		String host = RemoteServer.getClientHost();
		System.out.println("Noeud "+host+" enregistré");

	}

}
