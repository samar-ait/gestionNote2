package mod.sco;

import java.util.Vector;


public class TestMetier {
    public static void main(String[] args) {
        Scolarite scolarite = new Scolarite();

        // Numéro d'inscription de l'étudiant à tester
        String numeroInscription = "D133365421";

        // Récupération des notes de l'étudiant
        Vector<Note> notes = scolarite.getNotes(numeroInscription);

        // Affichage des notes
        for (Note note : notes) {
            System.out.println("Matière: " + note.getMatiere() + ", Note: " + note.getNote());
        }
    }
}
