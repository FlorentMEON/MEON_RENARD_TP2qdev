package main.java.org.example;

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

    }

    public void retirerEtudiant(Etudiant e)  {

    }
}
