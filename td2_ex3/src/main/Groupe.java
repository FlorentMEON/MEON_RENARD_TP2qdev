package main;

import exception.FormationDifferenteException;

import java.util.Set;
import java.util.TreeSet;

public class Groupe {
    private Set<Etudiant> etu;
    Formation forma;
    
    public Groupe(Formation f) {
        this.forma = f;
        this.etu = new TreeSet<Etudiant>();
    }
    
    public void ajouterEtudiant(Etudiant e) {
        if (this.forma.equals(e.getForma())){
            this.etu.add(e);
        } else {
            throw new FormationDifferenteException("l'etudiant n'a pas la formation du groupe");
        }
    }
    
    public void retirerEtudiant(Etudiant e)  {
        this.etu.remove(e);
    }
}
