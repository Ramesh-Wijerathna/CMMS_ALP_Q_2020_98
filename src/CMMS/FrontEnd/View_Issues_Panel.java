/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.FrontEnd;

import CMMS.BusinessLayer.BranchBusinessLayer;
import CMMS.Models.Maintenance_Issue;
import CMMS.ServiceLayer.BranchServiceLayer;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Ramesh Wijerathna
 */
public class View_Issues_Panel extends javax.swing.JPanel {

    /**
     * Creates new form View_Issues_Panel
     */
    public View_Issues_Panel() {
        initComponents();

        Load_All_Issues();
    }

    public void Load_All_Issues() {

        int BranchID = Integer.parseInt(lblBrnachId.getText());

        ArrayList<Maintenance_Issue> allissue = BranchServiceLayer.GetAllIssues(BranchID);

        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();
        dtm.setRowCount(0);

        for (Maintenance_Issue issue : allissue) {

            Object[] rowData = {
                issue.getMntID(),
                issue.getBrnID(),
                issue.getIntID(),
                issue.getSupID(),
                issue.getMntEmail(),
                issue.getIssFlag(),
                issue.getIssDetail(),
                issue.getIssRecDat(),
                issue.getStatus(),
                issue.getApprovalStat(),
                Boolean.FALSE

            };

            dtm.addRow(rowData);
        }

    }

    public void Load_Expire_Issues() {
        int BranchID = Integer.parseInt(lblBrnachId.getText());
        ArrayList<Maintenance_Issue> Expire_Issues_List = BranchBusinessLayer.Expire_Issue_PopUp(BranchID);
        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();
        dtm.setRowCount(0);

        for (Maintenance_Issue issue : Expire_Issues_List) {

            Object[] rowData = {
                issue.getMntID(),
                issue.getBrnID(),
                issue.getIntID(),
                issue.getSupID(),
                issue.getMntEmail(),
                issue.getIssFlag(),
                issue.getIssDetail(),
                issue.getIssRecDat(),
                issue.getStatus(),
                issue.getApprovalStat()

            };

            dtm.addRow(rowData);
        }

    }

    public void Search(int MaintainID, int BranchID) {

        ArrayList<Maintenance_Issue> SearchDetails = BranchServiceLayer.SearchIssue(MaintainID, BranchID);

        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();
        dtm.setRowCount(0);

        for (Maintenance_Issue issue : SearchDetails) {

            Object[] rowData = {
                issue.getMntID(),
                issue.getBrnID(),
                issue.getIntID(),
                issue.getSupID(),
                issue.getMntEmail(),
                issue.getIssFlag(),
                issue.getIssDetail(),
                issue.getIssRecDat(),
                issue.getStatus(),
                issue.getApprovalStat()

            };

            dtm.addRow(rowData);
        }

    }

    public static String getCureentDate() {

        String date;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime ldt = LocalDateTime.now();

        date = (dtf.format(ldt));

        return date;
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
        IssueTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaintainID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblBrnachId = new javax.swing.JLabel();
        chkExpired = new javax.swing.JCheckBox();
        btnResend = new javax.swing.JButton();

        IssueTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IssueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Maintenance  ID", "Branch ID", "Inventory ID", "Supplier ID", "Maintenance Office Email", "Issue Flag", "Issue Details", "Issu Record Data", "Issue Expire Date", "Status", "Approval Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        IssueTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(IssueTable);
        if (IssueTable.getColumnModel().getColumnCount() > 0) {
            IssueTable.getColumnModel().getColumn(0).setResizable(false);
            IssueTable.getColumnModel().getColumn(1).setResizable(false);
            IssueTable.getColumnModel().getColumn(2).setResizable(false);
            IssueTable.getColumnModel().getColumn(3).setResizable(false);
            IssueTable.getColumnModel().getColumn(4).setResizable(false);
            IssueTable.getColumnModel().getColumn(5).setResizable(false);
            IssueTable.getColumnModel().getColumn(6).setResizable(false);
            IssueTable.getColumnModel().getColumn(7).setResizable(false);
            IssueTable.getColumnModel().getColumn(8).setResizable(false);
            IssueTable.getColumnModel().getColumn(9).setResizable(false);
            IssueTable.getColumnModel().getColumn(10).setResizable(false);
        }

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Issues");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Maintenance  ID :");

        txtMaintainID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaintainIDKeyReleased(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblBrnachId.setText("123");

        chkExpired.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        chkExpired.setText("Show Expired Issues");
        chkExpired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkExpiredActionPerformed(evt);
            }
        });

        btnResend.setText("Re-Send Issue");
        btnResend.setEnabled(false);
        btnResend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBrnachId, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(chkExpired)
                            .addGap(36, 36, 36)
                            .addComponent(btnResend, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMaintainID, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSearch))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblBrnachId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaintainID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkExpired, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResend, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        int BranchID = Integer.parseInt(lblBrnachId.getText());

        if (txtMaintainID.getText().trim().isEmpty()) {
            if (chkExpired.isSelected() == true) {
                Load_Expire_Issues();
                IssueTable.setBackground(Color.ORANGE);
                btnResend.setEnabled(true);
            } else {
                Load_All_Issues();
                IssueTable.setBackground(Color.WHITE);
                btnResend.setEnabled(false);
            }
        } else {
            int MaintainID = Integer.parseInt(txtMaintainID.getText());

            Search(MaintainID, BranchID);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtMaintainIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaintainIDKeyReleased
        int BranchID = Integer.parseInt(lblBrnachId.getText());

        if (txtMaintainID.getText().trim().isEmpty()) {

            if (chkExpired.isSelected() == true) {
                Load_Expire_Issues();
                IssueTable.setBackground(Color.ORANGE);
                btnResend.setEnabled(true);
            } else {
                Load_All_Issues();
                IssueTable.setBackground(Color.WHITE);
                btnResend.setEnabled(false);
            }

        } else {
            int MaintainID = Integer.parseInt(txtMaintainID.getText());

            Search(MaintainID, BranchID);
        }
    }//GEN-LAST:event_txtMaintainIDKeyReleased

    private void chkExpiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkExpiredActionPerformed
        if (chkExpired.isSelected() == true) {
            Load_Expire_Issues();
            IssueTable.setBackground(Color.ORANGE);
            btnResend.setEnabled(true);
        } else {
            Load_All_Issues();
            IssueTable.setBackground(Color.WHITE);
            btnResend.setEnabled(false);
        }
    }//GEN-LAST:event_chkExpiredActionPerformed

    private void btnResendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResendActionPerformed

        int row = IssueTable.getSelectedRow();

        int MaintainID = (int) IssueTable.getValueAt(row, 0);

        boolean result = BranchServiceLayer.UpdateRecordDate(MaintainID, getCureentDate());


    }//GEN-LAST:event_btnResendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable IssueTable;
    private javax.swing.JButton btnResend;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkExpired;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrnachId;
    private javax.swing.JTextField txtMaintainID;
    // End of variables declaration//GEN-END:variables
}
