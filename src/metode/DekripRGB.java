/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;


import java.awt.image.BufferedImage;

/**
 *
 * @author angga cahyo
 */
public class DekripRGB {

   

    public int[] Memasukkanrgbtobitpesan(BufferedImage bf) {

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

         int[] arraymaximals=new int[15552];
        arraymaximals=membukabit_toarray(R, 0, arraymaximals);
        arraymaximals=membukabit_toarray(G, 5184, arraymaximals);
        arraymaximals=membukabit_toarray(B, 10368, arraymaximals);

        return arraymaximals;
       
    }

  

     private int[] membukabit_toarray(int[][] masuk,int parameter, int[] arrayRGB) {

        int inisialisasi=parameter;

        for (int i = 0; i < masuk.length; i++) {
            for (int j = 0; j < masuk.length; j++,inisialisasi++) {
                arrayRGB[inisialisasi]=masuk[i][j];
            }
        }

        return arrayRGB;
    }

   

    
}
