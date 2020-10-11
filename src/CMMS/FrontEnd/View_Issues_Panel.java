/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.FrontEnd;

import CMMS.BusinessLayer.BranchBusinessLayer;
import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.Maintenance_Issue;
import CMMS.ServiceLayer.BranchServiceLayer;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

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
        Table_Settings();
    }
    
 
    
    
    
    public void Genarate_Report(){
        
        String BranchID = lblBrnachId.getText();
        
        try {
            
            Connection conn = DatabaseConnection.getInstance().getConnection();
            
           
           
            
            
            InputStream in = new FileInputStream(new File("C:\\Users\\Ramesh Wijerathna\\OneDrive\\SLIIT\\2nd Year\\Semester 2\\PPA\\Project\\HNB_CMMS\\src\\CMMS\\Report\\Maintenance_Issue.jrxml"));
            JasperDesign jd = JRXmlLoader.load(in);
            String sql = "Select * From maintenance_issue where brnID = '"+BranchID+"' ";
            JRDesignQuery designQuery = new JRDesignQuery();
            designQuery.setText(sql);
            
            jd.setQuery(designQuery);
            
            JasperReport jr = JasperCompileManager.compileReport(jd);
            
            HashMap para = new HashMap();
            
            JasperPrint jp = JasperFillManager.fillReport(jr, para,conn);
            
            
            OutputStream out = new FileOutputStream(new File("G:\\iReport\\New.pdf"));
            
            
            JasperExportManager.exportReportToPdfStream(jp, out);
            
            JOptionPane.showMessageDialog(this, "Report Saved in G:/iReport");
            
            
        } catch (JRException | FileNotFoundException ex) {
            Logger.getLogger(View_Issues_Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(View_Issues_Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(View_Issues_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    

    public void Table_Settings() {
        IssueTable.setRowHeight(30);

        TableColumnModel columnModel = IssueTable.getColumnModel();
        columnModel.getColumn(6).setPreferredWidth(250);

        IssueTable.setShowHorizontalLines(true);
        IssueTable.setShowVerticalLines(true);
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
        ArrayList<Maintenance_Issue> Expire_Issues_List = BranchBusinessLayer.Check_Expire_Issue(BranchID);
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
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        IssueTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaintainID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblBrnachId = new javax.swing.JLabel();
        chkExpired = new javax.swing.JCheckBox();
        btnResend = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("Branch ID - ");

        IssueTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IssueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Maintenance  ID", "Branch ID", "Inventory ID", "Supplier ID", "Maintenance Office Email", "Issue Flag", "Issue Details", "Issu Record Data", "Status", "Approval Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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

        lblBrnachId.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblBrnachId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBrnachId.setText("000888");

        chkExpired.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        chkExpired.setText("Show Expired Issues");
        chkExpired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkExpiredActionPerformed(evt);
            }
        });

        btnResend.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnResend.setText("Re-Send Issue");
        btnResend.setEnabled(false);
        btnResend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResendActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Genarate Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkExpired)
                        .addGap(36, 36, 36)
                        .addComponent(btnResend, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaintainID, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(27, 27, 27)
                            .addComponent(lblBrnachId))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBrnachId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnResend, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chkExpired, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaintainID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();

        int row = IssueTable.getSelectedRow();

        int MaintainID = (int) IssueTable.getValueAt(row, 0);

        BranchServiceLayer.UpdateRecordDate(MaintainID, getCureentDate());

        dtm.removeRow(row);
    }//GEN-LAST:event_btnResendActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Genarate_Report();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable IssueTable;
    private javax.swing.JButton btnResend;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkExpired;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrnachId;
    private javax.swing.JTextField txtMaintainID;
    // End of variables declaration//GEN-END:variables
}
