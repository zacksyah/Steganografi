/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metode;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author angga cahyo
 */
public class saveGambar {

     public boolean menciptakan_gambar(BufferedImage gmbr_bmp, File file, String ext) {
        try {
            file.delete(); // menghapus file yang ada dengan nama yang sama
            ImageIO.write(gmbr_bmp, ext, file);//menciptakan sebuah file sesuai dengan gambar,ekstensi,dan file
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "File tidak berhasil di simpan!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
