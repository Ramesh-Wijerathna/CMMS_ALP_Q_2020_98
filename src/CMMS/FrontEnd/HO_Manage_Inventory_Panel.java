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
 * @author ransa
 */
public class HO_Manage_Inventory_Panel extends javax.swing.JPanel {

    /**
     * Creates new form HO_Manage_Inventory_Panel
     */
    public HO_Manage_Inventory_Panel() {
        initComponents();
        LoadSuppliers ();
        btnAddToServ.setVisible(false);
    }

    //Fetching suplliers information for inventory table
    public void LoadSuppliers ()
    {
        ArrayList <Supplier> sup = EquipmentServiceLayer.GetAllSuppliers();
        
        DefaultTableModel tbl = ( DefaultTableModel ) tblSupplier.getModel();
        tbl.setRowCount(0);
        
        for ( Supplier sp : sup )
        {
            Object[] rowData = {
            sp.getSup_ID(),
            sp.getCompName()
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEqmtID = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtEqmtName = new javax.swing.JTextField();
        txtEqmtModel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEqmtSerialNo = new javax.swing.JTextField();
        txtEqmtValue = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEqmtInvoiceNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSupID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBrnID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEqmtWarrantyExpDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEqmInvoiceDate = new javax.swing.JTextField();
        txtIsuCount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAddToServ = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Equipments");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Equipment ID :");

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Supplier ID");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Branch ID :");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Warrenty Expire Date : ");

        txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Invoice Date  : ");

        txtEqmInvoiceDate.setText("DD/MM/YYYY");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Issue Count :");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(538, 538, 538))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(520, 520, 520))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEqmtID, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtBrnID, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(txtEqmtWarrantyExpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtSupID, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEqmtInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEqmtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEqmtSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEqmtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEqmtName, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton2)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAddToServ, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEqmInvoiceDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIsuCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEqmtID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEqmtName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEqmtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEqmtSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEqmtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEqmtInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrnID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEqmtWarrantyExpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEqmInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIsuCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnAddToServ))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            ArrayList<Inventory> InventoryDetails = EquipmentServiceLayer.HOSearchEquipment(EquipID);
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
                    if ( wdate != null){
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
        } catch ( NumberFormatException nex1)
        {
            JOptionPane.showMessageDialog(this, "Invalid Data Type: \n"+nex1.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    //Update Item button
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
            if ( !( EquipWarDate.compareTo("DD/MM/YYYY") == 0 ) )
        {
            warntDate = new SimpleDateFormat("dd/MM/yyyy").parse(EquipWarDate);
             }
            
            Date systemDate = new Date();
            String EquipInvDate = txtEqmInvoiceDate.getText();
            Date invDate = new SimpleDateFormat("dd/MM/yyyy").parse(EquipInvDate);

            if ( EquipInvDate.trim().isEmpty() || ( invDate.compareTo(systemDate) > 0 ) )
        {
            throw new EquipInvoiceDateException();
        }
            //Checking whether the warranty date is valid or not whether comparing with invoice date
            if ((warntDate != null )&&(warntDate.compareTo(invDate) < 0))
        {
            throw new EquipInvalidWarrantyDateException();
        }
            String isCount = txtIsuCount.getText();
            int issCount = Integer.parseInt(isCount);
            if (isCount.trim().isEmpty() || issCount < 0) {
                throw new EquipmentInvalidIssueCount();
            }

            ArrayList<Inventory> InventoryDetails = EquipmentServiceLayer.SearchEquipment(EquipID, EquipBID);

            if (InventoryDetails.size() > 0) {
                Inventory inv = new Inventory(EquipID, EquipName, EquipModel, EquipSerNo, EquipVal, EquipInvNo, EquipBID, EquipSupID, warntDate, invDate, issCount, "");
                boolean result = EquipmentServiceLayer.UpdateEquipment(EquipID, inv, EquipBID);

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
        }  catch ( EquipIDNullException ex13 )
        {
            JOptionPane.showMessageDialog(this, ex13.getLocalizedMessage(), "Error!", 2);
        } catch ( NumberFormatException ex14 )
        {
            JOptionPane.showMessageDialog(this, "Invalid Data Type: \n"+ex14.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Delete button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String EquipID = txtEqmtID.getText();
        if (EquipID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter valid Inventory ID", "Error!", 2);
            } else {

        boolean result = EquipmentServiceLayer.HODeleteEquipment(EquipID);

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
        } }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Add to service button
    private void btnAddToServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToServActionPerformed
        try {
            String EquipID = txtEqmtID.getText();
            if (EquipID.trim().isEmpty()) {
                throw new EquipIDNullException();
            }
            String stat = "Running since: " + java.time.LocalDate.now();

            boolean res = EquipmentServiceLayer.HOupdateStatus(EquipID, stat);
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

    //Populating Supplier ID field usinng supplier details table
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