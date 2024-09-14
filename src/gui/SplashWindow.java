package gui;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
//import com.formdev.flatlaf.themes.FlatMacLightLaf;
import gui.Home;

/**
 *
 * @author User
 */
public class SplashWindow extends javax.swing.JFrame {

    public static SplashWindow splashWindow;

 
    public static Home home ;
    
    public SplashWindow() {
        initComponents();
        setSvg();
        lodingProgressAnimation();
    }

    private void setSvg() {

        FlatSVGIcon icon = new FlatSVGIcon("resources//SplashImage.svg", jLabel2.getWidth(), jLabel2.getHeight());
        jLabel2.setIcon(icon);
        FlatSVGIcon icon2 = new FlatSVGIcon("resources//logo.svg", jLabel3.getWidth(), jLabel3.getHeight());
        jLabel3.setIcon(icon2);

    }

    private void lodingProgressAnimation() {
        Thread lodingThread = new Thread(new Runnable() {
            public void run() {
                for (int x = 0; x <= 100; x++) {

                    jProgressBar1.setValue(x);

                    switch (x) {

                        case 10:
                            jLabel1.setText("Connecting to Inernet . . .");
                            break;

                        case 15:
                            jLabel1.setText("Connected to the Inernet");
                            break;

                        case 18:
                            jLabel1.setText("Loding Files . . .");
                            break;

                        case 23:
                            jLabel1.setText("File Loaded");
                            break;

                        case 25:
                            jLabel1.setText("Finding Libraries . . . .");
                            break;

                        case 30:
                            jLabel1.setText("Loading Libraries . . . .");
                            break;

                        case 40:
                            jLabel1.setText("Libraries Completely Loaded.");
                            break;

                        case 45:
                            jLabel1.setText("Loding Resourses . . .");
                            break;

                        case 55:
                            jLabel1.setText("Resorses Loaded");
                            break;

                        case 60:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 61:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 62:
                            jLabel1.setText("Connectiong to Database . . . ");
                            break;

                        case 63:
                            jLabel1.setText("Connectiong to Database . . . . ");
                            break;

                        case 64:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 65:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 66:
                            jLabel1.setText("Connectiong to Database . . . ");
                            break;

                        case 67:
                            jLabel1.setText("Connectiong to Database . . . . ");
                            break;

                        case 68:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 69:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 70:
                            jLabel1.setText("Connectiong to Database . . . ");
                            break;

                        case 71:
                            jLabel1.setText("Connectiong to Database . . . . ");
                            break;

                        case 72:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 73:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 74:
                            jLabel1.setText("Connectiong to Database . . . ");
                            break;

                        case 75:
                            jLabel1.setText("Connectiong to Database . . . . ");
                            break;

                        case 76:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 77:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 78:
                            jLabel1.setText("Connectiong to Database . . . ");
                            break;

                        case 79:
                            jLabel1.setText("Connectiong to Database . . . . ");
                            break;

                        case 80:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 81:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 82:
                            jLabel1.setText("Connectiong to Database . . . ");
                            break;

                        case 83:
                            jLabel1.setText("Connectiong to Database . . . . ");
                            break;

                        case 84:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 85:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 86:
                            jLabel1.setText("Connectiong to Database . . . ");
                            break;

                        case 87:
                            jLabel1.setText("Connectiong to Database . . . . ");
                            break;

                        case 88:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 89:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 90:
                            jLabel1.setText("Connectiong to Database . . . ");
                            break;

                        case 91:
                            jLabel1.setText("Connectiong to Database . . . . ");
                            break;
                        case 92:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 93:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 94:
                            jLabel1.setText("Connectiong to Database . . . ");
                            break;

                        case 95:
                            jLabel1.setText("Connectiong to Database . . . . ");
                            break;
                        case 96:
                            jLabel1.setText("Connectiong to Database . ");
                            break;

                        case 97:
                            jLabel1.setText("Connectiong to Database . . ");
                            break;

                        case 98:
                            jLabel1.setText("Successfully Connected to Database.");
                            break;

                        case 99:
                            jLabel1.setText("Done  ");
                            break;

                    }

                    try {
                        Thread.sleep(10);  ///// loading time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                splashWindow.dispose();
                home = new Home();
                home.setVisible(true);
                home.signInWindow();

            }
        });
        lodingThread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setOpaque(false);

        jProgressBar1.setForeground(new java.awt.Color(0, 153, 51));
        jProgressBar1.setStringPainted(true);

        jLabel1.setText("Loading . . . .");

        jLabel2.setBackground(new java.awt.Color(0, 51, 255));

        jLabel3.setBackground(new java.awt.Color(51, 204, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Welcome to GroceMart\nYour Smart Grocery POS Solution.\nLoading... Please wait while we \nprepare your shopping experience!\n\nGroceMart is an efficient and \nuser-friendly POS system designed \nto streamline your grocery \nmanagement and checkout process, \nensuring a smooth and hassle-free \nshopping experience.");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(null);
        jTextArea1.setEnabled(false);
        jTextArea1.setFocusable(false);
        jTextArea1.setOpaque(false);
        jTextArea1.setRequestFocusEnabled(false);
        jTextArea1.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 739, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the look and feel */
        FlatMacDarkLaf.setup();
//        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                splashWindow = new SplashWindow();
                splashWindow.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
