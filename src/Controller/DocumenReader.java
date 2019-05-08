/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Rizka-Nabillah
 */
public class DocumenReader {
    

    public DocumenReader (){

}
    public String [][] dataValueFromTXT (String str){
        String [][] nilai = null;
        File file = new File(str);
        try{
            BufferedReader br = new BufferedReader(new FileReader(file)); // buat objek baru untk baco ajo
            Object tableLine [] = br.lines().toArray(); // ini untk mengetahui perbarisnya
            int baris = tableLine.length; // mencari tahu jumlah baris data
            int kolom = tableLine[0].toString().split(",").length; // mencari tahu jumlah kolom
            nilai = new String[baris][kolom];
            for (int i=0; i<baris; i++){
                String line = tableLine[i].toString(); // nge get string perbaris
                String dataRow[]=line.split(","); // baris per baris dipishkan brdsrkan koma (,) untk baris ke[i]         
                for (int j=0; j<kolom; j++){
                    nilai [i][j] = dataRow [j]; // membaca selanjutnya
                }
            }
        }
        catch (Exception e){
//            Logger.getLogger(loadfile.loadfile1.class.getName ()).log(Level.SEVERE, null, e);
              e.printStackTrace();
        }
        
        return nilai;
    }
    
    public ImageIcon dataFromImage(String str, int width, int height){
        ImageIcon MyImage = new ImageIcon(str); // buat objek baru 
        Image img = MyImage.getImage(); //neg get image dr MyImage
        Image newImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
 
    // fungsi untk menampung list image pd folder
    public ArrayList ListFileForForlder (File folder){
        ArrayList<String> ListImage = new ArrayList<>();// ini nympan nama
        for (File FileEntry : folder.listFiles()) { // perulangan untk ambek file2 dlm foldder
            ListImage.add(FileEntry.getName());
        }
        return ListImage;
    }
}
