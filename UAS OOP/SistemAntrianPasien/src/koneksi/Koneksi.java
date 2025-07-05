/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

/**
 *
 * @author 
 * TGL: 21 JUNI 2025
 */
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/db_klinik"; // Disesuaikan dengan nama database kamu
    static String DB_USER = "root";
    static String DB_PASS = "";
    static Connection konek;

    public Connection koneksi() {
        try {
            Class.forName(JDBC_DRIVER);
            konek = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Koneksi ke database BERHASIL");
            return konek;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Terjadi masalah koneksi database: " + e.getMessage());
        }
        return null;
    }
}
