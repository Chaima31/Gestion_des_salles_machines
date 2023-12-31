/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.IDao;
import entities.Salle;
import entities.Machine;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lachgar
 */
public class SalleForm extends javax.swing.JInternalFrame {

    IDao<Salle> dao = null;
    DefaultTableModel model = null;
    DefaultTableModel modelMachine = null;

    IDao<Machine> daoMachine = null;

    List<Machine> machines = null;

    public void load() {
        try {
            model.setRowCount(0);
            for (Salle m : dao.findAll()) {
                model.addRow(new Object[]{
                    m.getId(),
                    m.getCode()
                });
            }
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SalleForm() {
        initComponents();
        try {
            dao = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/daosalle");
            daoMachine = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao");

        } catch (NotBoundException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        model = (DefaultTableModel) listSalles.getModel();
        modelMachine = (DefaultTableModel) listMachines.getModel();
        try {
            machines = daoMachine.findAll();
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        load();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        bnAdd = new javax.swing.JButton();
        bnUpdate = new javax.swing.JButton();
        bnDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSalles = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMachines = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        setClosable(true);
        setForeground(new java.awt.Color(0, 0, 255));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gérer les salles ");
        setToolTipText("");
        setFrameIcon(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 2, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Code :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        bnAdd.setBackground(new java.awt.Color(255, 255, 255));
        bnAdd.setFont(new java.awt.Font("Traditional Arabic", 3, 14)); // NOI18N
        bnAdd.setForeground(new java.awt.Color(255, 153, 153));
        bnAdd.setText("Ajouter");
        bnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAddActionPerformed(evt);
            }
        });

        bnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        bnUpdate.setFont(new java.awt.Font("Traditional Arabic", 3, 13)); // NOI18N
        bnUpdate.setForeground(new java.awt.Color(255, 102, 102));
        bnUpdate.setText("Modifier");
        bnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnUpdateActionPerformed(evt);
            }
        });

        bnDelete.setBackground(new java.awt.Color(255, 255, 255));
        bnDelete.setFont(new java.awt.Font("Traditional Arabic", 3, 13)); // NOI18N
        bnDelete.setForeground(new java.awt.Color(204, 51, 0));
        bnDelete.setText("Supprimer");
        bnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnAdd)
                    .addComponent(bnUpdate)
                    .addComponent(bnDelete))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.MatteBorder(null));

        listSalles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listSalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Code"
            }
        ));
        listSalles.setSelectionBackground(new java.awt.Color(255, 153, 153));
        listSalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSallesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSalles);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));

        listMachines.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", 0, 0, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(0, 0, 255))); // NOI18N
        listMachines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Référence", "Marque", "Prix"
            }
        ));
        jScrollPane3.setViewportView(listMachines);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(260, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("ENTRE Le code de la salle");
        jPanel1.getAccessibleContext().setAccessibleDescription("");
        jPanel4.getAccessibleContext().setAccessibleName("Liste des machines d'une salle");
        jPanel4.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddActionPerformed
        try {
            // TODO add your handling code here:
            String code = txtCode.getText().toString();
            dao.create(new Salle(code));
            load();
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bnAddActionPerformed

    private void bnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnUpdateActionPerformed
        int selectedIndex = listSalles.getSelectedRow();
        System.out.println(selectedIndex);
        if (selectedIndex != -1) {
            String code = txtCode.getText();
            int idSalle = Integer.parseInt(listSalles.getValueAt(selectedIndex, 0).toString());
            Salle salle = new Salle();
            salle.setCode(code);
            salle.setId(idSalle);
            System.out.println(salle);
            try {
                dao.update(salle);
                load();
            } catch (RemoteException ex) {
                Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bnUpdateActionPerformed

    private void listSallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSallesMouseClicked
      int selectedIndex = listSalles.getSelectedRow();
    
    if (selectedIndex != -1) {
        txtCode.setText(listSalles.getValueAt(selectedIndex, 1).toString());
        int idSalle = Integer.parseInt(listSalles.getValueAt(selectedIndex, 0).toString());

        modelMachine.setRowCount(0); // Clear the table

        if (machines != null) { // Check if machines is not null
            for (Machine m : machines) {
                if (m.getSalle() != null && m.getSalle().getId() == idSalle) {
                    modelMachine.addRow(new Object[]{
                        m.getId(),
                        m.getRef(),
                        m.getMarque(),
                        m.getPrix()
                    });
                }
            }
        }
    }
          
    }//GEN-LAST:event_listSallesMouseClicked

    private void bnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteActionPerformed
    int selectedIndex = listSalles.getSelectedRow();
    System.out.println(selectedIndex);
    if (selectedIndex != -1) {
        String code = txtCode.getText();
        int idSalle = Integer.parseInt(listSalles.getValueAt(selectedIndex, 0).toString());
        Salle salle = new Salle();
        salle.setCode(code);
        salle.setId(idSalle);

        if (machines != null) { // Check if machines is not null
            for (Machine m : machines) {
                if (m.getSalle() != null && m.getSalle().getId() == idSalle) {
                    try {
                        daoMachine.delete(m);
                    } catch (RemoteException ex) {
                        Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        try {
            dao.delete(salle);
            load();
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }//GEN-LAST:event_bnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAdd;
    private javax.swing.JButton bnDelete;
    private javax.swing.JButton bnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable listMachines;
    private javax.swing.JTable listSalles;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
