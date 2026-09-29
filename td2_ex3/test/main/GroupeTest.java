package main;

import exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest{
    private Groupe g1;
    private Groupe g2;
    private Etudiant etu1;
    @BeforeEach
    void init(){
        this.g1 = new Groupe(new Formation("for1"));
        this.g2 = new Groupe(new Formation("for2"));
        this.etu1 = new Etudiant(new Identite("111","toto","tata"), new Formation("for1"));
    }
    
    @Test
    void ajouterEtudiantBonneFormation(){
        this.g1.ajouterEtudiant(this.etu1);
        boolean test = this.g1.getEtu().contains(this.etu1);
        assertTrue(test, "l'étudiant n'est pas dans le groupe");
    }
    
    @Test
    void ajouterEtudiantMauvaiseFormation(){
        boolean test = false;
        try{
            this.g2.ajouterEtudiant(this.etu1);
        } catch (FormationDifferenteException e){
            test = true;
        }
        
        assertTrue(test, "l'erreur FormationDifferenteException devrait être renvoyée");
    }
    
    @Test
    void retirerEtudiant(){
        this.g1.ajouterEtudiant(this.etu1);
        this.g1.retirerEtudiant(this.etu1);
        boolean test = this.g1.getEtu().isEmpty();
        assertTrue(test,"le groupe devrait être vide");
    }
}