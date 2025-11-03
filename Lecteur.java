package lecteur;

import java.io.FileInputStream;
import java.util.ArrayList;

public abstract class Lecteur implements Copiable {
    protected String cheminFichier;
    protected ArrayList<String> main;
    protected FileInputStream in;

    public Lecteur(String chemin){
        this.cheminFichier = chemin;
        this.main = new ArrayList<>();
    }

    public abstract Object ouvrir();
    public abstract Object lire();
    public abstract void supprimer();

    public String normal() {
        return String.join("\n", this.main);
    }
    

    public String reverse() {
        String texte="";
        for (int i = main.size() - 1; i >= 0; i--) {
            texte = texte + main.get(i);
            if (i != 0) {
                texte = texte + "\n";
            }
        }
        return texte;
        
    }

    protected void ajouterLigne(String ligne) {
        main.add(ligne);
    }
    

    public String palindromeString() {
        String texte = "";
    
        for (int i = 0; i < main.size(); i++) {
            String ligne = main.get(i);
            String ligneInverse = "";
    

            for (int j = ligne.length() - 1; j >= 0; j--) {
                ligneInverse = ligneInverse + ligne.charAt(j);
            }
    
            texte = texte + ligneInverse;
            if (i != main.size() - 1) {
                texte = texte + "\n";
            }
        }
        return texte;
    }

    public String compare(Lecteur autre) {

        if (this.main.size() != autre.main.size()) {
            return "Les fichiers sont différents";
        }
    
        for (int i = 0; i < this.main.size(); i++) {
            if (!this.main.get(i).equals(autre.main.get(i))) {
                return "Les fichiers sont différents";
            }
        }
    
        return "Les fichiers sont identiques";
    }
    
}
