/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metode;

import javax.swing.JOptionPane;

/**
 *
 * @author angga cahyo
 */
public class classsisipke {

    public int[] masukkan_teks_kegambar(int[] lgambar, String pesanyangdisisipkan) {
        //konversi menjadi byte
        //byte temp_byte_gambar[] = byte_gambar(gambar);//mendapatkan jumlah byte gambar yang dipilih
        byte temp_byte_pesan[] = pesanyangdisisipkan.getBytes();//mendapatkan jumlah pbyte pesan yang akan dimasukkan
        byte panjang_data[] = konversi_bit(temp_byte_pesan.length);//mengkonversi jumlah pesan dalam 4 bit
        try {
            sisip_teks(lgambar, panjang_data, 0); //memasukka jumlah teks ke dalam 16 bit pertama gambar
            sisip_teks(lgambar, temp_byte_pesan, 32); //memasukkan teks ke dalam bit terakhir gambar

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "gambar tidak dapat diberikan sebuah teks", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lgambar;
    }

    //memasukan file teks yang telah di olah untuk dimasukkan kedalam gambar
    public int[] sisip_teks(int[] gambar, byte[] data, int offset) {
        //melakukan pengecekan apakah data gambar lebih besar dari data pesan setelah ditambah 32 bit
        if (data.length + offset > gambar.length) {
            throw new IllegalArgumentException("File terlalu besar!");
        }
        //perulangan untuk perubahan bit di setiap byte nya pesan
        for (int i = 0; i < data.length; ++i) {

            //memindahkan panjang data ke variabel baru di setiap bitnya
            int add = data[i];
            //perulangan untuk mengganti 8bit si setiap byte nya
            for (int bit = 7; bit >= 0; --bit, ++offset) {
                //data ke-i di shift right zero oleh bit kemudian di geser 1 bit
                int b = (add >>> bit) & 1;

                //mengganti bit terakhir dari byte gambar
                gambar[offset] = (byte) ((gambar[offset] & 0xFE) | b); //nilai byte yang lama dan 254 atau bit yang akan di tambahkan
            }
        }


        return gambar;
    }

    //untuk mengubah nilai integer jumlah kata ke dalam 8 bythe
    public byte[] konversi_bit(int i) {

         byte byte3 = (byte) ((i & 0xFF000000) >>> 24);
        byte byte2 = (byte) ((i & 0x00FF0000) >>> 16);
        byte byte1 = (byte) ((i & 0x0000FF00) >>> 8);
        byte byte0 = (byte) ((i & 0x000000FF));

        return (new byte[]{byte3, byte2, byte1, byte0});
    }

    public byte[] ekstrak_teks(int[] gambar) {
        int panjang = 0;
        int offset = 32;
        //mengambil panjang pesan uang ada di 32 bit pertama
        for (int i = 0; i < 32; ++i) {
            panjang = (panjang << 1) | (gambar[i] & 1);
        }
        byte[] result = new byte[panjang];

        System.out.println(result.length);

        //perulangan untuk membaca setiap byte dari teks
        for (int b = 0; b < result.length; ++b) {
            //perulangan untuk membaca setiap bit didalam byte teks
            for (int i = 0; i < 8; ++i, ++offset) {
                //bit di masukkan ke dalam byte teks, dari bit baru di shift 1 atau byte text di geser 1 bit
                //gambar dari 32 ke atas di dankan dengan 1 kemudian di OR kan dengan jumlah bit teks yang didapatkan dari atas
                result[b] =  (byte) ((result[b] << 1) | (gambar[offset] & 1));
            }
        }
        return result;
    }


    public void tampilkango(byte[] data){

        for(int i=0;i<data.length;i++){

            System.out.print(data[i]+",");

            if(i==8 && i==16 && i== 24){
                System.out.println("\n");
            }
        }

    }


     public void tampilkan32(int[] data){

        for(int i=32;i<=50;i++){

            System.out.print(data[i]+",");

         
        }

    }


}
