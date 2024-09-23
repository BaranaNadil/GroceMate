package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.MySQL;

public class EmployeeRegistration extends javax.swing.JDialog {

    HashMap<String, String> genderMap = new HashMap<>();
    HashMap<String, String> cityMap = new HashMap<>();
    HashMap<String, String> employeeTypeMap = new HashMap<>();

    public EmployeeRegistration(AdminDashboard parent, boolean modal) {
        super(parent, modal);
        initComponents();

        loadGender();
        loadCityesComboBox();
        loadCityesToComboBox();
    }
    
    
    ///Reset Employe Registration
    private void reset(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
    }
    ///Reset Employe Registration
    
    

    ///Load Genders To Combo Box
    private void loadGender() {
        try {

            ResultSet result = MySQL.execute("SELECT * FROM `gender`");

            Vector<String> vector = new Vector();
            vector.add("Select");
            while (result.next()) {

                vector.add(result.getString("gender"));
                genderMap.put(result.getString("gender"), result.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ///Load Genders To Combo Box

    ///Load Citys To Combo Box
    private void loadCityesComboBox() {
        try {

            ResultSet result = MySQL.execute("SELECT * FROM `city`");

            Vector<String> vector = new Vector();
            vector.add("Select");
            while (result.next()) {

                vector.add(result.getString("city"));
                cityMap.put(result.getString("city"), result.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ///Load Citys To Combo Box

    ///Load Employee Types ComboBox
    private void loadCityesToComboBox() {
        try {

            ResultSet result = MySQL.execute("SELECT * FROM `employee_type`");

            Vector<String> vector = new Vector();
            vector.add("Select");
            while (result.next()) {

                vector.add(result.getString("type"));
                employeeTypeMap.put(result.getString("type"), result.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox3.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ///Load Employee Types ComboBox

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setText("Email :");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Employee Registration");

        jLabel2.setText("First Name :");

        jLabel3.setText("Last Name :");

        jLabel4.setText("Email :");

        jLabel6.setText("mobile :");

        jLabel7.setText("NIC :");

        jLabel9.setText("City :");

        jLabel10.setText("Address Line 2 :");

        jLabel8.setText("Employee Type :");

        jLabel12.setText("Gender :");

        jLabel11.setText("Address Line 1 :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Password :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jTextField9)
                            .addComponent(jLabel11)
                            .addComponent(jTextField10)
                            .addComponent(jLabel12)
                            .addComponent(jComboBox1, 0, 309, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String fname = jTextField1.getText();
        String lname = jTextField2.getText();
        String email = jTextField3.getText();
        String mobile = jTextField5.getText();
        String nic = jTextField6.getText();
        String gender = String.valueOf(jComboBox1.getSelectedItem());
        String line1 = jTextField10.getText();
        String line2 = jTextField9.getText();
        String password =String.valueOf( jPasswordField1.getPassword());
        String city = String.valueOf(jComboBox2.getSelectedItem());
        String employeeType = String.valueOf(jComboBox3.getSelectedItem());

        if (fname.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please Enter First Name", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.length() >= 45) {
            JOptionPane.showMessageDialog(this, "First name Shoud Less than 45 Characters", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please Enter Last Name", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.length() >= 45) {
            JOptionPane.showMessageDialog(this, "Last name Shoud Less than 45 Characters", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please Enter First Name", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Envalid Email Address.", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (email.length() >= 100) {
            JOptionPane.showMessageDialog(this, "Email Shoud Less than 100 Characters", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please Enter obile number", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[0,1,2,4,5,6,7,8]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (nic.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please Enter NIC No", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (nic.length() >= 20) {
            JOptionPane.showMessageDialog(this, "invalid NIC No", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (gender.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Employee Gender", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (line1.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 1", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (line1.length() >= 45) {
            JOptionPane.showMessageDialog(this, "Address Line 1 Shoud Less than 45 Characters", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (line2.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 2", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (line2.length() >= 45) {
            JOptionPane.showMessageDialog(this, "Address Line 2 Shoud Less than 45 Characters", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (city.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select city", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (employeeType.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Employee type", "Warnning", JOptionPane.WARNING_MESSAGE);
        }else if(password.isBlank()){
         JOptionPane.showMessageDialog(this, "Please Enter The Password.", "Warnning", JOptionPane.WARNING_MESSAGE);
        }else if(password.isBlank()){
         JOptionPane.showMessageDialog(this, "Please Enter The Password.", "Warnning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                ResultSet result = MySQL.execute("SELECT * FROM `employee` "
                        + "WHERE `email` = '" + email + "' OR `mobile` = '" + mobile + "' OR `nic` = '" + nic + "' ");

                if (result.next()) {
                    JOptionPane.showMessageDialog(this, "This Employee Alredy registerd to System.", "Warnning", JOptionPane.WARNING_MESSAGE);
                } else {
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.execute("INSERT INTO `employee` (`nic`,`first_name`,`last_name`,`email`,`mobile`,`password`,`gender_id`, `employee_type_id`, `registerd_date`)"
                            + " VALUES ('"+nic+"', '"+fname+"', '"+lname+"', '"+email+"', '"+mobile+"', '"+password+"', '"+genderMap.get(gender)+"', '"+employeeTypeMap.get(employeeType)+"', '"+sdf.format(new Date())+"') ");
                    
                    MySQL.execute("INSERT INTO `employee_address` (`employee_nic`,`line1`,`line2`,`city_id`) "
                            + "VALUES ('"+nic+"', '"+line1+"', '"+line2+"', '"+cityMap.get(city)+"') ");
                    
                     JOptionPane.showMessageDialog(this, "Employee Registerd Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                    SignInDialog.logger.info("Type :" + SignInDialog.userType  +" User : " + SignInDialog.userName + " Registerd New Employee.  Employee_NIC  : "+nic+ ".");
                    reset();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
