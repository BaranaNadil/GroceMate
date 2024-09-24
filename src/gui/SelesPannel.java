package gui;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author User
 */
public class SelesPannel extends javax.swing.JPanel {

    /**
     * Creates new form SelesPannel
     */
    public SelesPannel() {
        initComponents();
        loadLineChart();
        loadSelesTable();

    }
    
    
    
    ///reset Total Sellings
    private void resetTotalSellings(){
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        loadSelesTable();
    }
    ///reset Total Sellings
    
    

    /// Load Seles Table
    private void loadSelesTable() {

        Date fdate = jDateChooser1.getDate();
        Date tdate = jDateChooser2.getDate();

        String quary = "SELECT * FROM `invoice` "
                + "INNER JOIN `employee` ON `invoice`.`employee_nic` = `employee` .`nic` "
                + "INNER JOIN `customes` ON  `invoice`.`customes_mobile` = `customes`.`mobile` "
                + "INNER JOIN `payment_method` ON `invoice`.`payment_method_id` = `payment_method`.`id` ";

        if (fdate != null && tdate == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fromDate = sdf.format(jDateChooser1.getDate());

            quary += " WHERE `date_time` > '" + fromDate + "' ";

        } else if (fdate == null && tdate != null) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String toDate = sdf.format(jDateChooser2.getDate());

            quary += " WHERE `date_time` < '" + toDate + "' ";

        } else if (fdate != null && tdate != null) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fromDate = sdf.format(jDateChooser1.getDate());
            String toDate = sdf.format(jDateChooser2.getDate());
            
            quary += " WHERE `date_time` BETWEEN '" + fromDate + "' AND '"+toDate+"'  ";

        }

        try {

            ResultSet result = MySQL.execute(quary);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (result.next()) {
                Vector<String> vector = new Vector();

                vector.add(result.getString("id"));
                vector.add(result.getString("customes.first_name") + " " + result.getString("last_name"));
                vector.add(result.getString("employee.first_name") + " " + result.getString("employee.last_name"));
                vector.add(result.getString("payment_method.name"));
                vector.add(result.getString("date_time"));
                vector.add(result.getString("discount"));
                vector.add(result.getString("payed_ammount"));

                model.addRow(vector);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /// Load Seles Table

    //// Load Selling Chart
    ////Load Line Chart to a panel 
    private void addLineChartToPanel() {
        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        double sales = 0;
        try {
            String query = "SELECT  `date_time`, `payed_ammount` FROM `invoice` ORDER BY `date_time` ASC";
            ResultSet result = MySQL.execute(query);

            while (result.next()) {
                String month = result.getString("date_time");
                sales = result.getDouble("payed_ammount");

                // Add data to dataset
                dataset.addValue(sales, "Sales", month);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create the line chart
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Sales Over Time", // Chart title
                "Month", // X-axis label
                "Sales Amount", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL,
                false, // Include legend
                false,
                false
        );

        // Customize the plot
        CategoryPlot plot = lineChart.getCategoryPlot();
        plot.setBackgroundPaint(UIManager.getColor("Panel.background"));
        plot.setRangeGridlinePaint(UIManager.getColor("Component.borderColor"));
        plot.setDomainGridlinePaint(UIManager.getColor("Component.borderColor"));

        lineChart.getTitle().setFont(UIManager.getFont("Label.font"));
        plot.getDomainAxis().setLabelFont(UIManager.getFont("Label.font"));
        plot.getRangeAxis().setLabelFont(UIManager.getFont("Label.font"));

        plot.setOutlinePaint(UIManager.getColor("Component.borderColor"));
        plot.setInsets(new RectangleInsets(10, 10, 10, 10));

        // Create ChartPanel to display the chart
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setBorder(BorderFactory.createLineBorder(UIManager.getColor("Component.borderColor")));
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 300));  // Adjust size as needed

        // Add the chart panel to jPanel39
        jPanel43.setLayout(new java.awt.BorderLayout());  // Use BorderLayout for dynamic resizing
        jPanel43.add(chartPanel, java.awt.BorderLayout.CENTER);

        jPanel43.validate();  // Revalidate the panel to update the UI
    }
////Load Line Chart to a panel

// Load the line chart
    private void loadLineChart() {
        addLineChartToPanel();
    }

    //// Load Selling Chart
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 80));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 102, 102));
        jLabel66.setText("Sales");

        jButton1.setText("Get Sellings by Date Time (chart)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Get Sellings by Date (chart)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Get Sellings by Month (chart)");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Get Sellings by Year (chart)");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jButton2)
                .addGap(39, 39, 39)
                .addComponent(jButton3)
                .addGap(53, 53, 53)
                .addComponent(jButton4)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel43.setPreferredSize(new java.awt.Dimension(1300, 302));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        add(jPanel43, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1300, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Total Sellings");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("From :");

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText(":");

        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("To :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "customer", "employee_name", "payment_method", "Date Time", "Discount", "Payed Ammount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("reset");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(218, 218, 218)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(33, 33, 33))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        HashMap<String, Object> params = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String date = sdf.format(new Date());

        params.put("date", date);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/my_pos_system1", "root", "barananadil");

            InputStream path = this.getClass().getResourceAsStream("/reports/testChart.jasper");

            JasperPrint report = JasperFillManager.fillReport(path, params, connection);

            JasperViewer.viewReport(report, false);
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        HashMap<String, Object> params = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String date = sdf.format(new Date());

        params.put("date", date);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/my_pos_system1", "root", "barananadil");

            InputStream path = this.getClass().getResourceAsStream("/reports/testChart(Date).jasper");

            JasperPrint report = JasperFillManager.fillReport(path, params, connection);

            JasperViewer.viewReport(report, false);
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        HashMap<String, Object> params = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String date = sdf.format(new Date());

        params.put("date", date);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/my_pos_system1", "root", "barananadil");

            InputStream path = this.getClass().getResourceAsStream("/reports/testChart(Month).jasper");

            JasperPrint report = JasperFillManager.fillReport(path, params, connection);

            JasperViewer.viewReport(report, false);
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        HashMap<String, Object> params = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String date = sdf.format(new Date());

        params.put("date", date);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/my_pos_system1", "root", "barananadil");

            InputStream path = this.getClass().getResourceAsStream("/reports/testChart(Year).jasper");

            JasperPrint report = JasperFillManager.fillReport(path, params, connection);

            JasperViewer.viewReport(report, false);
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      resetTotalSellings();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        loadSelesTable();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
     loadSelesTable();
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String from = String.valueOf(jDateChooser1.getDate());
        String to = String.valueOf(jDateChooser2.getDate());
        
        HashMap<String, Object> params = new HashMap<>();
        params.put(from, from);
        params.put(to, to);
        try{
        JRTableModelDataSource datasours = new JRTableModelDataSource(jTable1.getModel());
        InputStream path = this.getClass().getResourceAsStream("/reports/totalSelesReport.jasper");
       JasperPrint report = JasperFillManager.fillReport(path, params, datasours);
        JasperViewer.viewReport(report,false);
        }catch(JRException e){
        e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
