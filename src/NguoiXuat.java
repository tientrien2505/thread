
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TienTruong
 */
public class NguoiXuat implements Runnable{
    private Kho kho;
    private int soLuongSanPham;
    private int giaiDoan;

    public NguoiXuat(Kho kho, int soLuongSanPham, int giaiDoan) {
        this.kho = kho;
        this.soLuongSanPham = soLuongSanPham;
        this.giaiDoan = giaiDoan;
    }

    
    @Override
    public void run() {
        for (int i = 0; i < soLuongSanPham; i++){
            if (i < giaiDoan){
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NguoiXuat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                try {
                    sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(NguoiXuat.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.kho.xuatKho();
        }
    }
    
}
