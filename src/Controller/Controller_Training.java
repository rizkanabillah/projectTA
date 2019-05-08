/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Label;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rizka-Nabillah
 */
public class Controller_Training {
    String fullPath;
    private ArrayList<String> ListImageTraining = null; // nampung list image
    private final DocumenReader dr = new DocumenReader();

    public void SetTableImageTraining(DefaultTableModel model_image_training, JTable TB_Training) {
        model_image_training.addColumn("No"); // buat kolom
        model_image_training.addColumn("Part");
        model_image_training.addColumn("Type");
        // ngatur besar kolom table
        TB_Training.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TB_Training.getColumnModel().getColumn(0).setPreferredWidth(50);
        TB_Training.getColumnModel().getColumn(1).setPreferredWidth(300);
        TB_Training.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    // manggil folder untk tampil di table
    public void Load_TableImageTraining(DefaultTableModel model_image_training, JLabel L_Citra_Training) {
        String path_folder;
        JFileChooser fileChooser = new JFileChooser();
        //set directory of open function at same directory's project
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setDialogTitle("Open Directory");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            ListImageTraining = new ArrayList<>(); // nampung nilai yg dkembalikan fungsi
            File file = fileChooser.getSelectedFile();
            fullPath = file.getAbsolutePath();
            System.out.println(fullPath);

            File folder = new File(fullPath);
            ListImageTraining = dr.ListFileForForlder(folder);

            for (int i = 0; i < ListImageTraining.size(); i++) {
                Object[] obj = new Object[3];
                obj[0] = (i + 1);
                obj[1] = ListImageTraining.get(i);
                obj[2] = ListImageTraining.get(i).charAt(0);
                model_image_training.addRow(obj);
            }

            // untk nampilkan gambar pertama kali
            String init_image = fullPath + "\\" + ListImageTraining.get(0);
            ImageIcon img = dr.dataFromImage(init_image, L_Citra_Training.getWidth(), L_Citra_Training.getHeight());
            L_Citra_Training.setIcon(img);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancel By User");
        } else {
            System.out.println("Error");
        }
    }

    public void clickTableImage (JTable TB_Training,JLabel L_Citra_Training){
        TB_Training.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me){ // biar di click berubah
                int row = TB_Training.rowAtPoint(me.getPoint());
                int col = TB_Training.columnAtPoint(me.getPoint());
                if (row>=0 && col == 1 ){
                    String image_path = fullPath + "\\" + ListImageTraining.get(row);
                    ImageIcon img = dr.dataFromImage(image_path, L_Citra_Training.getWidth(), L_Citra_Training.getHeight()); // nampung image ny
                    L_Citra_Training.setIcon(img);
                }  
            }
        });
    }
}
