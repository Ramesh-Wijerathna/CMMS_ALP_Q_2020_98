/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.FrontEnd;

import CMMS.BusinessLayer.BranchBusinessLayer;
import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.Maintenance_Issue;
import CMMS.ServiceLayer.IssuessServiceLayer;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
public final class View_Issues_Panel extends javax.swing.JPanel {

    /**
     * Creates new form View_Issues_Panel //@param ID
     */
    public View_Issues_Panel(int ID) {
        initComponents();
        lblBrnachId.setText(String.valueOf(ID));
        Load_Reported_Issues();
        Table_Settings();
    }

    // view issue table settings
    public void Table_Settings() {
        IssueTable.setRowHeight(30);

        TableColumnModel columnModel = IssueTable.getColumnModel();
        columnModel.getColumn(5).setPreferredWidth(300);
        columnModel.getColumn(4).setPreferredWidth(30);
        columnModel.getColumn(7).setPreferredWidth(200);

        IssueTable.setShowHorizontalLines(true);
        IssueTable.setShowVerticalLines(true);
    }

    // load reported issues data to the table
    public void Load_Reported_Issues() {

        int BranchID = Integer.parseInt(lblBrnachId.getText());

        ArrayList<Maintenance_Issue> allissue = IssuessServiceLayer.GetReportedIssues(BranchID);

        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();
        dtm.setRowCount(0);

        for (Maintenance_Issue issue : allissue) {

            Object[] rowData = {
                issue.getMntID(),
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

    // load expire issues data to the table
    public void Load_Expire_Issues() {
        int BranchID = Integer.parseInt(lblBrnachId.getText());
        ArrayList<Maintenance_Issue> Expire_Issues_List = BranchBusinessLayer.Check_Expire_Issue(BranchID);
        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();
        dtm.setRowCount(0);

        for (Maintenance_Issue issue : Expire_Issues_List) {

            Object[] rowData = {
                issue.getMntID(),
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

    // load completed issues data to the table
    public void Load_Completed_Issues() {

        int BranchID = Integer.parseInt(lblBrnachId.getText());

        ArrayList<Maintenance_Issue> completedList = IssuessServiceLayer.GetCompletedIssues(BranchID);

        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();
        dtm.setRowCount(0);

        for (Maintenance_Issue issue : completedList) {

            Object[] rowData = {
                issue.getMntID(),
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

    // search issues in the table
    public void Search(String MaintainID, int BranchID) {

        ArrayList<Maintenance_Issue> SearchDetails = IssuessServiceLayer.SearchIssue(MaintainID);

        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();
        dtm.setRowCount(0);

        for (Maintenance_Issue issue : SearchDetails) {

            Object[] rowData = {
                issue.getMntID(),
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

    // get system current date
    public static String getCureentDate() {

        String date;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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
        btnGenerateReport = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        chkCompleted = new javax.swing.JCheckBox();

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("Branch ID - ");

        IssueTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IssueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue  ID", "Inventory ID", "Supplier ID", "Officer Email", "Issue Flag", "Issue Details", "Reported Data", "Status", "Approval Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        IssueTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        IssueTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IssueTableMouseClicked(evt);
            }
        });
        IssueTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IssueTableKeyReleased(evt);
            }
        });
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
        }

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Issues");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Maintenance  ID :");

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

        btnGenerateReport.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGenerateReport.setText("Genarate Report");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        btnDone.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDone.setText("Done Issue");
        btnDone.setEnabled(false);
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        chkCompleted.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        chkCompleted.setText("Show Completed Issues");
        chkCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCompletedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerateReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaintainID, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 683, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(27, 27, 27)
                                .addComponent(lblBrnachId))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnResend, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(chkExpired)
                                        .addGap(18, 18, 18)
                                        .addComponent(chkCompleted)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBrnachId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtMaintainID, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkExpired, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResend, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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

        try {

            String IDCode = txtMaintainID.getText().trim().substring(0, 3);
            int IDNum = Integer.parseInt(txtMaintainID.getText().trim().substring(3));

            if (txtMaintainID.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Please Enter Maintaiance ID");

            } else if (IDNum < 2020) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid ID");

            } else if (IDCode.compareTo("MNT") != 0) {

                JOptionPane.showMessageDialog(this, "Please Enter Valid ID");

            } else {

                int BranchID = Integer.parseInt(lblBrnachId.getText());

                if (txtMaintainID.getText().trim().isEmpty()) {
                    if (chkExpired.isSelected() == true) {
                        Load_Expire_Issues();
                        IssueTable.setBackground(Color.ORANGE);
                        btnResend.setEnabled(true);
                    } else {
                        Load_Reported_Issues();
                        IssueTable.setBackground(Color.WHITE);
                        btnResend.setEnabled(false);
                    }

                    if (chkCompleted.isSelected() == true) {
                        Load_Completed_Issues();
                        IssueTable.setBackground(Color.lightGray);
                    } else {
                        Load_Reported_Issues();
                        IssueTable.setBackground(Color.WHITE);
                        btnResend.setEnabled(false);
                    }

                } else {
                    String MaintainID = txtMaintainID.getText();
                    Search(MaintainID, BranchID);
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please Enter Valid ID");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void chkExpiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkExpiredActionPerformed
        if (chkExpired.isSelected() == true) {
            Load_Expire_Issues();
            IssueTable.setBackground(Color.ORANGE);
            btnResend.setEnabled(true);
            btnDone.setVisible(false);
            chkCompleted.setEnabled(false);
            btnGenerateReport.setVisible(false);
        } else {
            Load_Reported_Issues();
            IssueTable.setBackground(Color.WHITE);
            btnResend.setEnabled(false);
            btnDone.setVisible(true);
            btnDone.setEnabled(false);
            chkCompleted.setEnabled(true);
            btnGenerateReport.setVisible(true);
        }
    }//GEN-LAST:event_chkExpiredActionPerformed

    private void btnResendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResendActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();

        int row = IssueTable.getSelectedRow();

        int MaintainID = (int) IssueTable.getValueAt(row, 0);

        IssuessServiceLayer.UpdateRecordDate(MaintainID, getCureentDate());

        dtm.removeRow(row);
    }//GEN-LAST:event_btnResendActionPerformed

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        String BranchID = lblBrnachId.getText();

        try {

            Connection conn = DatabaseConnection.getInstance().getConnection();

            InputStream in = new FileInputStream(new File("src/CMMS/Report/BankRep.jrxml"));
            JasperDesign jd = JRXmlLoader.load(in);
            String sql = "Select * From maintenance_issue where brnID = '" + BranchID + "' ";
            JRDesignQuery designQuery = new JRDesignQuery();
            designQuery.setText(sql);

            jd.setQuery(designQuery);

            JasperReport jr = JasperCompileManager.compileReport(jd);

            HashMap para = new HashMap();

            JasperPrint jp = JasperFillManager.fillReport(jr, para, conn);

            JasperViewer.viewReport(jp, false);

            //OutputStream out = new FileOutputStream(new File("G:/iReport/New.pdf"));
            // JasperExportManager.exportReportToPdfStream(jp, out);
            //JOptionPane.showMessageDialog(this, "Report Saved in G:/iReport");
        } catch (JRException | FileNotFoundException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(View_Issues_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) IssueTable.getModel();

        int row = IssueTable.getSelectedRow();

        String MaintainID = String.valueOf(IssueTable.getValueAt(row, 0));

        String status = IssueTable.getValueAt(row, 7).toString();

        if (status.equals("Complete confirmation received by: Supplier")) {
            IssuessServiceLayer.UpdateStatus(MaintainID, "Completed: " + getCureentDate());
        } else {
            IssuessServiceLayer.UpdateStatus(MaintainID, "Complete Confirmation Received By: Branch");
        }

        dtm.removeRow(row);
    }//GEN-LAST:event_btnDoneActionPerformed

    private void IssueTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IssueTableMouseClicked
        String Flag = IssueTable.getModel().getValueAt(IssueTable.getSelectedRow(), 4).toString();
        String Status = IssueTable.getModel().getValueAt(IssueTable.getSelectedRow(), 8).toString();

        if (Flag.equals("Major") && Status.equals("Not Approved")) {
            btnDone.setEnabled(false);
        } else {
            btnDone.setEnabled(true);
        }

    }//GEN-LAST:event_IssueTableMouseClicked

    private void IssueTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IssueTableKeyReleased
        String Flag = IssueTable.getModel().getValueAt(IssueTable.getSelectedRow(), 4).toString();
        String Status = IssueTable.getModel().getValueAt(IssueTable.getSelectedRow(), 8).toString();

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            if (Flag.equals("Major") && Status.equals("Not Approved")) {
                btnDone.setEnabled(false);
            } else {
                btnDone.setEnabled(true);
            }

        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (Flag.equals("Major") && Status.equals("Not Approved")) {
                btnDone.setEnabled(false);
            } else {
                btnDone.setEnabled(true);
            }
        }
    }//GEN-LAST:event_IssueTableKeyReleased

    private void chkCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCompletedActionPerformed
        if (chkCompleted.isSelected() == true) {
            Load_Completed_Issues();
            IssueTable.setBackground(Color.lightGray);
            btnResend.setEnabled(false);
            btnDone.setVisible(false);
            chkExpired.setEnabled(false);
            btnGenerateReport.setVisible(false);
        } else {
            Load_Reported_Issues();
            IssueTable.setBackground(Color.WHITE);
            btnResend.setEnabled(false);
            btnDone.setVisible(true);
            btnDone.setEnabled(false);
            chkExpired.setEnabled(true);
            btnGenerateReport.setVisible(true);
        }
    }//GEN-LAST:event_chkCompletedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable IssueTable;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btnResend;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkCompleted;
    private javax.swing.JCheckBox chkExpired;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrnachId;
    private javax.swing.JTextField txtMaintainID;
    // End of variables declaration//GEN-END:variables
}
