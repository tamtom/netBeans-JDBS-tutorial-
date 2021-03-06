/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Employees;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Workers extends javax.swing.JFrame {
    //تعريف الميمبرز الرئيسيات
Connection con; Statement stmt; ResultSet rs;
int curRow = 0 ;
    public Workers() {
        initComponents();
        //استدعاء ميثود للشبك عالداتا بيس
        DoConnect();
        this.setLocationRelativeTo(null);
    }
    public void DoConnect( ) 
    {
    try {
        //الاتصال مع الداتا بيس
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/Employees", "lab", "1234");
      
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        con.prepareStatement("ALTER TABLE EMPLOYEES DROP SALARY");
        System.out.println("Done!");
      //الحصول على جميع الداتا   
        rs = stmt.executeQuery("SELECT * From EMPLOYEES");
        
        
        rs.next( ); 
        int id_col = rs.getInt("EM_ID");
        String id = Integer.toString(id_col);
        String first_name = rs.getString("First_Name");
        String last_name = rs.getString("Last_Name");
        String job = rs.getString("Job_Title");
        textID.setText(id);
         textFirst.setText(first_name);
        textLast.setText(last_name);
        textJob.setText(job);
    } catch (SQLException ex) {
        Logger.getLogger(Workers.class.getName()).log(Level.SEVERE, null, ex);
    }
}
//هذا اكشن للرجوع ال الخلف بالقائمة
    private void preBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preBtnActionPerformed
             try {
                 //التأكد اذا كان هنالك داتا قبل في حالة كان اول اسم لن يكون له اسم سابق فسيظهر له رسالة تنبه
            if ( rs.previous()) {
                int id_col = rs.getInt("EM_ID");
        String id = Integer.toString(id_col);
        String first_name = rs.getString("First_Name");
        String last_name = rs.getString("Last_Name");
        String job = rs.getString("Job_Title");
        textID.setText(id);
         textFirst.setText(first_name);
        textLast.setText(last_name);
        textJob.setText(job);
} 
            else {
                rs.next();
                JOptionPane.showMessageDialog(Workers.this, "Start of File"); 
            }
        } 
        catch (SQLException err) { JOptionPane.showMessageDialog(Workers.this, err.getMessage()); }
    }//GEN-LAST:event_preBtnActionPerformed
//اكشن زر لرؤية الداتا التالية 
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            //في حالة اخر سطر لا يوجد اسم تالي فيسظهر له رسالة انها نهاية الملف
            if ( rs.next( ) ) {
                int id_col = rs.getInt("EM_ID");
        String id = Integer.toString(id_col);
        String first_name = rs.getString("First_Name");
        String last_name = rs.getString("Last_Name");
        String job = rs.getString("Job_Title");
        textID.setText(id);
         textFirst.setText(first_name);
        textLast.setText(last_name);
        textJob.setText(job);
} 
            else {
                rs.previous( );
                JOptionPane.showMessageDialog(Workers.this, "End of File"); 
            }
        } 
        catch (SQLException err) { JOptionPane.showMessageDialog(Workers.this, err.getMessage()); }
    }//GEN-LAST:event_btnNextActionPerformed
//زر للذهاب الى اول سطر 
    private void firstBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstBtnActionPerformed
                    try {
            rs.first();
                int id_col = rs.getInt("EM_ID");
        String id = Integer.toString(id_col);
        String first_name = rs.getString("First_Name");
        String last_name = rs.getString("Last_Name");
        String job = rs.getString("Job_Title");
        textID.setText(id);
         textFirst.setText(first_name);
        textLast.setText(last_name);
        textJob.setText(job);
 
           
        } 
        catch (SQLException err) { JOptionPane.showMessageDialog(Workers.this, err.getMessage()); }
    }//GEN-LAST:event_firstBtnActionPerformed
//زر للذهاب الى اخر سطر 
    private void btnlastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlastActionPerformed
       try {
            rs.last();
                int id_col = rs.getInt("EM_ID");
        String id = Integer.toString(id_col);
        String first_name = rs.getString("First_Name");
        String last_name = rs.getString("Last_Name");
        String job = rs.getString("Job_Title");
        textID.setText(id);
         textFirst.setText(first_name);
        textLast.setText(last_name);
        textJob.setText(job);
 
           
        } 
        catch (SQLException err) { JOptionPane.showMessageDialog(Workers.this, err.getMessage()); }
    }//GEN-LAST:event_btnlastActionPerformed
//زر لتحديث المعلومات
    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        String id = textID.getText();
        String first_name = textFirst.getText();
        String last_name = textLast.getText();
        String job = textJob.getText();
        int newID = Integer.parseInt( id );
        try { 
           
         
            rs.updateInt( "EM_ID", newID );
            rs.updateString( "First_Name", first_name);
            rs.updateString( "last_Name", last_name );
            rs.updateString( "Job_Title", job );
            rs.updateRow( ); 
            JOptionPane.showMessageDialog(Workers.this, "Updated");
        } 
        catch (SQLException err) { System.out.println(err.getMessage() ); }
    }//GEN-LAST:event_BtnUpdateActionPerformed
//زر للحفظ
    private void btnsaveNewRecoredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveNewRecoredActionPerformed
    try {
        rs.moveToInsertRow( );
         String id = textID.getText();
        String first_name = textFirst.getText();
        String last_name = textLast.getText();
        String job = textJob.getText();
        int newID = Integer.parseInt( id );
         rs.updateInt( "EM_ID", newID );
            rs.updateString( "First_Name", first_name);
            rs.updateString( "last_Name", last_name );
            rs.updateString( "Job_Title", job );
            //not nessary
            rs.updateInt("Salary", 0);
            rs.insertRow( );
            stmt.close( ); rs.close( );
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
String sql = "SELECT * FROM EMPLOYEES"; rs = stmt.executeQuery(sql);
rs.next( );
int id_col = rs.getInt("EM_ID");

        String idn = Integer.toString(id_col);
        String firstn_name = rs.getString("First_Name");
        String last_namen = rs.getString("Last_Name");
        String jobn = rs.getString("Job_Title");
        textID.setText(idn);
         textFirst.setText(firstn_name);
        textLast.setText(last_namen);
        textJob.setText(jobn);
            JOptionPane.showMessageDialog(Workers.this, "Inserted");
            this.addBtn.setEnabled(true);
        this.btnlast.setEnabled(true);
        this.preBtn.setEnabled(true);
        this.btnDelete.setEnabled(true);
        this.firstBtn.setEnabled(true);
        this.BtnUpdate.setEnabled(true);
        this.btnNext.setEnabled(true);
        this.btnCancelNewRecored.setEnabled(false);
        btnsaveNewRecored.setEnabled(false);
    } catch (SQLException ex) {
        Logger.getLogger(Workers.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }//GEN-LAST:event_btnsaveNewRecoredActionPerformed

    private void btnCancelNewRecoredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelNewRecoredActionPerformed
    try {   
        rs.absolute( curRow );
        int id_col = rs.getInt("EM_ID");
        String id = Integer.toString(id_col);
        String first_name = rs.getString("First_Name");
        String last_name = rs.getString("Last_Name");
        String job = rs.getString("Job_Title");
        textID.setText(id);
         textFirst.setText(first_name);
        textLast.setText(last_name);
        textJob.setText(job);
        this.addBtn.setEnabled(true);
        this.btnlast.setEnabled(true);
        this.preBtn.setEnabled(true);
        this.btnDelete.setEnabled(true);
        this.firstBtn.setEnabled(true);
        this.BtnUpdate.setEnabled(true);
        this.btnNext.setEnabled(true);
        this.btnCancelNewRecored.setEnabled(false);
        btnsaveNewRecored.setEnabled(false);
    } catch (SQLException ex) {
        Logger.getLogger(Workers.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnCancelNewRecoredActionPerformed
//زر لاضافة اسم جديد
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
    try {
        curRow = rs.getRow();
        //clearing
        textID.setText("");
        textFirst.setText("");
        textLast.setText("");
        textJob.setText("");
        //disabeling Buttons
        this.addBtn.setEnabled(false);
        this.btnlast.setEnabled(false);
        this.preBtn.setEnabled(false);
        this.btnDelete.setEnabled(false);
        this.firstBtn.setEnabled(false);
        this.BtnUpdate.setEnabled(false);
        this.btnNext.setEnabled(false);
        this.btnCancelNewRecored.setEnabled(true);
        btnsaveNewRecored.setEnabled(true);
    } catch (SQLException ex) {
        Logger.getLogger(Workers.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        
    }//GEN-LAST:event_addBtnActionPerformed
//زر لحذف سطر 
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    try {
        rs.deleteRow();
        stmt.close();
        rs.close();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
String sql = "SELECT * FROM Employees"; rs = stmt.executeQuery(sql);
rs.next( );
int id_col = rs.getInt("EM_ID");

        String idn = Integer.toString(id_col);
        String firstn_name = rs.getString("First_Name");
        String last_namen = rs.getString("Last_Name");
        String jobn = rs.getString("Job_Title");
        textID.setText(idn);
         textFirst.setText(firstn_name);
        textLast.setText(last_namen);
        textJob.setText(jobn);
            JOptionPane.showMessageDialog(Workers.this, "Deleted");
        
    } catch (SQLException ex) {
        Logger.getLogger(Workers.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textFirst = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textLast = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        textJob = new javax.swing.JTextField();
        firstBtn = new javax.swing.JButton();
        preBtn = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnlast = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnsaveNewRecored = new javax.swing.JButton();
        btnCancelNewRecored = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textFirst.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("JOB TITLE");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID");

        textLast.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Last Name");

        textID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        textJob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textLast, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textJob, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        firstBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        firstBtn.setText("First");
        firstBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstBtnActionPerformed(evt);
            }
        });

        preBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        preBtn.setText("Previous");
        preBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preBtnActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnlast.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnlast.setText("Last");
        btnlast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlastActionPerformed(evt);
            }
        });

        BtnUpdate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BtnUpdate.setText("Update Recoreds");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addBtn.setText("New Record");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDelete.setText("Delete Record");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnsaveNewRecored.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnsaveNewRecored.setText("Save New Recored");
        btnsaveNewRecored.setEnabled(false);
        btnsaveNewRecored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveNewRecoredActionPerformed(evt);
            }
        });

        btnCancelNewRecored.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelNewRecored.setText("Cancel new Recored");
        btnCancelNewRecored.setEnabled(false);
        btnCancelNewRecored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelNewRecoredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(firstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(preBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlast, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnsaveNewRecored))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelNewRecored)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNext, btnlast, firstBtn, preBtn});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnUpdate, addBtn, btnDelete});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstBtn)
                    .addComponent(preBtn)
                    .addComponent(btnNext)
                    .addComponent(btnlast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(BtnUpdate)
                    .addComponent(addBtn))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsaveNewRecored)
                    .addComponent(btnCancelNewRecored))
                .addGap(30, 30, 30))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnNext, btnlast, firstBtn, preBtn});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnUpdate, addBtn, btnDelete});

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Workers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Workers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Workers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Workers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Workers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton btnCancelNewRecored;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnlast;
    private javax.swing.JButton btnsaveNewRecored;
    private javax.swing.JButton firstBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton preBtn;
    private javax.swing.JTextField textFirst;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textJob;
    private javax.swing.JTextField textLast;
    // End of variables declaration//GEN-END:variables
}
