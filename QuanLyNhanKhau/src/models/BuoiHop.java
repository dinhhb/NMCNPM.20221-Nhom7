package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BuoiHop {
	private String maBuoiHop;
	private String chuDe;
	private Date thoiGian;
	private String diaDiem;
	private int soLuong;
	private String noiDung;
	private String trangThai;
	
	public BuoiHop() {
		
	}
	
	public BuoiHop(String maBuoiHop, String chuDe, Date thoiGian, String diaDiem, int soLuong, String trangThai) {
		this.maBuoiHop = maBuoiHop;
		this.chuDe = chuDe;
		this.thoiGian = thoiGian;
		this.diaDiem = diaDiem;
		this.soLuong = soLuong;
		this.trangThai = trangThai;
	}
	
	public String getMaBuoiHop() {
		return maBuoiHop;
	}

	public void setMaBuoiHop(String maBuoiHop) {
		this.maBuoiHop = maBuoiHop;
	}
	
	public String getChuDe() {
		return chuDe;
	}
	public void setChuDe(String chuDe) {
		this.chuDe = chuDe;
	}
	public Date getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}
