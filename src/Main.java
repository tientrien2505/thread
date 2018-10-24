/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TienTruong
 */
public class Main {
    public static void main(String[] args) {
        Kho kho = new Kho(5);
        NguoiNhap nguoiNhap = new NguoiNhap(kho, 10, 5);
        NguoiXuat nguoiXuat = new NguoiXuat(kho, 10, 2);
        Thread t1 = new Thread(nguoiNhap);
        Thread t2 = new Thread(nguoiXuat);
        t1.start();
        t2.start();
    }
}
