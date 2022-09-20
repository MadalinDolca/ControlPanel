package sisteme_restrictionate;

import global.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class SistemeRestrictionateModelTabel extends AbstractTableModel {

    public ArrayList<SistemeRestrictionate> sistemeRestrictionateArray = new ArrayList<SistemeRestrictionate>();
    String coloane[] = {"ID", "ID Sistem"};

    public SistemeRestrictionateModelTabel() {
        sistemeRestrictionateArray = copiazaDBinArrayList();
    }

    @Override
    public int getRowCount() {
        return sistemeRestrictionateArray.size();
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
        SistemeRestrictionate a = sistemeRestrictionateArray.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.id;
            case 1:
                return a.idSistem;
        }

        return null;
    }

    public void sterge(int[] tab) {
        for (int i = tab.length - 1; i >= 0; i--) {
            sistemeRestrictionateArray.remove(tab[i]);
        }

        this.fireTableRowsDeleted(tab[0], tab[tab.length - 1]);
    }

    public ArrayList<SistemeRestrictionate> copiazaDBinArrayList() {
        ArrayList<SistemeRestrictionate> sistemeDBArray = new ArrayList<SistemeRestrictionate>();

        try {
            Database.adminStmt = Database.adminConnection.createStatement();
            Database.adminRs = Database.adminStmt.executeQuery(
                    "select * from BannedSystems;");

            while (Database.adminRs.next()) {
                sistemeDBArray.add(new SistemeRestrictionate(
                        Database.adminRs.getInt("id"),
                        Database.adminRs.getString("uuid")));
            }

        } catch (SQLException ex) {
            System.out.println("Eroare preluare date!");
        }

        return sistemeDBArray;
    }
}
