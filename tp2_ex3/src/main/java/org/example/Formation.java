package main.java.org.example;

import java.util.Map;

public class Formation {
    String identifiant;
    Map<String,Double> matieres;

    public Foramtion(String identifiant) {
        this.identifiant = identifiant;
    }

    public void ajouterFormation(String matiere,double valeur) {
        this.matieres.put(matiere,valeur);
    }

    public void retirerFormation(String matiere,double valeur) {
        this.matieres.remove(matiere);
    }

    public String getCoef(String matiere) {
        if(matieres.containsKey(matiere)){
        return identifiant;
        }else{
            return null;
        }
    }



}
