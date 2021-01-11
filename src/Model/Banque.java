package Model;

import Controleur.Position;

//interface du banque
public interface Banque extends java.rmi.Remote {

	//methode de creation du compte
	  public void creerCompte(String id, double somme) throws java.rmi.RemoteException;
   //methode d'ajoute d'argent dans la compte
	  public void ajouter(String id, double somme) throws java.rmi.RemoteException;
//methode de retire d'argent de la compte
	  public void retirer(String id, double somme) throws java.rmi.RemoteException;
// methode qui donne la position de compte (solde et temps)
	  public Position position(String id) throws java.rmi.RemoteException;

	  public void enregistrerNotification(String id, BanqueNotification b, double minimum)

	                                            throws java.rmi.RemoteException;

	  public void enleverNotification(String id) throws java.rmi.RemoteException;

	}