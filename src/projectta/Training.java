/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectta;

import control.DocumenReader;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Rizka-Nabillah
 */
public class Training extends javax.swing.JFrame {

    /**
     * Creates new form Training
     */
    
    private DefaultTableModel model_data, model_image_training;
    private String path_foldder; // nyimpn alamat folder
    private ArrayList<String>  ListImageTraining = null; // nampung list image
    private DocumenReader dr = new DocumenReader();
    
    public Training() {
        initComponents();
        SetTableImageTraining();
        PreviewTableImageTesting();
        clickTableImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
     // untuk ngatur tabel nampil list file
    public void SetTableImageTraining (){
        model_image_training = new DefaultTableModel();
        TB_Training.setModel(model_image_training);
        model_image_training.addColumn("No"); // buat kolom
        model_image_training.addColumn("Part");
        model_image_training.addColumn("Type");
        // ngatur besar kolom table
        TB_Training.setAutoResizeMode(TB_Training.AUTO_RESIZE_OFF);
        TB_Training.getColumnModel().getColumn(0).setPreferredWidth(50);
        TB_Training.getColumnModel().getColumn(1).setPreferredWidth(300);
        TB_Training.getColumnModel().getColumn(2).setPreferredWidth(50);
    }
    
     // manggil folder untk tampil di table
    private void PreviewTableImageTesting (){
        ListImageTraining = new ArrayList<>(); // nampung nilai yg dkembalikan fungsi
        path_foldder = "E:\\UNSRI\\try\\WARUNG BELAJAR\\ProjectTA\\fileTA\\dataset\\Data dipakai latih\\New folder";
        File folder = new File(path_foldder);
        ListImageTraining = dr.ListFileForForlder(folder);
        for (int i=0; i<ListImageTraining.size(); i++){
            Object[] obj = new Object[3];
            obj [0] = (i+1);
            obj [1] = ListImageTraining.get(i);
            obj [2] = ListImageTraining.get(i).charAt(0);
            model_image_training.addRow(obj);
            
        }
         // untk nampilkan gambar pertama kali
        String init_image = path_foldder + "\\" + ListImageTraining.get(0);
        ImageIcon img = dr.dataFromImage(init_image, L_Citra_Training2.getWidth(), L_Citra_Training2.getHeight());
        
        L_Citra_Training2.setIcon(img);
    }
    
    // method untk gambar berjalan berubah2
    private void clickTableImage (){
        TB_Training.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me){ // biar di click berubah
                int row = TB_Training.rowAtPoint(me.getPoint());
                int col = TB_Training.columnAtPoint(me.getPoint());
                if (row>=0 && col == 1 ){
                    String image_path = path_foldder + "\\" + ListImageTraining.get(row);
                    ImageIcon img = dr.dataFromImage(image_path, L_Citra_Training2.getWidth(), L_Citra_Training2.getHeight()); // nampung image ny
                    L_Citra_Training2.setIcon(img);
                }  
            }
        });
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_Training = new javax.swing.JTable();
        l_learningrate = new javax.swing.JLabel();
        tf_learningrate = new javax.swing.JTextField();
        l_iterasi = new javax.swing.JLabel();
        tf_iterasi = new javax.swing.JTextField();
        bt_training = new javax.swing.JButton();
        bt_saveweight = new javax.swing.JButton();
        L_Citra_Training2 = new javax.swing.JLabel();
        L_Citra_Training1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TB_Training.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Image Path", "Type"
            }
        ));
        jScrollPane1.setViewportView(TB_Training);

        l_learningrate.setText("Learning Rate :");

        tf_learningrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_learningrateActionPerformed(evt);
            }
        });

        l_iterasi.setText("Iterasi :");

        bt_training.setText("Training");
        bt_training.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_trainingActionPerformed(evt);
            }
        });

        bt_saveweight.setText("Save Weight");

        L_Citra_Training2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        L_Citra_Training1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_learningrate)
                            .addComponent(tf_learningrate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_iterasi)
                            .addComponent(tf_iterasi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_training)
                            .addComponent(bt_saveweight))
                        .addContainerGap(154, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(L_Citra_Training2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(L_Citra_Training1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_Citra_Training2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_Citra_Training1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(l_learningrate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_learningrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_iterasi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_iterasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_training)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_saveweight))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("File", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Help", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_learningrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_learningrateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_learningrateActionPerformed

    private void bt_trainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_trainingActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bt_trainingActionPerformed

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
            java.util.logging.Logger.getLogger(Training.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Training.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Training.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Training.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Training().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_Citra_Training1;
    private javax.swing.JLabel L_Citra_Training2;
    private javax.swing.JTable TB_Training;
    private javax.swing.JButton bt_saveweight;
    private javax.swing.JButton bt_training;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel l_iterasi;
    private javax.swing.JLabel l_learningrate;
    private javax.swing.JTextField tf_iterasi;
    private javax.swing.JTextField tf_learningrate;
    // End of variables declaration//GEN-END:variables
}
