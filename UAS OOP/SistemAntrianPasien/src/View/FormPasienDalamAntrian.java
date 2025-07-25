package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;


public class FormPasienDalamAntrian extends javax.swing.JFrame {


    public FormPasienDalamAntrian() {
    System.out.println(">> Konstruktor FormAntrianPasien dipanggil");
    initComponents();
    tampilData(); 
    System.out.println(">> initComponents selesai");

    }
 
    private void tampilData() {
    System.out.println(">> Memuat data pasien dari database");
    DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Nama Pasien", "Jenis Kelamin", "Usia", "Keluhan"}, 0);
        try {
            Connection conn = new Koneksi().koneksi();
            System.out.println(">> Koneksi DB berhasil");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM antrian_pasien");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("ID"),
                    rs.getString("Nama_Pasien"),
                    rs.getString("Jenis_Kelamin"),
                    rs.getInt("Usia"),
                    rs.getString("Keluhan")
                });
            }
            jTable1.setModel(model);
            System.out.println(">> Data berhasil dimuat ke tabel");
        } catch (SQLException e) {
            System.out.println("!! Gagal memuat data: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pasien Dalam Antrian");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Pasien", "Jenis Kelamin", "Usia", "Keluhan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTutup)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnTutup))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int baris = jTable1.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
            return;
        }
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            int id = (int) jTable1.getValueAt(baris, 0); // ambil ID

            try {
                Connection conn = new Koneksi().koneksi();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM antrian_pasien WHERE ID = ?");
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                tampilData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
    new FormPasiendiKlinik().setVisible(true); // tampilkan form sebelumnya
    this.dispose(); // tutup form saat ini
    }//GEN-LAST:event_btnTutupActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih baris yang akan diedit.");
            return;
        }

        // Ambil data lama dari tabel
        int ID = (int) jTable1.getValueAt(selectedRow, 0); // Kolom 0 adalah ID
        String nama = (String) jTable1.getValueAt(selectedRow, 1);
        String JenisKelamin = (String) jTable1.getValueAt(selectedRow, 2);
        int Usia = (int) jTable1.getValueAt(selectedRow, 3);
        String Keluhan = (String) jTable1.getValueAt(selectedRow, 4);

        // Input baru dari user
        String newNama = JOptionPane.showInputDialog(this, "Nama_Pasien:", nama);
        String newJenisKelamin = JOptionPane.showInputDialog(this, "Jenis_Kelamin (L/P):", JenisKelamin);
        String newUsiaStr = JOptionPane.showInputDialog(this, "Usia:", String.valueOf(Usia));
        String newKeluhan = JOptionPane.showInputDialog(this, "Keluhan:", Keluhan);

        if (newNama != null && newJenisKelamin != null && newUsiaStr != null && newKeluhan != null) {
            try {
                int newUsia = Integer.parseInt(newUsiaStr);

                Connection conn = new Koneksi().koneksi();
                PreparedStatement pst = conn.prepareStatement(
                    "UPDATE antrian_pasien SET Nama_Pasien = ?, Jenis_Kelamin = ?, Usia = ?, Keluhan = ? WHERE ID = ?"
                );
                pst.setString(1, newNama);
                pst.setString(2, newJenisKelamin);
                pst.setInt(3, newUsia);
                pst.setString(4, newKeluhan);
                pst.setInt(5, ID);

                int rowsUpdated = pst.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Data pasien berhasil diperbarui.");
                    tampilData(); // Refresh tabel
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal memperbarui data pasien.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Usia harus berupa angka.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan database: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPasienDalamAntrian().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnTutup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}