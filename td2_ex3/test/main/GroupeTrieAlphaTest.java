package main;

import exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

public class GroupeTrieAlphaTest {
    private Groupe g1;
    private Etudiant etu2;
    private Etudiant etu1;
    @BeforeEach
    void init(){
        this.g1 = new Groupe(new Formation("for1"));
        this.etu1 = new Etudiant(new Identite("111","ar","tata"), new Formation("for1"));
        this.etu2 = new Etudiant(new Identite("112","br","toto"), new Formation("for1"));
    }
    @Test
    void testTrieAlpha(){
        this.g1.ajouterEtudiant(this.etu1);
        this.g1.ajouterEtudiant(this.etu2);
        this.g1.triAlpha();
        ArrayList<Etudiant> ordre= new ArrayList<Etudiant>();
        ordre.add(this.etu1);
        ordre.add(this.etu2);
        //assertIterableEquals compare les element entre eu dans l'ordre
        assertIterableEquals(ordre,g1.getEtu());
    }
    @Test
    void testTrieAlphaNull(){
        ArrayList<Etudiant> ordre= new ArrayList<Etudiant>();
        this.g1.triAlpha();
        assertIterableEquals(ordre,g1.getEtu());
    }
    @Test
    void testTrieAntiAlpha(){
        this.g1.ajouterEtudiant(this.etu1);
        this.g1.ajouterEtudiant(this.etu2);
        this.g1.triAntiAlpha();
        ArrayList<Etudiant> ordre= new ArrayList<Etudiant>();
        ordre.add(this.etu2);
        ordre.add(this.etu1);
        assertIterableEquals(ordre,g1.getEtu());
    }
    @Test
    void testTrieAntiAlphaNull(){
        this.g1.triAntiAlpha();
        ArrayList<Etudiant> ordre= new ArrayList<Etudiant>();
        assertIterableEquals(ordre,g1.getEtu());
    }
}
