package main.java.org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Etudiant{
    private Identite id;
    private Formation forma;
    private Map<String, ArrayList<Double>> resultat;
    
    public Etudiant(Identite id, Formation forma){
        this.id = id;
        this.forma = forma;
        this.resultat = new HashMap<String, ArrayList<Double>>();
    }
    
    public void addNote(String mat, Double note){
        if (note >= 0 && note <= 20){
            if (this.forma.getMatieres().containsKey(mat)){
                ArrayList<Double> notes = this.resultat.get(mat);
                notes.add(note);
            } else {
                throw new FormationNotFoundException("la formation ne contient pas cette matière");
            }
        } else {
            throw new FormatNoteException("La note doit être entre 0 et 20");
        }
    }
    
    public Double getMoyenne(String mat){
        if (this.getForma().getMatieres().containsKey(mat)){
            double res = 0.0;
            ArrayList<Double> notes = this.resultat.get(mat);
            int n = notes.size();
            for (Double note : notes){
                res += note;
            }
            res = res/n;
            return  res;
        } else {
            throw new FormationNotFoundException("la formation ne contient pas cette matière");
        }
    }
    
    public Double getMoyenneGenerale(){
        double res = 0.0;
        double coefs = 0.0;
        for (String mat : this.resultat.keySet()){
            double coef = this.getForma().getCoef(mat);
            res += getMoyenne(mat)*coef;
            coefs += coef;
        }
        if (coefs != 0){
            res = res/coefs;
            return res;
        } else {
            throw new PasDeNoteException("l'etudiant n'a pas de notes");
        }
    }
    
    
    
    public Identite getId(){
        return id;
    }
    
    public Formation getForma(){
        return forma;
    }
    
    public Map<String, ArrayList<Double>> getResultat(){
        return resultat;
    }
}
