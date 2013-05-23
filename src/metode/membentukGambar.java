/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author angga cahyo
 */
public class membentukGambar {

   
    public BufferedImage setGambarintrgb(BufferedImage gambar) {
        BufferedImage gambar_baru = new BufferedImage(gambar.getWidth(), gambar.getHeight(), BufferedImage.TYPE_INT_RGB);
        //menjadikan sebuah gambar dalam tipe byte ble green red
        Graphics2D graphics = gambar_baru.createGraphics();
        graphics.drawRenderedImage(gambar, null);
        graphics.dispose();
        return gambar_baru;
    }

    public BufferedImage settnewrgb(BufferedImage gambarbaru, int[][] red, int[][] green, int[][] blue) {

         int patokan = gambarbaru.getWidth() / 2;

         WritableRaster raster = gambarbaru.getRaster();
      
        for (int i = 0,d=patokan; i < 72; i++,d++) {
            for (int j = 0,e=patokan; j < 72; j++,e++) {
               

                int R = red[i][j];
                int G = green[i][j];
                int B = blue[i][j];
                //System.out.println(B);
                int gray = R << 16 | G << 8 | B;
                gambarbaru.setRGB(d, e, gray);
               
            }
        }
        return gambarbaru;
    }




}
