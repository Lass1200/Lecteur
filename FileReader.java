package lecteur;

import javax.imageio.IIOException;
import lecteur.sous.csv;
import lecteur.sous.json;
import lecteur.sous.txt;

public class FileReader {

    public static void main(String[] args) throws IIOException {

        Lecteur test = new txt("exemple.txt");
        Lecteur test2 = new csv("exemple2.csv");
        Lecteur test3 = new json("exemple3.json");


        test.ouvrir();
        test.lire();

        System.out.println("Contenu normal :");
        System.out.println(test.normal());
        System.out.println("----------------");
        System.out.println("Contenu inversé :");
        System.out.println(test.reverse());
        System.out.println("Contenu palindromee :");
        System.out.println(test.palindromeString());


        System.out.println("Contenu normal :");
        System.out.println(test.normal());


    }
}
