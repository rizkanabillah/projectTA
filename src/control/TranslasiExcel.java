/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Rizka-Nabillah
 */


// yang bisa di run itu yg NewMain
public class TranslasiExcel {

    public void main_controller() {

        int nilai[][] = {{168, 173, 171, 169, 174},
        {168, 173, 173, 171, 174},
        {172, 175, 175, 172, 173},
        {178, 175, 173, 172, 172},
        {180, 173, 169, 170, 173}};
        ArrayList<ArrayList> tetangga_semua = new ArrayList<>();
        ArrayList<Integer> tetangga = new ArrayList<>();
        for (int i = 0; i < nilai.length; i++) {
            for (int j = 0; j < nilai[i].length; j++) {
                tetangga = new ArrayList<>();
                if (i == 0) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i - 1][j]);
                }

                if (i == 0) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i - 1][j + 1]);
                }

                if (j == nilai[i].length - 1) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i][j + 1]);
                }
                if (j == nilai[i].length - 1) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i + 1][j + 1]);
                }

                if (i == nilai.length - 1) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i + 1][j]);
                }

                if (j == 0) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i + 1][j - 1]);
                }

                if (j == 0) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i][j - 1]);
                }
                if (i == 0 || j == 0) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i - 1][j - 1]);
                }
                tetangga_semua.add(tetangga);
            }
        }
        
        int nilai_random=0;
        
        ArrayList<Integer> wa =new  ArrayList<>();
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wa.add(nilai_random);
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wa.add(nilai_random);
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wa.add(nilai_random);
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wa.add(nilai_random);
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wa.add(nilai_random);
        
        ArrayList<Integer> wb = new ArrayList<>();
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wb.add(nilai_random);
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wb.add(nilai_random);
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wb.add(nilai_random);
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wb.add(nilai_random);
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        wb.add(nilai_random);
        
        ArrayList<Integer> ba = new ArrayList<>();
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        ba.add(nilai_random);
        
        ArrayList<Integer> bb = new ArrayList<>();
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        bb.add(nilai_random);
        
        ArrayList<Integer> t = new ArrayList<>();
        nilai_random=ThreadLocalRandom.current().nextInt(0,2);
        t.add(nilai_random);
        
        
        
        

    }
}
