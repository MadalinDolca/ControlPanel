package utilizatori_restrictionati;

import global.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class UtilizatoriRestrictionatiModelTabel extends AbstractTableModel {

    public ArrayList<UtilizatoriRestrictionati> utilizatoriRestrictionatiArray = new ArrayList<UtilizatoriRestrictionati>();
    String coloane[] = {"ID", "Nume Cont"};

    public UtilizatoriRestrictionatiModelTabel() {
        utilizatoriRestrictionatiArray = copiazaDBinArrayList();
    }

    @Override
    public int getRowCount() {
        return utilizatoriRestrictionatiArray.size();
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
        UtilizatoriRestrictionati a = utilizatoriRestrictionatiArray.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.id;
            case 1:
                return a.numeCont;
        }

        return null;
    }

    public void sterge(int[] tab) {
        for (int i = tab.length - 1; i >= 0; i--) {
            utilizatoriRestrictionatiArray.remove(tab[i]);
        }

        this.fireTableRowsDeleted(tab[0], tab[tab.length - 1]);
    }

    public ArrayList<UtilizatoriRestrictionati> copiazaDBinArrayList() {
        ArrayList<UtilizatoriRestrictionati> autentificariDBArray = new ArrayList<UtilizatoriRestrictionati>();

        try {
            Database.adminStmt = Database.adminConnection.createStatement();
            Database.adminRs = Database.adminStmt.executeQuery(
                    "select * from BannedAccounts;");

            while (Database.adminRs.next()) {
                autentificariDBArray.add(new UtilizatoriRestrictionati(
                        Database.adminRs.getInt("id"),
                        Database.adminRs.getString("numeCont")));
            }

        } catch (SQLException ex) {
            System.out.println("Eroare preluare date!");
        }

        return autentificariDBArray;
    }
}
