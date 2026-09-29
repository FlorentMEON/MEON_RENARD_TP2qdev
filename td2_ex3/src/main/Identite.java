package main;

import java.util.Objects;

public class Identite implements Comparable<Identite>{
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
    
    @Override
    public int compareTo(Identite o){
        int valNom = this.nom.compareTo(o.nom);
        int valPrenom = this.nom.compareTo(o.prenom);
        int valNip = this.nom.compareTo(o.nip);
        if (valNom == 0){
            if (valPrenom == 0){
                return valNip;
            } else {
                return valPrenom;
            }
        } else {
            return valNom;
        }
    }
    
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Identite identite)) return false;
        return this.nip.equals(identite.nip);
    }
}
