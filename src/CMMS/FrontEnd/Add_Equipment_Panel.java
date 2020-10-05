package CMMS.FrontEnd;

import CMMS.Models.Inventory;
import CMMS.ServiceLayer.EquipmentServiceLayer;
import CMMS.Utilities.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Add_Equipment_Panel extends javax.swing.JPanel {

    /**
     * Creates new form Add_Equipment_Panel
     */
    ArrayList <Inventory> inventoryList;
    
    public Add_Equipment_Panel() {
        initComponents();
        inventoryList = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtEqmtID = new javax.swing.JTextField();
        txtEqmtModel = new javax.swing.JTextField();
        txtEqmtName = new javax.swing.JTextField();
        txtEqmtSerialNo = new javax.swing.JTextField();
        txtEqmtValue = new javax.swing.JTextField();
        txtEqmtInvoiceNo = new javax.swing.JTextField();
        txtSupID = new javax.swing.JTextField();
        txtBrnID = new javax.swing.JTextField();
        txtEqmtWarrantyExpDate = new javax.swing.JTextField();
        txtEqmInvoiceDate = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Equipment ID :");

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
        jLabel8.setText("Warrenty Expire Data : ");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Branch ID");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Supplier ID");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Invoice Date  : ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Add Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add New Equipment");
        jLabel1.setOpaque(true);

        txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");

        txtEqmInvoiceDate.setText("DD/MM/YYYY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(64, 64, 64)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEqmtID, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEqmtName, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEqmtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEqmtSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEqmtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEqmtInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSupID, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBrnID, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEqmtWarrantyExpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEqmInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(txtEqmtID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEqmtName, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEqmtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEqmtSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEqmtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEqmtInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSupID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBrnID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEqmtWarrantyExpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEqmInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtEqmtID.setText("");
        txtEqmtName.setText("");
        txtEqmtModel.setText("");
        txtEqmtSerialNo.setText("");
        txtEqmtValue.setText("");
        txtEqmtInvoiceNo.setText("");
        txtSupID.setText("");
        txtBrnID.setText("");
        txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");
        txtEqmInvoiceDate.setText("DD/MM/YYYY");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        String EquipID = txtEqmtID.getText();
        if ( EquipID.trim().isEmpty() )
        {
                throw new EquipIDNullException();
        }
        String EquipName = txtEqmtName.getText();
        if ( EquipName.trim().isEmpty() )
        {
            throw new EquipNameNullException();
        }
        String EquipModel = txtEqmtModel.getText();
        if ( EquipModel.trim().isEmpty())
        {
            throw new EquipModelNullException();
        }
        String EquipSerNo = txtEqmtSerialNo.getText();
        if ( EquipSerNo.trim().isEmpty())
        {
            throw new EquipSerialNoNullException();
        }
        String EquipValue = txtEqmtValue.getText();
        int EquipVal = Integer.parseInt(EquipValue);
        if ( EquipValue.trim().isEmpty() || EquipVal <= 0.0 )
        {
            throw new EquipValueInvalidException();
        }
        String EquipInvNo = txtEqmtInvoiceNo.getText();
        if ( EquipInvNo.trim().isEmpty())
        {
            throw new EquipInvoiceNoNullException();
        }
        String EquipSupID = txtSupID.getText();
        int EquipSID = Integer.parseInt(EquipSupID);
        if ( EquipSupID.trim().isEmpty() || EquipSID <= 0 )
        {
            throw new EquipSupIDNullException();
        }
        String EquipBrnID = txtBrnID.getText();
        int EquipBID = Integer.parseInt(EquipBrnID);
        if ( EquipBrnID.trim().isEmpty() || EquipBID <= 0 )
        {
            throw new EquipBranchIDNullException();
        }
        String EquipWarDate = txtEqmtWarrantyExpDate.getText();
        Date warntDate = new SimpleDateFormat("dd/MM/yyyy").parse(EquipWarDate);
            System.out.println("Warranty Date:" + warntDate);
        Date systemDate = new Date ();
        System.out.println("System Date:" + systemDate);
        if ( !EquipWarDate.trim().isEmpty())
        {
            if ( warntDate.compareTo(systemDate) < 0 )
        {
            throw new EquipInvalidWarrantyDateException();
        }
        }
        String EquipInvDate = txtEqmInvoiceDate.getText();
        Date invDate = new SimpleDateFormat ("dd/MM/yyyy").parse(EquipInvDate);
        System.out.println("Invoice Date:" + invDate);
        if ( EquipInvDate.trim().isEmpty() )
        {
            throw new EquipInvoiceDateException();
        }
        int issCount = 0;
        
        Inventory inv = new Inventory(EquipID, EquipName, EquipModel, EquipSerNo, EquipVal, EquipInvNo, EquipSID, EquipBID, warntDate, invDate, issCount);
        
        //inventoryList.add(inv);
        
        EquipmentServiceLayer eq1 = new EquipmentServiceLayer();
            
        boolean result =  eq1.AddEquipment(inv);
        
            System.out.println(result);
        
        txtEqmtID.setText("");
        txtEqmtName.setText("");
        txtEqmtModel.setText("");
        txtEqmtSerialNo.setText("");
        txtEqmtValue.setText("");
        txtEqmtInvoiceNo.setText("");
        txtSupID.setText("");
        txtBrnID.setText("");
        txtEqmtWarrantyExpDate.setText("DD/MM/YYYY");
        txtEqmInvoiceDate.setText("DD/MM/YYYY");
        } catch ( EquipIDNullException ex1 )
        {
            JOptionPane.showMessageDialog(this, ex1.getLocalizedMessage(), "Error!", 2);
        } catch ( EquipNameNullException ex2 )
        {
            JOptionPane.showMessageDialog(this, ex2.getLocalizedMessage(), "Error!", 2);
        } catch ( EquipModelNullException ex3 )
        {
            JOptionPane.showMessageDialog(this, ex3.getLocalizedMessage(), "Error!", 2);
        } catch ( EquipSerialNoNullException ex4 )
        {
            JOptionPane.showMessageDialog(this, ex4.getLocalizedMessage(), "Error!", 2);
        } catch ( EquipValueInvalidException ex5 )
        {
            JOptionPane.showMessageDialog(this, ex5.getLocalizedMessage(), "Error!", 2);
        } catch ( EquipInvoiceNoNullException ex6 )
        {
            JOptionPane.showMessageDialog(this, ex6.getLocalizedMessage(), "Error!", 2);
        } catch ( EquipInvalidWarrantyDateException ex7 )
        {
            JOptionPane.showMessageDialog(this, ex7.getLocalizedMessage(), "Error!", 2);
        } catch ( EquipInvoiceDateException ex8 )
        {
            JOptionPane.showMessageDialog(this, ex8.getLocalizedMessage(), "Error!", 2);
        } catch (ParseException ex9) {
            Logger.getLogger(Add_Equipment_Panel.class.getName()).log(Level.SEVERE, null, ex9);
            JOptionPane.showMessageDialog(this, "Invalid Date(s)!\n (Please enter valid Date(s))", "Error!", 2);
        }  catch ( EquipSupIDNullException ex10 ) {
            JOptionPane.showMessageDialog(this, ex10.getLocalizedMessage(), "Error!", 2);
        } catch ( EquipBranchIDNullException ex11 ) {
            JOptionPane.showMessageDialog(this, ex11.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBrnID;
    private javax.swing.JTextField txtEqmInvoiceDate;
    private javax.swing.JTextField txtEqmtID;
    private javax.swing.JTextField txtEqmtInvoiceNo;
    private javax.swing.JTextField txtEqmtModel;
    private javax.swing.JTextField txtEqmtName;
    private javax.swing.JTextField txtEqmtSerialNo;
    private javax.swing.JTextField txtEqmtValue;
    private javax.swing.JTextField txtEqmtWarrantyExpDate;
    private javax.swing.JTextField txtSupID;
    // End of variables declaration//GEN-END:variables
}
