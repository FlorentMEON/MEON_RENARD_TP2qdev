package main.java.org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {
    Identite id=new Identite("aaa","bili","cole") ;
    Formation forma= new Formation("test");
    Etudiant et=new Etudiant(id,forma);


    @Test
    void addNote() {
        et.addNote("math",12.0);
        assertEquals(12.0, et.getResultat().get("math"));
    }

    @Test
    void getMoyenne() {
    }

    @Test
    void getMoyenneGenerale() {
    }
    @Test
    void getId() {
    }
    @Test
    void getForma() {
    }
    @Test
    void getResultat() {
    }
}