package Controleur;

import java.net.MalformedURLException;

import java.rmi.*;
import java.util.Scanner;

import Model.Banque;

 

public class BanqueClient {

public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
	                                            
	                                            
                                                String name ;
                                                double montantDeDepart;
                                                int option;
                                                int i;
                                                //coonection client avec server
                                                Banque proxy = (Banque) Naming.lookup("rmi://localhost:1900/MaBanque");
                                                
                                                
                                                Scanner clavier = new Scanner (System.in);
                                              //donner le nom du client ou id 
                                        		System.out.println("donner le nom du client ");
                                        		name = clavier.next();
                                        		//donner le montand de depart 
                                        		System.out.println("donner montant De Depart ");
                                        		montantDeDepart = clavier.nextDouble();
                                        		 proxy.creerCompte(name, montantDeDepart);
                                                  
                                        		 //creation notification du compte
                                                 BanqueNotificationImpl bni = new BanqueNotificationImpl(name);
                                                  
                                                 //name : nom du titulaire du compte
                                                 //bni : message de notification 
                                                 //0 . minumum du solde 
                                                 proxy.enregistrerNotification(name, bni, 0);
                                        		
												do {
                                        			System.out.println("notre cher(e) " +name+" choisit une option \n"
                                        					+ "1:ajouter argent \n"
                                        					+ "2:retirer argent \n"
                                        					+ "3:etat de votre compte\n"
                                        					+ "0:fermer la session ");
                                        			option=clavier.nextInt();
                                        			 if(option==1) {
                                        				 System.out.println("donner montant à Ajouté ");
                                        				 double montantAjouté = clavier.nextDouble();
                                        				 proxy.ajouter(name, montantAjouté);
                                        				 System.out.println("la transaction a été effectuée \n    ");
                                        				 
                                        			 }
                                        			 if(option==2) {
                                        				 System.out.println("donner montant à retiré ");
                                        				 double montantRetiré = clavier.nextDouble();
                                        				 proxy.retirer(name, montantRetiré);
                                        				 System.out.println("merci cher(e) "+name+" \n ");
                                        				 
                                        			 }
                                        			 if(option==3) {
                                        				 System.out.println("Position du compte de " +name+" : "+proxy.position(name));
                                        				 
                                        			 }
                                        			 if((option<0) || (option>3)) {
                                        				 System.out.println("svp choississez une option correcte");
                                        			 }
                                        			
                                        		}while(option!=0);
												
												
												System.out.println("au revoir   " +name);
												//System.out.println("solde   " +position.getSolde());
												
                                        		

                                                   

                                               
                                                

                                                
                                                bni = null;

                                                proxy.enleverNotification(name);

                        }

 

}