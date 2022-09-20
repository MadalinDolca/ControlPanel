package conturi;

import global.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ConturiModelTabel extends AbstractTableModel {

    public ArrayList<Conturi> conturiArray = new ArrayList<Conturi>();
    String coloane[] = {"ID", "Nume", "Usertype", "Creat", "Actualizat"};

    public ConturiModelTabel() {
        conturiArray = copiazaDBinArrayList();
    }

    @Override
    public int getRowCount() {
        return conturiArray.size();
    }

    @Override
    public int getColumnCount() {
        return coloane.length;
    }

    @Override
    public String getColumnName(int indexColoana) {
        return coloane[indexColoana];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Conturi a = conturiArray.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.id;
            case 1:
                return a.username;
            case 2:
                return a.usertype;
            case 3:
                return a.creat;
            case 4:
                return a.actualizat;
        }

        return null;
    }

    public void sterge(int[] tab) {
        for (int i = tab.length - 1; i >= 0; i--) {
            conturiArray.remove(tab[i]);
        }

        this.fireTableRowsDeleted(tab[0], tab[tab.length - 1]);
    }

    public ArrayList<Conturi> copiazaDBinArrayList() {
        ArrayList<Conturi> conturiDBArray = new ArrayList<Conturi>();

        try {
            Database.adminStmt = Database.adminConnection.createStatement();
            Database.adminRs = Database.adminStmt.executeQuery(
                    "select id, username, usertype, creat, actualizat from Conturi;");

            while (Database.adminRs.next()) {
                conturiDBArray.add(new Conturi(
                        Database.adminRs.getInt("id"),
                        Database.adminRs.getString("username"),
                        Database.adminRs.getString("usertype"),
                        Database.adminRs.getString("creat"),
                        Database.adminRs.getString("actualizat")));
            }

        } catch (SQLException ex) {
            System.out.println("Eroare preluare date!");
        }

        return conturiDBArray;
    }
}
