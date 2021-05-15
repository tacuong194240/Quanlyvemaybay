
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
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
public class QuanLy extends javax.swing.JFrame {

    /**
     * Creates new form QuanLy
     */
    List<Ticket> ticketList = new ArrayList<>();

    DefaultTableModel tableModel;

    public boolean checkinput() {
        if (txt_flyPlace.getText() == null
                || txt_flyTime.getText() == null
                || txt_landPlace.getText() == null
                || txt_landTime.getText() == null
                || txt_price.getText() == null
                || txt_ticketID.getText() == null
                || soldTime_calendar.getDate() == null) {
            return false;
        } else {
            return true;
        }
    }

    public QuanLy() {
        initComponents();
        setLocationRelativeTo(null);

        tableModel = (DefaultTableModel) table.getModel();

        loadDatabse();
        showdata();

        table.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

                int index = table.getSelectedRow();
                Ticket ticket = ticketList.get(index);

                comboType.setSelectedItem(ticket.getType());
                txt_landPlace.setText(ticket.getLandPlace());
                txt_flyPlace.setText(ticket.getFlyPlace());
                txt_price.setText(String.valueOf(ticket.getPrice()));
                soldTime_calendar.setDate(ticket.getSoldTime());
                txt_flyTime.setText(ticket.getFlyTime().toString());
                txt_landTime.setText(ticket.getLandTime().toString());
                txt_ticketID.setText(ticket.getTicketID());

                btn_delete.setEnabled(true);
                btn_update.setEnabled(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
    }

    // hien thi du lieu ra bang
    private void showdata() {
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

    private void loadDatabse() {
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField8 = new javax.swing.JTextField();
        jtext = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_flyPlace = new javax.swing.JTextField();
        txt_landPlace = new javax.swing.JTextField();
        txt_landTime = new javax.swing.JTextField();
        txt_flyTime = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        txt_ticketID = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        comboType = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        soldTime_calendar = new com.toedter.calendar.JDateChooser();
        btn_clear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTextField8.setText("jTextField1");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtext.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản Lý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Loại Vé");

        jLabel2.setText("Điểm đến");

        jLabel3.setText("Điểm khởi hành");

        jLabel4.setText("Giá vé");

        jLabel5.setText("Thời gian mua");

        jLabel6.setText("Thời gian bay");

        jLabel7.setText("Thời gian đến");

        jLabel8.setText("Mã vé");

        txt_landPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_landPlaceActionPerformed(evt);
            }
        });

        jTextField6.setText("jTextField1");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });

        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Domestic", "International" }));

        btn_update.setText("Sửa");
        btn_update.setEnabled(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Xóa");
        btn_delete.setEnabled(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Loại vé", "Điểm đến", "Điểm khởi hành", "Giá vé", "Ngày mua", "Thời gian bay", "Thời gian đến", "Mã vé"
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

        soldTime_calendar.setDateFormatString("yyyy-MM-dd");

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jtextLayout = new javax.swing.GroupLayout(jtext);
        jtext.setLayout(jtextLayout);
        jtextLayout.setHorizontalGroup(
            jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jtextLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jtextLayout.createSequentialGroup()
                        .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jtextLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_flyTime, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jtextLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_landTime, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jtextLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ticketID, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jtextLayout.createSequentialGroup()
                                .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_landPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_flyPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(soldTime_calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(155, 155, 155)
                        .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_clear)
                            .addComponent(btn_update)
                            .addComponent(btn_delete)
                            .addComponent(btn_add)
                            .addComponent(jButton1))))
                .addContainerGap(292, Short.MAX_VALUE))
            .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jtextLayout.createSequentialGroup()
                    .addGap(271, 271, 271)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(468, Short.MAX_VALUE)))
        );
        jtextLayout.setVerticalGroup(
            jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtextLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jtextLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_landPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_flyPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jtextLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btn_add)
                        .addGap(38, 38, 38)
                        .addComponent(btn_update)))
                .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jtextLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btn_delete))
                    .addGroup(jtextLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(soldTime_calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jtextLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel6))
                            .addGroup(jtextLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txt_flyTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jtextLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(btn_clear)))
                    .addGroup(jtextLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_landTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jtextLayout.createSequentialGroup()
                        .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_ticketID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(jtextLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addGap(9, 9, 9)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jtextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jtextLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(772, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        int index = table.getSelectedRow();
        Ticket ticket = ticketList.get(index);

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/ticketplane", "root", "14092001");
            String sql = "delete from ticket where id = ?";

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.execute();
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        loadDatabse();
        showdata();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        if (checkinput()) {
            int index = table.getSelectedRow();
            Ticket ticket = ticketList.get(index);
            Connection con = null;
            PreparedStatement preparedStatement = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/ticketplane", "root", "14092001");
                String sql = "update ticket set type = ?, landPlace = ?, flyPlace = ?, price = ?,  soldTime = ?, flyTime = ?, landTime = ?, ticketID = ? where id = ?";

                ticket.setLandPlace(txt_landPlace.getText().toString());
                ticket.setFlyPlace(txt_flyPlace.getText().toString());
                try {
                    ticket.setPrice(Integer.valueOf(txt_price.getText()));
                    if (ticket.getPrice() < 1000000) {
                        JOptionPane.showMessageDialog(null, "Giá vé phải lớn hơn 1.000.000");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Giá vé phải nhập kiểu số nguyên");
                }
                ticket.setType(comboType.getSelectedItem().toString());
                ticket.setSoldTime(soldTime_calendar.getDate());
                try {
                    ticket.setFlyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(txt_flyTime.getText()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(jtext, "Thời gian bay phải nhập theo yyyy-MM-dd HH:mm");
                }
                try {
                    ticket.setLandTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(txt_landTime.getText()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(jtext, "Thời gian đến phải nhập theo yyyy-MM-dd HH:mm");

                }
                ticket.setTicketID(txt_ticketID.getText().toString());

                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, ticket.getType());
                preparedStatement.setString(2, ticket.getLandPlace());
                preparedStatement.setString(3, ticket.getFlyPlace());
                preparedStatement.setInt(4, ticket.getPrice());
                preparedStatement.setTimestamp(5, new Timestamp(ticket.getSoldTime().getTime()));
                preparedStatement.setTimestamp(6, new Timestamp(ticket.getFlyTime().getTime()));
                preparedStatement.setTimestamp(7, new Timestamp(ticket.getLandTime().getTime()));
                preparedStatement.setString(8, ticket.getTicketID());
                preparedStatement.setInt(9, ticket.getId());

                preparedStatement.executeUpdate();

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
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            loadDatabse();
            showdata();
        } else {
            JOptionPane.showMessageDialog(null, "Nhập đầy đủ các ô trong bảng");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:

        if (checkinput()) {
            Ticket ticket = new Ticket();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ticket.setLandPlace(txt_landPlace.getText().toString());
            ticket.setFlyPlace(txt_flyPlace.getText().toString());

            try {
                ticket.setPrice(Integer.parseInt(txt_price.getText()));
                if (ticket.getPrice() < 1000000) {
                    JOptionPane.showMessageDialog(null, "Giá vé phải lớn hơn 1.000.000");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Giá vé phải nhập kiểu số nguyên");
            }
            ticket.setPrice(Integer.parseInt(txt_price.getText()));
            ticket.setType(comboType.getSelectedItem().toString());
            ticket.setSoldTime(soldTime_calendar.getDate());
            try {
                ticket.setFlyTime(format.parse(txt_flyTime.getText()));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Thời gian bay phải nhập theo yyyy-MM-dd");
                Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ticket.setLandTime(format.parse(txt_landTime.getText()));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Thời gian bay phải nhập theo yyyy-MM-dd");
                Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
            ticket.setTicketID(txt_ticketID.getText().toString());
            insert(ticket);
        } else {
            JOptionPane.showMessageDialog(null, "Nhập đầy đủ các ô");
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void insert(Ticket ticket) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/ticketplane", "root", "14092001");
            String sql = "insert  into ticket(type, landPlace, flyPlace, price, soldTime, flyTime, landTime, ticketID ) values(?,?,?,?,?,?,?,?)";

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ticket.getType());
            preparedStatement.setString(2, ticket.getLandPlace());
            preparedStatement.setString(3, ticket.getFlyPlace());
            preparedStatement.setInt(4, ticket.getPrice());
            preparedStatement.setTimestamp(5, new Timestamp(ticket.getSoldTime().getTime()));
            preparedStatement.setTimestamp(6, new Timestamp(ticket.getFlyTime().getTime()));
            preparedStatement.setTimestamp(7, new Timestamp(ticket.getLandTime().getTime()));
            preparedStatement.setString(8, ticket.getTicketID());
            preparedStatement.executeUpdate();

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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        loadDatabse();
        showdata();
    }

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        txt_landPlace.setText("");
        txt_flyPlace.setText("");
        txt_price.setText("");
        comboType.setSelectedIndex(0);
        txt_flyTime.setText("");
        txt_landTime.setText("");
        soldTime_calendar.setDate(new java.util.Date());
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_landPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_landPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_landPlaceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(QuanLy.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JPanel jtext;
    private com.toedter.calendar.JDateChooser soldTime_calendar;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_flyPlace;
    private javax.swing.JTextField txt_flyTime;
    private javax.swing.JTextField txt_landPlace;
    private javax.swing.JTextField txt_landTime;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_ticketID;
    // End of variables declaration//GEN-END:variables
}
