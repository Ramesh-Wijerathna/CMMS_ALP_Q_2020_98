/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.FrontEnd;

import static CMMS.BusinessLayer.FindLogedRegionMgr.SelectFindLoged;
import static CMMS.BusinessLayer.FindMajorStat.SelectFindMajor;
import CMMS.Models.Maintenance_Issue;
import CMMS.ServiceLayer.ApproveServiceLayer;
import static CMMS.ServiceLayer.ApproveServiceLayer.*;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Approve_Panel extends javax.swing.JPanel {

    /**
     * Creates new form View_Issues_Panel
     */
    Maintenance_Issue approve[];

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs1;

    public Approve_Panel() {
        initComponents();
        approve = new Maintenance_Issue[100];

        displayTable();
        Display_Arrengement();

    }

    //Editing Table arrengement
    public void Display_Arrengement() {
        lblDisplayTable.setRowHeight(30);

        TableColumnModel columnModel = lblDisplayTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(110);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(85);
        columnModel.getColumn(3).setPreferredWidth(85);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(200);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(120);
        columnModel.getColumn(8).setPreferredWidth(110);

        lblDisplayTable.setShowHorizontalLines(true);
        lblDisplayTable.setShowVerticalLines(true);
    }

    //Display Major Issues in the Table
    public void displayTable() {

        try {

            ArrayList<Maintenance_Issue> list = SelectFindMajor();
            DefaultTableModel table = (DefaultTableModel) lblDisplayTable.getModel();
            table.setRowCount(0);
            for (Maintenance_Issue apr : list) {

                Object[] row = {
                    apr.getMntID(),
                    apr.getBrnID(),
                    apr.getIntID(),
                    apr.getSupID(),
                    apr.getMntEmail(),
                    //apr.getIssFlag(),
                    apr.getIssDetail(),
                    apr.getIssRecDat(),
                    apr.getIssDetail(),
                    apr.getApprovalStat()

                };

                table.addRow(row);
            }
            //Object[] row = new Object[11];
            /*for(int i=0;i<list.size();i++)
            {
                row[0]=list.get(i).getMntID();
                row[1]=list.get(i).getBrnID();
                row[2]=list.get(i).getInvID();
                row[3]=list.get(i).getSupID();
                row[4]=list.get(i).getMntEmail();
                row[5]=list.get(i).getIssFlag();
                row[6]=list.get(i).getIssDetail();
                row[7]=list.get(i).getIssRecDat();
                row[9]=list.get(i).getIssStatus();
                row[10]=list.get(i).getApproveStatus();

                table.addRow(row);
                
            }*/
            lblDisplayTable.setBackground(Color.WHITE);

        } catch (SQLException ex) {
            Logger.getLogger(ApproveServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Search Button, Approve Panel, Search maintenance issue display in the table
    public void searchTable() {

        try {
            String mntID = txtMntID.getText();
            ArrayList<Maintenance_Issue> list = SelectApprove(mntID);
            DefaultTableModel table = (DefaultTableModel) lblDisplayTable.getModel();
            table.setRowCount(0);
            for (Maintenance_Issue apr : list) {

                Object[] row = {
                    apr.getMntID(),
                    apr.getBrnID(),
                    apr.getIntID(),
                    apr.getSupID(),
                    apr.getMntEmail(),
                    //apr.getIssFlag(),
                    apr.getIssDetail(),
                    apr.getIssRecDat(),
                    apr.getIssDetail(),
                    apr.getApprovalStat()

                };

                table.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Checkbox Click, Approve Panel, Display the Approved maintenance issues in the table
    public void displayAppvrovedTable() {

        try {

            ArrayList<Maintenance_Issue> list = FindApproved();
            DefaultTableModel table = (DefaultTableModel) lblDisplayTable.getModel();
            table.setRowCount(0);
            for (Maintenance_Issue apr : list) {

                Object[] row = {
                    apr.getMntID(),
                    apr.getBrnID(),
                    apr.getIntID(),
                    apr.getSupID(),
                    apr.getMntEmail(),
                    //apr.getIssFlag(),
                    apr.getIssDetail(),
                    apr.getIssRecDat(),
                    apr.getIssDetail(),
                    apr.getApprovalStat()

                };

                table.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ApproveServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
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
        lblDisplayTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        chkApprovedIssues = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMntID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        lblDisplayTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Maintenance  ID", "Branch ID", "Inventory ID", "Supplier ID", "Maintenance Office Email", "Issue Details", "Receive Data", "Status", "Approval Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lblDisplayTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        lblDisplayTable.setRowHeight(20);
        jScrollPane1.setViewportView(lblDisplayTable);
        if (lblDisplayTable.getColumnModel().getColumnCount() > 0) {
            lblDisplayTable.getColumnModel().getColumn(0).setResizable(false);
            lblDisplayTable.getColumnModel().getColumn(1).setResizable(false);
            lblDisplayTable.getColumnModel().getColumn(2).setResizable(false);
            lblDisplayTable.getColumnModel().getColumn(3).setResizable(false);
            lblDisplayTable.getColumnModel().getColumn(4).setResizable(false);
            lblDisplayTable.getColumnModel().getColumn(5).setResizable(false);
            lblDisplayTable.getColumnModel().getColumn(6).setResizable(false);
            lblDisplayTable.getColumnModel().getColumn(7).setResizable(false);
            lblDisplayTable.getColumnModel().getColumn(8).setResizable(false);
        }

        chkApprovedIssues.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        chkApprovedIssues.setText("Approved Issues");
        chkApprovedIssues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkApprovedIssuesActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CMMS/Resources/Approved.png"))); // NOI18N
        jButton2.setText("Approve");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CMMS/Resources/Report.png"))); // NOI18N
        jButton4.setText("Generate Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(chkApprovedIssues, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkApprovedIssues, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Approve");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Maintenance  ID :");

        txtMntID.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CMMS/Resources/Search.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CMMS/Resources/Reset.png"))); // NOI18N
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMntID)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMntID, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String mntID = txtMntID.getText();
            String fCode = mntID.trim().substring(0, 3);
            int fNum = Integer.parseInt(mntID.trim().substring(3));

            if (mntID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pleace Enter Maintenance ID");
            } else if (fNum < 2020) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Maintenance ID");
            } else if (fCode.compareTo("MNT") != 0) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Maintenance ID");
            } else {

                ArrayList<Maintenance_Issue> ApproveSet = ApproveServiceLayer.SelectApprove(mntID);
                for (Maintenance_Issue al : ApproveSet) {

                    searchTable();
                }
                txtMntID.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String ApprovalStat = "Approved";
            String mntID = txtMntID.getText();

            String fCode = mntID.trim().substring(0, 3);
            int fNum = Integer.parseInt(mntID.trim().substring(3));

            if (mntID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pleace Enter Maintenance ID");
            } else if (fNum < 2020) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Maintenance ID");
            } else if (fCode.compareTo("MNT") != 0) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Maintenance ID");
            } else {

                UpdateApprovel(mntID, ApprovalStat);
                SelectFindLoged(mntID);
                displayTable();
                JOptionPane.showMessageDialog(null, "Maintenance ID " + mntID + " is Successfully Approved!");
                txtMntID.setText("");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Reset Button, Approve Panel, Reset tabel values
        displayTable();
        txtMntID.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Generate Report Button, Approve Panel, Display and Save report maintenance issue, Close the whole program
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmmsnew", "root", "");
            JasperDesign jd=JRXmlLoader.load("C:\\Users\\admin\\Desktop\\PPA Project\\CMMS_ALP_Q_2020_98-master\\src\\CMMS\\Reports\\Maintenance_Issue.jrxml");
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp= JasperFillManager.fillReport(jr, null, connection);
            JasperViewer.viewReport(jp);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Generate Report Button, Approve Panel, Save report maintenance issue
        /*try {
            String pattern = "yyyy/MM/dd";
            String dateInString = new SimpleDateFormat(pattern).format(new Date());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmmsnew", "root", "");
            InputStream input = new FileInputStream(new File("C:\\Users\\admin\\Desktop\\PPA Project\\CMMS_ALP_Q_2020_98-master\\src\\CMMS\\Reports\\Maintenance_Issue.jrxml"));
            try {

                JasperDesign jd = JRXmlLoader.load(input);
                String sql = "SELECT * FROM maintenance_issue";
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                HashMap para = new HashMap();
                JasperPrint j = JasperFillManager.fillReport(jr, para, connection);
                JasperViewer.viewReport(j, false);
                OutputStream os = new FileOutputStream(new File("F:\\Maintenance_Issues_" + dateInString + ".pdf"));
                JasperExportManager.exportReportToPdfStream(j, os);

            } catch (JRException ex) {
                Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Approve_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }*/


    }//GEN-LAST:event_jButton4ActionPerformed

    private void chkApprovedIssuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkApprovedIssuesActionPerformed
        // TODO add your handling code here:
        if (chkApprovedIssues.isSelected()) {
            displayAppvrovedTable();
            lblDisplayTable.setBackground(Color.ORANGE);
        } else {
            displayTable();
            lblDisplayTable.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_chkApprovedIssuesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkApprovedIssues;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lblDisplayTable;
    private javax.swing.JTextField txtMntID;
    // End of variables declaration//GEN-END:variables
}
