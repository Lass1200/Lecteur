package lecteur.sous;

import java.io.File;
import java.io.FileInputStream;
import lecteur.Lecteur;

public class csv extends Lecteur {

    public csv(String chemin) {
        super(chemin);
    }

    public Object ouvrir() {
        try {
            File f = new File(cheminFichier);
            in = new FileInputStream(f);
            return in;
        } catch (Exception e) {
            System.out.println("Erreur ouverture fichier csv: " + e.getMessage());
            return null;
        }
    }

    public Object lire() {
        try {
            int i = in.read();
            String ligne = "";

            while (i != -1) { 
                char c = (char) i;

                if (c == '\n') {  
                    ajouterLigne(ligne);
                    if (ligne.contains(";") || ligne.contains(",")) {
                        System.out.println("Cette ligne contient un séparateur CSV");
                    }
                    ligne = "";

                } else {
                    ligne = ligne + c;
                }

                i = in.read();
            }

    
            if (!ligne.isEmpty()) {
                ajouterLigne(ligne);
            }

        } catch (Exception e) {
            System.out.println("Erreur lecture fichier csv : " + e.getMessage());
        }

        return null;
    }
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
