/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.FrontEnd;

import CMMS.Models.Inventory;
import CMMS.Models.Supplier;
import CMMS.ServiceLayer.EquipmentServiceLayer;
import CMMS.Utilities.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramesh Wijerathna
 */
public class Manage_Equi_Panel extends javax.swing.JPanel {

    /**
     * Creates new form Add_Equipment_Panel
     */
    ArrayList<Inventory> inventoryList;
    int branchID = 0;

    public Manage_Equi_Panel(String brID) {
        initComponents();
        branchID = Integer.parseInt(brID);
        inventoryList = new ArrayList<>();
        //Add to service button is hidden
        btnAddToServ.setVisible(false);
        LoadSuppliers();
    }

    //Fetching suplliers information for inventory table
    public void LoadSuppliers() {
        ArrayList<Supplier> sup = EquipmentServiceLayer.GetAllSuppliers();

        DefaultTableModel tbl = (DefaultTableModel) tblSupplier.getModel();
        tbl.setRowCount(0);

        for (Supplier sp : sup) {
            Object[] rowData = {
                sp.getSupID(),
                sp.getSupComName()
            };
            tbl.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtEqmtName = new javax.swing.JTextField();
        txtEqmtModel = new javax.swing.JTextField();
        txtEqmtSerialNo = new javax.swing.JTextField();
        txtEqmtValue = new javax.swing.JTextField();
        txtEqmtInvoiceNo = new javax.swing.JTextField();
        txtEqmtWarrantyExpDate = new javax.swing.JTextField();
        txtEqmInvoiceDate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtBrnID = new javax.swing.JTextField();
        txtSupID = new javax.swing.JTextField();
        txtIsuCount = new javax.swing.JTextField();
        btnAddToServ = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEqmtID = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();

        txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");

        txtEqmInvoiceDate.setText("DD/MM/YYYY");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Update Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Delete Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnAddToServ.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAddToServ.setText("Add to service");
        btnAddToServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToServActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIsuCount)
                    .addComponent(txtSupID)
                    .addComponent(txtEqmtInvoiceNo)
                    .addComponent(txtEqmtValue)
                    .addComponent(txtEqmtSerialNo)
                    .addComponent(txtBrnID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddToServ, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(txtEqmtWarrantyExpDate, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEqmInvoiceDate, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEqmtModel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEqmtName, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtEqmtName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEqmtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEqmtSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEqmtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEqmtInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSupID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBrnID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEqmtWarrantyExpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEqmInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIsuCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnAddToServ))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Equipment Name :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Model :");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Serial Number :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Value :");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Invoice Number :");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Warrenty Expire Date : ");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Invoice Date  : ");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Branch ID :");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Supplier ID :");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Issue Count :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Equipment ID :");

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Equipments");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(txtEqmtID, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEqmtID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Supplier ID", "Supllier Company Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSupplier);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //Search button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            String EquipID = txtEqmtID.getText();
            if (EquipID.trim().isEmpty()) {
                throw new EquipIDNullException();
            }

            //Populating text fields in form from database
            ArrayList<Inventory> InventoryDetails = EquipmentServiceLayer.SearchEquipment(EquipID, branchID);
            if (InventoryDetails.size() > 0) {
                for (Inventory inv : InventoryDetails) {
                    txtEqmtName.setText(inv.getItemName());
                    txtEqmtModel.setText(inv.getModel());
                    txtEqmtSerialNo.setText(inv.getSelialNumber());
                    txtEqmtValue.setText(Integer.toString(inv.getItemValue()));
                    txtEqmtInvoiceNo.setText(inv.getInvNum());
                    txtSupID.setText(inv.getSupID());
                    txtBrnID.setText(Integer.toString(inv.getBrnID()));

                    Date wdate = inv.getWarntDate();
                    if (wdate != null) {
                        DateFormat wdateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String warrDate = wdateFormat.format(wdate);

                        txtEqmtWarrantyExpDate.setText(warrDate);
                    } else {
                        txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");
                    }

                    Date idate = inv.getInvDate();
                    DateFormat idateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String invDate = idateFormat.format(idate);

                    txtEqmInvoiceDate.setText(invDate);
                    txtIsuCount.setText(Integer.toString(inv.getIssCount()));
                    if (inv.getStatus().substring(0, 3).compareTo("Out") == 0) {
                        btnAddToServ.setVisible(true);
                    } else {
                        btnAddToServ.setVisible(false);
                    }
                }
            } else {
                txtEqmtID.setText("");
                txtEqmtName.setText("");
                txtEqmtModel.setText("");
                txtEqmtSerialNo.setText("");
                txtEqmtValue.setText("");
                txtEqmtInvoiceNo.setText("");
                txtBrnID.setText("");
                txtSupID.setText("");
                txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");
                txtEqmInvoiceDate.setText("DD/MM/YYYY");
                txtIsuCount.setText("");

                JOptionPane.showMessageDialog(this, "Data Record Is Not Available!", "Error!", 2);
            }
        } catch (EquipIDNullException ex1) {
            JOptionPane.showMessageDialog(this, ex1.getLocalizedMessage(), "Error!", 2);
        } catch (NumberFormatException nex1) {
            JOptionPane.showMessageDialog(this, "Invalid Data Type: \n" + nex1.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    //Update button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String EquipID = txtEqmtID.getText();
            if (EquipID.trim().isEmpty()) {
                throw new EquipIDNullException();
            }
            String EquipName = txtEqmtName.getText();
            if (EquipName.trim().isEmpty()) {
                throw new EquipNameNullException();
            }
            String EquipModel = txtEqmtModel.getText();
            if (EquipModel.trim().isEmpty()) {
                throw new EquipModelNullException();
            }
            String EquipSerNo = txtEqmtSerialNo.getText();
            if (EquipSerNo.trim().isEmpty()) {
                throw new EquipSerialNoNullException();
            }
            String EquipValue = txtEqmtValue.getText();
            int EquipVal = Integer.parseInt(EquipValue);
            if (EquipValue.trim().isEmpty() || EquipVal <= 0) {
                throw new EquipValueInvalidException();
            }
            String EquipInvNo = txtEqmtInvoiceNo.getText();
            if (EquipInvNo.trim().isEmpty()) {
                throw new EquipInvoiceNoNullException();
            }
            String EquipSupID = txtSupID.getText();
            if (EquipSupID.trim().isEmpty()) {
                throw new EquipSupIDNullException();
            }
            String EquipBrnID = txtBrnID.getText();
            int EquipBID = Integer.parseInt(EquipBrnID);
            if (EquipBrnID.trim().isEmpty() || EquipBID <= 0) {
                throw new EquipBranchIDNullException();
            }
            String EquipWarDate = txtEqmtWarrantyExpDate.getText();
            //Checking whether the Warranty section is empty or not
            Date warntDate = null;
            if (!(EquipWarDate.compareTo("DD/MM/YYYY") == 0)) {
                warntDate = new SimpleDateFormat("dd/MM/yyyy").parse(EquipWarDate);
            }

            Date systemDate = new Date();
            String EquipInvDate = txtEqmInvoiceDate.getText();
            Date invDate = new SimpleDateFormat("dd/MM/yyyy").parse(EquipInvDate);
            if (EquipInvDate.trim().isEmpty() || (invDate.compareTo(systemDate) > 0)) {
                throw new EquipInvoiceDateException();
            }
            //Checking whether the warranty date is valid or not whether comparing with invoice date
            if ((warntDate != null) && (warntDate.compareTo(invDate) < 0)) {
                throw new EquipInvalidWarrantyDateException();
            }

            String isCount = txtIsuCount.getText();
            int issCount = Integer.parseInt(isCount);
            if (isCount.trim().isEmpty() || issCount < 0) {
                throw new EquipmentInvalidIssueCount();
            }

            ArrayList<Inventory> InventoryDetails = EquipmentServiceLayer.SearchEquipment(EquipID, branchID);

            if (InventoryDetails.size() > 0) {
                Inventory inv = new Inventory(EquipID, EquipName, EquipModel, EquipSerNo, EquipVal, EquipInvNo, EquipBID, EquipSupID, warntDate, invDate, issCount, "");
                //boolean result = EquipmentServiceLayer.UpdateEquipment(EquipID, inv, branchID);
                boolean result = true;
                if (result) {
                    txtEqmtID.setText("");
                    txtEqmtName.setText("");
                    txtEqmtModel.setText("");
                    txtEqmtSerialNo.setText("");
                    txtEqmtValue.setText("");
                    txtEqmtInvoiceNo.setText("");
                    txtBrnID.setText("");
                    txtSupID.setText("");
                    txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");
                    txtEqmInvoiceDate.setText("DD/MM/YYYY");
                    txtIsuCount.setText("");

                    JOptionPane.showMessageDialog(this, "Record updated successfully!");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Data record is not available to update!", "Error!", 2);
            }

        } catch (EquipNameNullException ex2) {
            JOptionPane.showMessageDialog(this, ex2.getLocalizedMessage(), "Error!", 2);
        } catch (EquipModelNullException ex3) {
            JOptionPane.showMessageDialog(this, ex3.getLocalizedMessage(), "Error!", 2);
        } catch (EquipSerialNoNullException ex4) {
            JOptionPane.showMessageDialog(this, ex4.getLocalizedMessage(), "Error!", 2);
        } catch (EquipValueInvalidException ex5) {
            JOptionPane.showMessageDialog(this, ex5.getLocalizedMessage(), "Error!", 2);
        } catch (EquipInvoiceNoNullException ex6) {
            JOptionPane.showMessageDialog(this, ex6.getLocalizedMessage(), "Error!", 2);
        } catch (EquipInvalidWarrantyDateException ex7) {
            JOptionPane.showMessageDialog(this, ex7.getLocalizedMessage(), "Error!", 2);
        } catch (EquipInvoiceDateException ex8) {
            JOptionPane.showMessageDialog(this, ex8.getLocalizedMessage(), "Error!", 2);
        } catch (ParseException ex9) {
            Logger.getLogger(Add_Equipment_Panel.class.getName()).log(Level.SEVERE, null, ex9);
            JOptionPane.showMessageDialog(this, "Invalid Date(s)!\n (Please enter valid Date(s))", "Error!", 2);
        } catch (EquipmentInvalidIssueCount ex10) {
            JOptionPane.showMessageDialog(this, ex10.getLocalizedMessage(), "Error!", 2);
        } catch (EquipBranchIDNullException ex11) {
            JOptionPane.showMessageDialog(this, ex11.getLocalizedMessage(), "Error!", 2);
        } catch (EquipSupIDNullException ex12) {
            JOptionPane.showMessageDialog(this, ex12.getLocalizedMessage(), "Error!", 2);
        } catch (EquipIDNullException ex13) {
            JOptionPane.showMessageDialog(this, ex13.getLocalizedMessage(), "Error!", 2);
        } catch (NumberFormatException ex14) {
            JOptionPane.showMessageDialog(this, "Invalid Data Type: \n" + ex14.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Delete button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String EquipID = txtEqmtID.getText();
        if (EquipID.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter valid Inventory ID", "Error!", 2);
        } else {
            boolean result = EquipmentServiceLayer.DeleteEquipment(EquipID, branchID);

            if (result) {
                txtEqmtID.setText("");
                txtEqmtName.setText("");
                txtEqmtModel.setText("");
                txtEqmtSerialNo.setText("");
                txtEqmtValue.setText("");
                txtEqmtInvoiceNo.setText("");
                txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");
                txtEqmInvoiceDate.setText("DD/MM/YYYY");
                txtIsuCount.setText("");
                JOptionPane.showMessageDialog(this, "Record deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Data record is not available to update!", "Error!", 2);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Add to service button
    private void btnAddToServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToServActionPerformed
        try {
            String EquipID = txtEqmtID.getText();
            if (EquipID.trim().isEmpty()) {
                throw new EquipIDNullException();
            }
            String stat = "Running since: " + java.time.LocalDate.now();

            boolean res = EquipmentServiceLayer.updateStatus(EquipID, stat, branchID);
            if (res == true) {
                txtEqmtID.setText("");
                txtEqmtName.setText("");
                txtEqmtModel.setText("");
                txtEqmtSerialNo.setText("");
                txtEqmtValue.setText("");
                txtEqmtInvoiceNo.setText("");
                txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");
                txtEqmInvoiceDate.setText("DD/MM/YYYY");
                txtIsuCount.setText("");
                JOptionPane.showMessageDialog(this, "Status updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed update status!", "Error!", 2);
            }

        } catch (EquipIDNullException ex1) {
            JOptionPane.showMessageDialog(this, ex1.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_btnAddToServActionPerformed

    private void tblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierMouseClicked
        String supID = tblSupplier.getModel().getValueAt(tblSupplier.getSelectedRow(), 0).toString();
        txtSupID.setText(supID);
    }//GEN-LAST:event_tblSupplierMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToServ;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextField txtBrnID;
    private javax.swing.JTextField txtEqmInvoiceDate;
    private javax.swing.JTextField txtEqmtID;
    private javax.swing.JTextField txtEqmtInvoiceNo;
    private javax.swing.JTextField txtEqmtModel;
    private javax.swing.JTextField txtEqmtName;
    private javax.swing.JTextField txtEqmtSerialNo;
    private javax.swing.JTextField txtEqmtValue;
    private javax.swing.JTextField txtEqmtWarrantyExpDate;
    private javax.swing.JTextField txtIsuCount;
    private javax.swing.JTextField txtSupID;
    // End of variables declaration//GEN-END:variables
}
