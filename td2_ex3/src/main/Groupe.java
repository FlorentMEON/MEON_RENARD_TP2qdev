package main;

import exception.*;
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

    public Double getMoyenne(String mat){
        if (this.forma.getMatieres().containsKey(mat)){
            if (!this.etu.isEmpty()){
                Double res = 0.0;
                int n = 0;
                for (Etudiant e : this.etu){
                    try{
                        res += e.getMoyenne(mat);
                        n += 1;
                    } catch (PasDeNoteException _){}
                }
                if (n == 0){
                    throw new PasDeNoteException("personne n'a des notes dans cette matière");
                }
                return res / n;

            } else throw new PasDeNoteException("aucun étudiant dans le groupe");
        } else {
            throw new FormationNotFoundException("la formation ne contient pas cette matière");
        }
    }

    public double getMoyenneGenerale(){
        if (!this.etu.isEmpty()){
            Double res = 0.0;
            int n = 0;
            for (Etudiant e : this.etu){
                try{
                    res += e.getMoyenneGenerale();
                    n += 1;
                } catch (PasDeNoteException _){
                }
            }
            if (n == 0){
                throw new PasDeNoteException("personne n'a des notes dans ce groupe");
            }
            return res / n;
        } else throw new PasDeNoteException("aucun étudiant dans le groupe");
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
    public void triParMerite(){
        Comparator<Etudiant>ce=new Comparator<Etudiant>(){
            public int compare(Etudiant e1,Etudiant e2){
                int res=e2.getMoyenneGenerale().compareTo(e1.getMoyenneGenerale());
                if(res==0){
                    res=e1.getId().getNom().compareTo(e2.getId().getNom());
                }
                return res;
            }
        };
        TreeSet<Etudiant>etud=new TreeSet<Etudiant>(ce);
        for(Etudiant e:etu){
            etud.add(e);
        }
        this.etu=etud;
    }
}
