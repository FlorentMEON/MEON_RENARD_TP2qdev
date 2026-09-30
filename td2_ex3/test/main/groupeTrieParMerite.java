package main;

import exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class groupeTrieParMerite {
    private Formation for1;
    private Groupe g1,g2;
    private Etudiant etu1, etu2;

    @BeforeEach
    void init(){
        this.for1 = new Formation("for1");
        this.for1.ajouterFormation("mat1",1);


        this.etu1 = new Etudiant(new Identite("1","etu1","e1"), this.for1);
        this.etu2 = new Etudiant(new Identite("2","etu2","e2"), this.for1);

        etu1.addNote("mat1",5.0);
        etu1.addNote("mat1",15.0);

        etu2.addNote("mat1",10.0);
        etu2.addNote("mat1",10.0);

        g1 = new Groupe(this.for1);
        g2 = new Groupe(this.for1);

        g1.ajouterEtudiant(etu1);
        g1.ajouterEtudiant(etu2);

    }
@Test
    void testTrieParMerite(){
        g1.triParMerite();
        ArrayList<Etudiant> ordre= new ArrayList<Etudiant>();
        ordre.add(this.etu1);
        ordre.add(this.etu2);
        assertIterableEquals(ordre,g1.getEtu());
    }
    @Test
    void testTrieParMeriteNull(){
        ArrayList<Etudiant> ordre= new ArrayList<Etudiant>();
        this.g1.triAlpha();
        assertIterableEquals(ordre,g2.getEtu());
    }
}
