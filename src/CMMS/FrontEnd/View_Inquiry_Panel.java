/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.FrontEnd;

import CMMS.Models.Inquiry;
import CMMS.ServiceLayer.InquirySeviceLayer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ransa
 */
public class View_Inquiry_Panel extends javax.swing.JPanel {

    /**
     * Creates new form View_Inquiry_Panel
     */
    public View_Inquiry_Panel() {
        initComponents();
        LoadInquiries ();
    }

    //Fetching inquries
    public void LoadInquiries ()
    {
        ArrayList<Inquiry> allinq = InquirySeviceLayer.GetUnreadMessages();

        DefaultTableModel dtm = (DefaultTableModel) InquiryTable.getModel();
        dtm.setRowCount(0);

        for (Inquiry inqr : allinq) {

            Object[] rowData = {
                inqr.getInqID(),
                inqr.getSupUserName(),
                inqr.getName(),
                inqr.getEmail(),
                inqr.getConNum(),
                inqr.getSubject(),
                inqr.getMessage()
            };

            dtm.addRow(rowData);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        InquiryTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtInqID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        chkRead = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        InquiryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Inquiry ID", "Supplier Username", "Name", "Email", "Contact No", "Subject", "Message"
            }
        ));
        InquiryTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        InquiryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InquiryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(InquiryTable);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Inquiries");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        jLabel2.setText("Inquiry ID: ");

        jButton1.setText("Mark as read");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        chkRead.setText("Show read inquries");
        chkRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkReadActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtInqID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                        .addComponent(chkRead)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtInqID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(chkRead))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //Fetching reat inquries
    private void chkReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkReadActionPerformed
       if ( chkRead.isSelected() == true )
       {
           ArrayList<Inquiry> allrinq = InquirySeviceLayer.GetReadMessages();

        DefaultTableModel dtm = (DefaultTableModel) InquiryTable.getModel();
        dtm.setRowCount(0);

        for (Inquiry rinqr : allrinq) {

            Object[] rowData = {
                rinqr.getInqID(),
                rinqr.getSupUserName(),
                rinqr.getName(),
                rinqr.getEmail(),
                rinqr.getConNum(),
                rinqr.getSubject(),
                rinqr.getMessage()
            };

            dtm.addRow(rowData);
        }
       } else {
           ArrayList<Inquiry> allinq = InquirySeviceLayer.GetUnreadMessages();

        DefaultTableModel dtm = (DefaultTableModel) InquiryTable.getModel();
        dtm.setRowCount(0);

        for (Inquiry inqr : allinq) {

            Object[] rowData = {
                inqr.getInqID(),
                inqr.getSupUserName(),
                inqr.getName(),
                inqr.getEmail(),
                inqr.getConNum(),
                inqr.getSubject(),
                inqr.getMessage()
            };

            dtm.addRow(rowData);
        }
       }
    }//GEN-LAST:event_chkReadActionPerformed

    //Mark as read button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int serKey = Integer.parseInt( txtInqID.getText() );
        if (serKey <= 0) {
                JOptionPane.showMessageDialog(this, "Please provide valid Inquiry ID!", "Error!", 2);;
            }
        boolean res = InquirySeviceLayer.updateViewStatus(serKey);
        if ( res ){
        ArrayList<Inquiry> allrinq = InquirySeviceLayer.GetReadMessages();

        DefaultTableModel dtm = (DefaultTableModel) InquiryTable.getModel();
        dtm.setRowCount(0);

        for (Inquiry rinqr : allrinq) {

            Object[] rowData = {
                rinqr.getInqID(),
                rinqr.getSupUserName(),
                rinqr.getName(),
                rinqr.getEmail(),
                rinqr.getConNum(),
                rinqr.getSubject(),
                rinqr.getMessage()
            };

            dtm.addRow(rowData);
        }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Inquiry ID!", "Error!", 2);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Search button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int serKey = Integer.parseInt( txtInqID.getText() );
        if (serKey <= 0) {
                JOptionPane.showMessageDialog(this, "Please provide valid Inquiry ID!", "Error!", 2);;
            }
         ArrayList<Inquiry> allrinq = InquirySeviceLayer.SearchInquiry(serKey);
        if ( allrinq.size() > 0 ){
       
        DefaultTableModel dtm = (DefaultTableModel) InquiryTable.getModel();
        dtm.setRowCount(0);

        for (Inquiry rinqr : allrinq) {

            Object[] rowData = {
                rinqr.getInqID(),
                rinqr.getSupUserName(),
                rinqr.getName(),
                rinqr.getEmail(),
                rinqr.getConNum(),
                rinqr.getSubject(),
                rinqr.getMessage()
            };

            dtm.addRow(rowData);
        }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Inquiry ID!", "Error!", 2);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Populatin the Inquiry ID field from the table
    private void InquiryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InquiryTableMouseClicked
       String inqId = InquiryTable.getModel().getValueAt(InquiryTable.getSelectedRow(), 0).toString();
       txtInqID.setText(inqId);
    }//GEN-LAST:event_InquiryTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InquiryTable;
    private javax.swing.JCheckBox chkRead;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtInqID;
    // End of variables declaration//GEN-END:variables
}