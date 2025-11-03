package lecteur.sous;

import java.io.File;
import java.io.FileInputStream;
import lecteur.Lecteur;

public class json extends Lecteur {


    public json(String chemin){
        super(chemin);
    }

    @Override
    public Object ouvrir(){
        try {
            File f = new File(cheminFichier);
            in = new FileInputStream(f); 
            return in;
        } catch (Exception e) {
            System.out.println("Erreur ouverture fichier : " + e.getMessage());
            return null;
        }
    }

    @Override
    public Object lire() {
        try {
            int i = in.read();
            String ligne = "";

            while (i != -1) { 
                char c = (char) i;
                ligne += c;

                if (c == '{' ){
                    System.out.println("Début d'un fichier JSON");
                }
                else if (c == '}' ){
                    System.out.println("la fin d'un fichier JSON");
                }
                if (c == '[' ){
                    System.out.println("Début d'un tableauJSON");
                }
                if (c == ']' ){
                    System.out.println("Début d'un tableauJSON");
                }
                i = in.read();
               
            }
            
    
            if (!ligne.isEmpty()) {
                ajouterLigne(ligne);
            }

        } catch (Exception e) {
            System.out.println("Erreur lecture : " + e.getMessage());
        }

        return null;
    }

    @Override
    public void supprimer() {
        try {
            if (in != null) {
                in.close();
            }
        } catch (Exception e) {
            System.out.println("Erreur fermeture fichier : " + e.getMessage());
        }
    }
}
