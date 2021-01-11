package Controleur;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;

import Model.BanqueNotification;

 

public class BanqueNotificationImpl extends UnicastRemoteObject implements BanqueNotification {

                        private String id;

 

                        public BanqueNotificationImpl(String id) throws RemoteException {

                                                super() ;

                                                this.id = id;

                        }
                          //methode de notification en cas du probleme 
                        public void notification(double valeur, double mini) throws RemoteException {

                                                System.out.println("Votre compte "+id+" est inférieur au mini : "+mini+" solde : "+valeur);

                        }

}