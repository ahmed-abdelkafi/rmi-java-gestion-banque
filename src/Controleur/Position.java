package Controleur;

import java.io.Serializable;

import java.util.Date;

 

public class Position implements Serializable {

                          private double solde;

                          private Date derniereOperation;

 
                          //methode donne la position du compte
                          public Position(double solde) {

                            this.solde = solde; 
                            this.derniereOperation = new Date();

                          }
                        //  derniere date d'operartion 
                        public Date getDerniereOperation() {

                             return derniereOperation;

                        }

 
                        //changer derniere date
                        public void setDerniereOperation(Date derniereOperation) {

                               this.derniereOperation = derniereOperation;

                        }

 
                       //solde de compte
                        public double getSolde() {

                            return solde;

                        }

 
                        //changer le solde du compte
                        public void setSolde(double solde) {

                               this.solde = solde;

                        }

                        public String toString() {

                                                return "solde = "+solde+" date dernière op. "+derniereOperation;

                        }

}