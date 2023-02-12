package models;

public class ThongKeBH {
    private String maHoKhau;
    private int tongBuoiHop;

    public ThongKeBH(){

    }
    public ThongKeBH(String maHoKhau, int tongBuoiHop){
        this.maHoKhau= maHoKhau;
        this.tongBuoiHop = tongBuoiHop;

    }
    public String getMaHoKhau(){
        return maHoKhau;
    }
    public void setMaHoKhau(){
        this.maHoKhau=maHoKhau;
    }
    public int getTongBuoiHop(){
        return tongBuoiHop;
    }
    public void setTongBuoiHop(){
        this.tongBuoiHop = tongBuoiHop;

    }
}
