
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BrianLee
 */
public class Frame_CSV extends javax.swing.JFrame {
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
String filename = null;
    /**
     * Creates new form Frame_CSV
     */
    public Frame_CSV() {
        initComponents();
        conn = javaconnect.ConnectDb();
    }
    private void Update_table(){
        
        try{
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        } 
        
        /*try{
            String sql = "select * from CSV_import";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table_attach.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }
            catch(Exception e){}
        }
        
        */
    }    
       public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmb_Choose = new javax.swing.JToggleButton();
        txt_Directory = new javax.swing.JTextField();
        cmb_Upload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmb_Choose.setText("Choose file");
        cmb_Choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ChooseActionPerformed(evt);
            }
        });

        cmb_Upload.setText("Upload CSV");
        cmb_Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_UploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmb_Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cmb_Choose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Directory, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Choose)
                    .addComponent(txt_Directory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(cmb_Upload)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_ChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ChooseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        txt_Directory.setText(filename);
    }//GEN-LAST:event_cmb_ChooseActionPerformed

    private void cmb_UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_UploadActionPerformed
        
        if (this.getX()==0){
                 try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            //filename is referring to the path to reach the file, this is obtained using JFileChooser
            String line;//= "red,blue,green,yellow,purple,brown,grey,black,orange";
            while ((line = br.readLine()) != null) {
                line = line.replace('"',' ');
                String[] value = line.split(",");//this is the separator
                String sql = "insert into StudentInfoG (Id,Name,Surname,Noise,Tidiness,Sleep,Time,Visitor,Temp)  values ('" + value[0] + "' ,  '" + value[1] + "' , '" + value[2] + "' ,  '" + value[3] + "' , '" + value[4] + "', '" + value[5] + "' , '" + value[6] + "' , '" + value[7] + "' ,  '" + value[8] + "')";
            //Above is how each data will be added from the csv
                pst=conn.prepareStatement(sql);
                pst.executeUpdate();
                //Then update is executed
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }Update_table();
}else if(this.getX()==1){
                 try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            //filename is referring to the path to reach the file, this is obtained using JFileChooser
            String line;//= "red,blue,green,yellow,purple,brown,grey,black,orange";
            while ((line = br.readLine()) != null) {
                line = line.replace('"',' ');
                String[] value = line.split(",");//this is the separator
                String sql = "insert into StudentInfoB (Id,Name,Surname,Noise,Tidiness,Sleep,Time,Visitor,Temp)  values ('" + value[0] + "' ,  '" + value[1] + "' , '" + value[2] + "' ,  '" + value[3] + "' , '" + value[4] + "', '" + value[5] + "' , '" + value[6] + "' , '" + value[7] + "' ,  '" + value[8] + "')";
            //Above is how each data will be added from the csv
                pst=conn.prepareStatement(sql);
                pst.executeUpdate();
                //Then update is executed
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }Update_table();
}else{
    JOptionPane.showMessageDialog(null, "Please choose a gender");
}
    }//GEN-LAST:event_cmb_UploadActionPerformed
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
            java.util.logging.Logger.getLogger(Frame_CSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_CSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_CSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_CSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_CSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cmb_Choose;
    private javax.swing.JButton cmb_Upload;
    private javax.swing.JTextField txt_Directory;
    // End of variables declaration//GEN-END:variables
}