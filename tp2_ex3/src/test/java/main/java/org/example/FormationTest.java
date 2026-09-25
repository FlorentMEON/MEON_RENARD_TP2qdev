package main.java.org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormationTest{
    Formation forma;
    @BeforeEach
    void init(){
        this.forma = new Formation("for1");
        this.forma.ajouterFormation("mat1",1);
    }
    
    @Test
    void getCoefDedans(){
        double test = this.forma.getCoef("mat1");
        
        assertEquals(1,test,"le coef devrait être 1");
    }
    
    @Test
    void getCoefPasDedans(){
        boolean test = false;
        try {
            double a = this.forma.getCoef("mat2");
        } catch (FormationNotFoundException e){
            test = true;
        }
        
        assertTrue(test,"la méthode devrait renvoyer une erreur");
    }
    
    @Test
    void ajouterFormation(){
        this.forma.ajouterFormation("mat2",2);
        double test = this.forma.getCoef("mat2");
        assertEquals(2, test, "le coef devrait être 2");
    }
    
    @Test
    void retirerFormation(){
        boolean test = false;
        
        this.forma.ajouterFormation("mat2",2);
        this.forma.retirerFormation("mat1");
        
        try {
            double a = this.forma.getCoef("mat1");
        } catch (FormationNotFoundException e){
            test = true;
        }
        
        assertTrue(test,"la matière 1 devrait être retirée");
        
    }
}