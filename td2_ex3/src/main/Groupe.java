package main;

import exception.FormationDifferenteException;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Groupe {
    private Set<Etudiant> etu;
    Formation forma;
    
    public Groupe(Formation f){
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
    
    public Formation getForma(){
        return forma;
    }
    
    public Set<Etudiant> getEtu(){
        return etu;
    }

    public void triAlpha(){
        TreeSet<Etudiant> etud=new TreeSet<Etudiant>();
        for (Etudiant e:etu){
            etud.add(e);
        }
        this.etu=etud;
    }
    public void triAntiAlpha(){
        Comparator<Etudiant> ce = new Comparator<Etudiant>() {
            public int compare(Etudiant e1, Etudiant e2) {
                int res=-(e1.compareTo(e2));
                return res;
            }
        };
        TreeSet<Etudiant> etud=new TreeSet<Etudiant>(ce);
        for (Etudiant e:etu){
            etud.add(e);
        }
        this.etu=etud;
    }

}
