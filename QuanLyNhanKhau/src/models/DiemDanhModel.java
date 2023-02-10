package models;

public class DiemDanhModel {
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
        String soHoKhau;
        String maBuoiHop;
        String trangThai;

        public DiemDanhModel(String soHoKhau, String maBuoiHop, String trangThai) {
            this.soHoKhau = soHoKhau;
            this.maBuoiHop = maBuoiHop;
            this.trangThai = trangThai;
        }


        public String getSoHoKhau() {
            return soHoKhau;
        }

        public void setSoHoKhau(String soHoKhau) {
            this.soHoKhau = soHoKhau;
        }

        public String getMaBuoiHop() {
            return maBuoiHop;
        }

        public void setMaBuoiHop(String maBuoiHop) {
            this.maBuoiHop = maBuoiHop;
        }

        public String getTrangThai() {
            return trangThai;
        }

        public void setTrangThai(String trangThai) {
            this.trangThai = trangThai;
        }



}
