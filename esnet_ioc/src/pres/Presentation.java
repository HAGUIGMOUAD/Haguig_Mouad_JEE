package pres;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.MetierImpl;

import java.time.Clock;
import java.util.Arrays;

public class Presentation {
    public static void main(String[] args) {
        /*
        Injection des dépendances par
        Instanciation statique => new
         */
        DaoImpl2 dao = new DaoImpl2();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println("Resultat="+metier.calcul());
    }
}
