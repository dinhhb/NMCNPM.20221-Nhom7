package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import java.text.SimpleDateFormat;
import models.BuoiHop;

public class BuoiHopService {
	private static Connection conn;
	
	public static List<BuoiHop> layDanhSachBuoiHop() {
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		String sql;
		List<BuoiHop>  danhSachBuoiHop = null;
		BuoiHop buoiHop;
		
		try {
			danhSachBuoiHop = new ArrayList<BuoiHop>();
			conn =MysqlConnection.getMysqlConnection();
			sql = "SELECT * FROM buoihoptable";
			preStatement = conn.prepareStatement(sql);
			resultSet = preStatement.executeQuery();
			
			if(resultSet.isBeforeFirst() == false) {
				return null;
			} else {
				while(resultSet.next()) {
                                        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
                                        long millis=System.currentTimeMillis();  
                                        java.sql.Date now=new java.sql.Date(millis);
                                        long tmp = Long.parseLong(fmt.format(resultSet.getDate(3))) - Long.parseLong(fmt.format(now));
                                        String s = null;
                                        if(tmp > 0) {
                                            s = "Chưa diễn ra";
                                        } else if(tmp < 0) {
                                            s = "Đã diễn ra";
                                        } else {
                                            s = "Đang diễn ra";
                                        }
					buoiHop = new BuoiHop(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getInt(5), s);
					danhSachBuoiHop.add(buoiHop);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  danhSachBuoiHop;	
	}
	
//	public static void updateBuoiHopTable(List<BuoiHop> danhSachBuoiHop) {
////		String sql = "Drop table BuoiHop";
//	}
	public static void updateBuoiHop(BuoiHop buoiHop) {
            //		String sql = "Drop table BuoiHop";
            Connection conn = null;
            PreparedStatement preStatement = null;
            ResultSet resultSet = null;
            String sql;
            SimpleDateFormat fmt;
            try {
                fmt = new SimpleDateFormat("yyyy-MM-dd");
                conn = MysqlConnection.getMysqlConnection();
                sql = "INSERT INTO buoihoptable(id, chude, thoigian, diadiem, soluong, trangthai) values (?,?,?,?,?,?)";
                preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, buoiHop.getMaBuoiHop());
                preStatement.setString(2, buoiHop.getChuDe());
                preStatement.setString(3, fmt.format(buoiHop.getThoiGian()));
                preStatement.setString(4, buoiHop.getDiaDiem());
                preStatement.setInt(5, buoiHop.getSoLuong());
                preStatement.setString(6, buoiHop.getTrangThai());
                preStatement.executeUpdate();
              
            }catch (Exception e) {
                    e.printStackTrace();
                }
	}
        
        public void capNhapBuoiHop (BuoiHop buoiHop){
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        try{
            conn =MysqlConnection.getMysqlConnection();
            sql="UPDATE buoihoptable SET soluong = ? WHERE id=?";
            preStatement=conn.prepareStatement(sql);
            preStatement.setInt(1, buoiHop.getSoLuong());
            preStatement.setString(2, buoiHop.getMaBuoiHop());
            preStatement.executeUpdate();
        }catch (Exception ex) {
              ex.printStackTrace();
        }   
    }    

}
