package Controleur;

import java.rmi.Naming;

import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;

import java.rmi.server.UnicastRemoteObject;

import java.util.Hashtable;

import Model.Banque;
import Model.BanqueNotification;
import Model.Compte;

 

public class BanqueImpl extends UnicastRemoteObject implements Banque {

 
                         //classer les comptes dans hashtable
                        Hashtable<String,Compte> comptes;

 

                        public BanqueImpl() throws RemoteException {

                                                super();

                                                comptes = new Hashtable<String,Compte>();

                        }

 
                            //creation de compte
                        public void creerCompte(String id, double somme) throws RemoteException {

                                                comptes.put(id, new Compte(somme));

                        }

                            //methode d'ajoute avec id 

                        public void ajouter(String id, double somme) throws RemoteException {

                                                Compte cpt = comptes.get(id);

                                                cpt.ajouter(somme);

                        }

 
                         // methode de retirer avec id
                        public void retirer(String id, double somme) throws RemoteException {

                                                Compte cpt = comptes.get(id);

                                                cpt.retirer(somme);

                        }

 

                        public Position position(String id) throws RemoteException {

                                                Compte cpt = comptes.get(id);

                                                return cpt.getPosition();

                        }

 

                        public void enregistrerNotification(String id, BanqueNotification b, double mini)

                                                                        throws RemoteException {

                                                Compte cpt = comptes.get(id);

                                                cpt.setNotification(b, mini);

                        }

 

                        public void enleverNotification(String id) throws RemoteException {

                                                Compte cpt = comptes.get(id);

                                                cpt.setNotification(null, 0);

                        }

 

                        public static void main(String[] args) throws Exception {

                                                LocateRegistry.createRegistry(1900) ;

                                                Naming.rebind("rmi://localhost:1900/MaBanque", new BanqueImpl());

                                                System.out.println("MaBanque est enregistrée");

                        }

 

 

}