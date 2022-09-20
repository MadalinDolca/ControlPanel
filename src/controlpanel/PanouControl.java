package controlpanel;

import global.Database;
import conturi.ConturiModelTabel;
import global.Mesaje;
import autentificari.AutentificariModelTabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import sisteme_restrictionate.SistemeRestrictionateModelTabel;
import utilizatori_restrictionati.UtilizatoriRestrictionatiModelTabel;

public class PanouControl extends javax.swing.JFrame {

    String numeCautat; // nume cont cautat in baza de date
    String sistemCautat; // id-ul sistemului cautat in baza de date
    String numarVersiune;
    String numarVersiuneCurenta;
    String mesajRestrictionare;
    String credit;

    public PanouControl() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagini/icon.png")).getImage());
        Database.conectare(this);

        conturiTable.setModel(new ConturiModelTabel());
        setariTabel(conturiTable);

        autentificariTable.setModel(new AutentificariModelTabel());
        setariTabel(autentificariTable);

        bannedUsersTable.setModel(new UtilizatoriRestrictionatiModelTabel());
        setariTabel(bannedUsersTable);

        bannedSystemsTable.setModel(new SistemeRestrictionateModelTabel());
        resizeColumnWidth(bannedSystemsTable);
    }

    public void setariTabel(JTable tabel) {
        tabel.setAutoCreateRowSorter(true);
        tabel.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        tabel.getTableHeader().setBackground(new Color(240, 240, 240));
        tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resizeColumnWidth(tabel);
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();

        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }

            if (width > 300) {
                width = 300;
            }

            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public void preluareSetariDB() {
        try {
            Database.adminStmt = Database.adminConnection.createStatement();
            Database.adminRs = Database.adminStmt.executeQuery(
                    "select * from Setari where id = 1;");

            while (Database.adminRs.next()) {
                numarVersiuneTextField.setText(Database.adminRs.getString("numarVersiune"));
                numarVersiuneCurentaTextField.setText(Database.adminRs.getString("numarVersiuneCurenta"));
                mesajRestrictionareTextField.setText(Database.adminRs.getString("mesajRestrictionare"));
                creditTextField.setText(Database.adminRs.getString("credit"));
                temaLookAndFeelComboBox.setSelectedItem(Database.adminRs.getString("temaLookAndFeel"));
                melodieComboBox.setSelectedItem(Database.adminRs.getString("melodie"));
            }

        } catch (Exception e) {
            Mesaje.mesajAtentionare(this, null,
                    "Eroare preluare setări!", "warning");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panouControlTabbedPane = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        conturiTable = new javax.swing.JTable();
        baneazaContButton = new javax.swing.JButton();
        adaugaContButton = new javax.swing.JButton();
        modificaContButton = new javax.swing.JButton();
        stergeContButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        autentificariTable = new javax.swing.JTable();
        baneazaUtilizatorAutButton = new javax.swing.JButton();
        baneazaSistemAutButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bannedUsersTable = new javax.swing.JTable();
        debaneazaUtilizatorButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        bannedSystemsTable = new javax.swing.JTable();
        debaneazaSistemButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numarVersiuneTextField = new javax.swing.JTextField();
        actualizareSetariButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        numarVersiuneCurentaTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        mesajRestrictionareTextField = new javax.swing.JTextField();
        creditTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        temaLookAndFeelComboBox = new javax.swing.JComboBox<>();
        melodieComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panou Control - Evidență Elevi");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        panouControlTabbedPane.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        panouControlTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panouControlTabbedPaneStateChanged(evt);
            }
        });

        conturiTable.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        conturiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        conturiTable.setRowHeight(40);
        jScrollPane5.setViewportView(conturiTable);
        if (conturiTable.getColumnModel().getColumnCount() > 0) {
            conturiTable.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            conturiTable.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            conturiTable.getColumnModel().getColumn(3).setHeaderValue("Title 4");
            conturiTable.getColumnModel().getColumn(4).setHeaderValue("Title 5");
        }

        baneazaContButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        baneazaContButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/ban.png"))); // NOI18N
        baneazaContButton.setText("Banează Cont");
        baneazaContButton.setIconTextGap(10);
        baneazaContButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baneazaContButtonActionPerformed(evt);
            }
        });

        adaugaContButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        adaugaContButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/plus.png"))); // NOI18N
        adaugaContButton.setText("Adaugă Cont");
        adaugaContButton.setIconTextGap(10);
        adaugaContButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaContButtonActionPerformed(evt);
            }
        });

        modificaContButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        modificaContButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/pencil.png"))); // NOI18N
        modificaContButton.setText("Modifică Cont");
        modificaContButton.setIconTextGap(10);
        modificaContButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaContButtonActionPerformed(evt);
            }
        });

        stergeContButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        stergeContButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/remove.png"))); // NOI18N
        stergeContButton.setText("Șterge Cont");
        stergeContButton.setIconTextGap(10);
        stergeContButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeContButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(adaugaContButton)
                        .addGap(18, 18, 18)
                        .addComponent(modificaContButton)
                        .addGap(18, 18, 18)
                        .addComponent(baneazaContButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stergeContButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baneazaContButton)
                    .addComponent(adaugaContButton)
                    .addComponent(modificaContButton)
                    .addComponent(stergeContButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panouControlTabbedPane.addTab("Conturi", jPanel4);

        autentificariTable.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        autentificariTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        autentificariTable.setRowHeight(40);
        jScrollPane2.setViewportView(autentificariTable);
        if (autentificariTable.getColumnModel().getColumnCount() > 0) {
            autentificariTable.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            autentificariTable.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            autentificariTable.getColumnModel().getColumn(3).setHeaderValue("Title 4");
            autentificariTable.getColumnModel().getColumn(4).setHeaderValue("Title 5");
        }

        baneazaUtilizatorAutButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        baneazaUtilizatorAutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/ban.png"))); // NOI18N
        baneazaUtilizatorAutButton.setText("Banează Utilizator");
        baneazaUtilizatorAutButton.setIconTextGap(10);
        baneazaUtilizatorAutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baneazaUtilizatorAutButtonActionPerformed(evt);
            }
        });

        baneazaSistemAutButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        baneazaSistemAutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/ban.png"))); // NOI18N
        baneazaSistemAutButton.setText("Banează Sistem");
        baneazaSistemAutButton.setIconTextGap(10);
        baneazaSistemAutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baneazaSistemAutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(baneazaUtilizatorAutButton)
                        .addGap(164, 164, 164)
                        .addComponent(baneazaSistemAutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baneazaUtilizatorAutButton)
                    .addComponent(baneazaSistemAutButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panouControlTabbedPane.addTab("Autentificări", jPanel1);

        bannedUsersTable.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bannedUsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        bannedUsersTable.setRowHeight(40);
        jScrollPane6.setViewportView(bannedUsersTable);
        if (bannedUsersTable.getColumnModel().getColumnCount() > 0) {
            bannedUsersTable.getColumnModel().getColumn(1).setHeaderValue("Title 2");
        }

        debaneazaUtilizatorButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        debaneazaUtilizatorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/dove.png"))); // NOI18N
        debaneazaUtilizatorButton.setText("Debaneză Utilizator");
        debaneazaUtilizatorButton.setIconTextGap(10);
        debaneazaUtilizatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debaneazaUtilizatorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(debaneazaUtilizatorButton)
                .addGap(384, 384, 384))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(debaneazaUtilizatorButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panouControlTabbedPane.addTab("Utilizatori Restricționați", jPanel5);

        bannedSystemsTable.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bannedSystemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        bannedSystemsTable.setRowHeight(40);
        jScrollPane7.setViewportView(bannedSystemsTable);

        debaneazaSistemButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        debaneazaSistemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/dove.png"))); // NOI18N
        debaneazaSistemButton.setText("Debanează Sistem");
        debaneazaSistemButton.setIconTextGap(10);
        debaneazaSistemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debaneazaSistemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(debaneazaSistemButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(debaneazaSistemButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panouControlTabbedPane.addTab("Sisteme Restricționate", jPanel2);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Număr versiune curentă");

        numarVersiuneTextField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        actualizareSetariButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        actualizareSetariButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/floppy-disk.png"))); // NOI18N
        actualizareSetariButton.setText("Actualizare Setări");
        actualizareSetariButton.setIconTextGap(10);
        actualizareSetariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizareSetariButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Număr versiune din aplicație");

        numarVersiuneCurentaTextField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Mesaj restricționare");

        mesajRestrictionareTextField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        creditTextField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Credit");

        temaLookAndFeelComboBox.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        temaLookAndFeelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Windows", "WIndows Classic", "Nimbus" }));

        melodieComboBox.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        melodieComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "Story", "The Hero", "Ranbu no Melody" }));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Temă");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("Melodie");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(temaLookAndFeelComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numarVersiuneTextField)
                    .addComponent(numarVersiuneCurentaTextField)
                    .addComponent(mesajRestrictionareTextField)
                    .addComponent(creditTextField)
                    .addComponent(melodieComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 656, Short.MAX_VALUE))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actualizareSetariButton)
                .addGap(395, 395, 395))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numarVersiuneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numarVersiuneCurentaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesajRestrictionareTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temaLookAndFeelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(melodieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(actualizareSetariButton)
                .addGap(27, 27, 27))
        );

        panouControlTabbedPane.addTab("Setări", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panouControlTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panouControlTabbedPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void baneazaUtilizatorAutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baneazaUtilizatorAutButtonActionPerformed
        if (autentificariTable.getSelectedRow() == -1) {
            Mesaje.mesajAtentionare(this, null, "Nu ați selectat nimic!", "warning");
        } else {
            // obtinere nume cont din tabel
            String numeContSelectat = autentificariTable.getValueAt(autentificariTable.getSelectedRow(), 1).toString();

            try {
                // cautare nume selectat in baza de date
                Database.adminStmt = Database.adminConnection.createStatement();
                Database.adminRs = Database.adminStmt.executeQuery(
                        "select numeCont from BannedAccounts where numeCont = '"
                        + numeContSelectat + "';");

                // memorare nume cautat
                while (Database.adminRs.next()) {
                    numeCautat = Database.adminRs.getString("numeCont");
                }

                // daca este deja restrictionat
                if (numeContSelectat.equals(numeCautat)) {
                    Mesaje.mesajAtentionare(this, null,
                            "Acest utilizator este deja restricționat!", "warning");

                } // daca nu este restrictionat se continua
                else {
                    int confirmareStergere = Mesaje.mesajInterogareOptiune(this,
                            "Restricționare Cont", "Restricționați contul selectat?",
                            "Da", "Nu");

                    if (confirmareStergere != 0) { // daca am apasat "NO" iesim din metoda
                        return;
                    } else { // daca am apasat "YES"
                        try {
                            Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
                            Database.adminStmt.executeUpdate(
                                    "insert into BannedAccounts (numeCont) values ('"
                                    + numeContSelectat + "');"
                            );

                            if (true) {
                                Mesaje.mesajSucces(this, "Cont Restricționat!",
                                        "<html><b>Succes!</b><br/>Contul a fost restricționat!</html>");
                            }

                        } catch (SQLException ex) {
                            /*Mesaje.mesajFrameReconectare(this, "Eroare Ștergere!",
                            "<html><b>Ștergere eșuată!</b><br/>"
                            + "Probabil s-a întrerupt conexiunea.</html>");*/
                            Mesaje.mesajAtentionare(this, null, "Eroare Bază de Date!", "warning");
                        }
                    }
                }

            } catch (SQLException ex) {
                Mesaje.mesajAtentionare(this, null, "Eroare Bază de Date!", "warning");
            }
        }
    }//GEN-LAST:event_baneazaUtilizatorAutButtonActionPerformed

    private void baneazaSistemAutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baneazaSistemAutButtonActionPerformed
        if (autentificariTable.getSelectedRow() == -1) {
            Mesaje.mesajAtentionare(this, null, "Nu ați selectat nimic!", "warning");
        } else {
            // obtinere ID sistem din tabel
            String idSistemSelectat = autentificariTable.getValueAt(autentificariTable.getSelectedRow(), 3).toString();

            try {
                // cautare ID sistem selectat in baza de date
                Database.adminStmt = Database.adminConnection.createStatement();
                Database.adminRs = Database.adminStmt.executeQuery(
                        "select uuid from BannedSystems where uuid = '"
                        + idSistemSelectat + "';");

                // memorare id sistem cautat
                while (Database.adminRs.next()) {
                    sistemCautat = Database.adminRs.getString("uuid");
                }

                // daca este deja restrictionat
                if (idSistemSelectat.equals(sistemCautat)) {
                    Mesaje.mesajAtentionare(this, null,
                            "Acest sistem este deja restricționat!", "warning");

                } // daca nu este restrictionat se continua
                else {
                    int confirmareStergere = Mesaje.mesajInterogareOptiune(this,
                            "Restricționare Cont", "Restricționați sistemul selectat?",
                            "Da", "Nu");

                    if (confirmareStergere != 0) { // daca am apasat "NO" iesim din metoda
                        return;
                    } else { // daca am apasat "YES"
                        try {
                            // obtinere id sistem
                            String sistemSelectat = autentificariTable.getValueAt(autentificariTable.getSelectedRow(), 3).toString();

                            Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
                            Database.adminStmt.executeUpdate(
                                    "insert into BannedSystems (uuid) values ('"
                                    + sistemSelectat + "');"
                            );

                            if (true) {
                                Mesaje.mesajSucces(this, "Sistem Restricționat!",
                                        "<html><b>Succes!</b><br/>Sistemul a fost restricționat!</html>");
                            }

                        } catch (SQLException ex) {
                            /*Mesaje.mesajFrameReconectare(this, "Eroare Ștergere!",
                            "<html><b>Ștergere eșuată!</b><br/>"
                            + "Probabil s-a întrerupt conexiunea.</html>");*/
                            Mesaje.mesajAtentionare(this, null, "Eroare Bază de Date!", "warning");
                        }
                    }
                }
            } catch (Exception e) {
                Mesaje.mesajAtentionare(this, null, "Eroare Bază de Date!", "warning");
            }

        }
    }//GEN-LAST:event_baneazaSistemAutButtonActionPerformed

    private void panouControlTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panouControlTabbedPaneStateChanged
        //if (evt.getSource() == ChangeEvent.class) {
        // conturi
        if (panouControlTabbedPane.getSelectedIndex() == 0) {
            //conturiTable.setModel(new ConturiModelTabel());
            //setariTabel(conturiTable);

        } // autentificari
        else if (panouControlTabbedPane.getSelectedIndex() == 1) {
            autentificariTable.setModel(new AutentificariModelTabel());
            setariTabel(autentificariTable);

        } // utilizatori restrictionati
        else if (panouControlTabbedPane.getSelectedIndex() == 2) {
            bannedUsersTable.setModel(new UtilizatoriRestrictionatiModelTabel());
            setariTabel(bannedUsersTable);

        } // sisteme restrictionate
        else if (panouControlTabbedPane.getSelectedIndex() == 3) {
            bannedSystemsTable.setModel(new SistemeRestrictionateModelTabel());
            setariTabel(bannedSystemsTable);

        } // setari
        else if (panouControlTabbedPane.getSelectedIndex() == 4) {
            preluareSetariDB();
        }
        //}
    }//GEN-LAST:event_panouControlTabbedPaneStateChanged

    private void baneazaContButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baneazaContButtonActionPerformed
        if (conturiTable.getSelectedRow() == -1) {
            Mesaje.mesajAtentionare(this, null, "Nu ați selectat nimic!", "warning");
        } else {
            // obtinere nume cont din tabel
            String numeContSelectat = conturiTable.getValueAt(conturiTable.getSelectedRow(), 1).toString();

            try {
                // cautare nume selectat in baza de date
                Database.adminStmt = Database.adminConnection.createStatement();
                Database.adminRs = Database.adminStmt.executeQuery(
                        "select numeCont from BannedAccounts where numeCont = '"
                        + numeContSelectat + "';");

                // memorare nume cautat
                while (Database.adminRs.next()) {
                    numeCautat = Database.adminRs.getString("numeCont");
                }

                // daca este deja restrictionat
                if (numeContSelectat.equals(numeCautat)) {
                    Mesaje.mesajAtentionare(this, null,
                            "Acest utilizator este deja restricționat!", "warning");

                } // daca nu este restrictionat se continua
                else {
                    int confirmareStergere = Mesaje.mesajInterogareOptiune(this,
                            "Restricționare Cont", "Restricționați contul selectat?",
                            "Da", "Nu");

                    if (confirmareStergere != 0) { // daca am apasat "NO" iesim din metoda
                        return;
                    } else { // daca am apasat "YES"
                        try {
                            Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
                            Database.adminStmt.executeUpdate(
                                    "insert into BannedAccounts (numeCont) values ('"
                                    + numeContSelectat + "');"
                            );

                            if (true) {
                                Mesaje.mesajSucces(this, "Cont Restricționat!",
                                        "<html><b>Succes!</b><br/>Contul a fost restricționat!</html>");
                            }

                        } catch (SQLException ex) {
                            /*Mesaje.mesajFrameReconectare(this, "Eroare Ștergere!",
                            "<html><b>Ștergere eșuată!</b><br/>"
                            + "Probabil s-a întrerupt conexiunea.</html>");*/
                            Mesaje.mesajAtentionare(this, null, "Eroare Bază de Date!", "warning");
                        }
                    }
                }
            } catch (SQLException ex) {
                Mesaje.mesajAtentionare(this, null, "Eroare Bază de Date!", "warning");
            }
        }
    }//GEN-LAST:event_baneazaContButtonActionPerformed

    private void debaneazaUtilizatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debaneazaUtilizatorButtonActionPerformed
        if (bannedUsersTable.getSelectedRow() == -1) {
            Mesaje.mesajAtentionare(this, null, "Nu ați selectat nimic!", "warning");
        } else {
            int confirmareStergere = Mesaje.mesajInterogareOptiune(this,
                    "Debanează Utilizator", "Debanați contul selectat?",
                    "Da", "Nu");

            if (confirmareStergere != 0) { // daca am apasat "NO" iesim din metoda
                return;
            } else { // daca am apasat "YES"
                try {
                    // obtinere nume cont
                    String numeContSelectat = bannedUsersTable.getValueAt(bannedUsersTable.getSelectedRow(), 1).toString();

                    Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
                    Database.adminStmt.executeUpdate(
                            "delete from BannedAccounts where numeCont = '"
                            + numeContSelectat + "';"
                    );

                    if (true) {
                        Mesaje.mesajSucces(this, "Cont Debanat!",
                                "<html><b>Succes!</b><br/>Contul a fost debanat!</html>");
                    }

                } catch (SQLException ex) {
                    /*Mesaje.mesajFrameReconectare(this, "Eroare Ștergere!",
                            "<html><b>Ștergere eșuată!</b><br/>"
                            + "Probabil s-a întrerupt conexiunea.</html>");*/
                    Mesaje.mesajAtentionare(this, null, "Eroare Bază de Date!", "warning");
                }
            }
        }
    }//GEN-LAST:event_debaneazaUtilizatorButtonActionPerformed

    private void debaneazaSistemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debaneazaSistemButtonActionPerformed
        if (bannedSystemsTable.getSelectedRow() == -1) {
            Mesaje.mesajAtentionare(this, null, "Nu ați selectat nimic!", "warning");
        } else {
            int confirmareStergere = Mesaje.mesajInterogareOptiune(this,
                    "Debanare Sistem", "Debanați sistemul selectat?",
                    "Da", "Nu");

            if (confirmareStergere != 0) { // daca am apasat "NO" iesim din metoda
                return;
            } else { // daca am apasat "YES"
                try {
                    // obtinere nume cont
                    String numeContSelectat = bannedSystemsTable.getValueAt(bannedSystemsTable.getSelectedRow(), 1).toString();

                    Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
                    Database.adminStmt.executeUpdate(
                            "delete from BannedSystems where uuid = '"
                            + numeContSelectat + "';"
                    );

                    if (true) {
                        Mesaje.mesajSucces(this, "Sistem debanat!",
                                "<html><b>Succes!</b><br/>Sistemul a fost debanat!</html>");
                    }

                } catch (SQLException ex) {
                    /*Mesaje.mesajFrameReconectare(this, "Eroare Ștergere!",
                            "<html><b>Ștergere eșuată!</b><br/>"
                            + "Probabil s-a întrerupt conexiunea.</html>");*/
                    Mesaje.mesajAtentionare(this, null, "Eroare Bază de Date!", "warning");
                }
            }
        }
    }//GEN-LAST:event_debaneazaSistemButtonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        conturiTable.setModel(new ConturiModelTabel());
        setariTabel(conturiTable);

        autentificariTable.setModel(new AutentificariModelTabel());
        resizeColumnWidth(autentificariTable);

        bannedUsersTable.setModel(new UtilizatoriRestrictionatiModelTabel());
        resizeColumnWidth(bannedUsersTable);

        bannedSystemsTable.setModel(new SistemeRestrictionateModelTabel());
        resizeColumnWidth(bannedSystemsTable);

        preluareSetariDB();
    }//GEN-LAST:event_formWindowGainedFocus

    private void actualizareSetariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizareSetariButtonActionPerformed
        try {
            Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
            Database.adminStmt.executeUpdate("update Setari set "
                    + "numarVersiune = '" + numarVersiuneTextField.getText() + "', "
                    + "numarVersiuneCurenta = '" + numarVersiuneCurentaTextField.getText() + "', "
                    + "mesajRestrictionare = '" + mesajRestrictionareTextField.getText() + "', "
                    + "credit = '" + creditTextField.getText() + "', "
                    + "temaLookAndFeel = '" + temaLookAndFeelComboBox.getSelectedItem().toString() + "', "
                    + "melodie = '" + melodieComboBox.getSelectedItem().toString() + "' "
                    + "where id = 1;"
            );

            Mesaje.mesajSucces(this, "Actualizare Reușită!",
                    "<html><b>Succes!</b><br/>Setările au fost actualizate!</html>");

        } catch (Exception e) {
            Mesaje.mesajAtentionare(this, null, "Eroare actualizare date!", "warning");
        }
    }//GEN-LAST:event_actualizareSetariButtonActionPerformed

    private void adaugaContButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaContButtonActionPerformed
        new AdaugaContDialog(this, true).setVisible(true); // deschide fereastra dialog adaugare cont
    }//GEN-LAST:event_adaugaContButtonActionPerformed

    private void modificaContButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaContButtonActionPerformed
        if (conturiTable.getSelectedRow() == -1) { // daca nu avem nici o linie selectata
            Mesaje.mesajAtentionare(this, null, "Nu ați selectat nici un elev!", "warning");
        } else {
            new ModificaContDialog(this, true, conturiTable).setVisible(true); // deschide fereastra dialog de actualizare
        }
    }//GEN-LAST:event_modificaContButtonActionPerformed

    private void stergeContButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeContButtonActionPerformed
        if (conturiTable.getSelectedRow() == -1) {
            Mesaje.mesajAtentionare(this, null, "Nu ați selectat nimic!", "warning");
        } else {
            int confirmareStergere = Mesaje.mesajInterogareOptiune(this,
                    "Ștergere Cont", "Ștergeți contul selectat?",
                    "Da", "Nu");

            if (confirmareStergere != 0) { // daca am apasat "NO" iesim din metoda
                return;
            } else { // daca am apasat "YES"
                try {
                    // obtinem id-ul randului selectat
                    int idRandSelectat = Integer.parseInt(conturiTable.getValueAt(conturiTable.getSelectedRow(), 0).toString());

                    Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
                    Database.adminStmt.executeUpdate(
                            "delete from Conturi where id = " + idRandSelectat + ";"
                    );

                    if (true) {
                        Mesaje.mesajSucces(this, "Cont Șters",
                                "<html><b>Succes!</b><br/>Un cont a fost șters.</html>");
                    }

                } catch (SQLException ex) {
                    Mesaje.mesajAtentionare(this, null,
                            "Eroare bază de date!", "warning");
                    /*Mesaje.mesajFrameReconectare(this, "Eroare Ștergere!",
                            "<html><b>Ștergere eșuată!</b><br/>"
                            + "Probabil s-a întrerupt conexiunea.</html>");*/
                }
            }
        }
    }//GEN-LAST:event_stergeContButtonActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanouControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanouControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanouControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanouControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanouControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizareSetariButton;
    private javax.swing.JButton adaugaContButton;
    private javax.swing.JTable autentificariTable;
    private javax.swing.JButton baneazaContButton;
    private javax.swing.JButton baneazaSistemAutButton;
    private javax.swing.JButton baneazaUtilizatorAutButton;
    private javax.swing.JTable bannedSystemsTable;
    private javax.swing.JTable bannedUsersTable;
    private javax.swing.JTable conturiTable;
    private javax.swing.JTextField creditTextField;
    private javax.swing.JButton debaneazaSistemButton;
    private javax.swing.JButton debaneazaUtilizatorButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JComboBox<String> melodieComboBox;
    private javax.swing.JTextField mesajRestrictionareTextField;
    private javax.swing.JButton modificaContButton;
    private javax.swing.JTextField numarVersiuneCurentaTextField;
    private javax.swing.JTextField numarVersiuneTextField;
    private javax.swing.JTabbedPane panouControlTabbedPane;
    private javax.swing.JButton stergeContButton;
    private javax.swing.JComboBox<String> temaLookAndFeelComboBox;
    // End of variables declaration//GEN-END:variables
}
