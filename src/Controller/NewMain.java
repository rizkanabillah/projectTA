/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Rizka-Nabillah
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // proses ekstraksi ciri
        int nilai[][] = {{168, 173, 171, 169, 174},
        {168, 173, 173, 171, 174},
        {172, 175, 175, 172, 173},
        {178, 175, 173, 172, 172},
        {180, 173, 169, 170, 173}};
        ArrayList<ArrayList> tetangga_semua = new ArrayList<>();
        int target = 8;
        ArrayList<Integer> tetangga = new ArrayList<>();
        for (int i = 0; i < nilai.length; i++) {
            for (int j = 0; j < nilai[i].length; j++) {
                tetangga = new ArrayList<>(); // mencari nilai tetangga ny
                if (i == 0) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i - 1][j]);
                }

                if (i == 0 || j == nilai[i].length - 1) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i - 1][j + 1]);
                }

                if (j == nilai[i].length - 1) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i][j + 1]);
                }
                if (j == nilai[i].length - 1 || i == nilai.length - 1) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i + 1][j + 1]);
                }

                if (i == nilai.length - 1) {
                    tetangga.add(0);
                } else {
                    tetangga.add(nilai[i + 1][j]);
                }

                if (j == 0 || i == nilai.length - 1) {
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
                ArrayList<Integer> temp = new ArrayList<>();

                for (int l = 0; l < tetangga.size() / 2; l++) {
                    temp.add(Math.abs(tetangga.get(l)
                            - tetangga.get(l + (tetangga.size() / 2)))
                    );
                }

                int sum_temp = temp.stream()
                        .mapToInt(a -> a)
                        .sum();

                double s_temp = Math.abs(
                        nilai[i][j] - ((nilai[i][j] * 1.0 + sum_temp * 1.0) / 9.0)
                );
                ArrayList<Integer> temp_syarat = new ArrayList<>();
                for (int m = 0; m < temp.size(); m++) {
                    if (temp.get(m) > target) {
                        temp_syarat.add(1);
                    } else {
                        temp_syarat.add(0);
                    }
                }
                if (s_temp > target) {
                    temp_syarat.add(1);
                } else {
                    temp_syarat.add(0);
                }

                ArrayList<Integer> temp_syarat_2 = new ArrayList<>();
                for (int m = 0; m < temp_syarat.size(); m++) {
                    Double pangkat = Math.pow(2, m);
                    temp_syarat_2.add(temp_syarat.get(m) * pangkat.intValue());
                }
                System.out.println("temp TETANGGA");
                System.out.println(tetangga);
                System.out.println("temp");
                System.out.println(temp);
                System.out.println("temp SYARAT");
                System.out.println(temp_syarat);
                System.out.println("temp SYARAT 2");
                System.out.println(temp_syarat_2);

                nilai[i][j] = temp_syarat_2.stream()
                        .mapToInt(a -> a)
                        .sum();

            }
        }
        for (int i = 0; i < nilai.length; i++) {
            for (int j = 0; j < nilai[i].length; j++) {
                System.out.print(nilai[i][j] + "\t");
            }
            System.out.println("");
        }

        // proses backpropagation
        int nilai_random = 0;

        ArrayList<Integer> wa = new ArrayList<>();
        for (int i = 0; i < nilai[0].length; i++) {
            nilai_random = ThreadLocalRandom.current().nextInt(0, 2);
            wa.add(nilai_random);
        }

        ArrayList<Integer> wb = new ArrayList<>();
        for (int i = 0; i < nilai[0].length; i++) {
            nilai_random = ThreadLocalRandom.current().nextInt(0, 2);
            wb.add(nilai_random);
        }

        int ba ;
        nilai_random = ThreadLocalRandom.current().nextInt(0, 2);
        ba=nilai_random;

        int bb;
        nilai_random = ThreadLocalRandom.current().nextInt(0, 2);
        bb=nilai_random;

        int  t1,t2 ;
        nilai_random = ThreadLocalRandom.current().nextInt(0, 2);
        t1=nilai_random;
        nilai_random = ThreadLocalRandom.current().nextInt(0, 2);
        t2=nilai_random;


        ArrayList<Double> a1 = new ArrayList<>();

        for (int i = 0; i < nilai[0].length; i++) {
            int temps=0;
            for(int j=0; j<nilai.length; j++){
                temps=(nilai[j][i]*wa.get(j))+temps;
            }
            
            a1.add(
                    1.0/(1.0+Math.pow(2.718,-(temps+ba)))
            );
        }
        ArrayList<Double> a2 = new ArrayList<>();

        for(int i=0; i<a1.size(); i++){
            double hasil=(a1.get(i)*wb.get(i))+bb;
            a2.add( 1.0/(1.0+Math.pow(2.718,-hasil)));
        }
        
        ArrayList<Double> mse1 = new ArrayList<>();
        for (int i=0; i<a2.size(); i++){
            double hasil = (a2.get(i)-t1);
            mse1.add(0.5*(Math.pow(hasil, 2)));
        }
        
        ArrayList<Double> mse2 = new ArrayList<>();
        for (int i=0; i<a2.size(); i++){
            double hasil = (a2.get(i)-t2);
            mse2.add(0.5*(Math.pow(hasil, 2)));
        }
        
        ArrayList<Double> eror_akhir = new ArrayList<>();
        for ( int i=0; i<a2.size(); i++){
            double hasil_eror_akhir_1 =1/(1+Math.pow(2.718,-a2.get(i))); 
             double hasil_eror_akhir_2 =1-(1/(1+Math.pow(2.718,-a2.get(i))));
            eror_akhir.add(hasil_eror_akhir_1*hasil_eror_akhir_2);
        }
        
        ArrayList<Double> jumlah_eror1 = new ArrayList<>();
        for ( int i=0; i<mse1.size(); i++){
            jumlah_eror1.add(mse1.get(i)*eror_akhir.get(i));
        }
        
        ArrayList<Double> jumlah_eror2 = new ArrayList<>();
        for (int i=0; i<mse2.size(); i++){
            jumlah_eror2.add(mse2.get(i)*eror_akhir.get(i));
        }
        
        ArrayList<Double> eror_layer = new ArrayList<>();
        for ( int i=0; i<a1.size(); i++){
            double hasil_eror_layer_1 =1/(1+Math.pow(2.718,-a1.get(i))); 
             double hasil_eror_layer_2 =1-(1/(1+Math.pow(2.718,-a1.get(i))));
            eror_layer.add(hasil_eror_layer_1*hasil_eror_layer_2);
        }
        
        ArrayList<Double> jumlah_eror_layer_1 = new ArrayList<>();
        for ( int i=0; i<jumlah_eror1.size(); i++){
            jumlah_eror_layer_1.add(jumlah_eror1.get(i)*eror_layer.get(i));
        }
        
        ArrayList<Double> jumlah_eror_layer_2 = new ArrayList<>();
        for ( int i=0; i<jumlah_eror2.size(); i++){
            jumlah_eror_layer_2.add(jumlah_eror2.get(i)*eror_layer.get(i));
        }
        
        
        ArrayList<Double> partial_derivatif_wb1 = new ArrayList<>();
        for (int i=0; i<a1.size(); i++){
            partial_derivatif_wb1.add(a1.get(i)*jumlah_eror_layer_2.get(i));
        }
        
        ArrayList<Double> partial_derivatif_wb2 = new ArrayList<>();
        for (int i=0; i<a1.size(); i++){
            partial_derivatif_wb2.add(a1.get(i)*jumlah_eror_layer_1.get(i));
        }
        
        int partial_derivatif_wa[][]=new int[nilai.length][nilai[0].length];
        for(int i=0; i<nilai.length; i++){
            for(int j=0; j<nilai[i].length; j++){
                partial_derivatif_wa[i][j]=(int) ((nilai[i][j]*jumlah_eror_layer_1.get(j))
                        +(nilai[i][j]*jumlah_eror_layer_2.get(j)));
            }
        }
        
         int bobot_wa[][]=new int[nilai.length][nilai[0].length];
         double learning_rate=0.1;
        for(int i=0; i<nilai.length; i++){
            for(int j=0; j<nilai[i].length; j++){
                bobot_wa[i][j]=(int) (wa.get(j)-(learning_rate*partial_derivatif_wa[i][j]));
            }
        }
        
        int bobot_wb[][]=new int[nilai.length][nilai[0].length];
        
        for(int i=0; i<nilai.length; i++){
            for(int j=0; j<nilai[i].length; j++){
                bobot_wb[i][j]=(int) (wb.get(j)-(learning_rate*partial_derivatif_wa[i][j]));
            }
        }
        
        System.out.println(wa);
        System.out.println(wb);
        System.out.println(ba);
        System.out.println(bb);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(mse1);
        System.out.println(mse2);
        System.out.println(eror_akhir);
        System.out.println(jumlah_eror1);
        System.out.println(jumlah_eror2);
        System.out.println(eror_layer);
        System.out.println(jumlah_eror_layer_1);
        System.out.println(jumlah_eror_layer_2);
        
        
        
        for(int i=0; i<bobot_wb.length; i++){
            for(int j=0; j<bobot_wb[i].length; j++){
                System.out.print(bobot_wb[i][j]+"\t");
            }
            System.out.println("");
        }
        
        
    }
}
