package mod.sco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Scolarite {
    public Vector<Note> getNotes(String num_Ins) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Vector<Note> notes = new Vector<>();

        try {
            // Obtenez une connexion à la base de données en utilisant DatabaseConn ou toute autre méthode de connexion.

            connection = DatabaseConn.getConnection();

            // Préparez la requête SQL pour obtenir les notes de l'étudiant.
            String query = "SELECT matiere, note FROM notes WHERE numero_inscription = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, num_Ins);

            // Exécutez la requête.
            resultSet = preparedStatement.executeQuery();

            // Parcourez les résultats et créez des objets Note pour chaque enregistrement.
            while (resultSet.next()) {
                String matiere = resultSet.getString("matiere");
                float note = resultSet.getFloat("note");
                Note studentNote = new Note(matiere, note);
                notes.add(studentNote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Assurez-vous de libérer les ressources.
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return notes;
    }
}

