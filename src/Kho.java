
import static java.lang.Thread.sleep;
import java.util.ArrayList;
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
public class Kho {
    private ArrayList hang = new ArrayList(); // danh sach chua san pham trong kho
    private int full;// so san pham co the cho vao kho toi da
    private int slot;// so slot con trong trong kho   
    private boolean coTheNhap;
    private boolean coTheXuat;

    public Kho(int toiDa) {
        full = toiDa;
        slot = full;        
        coTheNhap = true;
        coTheXuat = false;
    }
    
    // hoat dong nhap kho
    public synchronized void nhapKho(int sanPham){
        if (!coTheNhap){            
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Kho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.hang.add(sanPham);
            System.out.println("Nhap: " + sanPham);
            slot--;        
            coTheXuat = true;
            if (slot==0)
                coTheNhap = false;            
            notify();
            
    }
    // hoat dong xuat kho
    public synchronized void xuatKho(){
        if (!coTheXuat){            
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Kho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Xuat: " + this.hang.remove((full-slot)-1));            
            slot++;
            coTheNhap = true;
            if (slot == full)
                coTheXuat = false;            
            notify();            
    }
}
