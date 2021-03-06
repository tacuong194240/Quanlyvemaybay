
import java.sql.Connection;
import java.util.Date;
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
public class TimKiem extends javax.swing.JFrame {

    /**
     * Creates new form TimKiem
     */
    List<Ticket> ticketList = new ArrayList<>();
    DefaultTableModel tableModel;

    public TimKiem() {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_flyPlace = new javax.swing.JTextField();
        txt_landPlace = new javax.swing.JTextField();
        txt_landTime = new javax.swing.JTextField();
        txt_flyTime = new javax.swing.JTextField();
        btn_timkiemLocal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_timkiemTime = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("T??m ki???m v?? m??y bay\n");

        jLabel2.setText("N??i ??i");

        jLabel3.setText("Th???i gian ?????n");

        jLabel4.setText("N??i ?????n");

        jLabel5.setText("Th???i gian bay");

        txt_flyTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_flyTimeActionPerformed(evt);
            }
        });

        btn_timkiemLocal.setText("T??m theo ?????a ??i???m");
        btn_timkiemLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemLocalActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Lo???i v??", "N??i ?????n", "N??i ??i", "Gi?? v??", "Ng??y mua", "Th???i gian bay", "Th???i gian ?????n", "M?? v??"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        btn_timkiemTime.setText("T??m theo th???i gian");
        btn_timkiemTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemTimeActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_landTime, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(btn_cancel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_landPlace)
                                            .addComponent(txt_flyPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_flyTime, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_timkiemLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_timkiemTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_landPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_flyPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btn_timkiemLocal)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_timkiemTime))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_flyTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3))
                            .addComponent(txt_landTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void btn_timkiemLocalActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        if (txt_flyPlace.getText().isEmpty() || txt_landPlace.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nh???p ?????y ????? ?????a ??i???m ");
        } else {
            ticketList.clear();
            Connection con = null;
            Statement statement = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/ticketplane? zeroDateTimeBehavior = convertToNull", "root", "14092001");

                String landPlace = txt_landPlace.getText();
                String flyPlace = txt_flyPlace.getText();
 
                //truy van lay du lieu giong voi ten nhap vao
                String sql = " select * from ticket where landPlace like'%" + landPlace + "%' or flyPlace like'%" + flyPlace + "%'";
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
                Logger.getLogger(TimKiem.class.getName()).log(Level.SEVERE, null, ex);
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


    }                                                

    
    
    private void btn_timkiemTimeActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        if (txt_flyTime.getText().isEmpty() || txt_landTime.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nh???p ?????y ????? th???i gian ");
        } else {
            ticketList.clear();
            Connection con = null;
            Statement statement = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/ticketplane? zeroDateTimeBehavior = convertToNull", "root", "14092001");
            
                       try {
                    Date  date1 =  new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(txt_flyTime.getText());  // ep kieu du lieu nhap vao
                    Date  date2 =  new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(txt_flyTime.getText());                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Th???i gian bay ph???i nh???p theo yyyy-MM-dd HH:mm");
                }
                
                String flyTime = txt_flyTime.getText();
                String landTime = txt_landTime.getText();

                String sql = " select * from ticket where flyTime >= '" + flyTime + " 'and landTime <= '" + landTime + " '";
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
                Logger.getLogger(TimKiem.class.getName()).log(Level.SEVERE, null, ex);
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


    }                                               

    private void txt_flyTimeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        new Quanlyve().setVisible(true);
        this.dispose();
    }                                          

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
            java.util.logging.Logger.getLogger(TimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimKiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_timkiemLocal;
    private javax.swing.JButton btn_timkiemTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_flyPlace;
    private javax.swing.JTextField txt_flyTime;
    private javax.swing.JTextField txt_landPlace;
    private javax.swing.JTextField txt_landTime;
    // End of variables declaration                   
}
