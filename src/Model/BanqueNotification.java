package Model;

import java.rmi.Remote;

import java.rmi.RemoteException;

 

public interface BanqueNotification extends Remote {
	
	//notifiaction pour les transaction non valide 

      public void notification(double valeur, double mini) throws RemoteException;

}