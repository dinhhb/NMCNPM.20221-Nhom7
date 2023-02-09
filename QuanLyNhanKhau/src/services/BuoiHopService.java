package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import java.text.SimpleDateFormat;
import models.BuoiHop;

import javax.swing.*;

public class BuoiHopService {
	private static Connection conn;
	
	public static List<BuoiHop> layDanhSachBuoiHop() {
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		String sql;
		List<BuoiHop>  danhSachBuoiHop = null;
		BuoiHop BuoiHop;
		
		try {
			danhSachBuoiHop = new ArrayList<BuoiHop>();
			conn =MysqlConnection.getMysqlConnection();
			sql = "SELECT buoihoptable.id, buoihoptable.chude, buoihoptable.thoigian,buoihoptable.diadiem, count(diemdanhtable.mahokhau) as soluong\n" +
                    "FROM buoihoptable\n" +
                    "LEFT JOIN diemdanhtable\n" +
                    "ON buoihoptable.id = diemdanhtable.idbuoihop\n" +
                    "GROUP BY buoihoptable.id;";
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
					BuoiHop = new BuoiHop(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4),resultSet.getInt(5), s);
					danhSachBuoiHop.add(BuoiHop);
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
	public static void updateBuoiHop(BuoiHop BuoiHop) {
            //		String sql = "Drop table BuoiHop";
            Connection conn = null;
            PreparedStatement preStatement = null;
            ResultSet resultSet = null;
            String sql;
            SimpleDateFormat fmt;
            try {
                fmt = new SimpleDateFormat("yyyy-MM-dd");
                conn = MysqlConnection.getMysqlConnection();
                sql = "INSERT INTO BuoiHoptable(id, chude, thoigian, diadiem, soluong, trangthai) values (?,?,?,?,?,?)";
                preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, BuoiHop.getMaBuoiHop());
                preStatement.setString(2, BuoiHop.getChuDe());
                preStatement.setString(3, fmt.format(BuoiHop.getThoiGian()));
                preStatement.setString(4, BuoiHop.getDiaDiem());
                preStatement.setInt(5, BuoiHop.getSoLuong());
                preStatement.setString(6, BuoiHop.getTrangThai());
                preStatement.executeUpdate();
              
            }catch (Exception e) {
                    e.printStackTrace();
                }
	}
        
        public void capNhapBuoiHop (BuoiHop BuoiHop){
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        try{
            conn =MysqlConnection.getMysqlConnection();
            sql="UPDATE BuoiHoptable SET soluong = ? WHERE id=?";
            preStatement=conn.prepareStatement(sql);
            preStatement.setInt(1, BuoiHop.getSoLuong());
            preStatement.setString(2, BuoiHop.getMaBuoiHop());
            preStatement.executeUpdate();
        }catch (Exception ex) {
              ex.printStackTrace();
        }   
    }

    public List<BuoiHop> search(String keyword) {
        List<BuoiHop> list = new  ArrayList<>();
        String query = "";
        if (keyword.trim().isEmpty()) {
            return this.layDanhSachBuoiHop();
        }
        // truy cap db
        // create query
        try {
            query = "SELECT * "
                    + "FROM buoihoptable "
                    + "WHERE chude LIKE '%"
                    + keyword
                    + "%'";
            query = "SELECT buoihoptable.id, buoihoptable.chude, buoihoptable.thoigian,buoihoptable.diadiem, count(diemdanhtable.mahokhau) as soluong\n" +
                    "FROM buoihoptable\n" +
                    "LEFT JOIN diemdanhtable\n" +
                    "ON buoihoptable.id = diemdanhtable.idbuoihop\n"
                    +"WHERE chude LIKE '%"
                    + keyword
                    + "%'"
                    +"GROUP BY buoihoptable.id;";
        } catch (Exception e) {
            System.out.println(e);
        }

        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
                long millis=System.currentTimeMillis();
                java.sql.Date now=new java.sql.Date(millis);
                long tmp = Long.parseLong(fmt.format(rs.getDate(3))) - Long.parseLong(fmt.format(now));
                String s = null;
                if(tmp > 0) {
                    s = "Chưa diễn ra";
                } else if(tmp < 0) {
                    s = "Đã diễn ra";
                } else {
                    s = "Đang diễn ra";
                }
                BuoiHop BuoiHop = new BuoiHop(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5), s);
                list.add(BuoiHop);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }

    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }

}
