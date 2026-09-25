package main.java.org.example;

public class Identite{
    private String nip,nom,prenom;
    
    public Identite(String nip, String nom, String prenom){
        this.nip = nip;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public String getNip(){
        return nip;
    }
    
    public String getPrenom(){
        return prenom;
    }
    
    public String getNom(){
        return nom;
    }
}
