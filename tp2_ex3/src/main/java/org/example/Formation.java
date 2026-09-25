package main.java.org.example;

import java.util.Map;

public class Formation {
    private String identifiant;
    private Map<String,Double> matieres;

    public Formation(String identifiant) {
        this.identifiant = identifiant;
    }

    public void ajouterFormation(String matiere,double valeur) {
        this.matieres.put(matiere,valeur);
    }

    public void retirerFormation(String matiere,double valeur) {
        this.matieres.remove(matiere);
    }

    public double getCoef(String matiere) {
        if(matieres.containsKey(matiere)){
        return this.matieres.get(matiere);
        }else{
            return 0;
        }
    }

    public Map<String,Double> getMatieres() {
        return matieres;
    }
    public String getIdentifiant() {
       return identifiant;
    }



}
