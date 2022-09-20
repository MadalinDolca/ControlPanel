package controlpanel;

import global.Database;
import global.Mesaje;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class ModificaContDialog extends javax.swing.JDialog {

    JTable modificaConturiTable;
    String usernameAux;

    public ModificaContDialog(java.awt.Frame parent, boolean modal, JTable conturiTable) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagini/icon.png")).getImage());
        this.setLocationRelativeTo(parent); // pozitia modalului corespunde cu cea a ferestrei

        modificaConturiTable = conturiTable; // instantiere

        // completare campuri cu datele selectate din tabel
        numeTextField.setText(modificaConturiTable.getValueAt(modificaConturiTable.getSelectedRow(), 1).toString());
        gradComboBox.setSelectedItem(modificaConturiTable.getValueAt(modificaConturiTable.getSelectedRow(), 2).toString());

        // preluare parola cont si adaugare in text field
        try {
            Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
            Database.adminRs = Database.adminStmt.executeQuery(
                    "select password from Conturi "
                    + "where username = '" + numeTextField.getText() + "'");
            Database.adminRs.next();

            parolaTextField.setText(Database.adminRs.getString("password"));

        } catch (Exception e) {
            Mesaje.mesajAtentionare(this, "Eroare!",
                    "Eroare preluare parolă!", "error");
        }
        
        usernameAux = numeTextField.getText(); // memorare username
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        modificaContButton = new javax.swing.JButton();
        numeTextField = new javax.swing.JTextField();
        parolaTextField = new javax.swing.JTextField();
        gradComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Grad");

        modificaContButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        modificaContButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagini/floppy-disk.png"))); // NOI18N
        modificaContButton.setText("Actualizează Cont");
        modificaContButton.setIconTextGap(10);
        modificaContButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaContButtonActionPerformed(evt);
            }
        });

        numeTextField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        parolaTextField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        gradComboBox.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        gradComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "profesor" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Parola");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Nume");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modificaContButton, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(parolaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gradComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parolaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addComponent(modificaContButton)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificaContButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaContButtonActionPerformed
        boolean potAdauga = true;
        int idRandSelectat = Integer.parseInt(modificaConturiTable.getValueAt(modificaConturiTable.getSelectedRow(), 0).toString());

        // verific completarea si corectitudinea campurilor
        if (numeTextField.getText().equals("") || parolaTextField.getText().equals("")) {
            Mesaje.mesajAtentionare(this, "Atenție!", "Ai lăsat un câmp gol!", "warning");
            potAdauga = false;

        } // daca campurile sunt completate verifica daca NOUL username exista deja
        else if(!numeTextField.getText().equals(usernameAux)) {
            try {
                Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
                Database.adminRs = Database.adminStmt.executeQuery(
                        "select username from Conturi where username = '"
                        + numeTextField.getText() + "';");
                Database.adminRs.next();

                String existentaUsername = Database.adminRs.getString("username");

                if (numeTextField.getText().equals(existentaUsername)) {
                    Mesaje.mesajAtentionare(this, "Atenție!",
                            "<html><b>Username</b>-ul este indisponibil!</html>", "warning");
                    potAdauga = false;
                }

            } catch (SQLException ex) {
                // raporteaza faptul ca nu putem opera o selectie nula
                // Logger.getLogger(AdaugaDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // actualizare in baza de date
        if (potAdauga == true) {
            try {
                Database.adminStmt = Database.adminConnection.createStatement(); // obiect de trimitere a statement-urilor spre baza de date
                Database.adminStmt.executeUpdate(
                        "update Conturi set "
                        + "username = '" + numeTextField.getText() + "', "
                        + "password = '" + parolaTextField.getText() + "', "
                        + "usertype = '" + gradComboBox.getSelectedItem().toString() + "', "
                        + "actualizat = now() "
                        + "where id = " + idRandSelectat + ";"
                );

                this.dispose(); // inlaturare fereastra dupa adaugarea datelor

            } catch (SQLException ex) {
                Mesaje.mesajAtentionare(this, null,
                        "Eroare bază de date!", "warning");
                /*Mesaje.mesajDialogReconectare(this, "Eroare Adăugare!",
                    "<html><b>Adăugare eșuată!</b><br/>"
                    + "Probabil s-a întrerupt conexiunea.</html>");*/
            }
        }
    }//GEN-LAST:event_modificaContButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(ModificaContDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificaContDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificaContDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificaContDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> gradComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton modificaContButton;
    private javax.swing.JTextField numeTextField;
    private javax.swing.JTextField parolaTextField;
    // End of variables declaration//GEN-END:variables
}
