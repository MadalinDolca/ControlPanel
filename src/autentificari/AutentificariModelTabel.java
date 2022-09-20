package autentificari;

import global.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AutentificariModelTabel extends AbstractTableModel {

    public ArrayList<Autentificari> autentificariArray = new ArrayList<Autentificari>();
    String coloane[] = {"ID", "Nume Cont", "Nume PC", "ID PC", "Accesare"};

    public AutentificariModelTabel() {
        autentificariArray = copiazaDBinArrayList();
    }

    @Override
    public int getRowCount() {
        return autentificariArray.size();
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
        Autentificari a = autentificariArray.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.id;
            case 1:
                return a.numeCont;
            case 2:
                return a.numePC;
            case 3:
                return a.idPC;
            case 4:
                return a.accesare;
        }

        return null;
    }

    public void sterge(int[] tab) {
        for (int i = tab.length - 1; i >= 0; i--) {
            autentificariArray.remove(tab[i]);
        }

        this.fireTableRowsDeleted(tab[0], tab[tab.length - 1]);
    }

    public ArrayList<Autentificari> copiazaDBinArrayList() {
        ArrayList<Autentificari> autentificariDBArray = new ArrayList<Autentificari>();

        try {
            Database.adminStmt = Database.adminConnection.createStatement();
            Database.adminRs = Database.adminStmt.executeQuery(
                    "select * from Autentificari order by id desc;");

            while (Database.adminRs.next()) {
                autentificariDBArray.add(new Autentificari(
                        Database.adminRs.getInt("id"),
                        Database.adminRs.getString("numeCont"),
                        Database.adminRs.getString("numePC"),
                        Database.adminRs.getString("uuid"),
                        Database.adminRs.getString("accesare")));
            }

        } catch (SQLException ex) {
            System.out.println("Eroare preluare date!");
        }

        return autentificariDBArray;
    }
}
