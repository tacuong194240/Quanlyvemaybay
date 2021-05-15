
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class ThongKe extends javax.swing.JFrame {

    /**
     * Creates new form ThongKe
     */
    List<Ticket> ticketList = new ArrayList<>();
    DefaultTableModel tableModel;

    public ThongKe() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) table.getModel();

        loadDatabase();
        showdata();

    }

    public void showdata() {
        tableModel.setRowCount(0);

        for (int i = 0; i < ticketList.size(); i++) {
            tableModel.addRow(new Object[]{
                String.valueOf(ticketList.get(i).getId()),
                ticketList.get(i).getType(),
                ticketList.get(i).getLandPlace(),
                ticketList.get(i).getFlyPlace(),
                ticketList.get(i).getPrice(),
                ticketList.get(i).getSoldTime(),
                ticketList.get(i).getFlyTime(),
                ticketList.get(i).getLandTime(),
                ticketList.get(i).getTicketID()
            });

        }

    }

    public void loadDatabase() {
        ticketList.clear();
        Connection con = null;
        Statement statement = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/ticketplane? zeroDateTimeBehavior = convertToNull", "root", "14092001");
            String sql = "select * from ticket";

            statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Ticket ticket = new Ticket(result.getInt("id"),
                        result.getString("type"),
                        result.getString("landPlace"),
                        result.getString("flyPlace"),
                        result.getInt("price"),
                        result.getDate("soldTime"),
                        result.getTimestamp("flyTime"),
                        result.getTimestamp("landTime"),
                        result.getString("ticketID"));

                ticketList.add(ticket);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Thongke = new javax.swing.JButton();
        btn_Tinhtien = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Thống Kê");

        jLabel2.setText("To:");
        jLabel2.setToolTipText("");

        jLabel3.setText("From:");

        btn_Thongke.setText("Thống Kê");
        btn_Thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThongkeActionPerformed(evt);
            }
        });

        btn_Tinhtien.setText("Tính Tiền");
        btn_Tinhtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TinhtienActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Loại vé", "Địa điểm đến", "Địa điểm bay", "Giá vé", "Ngày mua", "Thời gian bay", "Thời gian đến", "Mã vé"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(btn_Thongke)
                            .addComponent(btn_Tinhtien)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(546, 546, 546)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(550, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1131, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Thongke))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Tinhtien)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(642, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btn_ThongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThongkeActionPerformed
        // TODO add your handling code here:
        ticketList.clear();
        Connection con = null;
        Statement statement = null;
        if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {
            loadDatabase();
            showdata();
            JOptionPane.showMessageDialog(null, "Nhập khoảng thời gian cần tìm kiếm");
        } else {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/ticketplane? zeroDateTimeBehavior = convertToNull", "root", "14092001");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date1 = dateFormat.format(jDateChooser1.getDate());
                String date2 = dateFormat.format(jDateChooser2.getDate());
                String sql = "select * from ticket where flyTime  between'" + date1 + " 'and ' " + date2 + "'  and type = 'Domestic' ";

                statement = con.createStatement();

                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    Ticket ticket = new Ticket(result.getInt("id"),
                            result.getString("type"),
                            result.getString("landPlace"),
                            result.getString("flyPlace"),
                            result.getInt("price"),
                            result.getDate("soldTime"),
                            result.getTimestamp("flyTime"),
                            result.getTimestamp("landTime"),
                            result.getString("ticketID"));

                    ticketList.add(ticket);

                }

            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            showdata();
        }
    }//GEN-LAST:event_btn_ThongkeActionPerformed

    private void btn_TinhtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TinhtienActionPerformed
        // TODO add your handling code here:
        ticketList.clear();
        Connection con = null;
        Statement statement = null;
        if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {
            loadDatabase();
            showdata();
            JOptionPane.showMessageDialog(null, "Nhập khoảng thời gian cần tìm kiếm");
        } else {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/ticketplane? zeroDateTimeBehavior = convertToNull", "root", "14092001");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date1 = dateFormat.format(jDateChooser1.getDate());
                String date2 = dateFormat.format(jDateChooser2.getDate());
                String sql = "select * from ticket where flyTime  between'" + date1 + " 'and ' " + date2 + "'  ";

                statement = con.createStatement();

                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    Ticket ticket = new Ticket(result.getInt("id"),
                            result.getString("type"),
                            result.getString("landPlace"),
                            result.getString("flyPlace"),
                            result.getInt("price"),
                            result.getDate("soldTime"),
                            result.getTimestamp("flyTime"),
                            result.getTimestamp("landTime"),
                            result.getString("ticketID"));

                    ticketList.add(ticket);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            Tinhtien();
        }

    }//GEN-LAST:event_btn_TinhtienActionPerformed

    public double Tinhtien() {
        double n = 0;
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).getType().equals("Domestic")) {
                n += ticketList.get(i).getPrice() * 0.05;
            } else {
                n += ticketList.get(i).getPrice() * 0.07 + 100000;
            }
        }
        return n;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Quanlyve().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Thongke;
    private javax.swing.JButton btn_Tinhtien;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
