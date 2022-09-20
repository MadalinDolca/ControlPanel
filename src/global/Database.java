package global;

import controlpanel.PanouControl;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Database {

    public static Connection adminConnection;
    public static ResultSet adminRs;
    public static Statement adminStmt;

    public static void conectare(PanouControl panou) {
        String adminUrl = "jdbc:mysql://localhost:3306/controlpanel";
        String adminUsername = "root";
        String adminPassword = "";

        adminRs = null;
        adminStmt = null;

        try (Connection adminConnection = DriverManager.getConnection(adminUrl, adminUsername, adminPassword)) {
            System.out.println("Baza de date admin conectata!");

        } catch (SQLException ex) {
            System.out.println("Nu ma pot conecta la baza de date admin!" + " " + ex);
            // Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex.getMessage());

            JLabel continutDialog = new JLabel(
                    "<html>Nu mă pot conecta la baza de date admin!<br/>"
                    + "Fie nu ai acces la server,<br/>"
                    + "fie nu ai conexiune la internet.</html>");
            continutDialog.setFont(new Font("Arial", Font.PLAIN, 24));
            String[] optiuni = {"Reîncercare", "Anulare"}; // optiunile dialogului
            UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 18))); // dimensiune font butoane

            // mesajul de reconectare la baza de date
            int optiuneAleasa = JOptionPane.showOptionDialog(panou, continutDialog, "Conectare Eșuată!",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon(PanouControl.class.getResource("/imagini/connection.png")),
                    optiuni, optiuni[0]);

            // reconectare daca s-a apasat "Reîncercare"
            if (optiuneAleasa == 0) {
                conectare(panou);
                return;

            } // inchidere program daca s-a apasat "Anulare" sau "Inchidere Fereastra" 
            else if (optiuneAleasa == 1 || optiuneAleasa == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }
        }

        System.out.println("Incarc driver-ul admin...");
        try {
            adminConnection = DriverManager.getConnection(adminUrl, adminUsername, adminPassword); // conectare la baza de date

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver admin incarcat!");

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the admin driver in the classpath!", e);

        } catch (SQLException ex) {
            System.out.println("lol");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
