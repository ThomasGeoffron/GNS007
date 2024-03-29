/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gns;

/**
 *
 * @author etudiant
 */
public class Joueur {
    private String nom;
    private String mdp;
    private String pays;
    private char genre;
    private boolean cgu;
    
    
    public Joueur(String nom, String mdp, String pays, char genre, boolean cgu){
        this.nom = nom;
        this.mdp = mdp;
        this.pays = pays;
        this.genre = genre;
        this.cgu = cgu;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getMDP(){
        return mdp;
    }
    
    public void setMDP(String mdp){
        this.mdp = mdp;
    }
    
    public String getPays(){
        return pays;
    }
    
    public void setPays(){
        this.pays = pays;
    }
    
    public char getGenre(){
        return genre;
    }
    
    public void setGenre(char genre){
        this.genre = genre;
    }
    
    public boolean acceptCGU(){
        return cgu;
    }
    
    public void setCGU(boolean cgu){
        this.cgu = cgu;
    }
    
    @Override
    public String toString(){
        return "Joueur[nom : " + nom + ", mdp : " + mdp + ", pays : " + pays +", genre : " + genre +
                ", cgu : " + cgu + "]";
    }
    
    
}
