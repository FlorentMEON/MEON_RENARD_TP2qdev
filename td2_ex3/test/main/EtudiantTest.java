package main;

import exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {
    Formation forma;
    Etudiant et;
    Identite id;

    @BeforeEach
    void init(){
        this.forma = new Formation("for1");
        this.forma.ajouterFormation("mat1",1);
        this.forma.ajouterFormation("mat2",2);
        this.id=new Identite("aaa","bili","cole") ;
        this.et=new Etudiant(id,forma);
    }



    
    @Test
    void addNote() {
        this.et.addNote("mat1",12.0);
        assertEquals(12.0, this.et.getResultat().get("mat1").get(0));
    }
    
    @Test
    void getMoyenne() {
        this.et.addNote("mat1",12.0);
        this.et.addNote("mat1",11.0);
        assertEquals(11.5, this.et.getMoyenne("mat1"));
    }
    
    @Test
    void getMoyenneGenerale() {
        this.et.addNote("mat1",20.0);
        this.et.addNote("mat2",5.0);
        assertEquals(10.0, this.et.getMoyenneGenerale());
    }
    @Test
    void getIdentifiante() {
        assertEquals(id,et.getId());
    }
    @Test
    void getForma() {
        assertEquals(forma, et.getForma());
    }
}