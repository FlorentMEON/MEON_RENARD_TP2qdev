package main;

import exception.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Formation {
    private String identifiant;
    private Map<String,Double> matieres;
    
    public Formation(String identifiant) {
        this.identifiant = identifiant;
        this.matieres = new HashMap<String, Double>();
    }
    
    public void ajouterFormation(String matiere,double valeur) {
        this.matieres.put(matiere,valeur);
    }
    
    public void retirerFormation(String matiere) {
        this.matieres.remove(matiere);
    }
    
    public double getCoef(String matiere) {
        if(matieres.containsKey(matiere)){
            return this.matieres.get(matiere);
        }else{
            throw new FormationNotFoundException("La matière n'est pas dans la formation");
        }
    }
    
    public Map<String,Double> getMatieres() {
        return matieres;
    }
    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Formation formation = (Formation) o;
        return this.identifiant.equals(formation.identifiant) ;
    }

}
