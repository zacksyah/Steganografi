/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Tampilan.java
 *
 * Created on Apr 23, 2013, 6:08:23 PM
 */
package viewer;


import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import metode.RGB;
import metode.classsisipke;
import metode.membentukGambar;
import metode.saveGambar;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author angga cahyo
 */
public class Tampilan extends javax.swing.JFrame {

    private JFileChooser fileChooser;
    JFileChooser jf = new JFileChooser();
    private Timer timerprogress;
    File files;
    ImageIcon imgc;
    FileInputStream fli = null;
    BufferedImage gmbr1;
    BufferedImage gmbr2;
    String alamattxt;
    String alamattxt2;
    String alamatgambarygakndisisipkan;
    private String filePath = null;
    private File file;
    private POIFSFileSystem fs = null;
    private FileInputStream fis;
    private HWPFDocument doc;
    private WordExtractor we;
    String[] paragraphs;

    RGB rgb=new RGB();
    classsisipke cs=new classsisipke();
    membentukGambar mbtgmbr=new membentukGambar();
    saveGambar svgmbr=new saveGambar();
   
    
    /** Creates new form Tampilan */
    public Tampilan() {
        initComponents();
        ActionListener listenerprogres = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                pgloading.setValue(pgloading.getValue() + 1);//pengauran coding untuk progress bar
                if (pgloading.getValue() == pgloading.getMaximum()) {
                    timerprogress.stop();
                    ImageIcon imisci = new ImageIcon(resize(gmbr1, lblgmbrsesudah.getWidth(), lblgmbrsesudah.getHeight()));
                    lblgmbrsesudah.setIcon(imisci);
                }
            }
        };
        timerprogress = new Timer(10, listenerprogres);

        files = new File("D:\\");
        jf.setCurrentDirectory(files);

        checkboxinputmanual.setSelected(true);
        checkpilihtxt.setSelected(false);
        txtalamatfiletxt.setEnabled(false);
        btncaritxt.setEnabled(false);
        txtpesansisipkan.setEditable(true);

        setExtendedState(MAXIMIZED_BOTH);
        initAbstract();
    }

    private void almt_txt(String j) {
        alamattxt2 = j;
    }

    private void dapatkangambardariurl(String url) {
        File fil = new File(url);
        try {
            gmbr2 = ImageIO.read(fil);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "file tidak didapatkan");
        }
    }

    //  digunakan untuk membaca file gambar dari URL
    public BufferedImage loadimage(String url) {
        BufferedImage bmg = null;
        try {
            bmg = ImageIO.read(new File(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bmg;
    }

    //  digunakan untuk merender gambar sesuai tampilan di program
    public BufferedImage resize(BufferedImage img, int newW, int newH) {
        int wi = img.getWidth();
        int he = img.getHeight();

        BufferedImage bim = new BufferedImage(newW, newH, img.getType());

        Graphics2D gp = bim.createGraphics();
        gp.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        gp.drawImage(img, 0, 0, newW, newH, 0, 0, wi, he, null);
        gp.dispose();
        return bim;
    }

    public void kembalikangambar(BufferedImage imgst) {
        gmbr1 = imgst;
    }

    private void initAbstract() {
        setLocationRelativeTo(null);
        txtpesansisipkan.setLineWrap(true);
        txtpesansisipkan.setWrapStyleWord(true);
        fileChooser = new JFileChooser();
        progressbar.setVisible(false);
    }

    private void reset() {
        checkboxinputmanual.setSelected(true);
        checkpilihtxt.setSelected(false);

        alamattxt = null;
        alamattxt2 = null;
        alamatgambarygakndisisipkan = null;

        timerprogress = null;
        imgc = null;

        lblgmbarsebelum.setIcon(new ImageIcon());
        lblgmbrsesudah.setIcon(new ImageIcon());

        gmbr1 = null;
        gmbr2 = null;

        txtalamatfiletxt.setText("");
        txtpesansisipkan.setText("");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btncaritxt = new javax.swing.JButton();
        checkpilihtxt = new javax.swing.JCheckBox();
        checkboxinputmanual = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtalamatfiletxt = new javax.swing.JTextField();
        checkpilihdoc = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtpesansisipkan = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        lblgmbarsebelum = new javax.swing.JLabel();
        pgloading = new javax.swing.JProgressBar();
        jPanel4 = new javax.swing.JPanel();
        lblgmbrsesudah = new javax.swing.JLabel();
        btnsisipkan = new javax.swing.JButton();
        btnsimpangambar = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btncarigambar = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        progressbar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesan"));

        btncaritxt.setText("Cari File txt");
        btncaritxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaritxtActionPerformed(evt);
            }
        });

        checkpilihtxt.setText("Pilih File .txt");
        checkpilihtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkpilihtxtActionPerformed(evt);
            }
        });

        checkboxinputmanual.setText("Input Pesan");
        checkboxinputmanual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxinputmanualActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtalamatfiletxt);

        checkpilihdoc.setText("Doc/Dock");
        checkpilihdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkpilihdocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkboxinputmanual)
                        .addGap(18, 18, 18)
                        .addComponent(checkpilihtxt)
                        .addGap(28, 28, 28)
                        .addComponent(checkpilihdoc)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncaritxt))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxinputmanual)
                    .addComponent(checkpilihdoc)
                    .addComponent(checkpilihtxt))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncaritxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Pesan"));

        txtpesansisipkan.setColumns(20);
        txtpesansisipkan.setRows(5);
        jScrollPane1.setViewportView(txtpesansisipkan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sebelum DWT"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblgmbarsebelum, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(lblgmbarsebelum, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Sesudah DWT"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblgmbrsesudah, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(lblgmbrsesudah, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnsisipkan.setText("Sisipkan");
        btnsisipkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsisipkanActionPerformed(evt);
            }
        });

        btnsimpangambar.setText("save");
        btnsimpangambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpangambarActionPerformed(evt);
            }
        });

        btnexit.setText("Keluar");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Mencari Gambar"));

        btncarigambar.setText("Cari Gambar");
        btncarigambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarigambarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btncarigambar)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btncarigambar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressbar, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnsisipkan)
                                .addGap(34, 34, 34)
                                .addComponent(btnsimpangambar)
                                .addGap(33, 33, 33)
                                .addComponent(btnreset)
                                .addGap(35, 35, 35)
                                .addComponent(btnexit)
                                .addGap(25, 25, 25))
                            .addComponent(pgloading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(pgloading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsisipkan)
                            .addComponent(btnsimpangambar)
                            .addComponent(btnexit)
                            .addComponent(btnreset)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Dimension posisi = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (int) ((posisi.getWidth() - this.getWidth()) / 2);
        int y = (int) ((posisi.getHeight() - this.getHeight()) / 2);

        this.setLocation(x, y);
    }//GEN-LAST:event_formWindowOpened

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        menuUtm mnutm = new menuUtm();
        mnutm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btncaritxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaritxtActionPerformed
        // TODO add your handling code here:
        if (checkpilihdoc.isSelected() == true) {
            if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)) {
                filePath = fileChooser.getSelectedFile().getAbsolutePath();
                file = new File(filePath);
                txtalamatfiletxt.setText(filePath);
                txtpesansisipkan.setText("");

                StringBuffer sbd = new StringBuffer(txtalamatfiletxt.getText());
            char w = sbd.charAt(sbd.length() - 1);
            System.out.println(w);

            if (w == 'c') {

                if (filePath != null) {
                    progressbar.setVisible(true);
                    Thread t = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                fis = new FileInputStream(file);

                                HWPFDocument docx = new HWPFDocument(fis);
                                we = new WordExtractor(docx);
                                //get Paragraph text  as array
                                paragraphs = we.getParagraphText();

                                for (int i = 0; i < paragraphs.length; i++) {
                                    //paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n","");
                                    txtpesansisipkan.append(paragraphs[i]);
                                }
                            } catch (Exception exc) {
                                System.out.println(exc.getMessage());
                            } finally {
                                progressbar.setVisible(false);
                            }
                        }
                    });
                    t.start();
                }
            } else if (w == 'x') {

                if (filePath != null) {
                    try {
                        progressbar.setVisible(true);
                        FileInputStream files = null;
                        try {
                            files = new FileInputStream(file);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ZipInputStream docXFile = new ZipInputStream(files);
                        ZipEntry zipEntry;
                        OutputStream out;
                        String xml = "";
                        while ((zipEntry = docXFile.getNextEntry()) != null) {
                            if (zipEntry.toString().equals("word/document.xml")) {
                                byte[] buffer = new byte[1024 * 4];
                                long count = 0;
                                int n = 0;
                                long size = zipEntry.getSize();
                                out = System.out;
                                while (-1 != (n = docXFile.read(buffer)) && count < size) {
                                    xml += new String(buffer, 0, n);
                                    count += n;
                                }
                            }
                        }
                        InputStream is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder parser = factory.newDocumentBuilder();
                        Document document = parser.parse(is);
                        NodeList sections = document.getElementsByTagName("w:t");
                        String isidocx = "";
                        for (int i = 0; i < sections.getLength(); i++) {
                            isidocx += sections.item(i).getFirstChild().getNodeValue();
                        }
                        txtpesansisipkan.setText(isidocx);
                    } catch (SAXException ex) {
                        Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "not detected");
        }




            } else if (checkpilihtxt.isSelected() == true) {
            FileNameExtensionFilter ff = new FileNameExtensionFilter(".txt", "txt");
            jf.setFileFilter(ff);
            int y = jf.showOpenDialog(this);
            if (y == jf.APPROVE_OPTION) {
                alamattxt = jf.getSelectedFile().getPath();
                txtalamatfiletxt.setText(alamattxt);
                almt_txt(alamattxt);

                try {
                    fli = new FileInputStream(alamattxt);
                    LineNumberReader flined = new LineNumberReader(new InputStreamReader(new FileInputStream(alamattxt)));
//digunakan untuk mnerapkan file txt notepad ke dalam program
                    try {
                        int i = 0;
                        String stringline = flined.readLine();
                        while (stringline != null) {
                            flined.setLineNumber(i);
                            txtpesansisipkan.append(stringline + "\n");
                            stringline = flined.readLine();
                            i++;
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "file tidak ditemukan");
                }

            }
        }
    }//GEN-LAST:event_btncaritxtActionPerformed

    private void checkboxinputmanualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxinputmanualActionPerformed
        // TODO add your handling code here:
        if (checkboxinputmanual.isSelected() == true) {
            checkpilihtxt.setSelected(false);
            checkpilihdoc.setSelected(false);
            txtalamatfiletxt.setEnabled(false);
            btncaritxt.setEnabled(false);
            txtpesansisipkan.setEditable(true);


        } else {
            txtalamatfiletxt.setEnabled(false);
            btncaritxt.setEnabled(false);
            txtpesansisipkan.setEditable(false);


        }
    }//GEN-LAST:event_checkboxinputmanualActionPerformed

    private void checkpilihtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkpilihtxtActionPerformed
        // TODO add your handling code here:
        if (checkpilihtxt.isSelected() == true) {
            checkboxinputmanual.setSelected(false);
            checkpilihdoc.setSelected(false);
            txtalamatfiletxt.setEnabled(false);
            btncaritxt.setEnabled(true);
            txtpesansisipkan.setEditable(false);


        } else {
            txtalamatfiletxt.setEnabled(false);
            btncaritxt.setEnabled(false);
            txtpesansisipkan.setEditable(false);


        }
    }//GEN-LAST:event_checkpilihtxtActionPerformed

    private void btncarigambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarigambarActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter ff2 = new FileNameExtensionFilter(".bmp",".JPG","PNG", "bmp","JPG","PNG");
        jf.setFileFilter(ff2);


        int l = jf.showOpenDialog(null);


        if (l == jf.APPROVE_OPTION) {

            alamatgambarygakndisisipkan = jf.getSelectedFile().getPath();//mendapatkan url gambar dari pemilihan Jfile chooser
            dapatkangambardariurl(
                    alamatgambarygakndisisipkan);
//            namaFile = jf.getName();//mendapatkan nama file dari URL
//            System.out.print(namaFile);

            BufferedImage igmbr = loadimage(alamatgambarygakndisisipkan);



            int pn = igmbr.getHeight();//mengetahui panjang gambar


            int lb = igmbr.getWidth();//mengetahui lebar gambar



            if (pn <= 200 || lb < 200 ) {
                JOptionPane.showMessageDialog(null, " masukkan gambar minimal ukuran 200 X 200 Px", "ERROR", JOptionPane.ERROR_MESSAGE);
                //reset();


            } else if (pn > 1024 || lb > 1024) {
                JOptionPane.showMessageDialog(null, " masukkan gambar maximal ukuran 1024 X 1024 Px", "ERROR", JOptionPane.ERROR_MESSAGE);
                //reset();


            } else if (pn != lb) {
                JOptionPane.showMessageDialog(null, "anda harus memasukkan gambar dalam ukuran persegi", "ERROR", JOptionPane.ERROR_MESSAGE);


            } else {

                ImageIcon imii = new ImageIcon(resize(igmbr, lblgmbarsebelum.getWidth(), lblgmbrsesudah.getHeight()));
                lblgmbarsebelum.setIcon(imii);


            }

        }
    }//GEN-LAST:event_btncarigambarActionPerformed

    private void btnsisipkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsisipkanActionPerformed
        // TODO add your handling code here:
        BufferedImage gambarsisip1 = loadimage(alamatgambarygakndisisipkan);


        int karakter = txtpesansisipkan.getText().length();
        //System.out.println("panjang karakter="+karakter);



        if (txtpesansisipkan.getText() == null) {
            JOptionPane.showMessageDialog(null, "masukkan pesan yang akan disisipkan", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else if (gambarsisip1 == null) {
            JOptionPane.showMessageDialog(null, "masukkan gambar yang akan disisipi pesannya", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else if (karakter >= 1916) {
            JOptionPane.showMessageDialog(null, karakter);
            JOptionPane.showMessageDialog(null, "maximal karakter yang bisa dimasukkan 1916", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {

       
        int[] bitsiapsisip=rgb.Memasukkanrgbtoarraylis(gambarsisip1);
            //System.out.println(bitsiapsisip.length);
            //rgb.tampilarray(bitsiapsisip);
        int[] bittersisippesan=cs.masukkan_teks_kegambar(bitsiapsisip, txtpesansisipkan.getText());
        int[][] Rback=rgb.gettingR(bittersisippesan);
        int[][] Gback=rgb.gettingG(bittersisippesan);
        int[][] Bback=rgb.gettingB(bittersisippesan);
        BufferedImage gambarjadi=mbtgmbr.settnewrgb(gambarsisip1, Rback, Gback, Bback);
        kembalikangambar(gambarjadi);
        timerprogress.start();

        }

    }//GEN-LAST:event_btnsisipkanActionPerformed

    private void btnsimpangambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpangambarActionPerformed
        // TODO add your handling code here:
        int gambarakhir = jf.showSaveDialog(this);


        if (gambarakhir == jf.APPROVE_OPTION) {
             svgmbr.menciptakan_gambar(gmbr1, new File(jf.getSelectedFile().toString()), "bmp");
        }
    }//GEN-LAST:event_btnsimpangambarActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:

        reset();
        Tampilan tmpl = new Tampilan();
        tmpl.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnresetActionPerformed

    private void checkpilihdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkpilihdocActionPerformed
        // TODO add your handling code here:
        if (checkpilihdoc.isSelected() == true) {
            checkboxinputmanual.setSelected(false);
            checkpilihtxt.setSelected(false);
            txtalamatfiletxt.setEnabled(false);
            btncaritxt.setEnabled(true);
            txtpesansisipkan.setEditable(false);


        } else {
            txtalamatfiletxt.setEnabled(false);
            btncaritxt.setEnabled(false);
            txtpesansisipkan.setEditable(false);


        }
    }//GEN-LAST:event_checkpilihdocActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Tampilan().setVisible(true);


            }
        });


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncarigambar;
    private javax.swing.JButton btncaritxt;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsimpangambar;
    private javax.swing.JButton btnsisipkan;
    private javax.swing.JCheckBox checkboxinputmanual;
    private javax.swing.JCheckBox checkpilihdoc;
    private javax.swing.JCheckBox checkpilihtxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblgmbarsebelum;
    private javax.swing.JLabel lblgmbrsesudah;
    private javax.swing.JProgressBar pgloading;
    private javax.swing.JProgressBar progressbar;
    private javax.swing.JTextField txtalamatfiletxt;
    private javax.swing.JTextArea txtpesansisipkan;
    // End of variables declaration//GEN-END:variables
}
