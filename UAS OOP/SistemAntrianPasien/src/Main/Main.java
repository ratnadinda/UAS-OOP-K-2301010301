package Main;
import View.FormPasiendiKlinik;


public class Main {
    public static void main(String[] args) {
        System.out.println(">> Program dimulai");

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println(">> Membuka FormAntrianPasien");
                new FormPasiendiKlinik().setVisible(true);
            }
        });
    }
}
