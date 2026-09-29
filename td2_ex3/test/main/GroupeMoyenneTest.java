package main;

import exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GroupeMoyenneTest {
    private Formation for1;
    private Groupe g1, g2, g3;
    private Etudiant etu1, etu2, etu3;
    
    @BeforeEach
    void init(){
        this.for1 = new Formation("for1");
        this.for1.ajouterFormation("mat1",1);
        this.for1.ajouterFormation("mat2",2);
        this.for1.ajouterFormation("mat3",3);
        
        this.etu1 = new Etudiant(new Identite("1","etu1","e1"), this.for1);
        this.etu2 = new Etudiant(new Identite("2","etu2","e2"), this.for1);
        this.etu3 = new Etudiant(new Identite("3","etu3","e3"), this.for1);
        
        etu1.addNote("mat1",5.0);
        etu1.addNote("mat1",15.0);
        etu1.addNote("mat2",10.0);
        
        etu2.addNote("mat1",10.0);
        etu2.addNote("mat1",10.0);
        
        g1 = new Groupe(this.for1);
        g2 = new Groupe(this.for1);
        g3 = new Groupe(this.for1);
        
        g1.ajouterEtudiant(etu1);
        g1.ajouterEtudiant(etu2);
        
        this.g3.ajouterEtudiant(this.etu3);
    }
    
    @Test
    void getMoyenne(){
        double test = this.g1.getMoyenne("mat1");
        assertEquals(10, test, "la moyenne devrait être 10");
    }
    
    @Test
    void getMoyennePasTous(){
        double test = this.g1.getMoyenne("mat2");
        assertEquals(10.0, test,"la moyenne devrait être 10");
    }
    
    @Test
    void getMoyenneGroupeVide(){
        boolean test = false;
        String message = "";
        try{
            this.g2.getMoyenne("mat1");
        } catch (PasDeNoteException e){
            test = true;
            message = e.getMessage();
        }
        assertTrue(test, "l'exception PasDeNoteException devrait être renvoyée");
        assertEquals("aucun étudiant dans le groupe", message, "mauvaise exception lancée");
    }
    
    @Test
    void getMoyennePasDansFormation(){
        boolean test = false;
        try{
            this.g1.getMoyenne("mat-1");
        } catch (FormationNotFoundException e){
            test = true;
        }
        assertTrue(test, "l'exception FormationNotFoundException devrait être renvoyée");
    }
    
    @Test
    void getMoyennePsaDeNotes(){
        boolean test = false;
        String message = "";
        try{
            this.g1.getMoyenne("mat3");
        } catch (PasDeNoteException e){
            test = true;
            message = e.getMessage();
        }
        assertTrue(test, "l'exception PasDeNoteException devrait être renvoyée");
        assertEquals("personne n'a des notes dans cette matière", message, "mauvaise exception lancée");
    }
    
    @Test
    void getMoyenneGenerale(){
        Double test = this.g1.getMoyenneGenerale();
        assertEquals(10.0, test, "la moyenne devrait être de 10");
    }
    
    @Test
    void getMoyenneGeneralePersonneDansGroupe(){
        boolean test = false;
        String message = "";
        try{
            this.g2.getMoyenneGenerale();
        } catch (PasDeNoteException e){
            test = true;
            message = e.getMessage();
        }
        assertTrue(test, "l'exception PasDeNoteException devrait être renvoyée");
        assertEquals("aucun étudiant dans le groupe", message, "mauvaise exception lancée");
    }
    
    @Test
    void getMoyenneGeneralePasDeNotes(){
        boolean test = false;
        String message = "";
        try{
            this.g3.getMoyenneGenerale();
        } catch (PasDeNoteException e){
            test = true;
            message = e.getMessage();
        }
        assertTrue(test, "l'exception PasDeNoteException devrait être renvoyée");
        assertEquals("personne n'a des notes dans ce groupe", message, "mauvaise exception lancée");
    }
    
    
}