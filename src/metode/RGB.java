/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author angga cahyo
 */
public class RGB {

  

    public int[] Memasukkanrgbtoarraylis(BufferedImage bf) {

        int pixel;
        int r, g, b;

        int patokan = bf.getWidth() / 2;

        int baris = 72, kolom = 72;


        int[][] R = new int[baris][kolom];
        int[][] G = new int[baris][kolom];
        int[][] B = new int[baris][kolom];


        int[][] buffer = new int[baris][kolom];

        for (int i = 0, d = patokan; i < baris; i++, d++) {
            for (int j = 0, e = patokan; j < kolom; j++, e++) {

                buffer[i][j] = bf.getRGB(d, e);
                pixel = buffer[i][j];

                r = (pixel >> 16) & 0x000000FF;

                g = (pixel >> 8) & 0x000000FF;

                b = (pixel) & 0x000000FF;

                R[i][j] = r;
                G[i][j] = g;
                B[i][j] = b;
            }
        }

        int[] arraymaximal=new int[15552];
        arraymaximal=memasukkanbit_toarray(R, 0, arraymaximal);
        arraymaximal=memasukkanbit_toarray(G, 5184, arraymaximal);
        arraymaximal=memasukkanbit_toarray(B, 10368, arraymaximal);

        return arraymaximal;

       
    }

    public void tampilarray(int[] arr) {

       
        for (int i = 15552; i < 15555; i++) {
            System.out.println(arr[i]+",");
        }
      
    }

    private int[] memasukkanbit_toarray(int[][] masuk,int parameter, int[] arrayRGB) {

        int inisialisasi=parameter;

        for (int i = 0; i < masuk.length; i++) {
            for (int j = 0; j < masuk.length; j++,inisialisasi++) {
                arrayRGB[inisialisasi]=masuk[i][j];
            }
        }

        return arrayRGB;
    }

   

    public int [][] gettingR(int[] masuk){

        int[][] tampung=new int[72][72];

         int p = 0;
        for (int i = 0; i < 72; i++) {
            for (int j = 0; j < 72; j++, p++) {
                tampung[i][j] = masuk[p];
            }
        }

        return tampung;

    }

     public int [][] gettingG(int[] masuk){

        int[][] tampung=new int[72][72];

         int p = 5184;
        for (int i = 0; i < 72; i++) {
            for (int j = 0; j < 72; j++, p++) {
                tampung[i][j] = masuk[p];
            }
        }

        return tampung;

    }

      public int [][] gettingB(int[] masuk){

        int[][] tampung=new int[72][72];

         int p = 10368;
        for (int i = 0; i < 72; i++) {
            for (int j = 0; j < 72; j++, p++) {
                tampung[i][j] = masuk[p];
            }
        }

        return tampung;

    }

    
}
