package Model;

import java.net.MalformedURLException;

import java.rmi.*;

import java.rmi.server.*;

import java.util.*;

import Controleur.Position;

 

public class Compte {

                        private Position position;

                        private BanqueNotification notif;

                        private double notifMinimum;

 
                       //constructeur
                        public Compte(double somme) {

                                     this.position = new Position(somme);

                        }

 
                       //retourner la position du compte
                        public Position getPosition() {

                                return position;

                        }

 
                         //methde ajouter argent dans le compte
                        public void ajouter(double somme) {

                                                position.setSolde(position.getSolde()+somme);

                                                position.setDerniereOperation(new Date());

                        }

 
                        //methode retirer d'argent de compte
                        public void retirer(double somme) {
                        	 
                        	double solde = position.getSolde() ;
                        	double newSolde = solde-somme;
                            
                             position.setDerniereOperation(new Date());
                              //condition si le montant retirer > solde
                             if ((notif != null) && (newSolde < notifMinimum)) {

                                                                     try {
                                                                        

                                                                               notif.notification(position.getSolde(), notifMinimum);

                                                                        } catch (RemoteException e) {

                                                                                     e.printStackTrace();

                                                                        }

                             }else {
                            	 position.setSolde(newSolde);
                            	 
                             }

                        }

 
                        	//methode de changement du nptification 
                        public void setNotification(BanqueNotification notif, double mini) {

                              this.notif = notif;

                             notifMinimum = mini;

                        }

 

}