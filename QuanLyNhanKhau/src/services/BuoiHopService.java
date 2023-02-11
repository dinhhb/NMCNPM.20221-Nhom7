package services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    "GROUP BY buoihoptable.id"+" ORDER BY buoihoptable.thoigian desc";
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
        SimpleDateFormat fmt;
        try{
            conn =MysqlConnection.getMysqlConnection();
            fmt = new SimpleDateFormat("yyyy-MM-dd");
            sql="UPDATE buoihoptable SET chude = ? , thoigian = ? ,diadiem=? WHERE id=?";

            preStatement=conn.prepareStatement(sql);
            preStatement.setString(1, BuoiHop.getChuDe());
            preStatement.setDate(2, new java.sql.Date(BuoiHop.getThoiGian().getTime()));
            preStatement.setString(3, BuoiHop.getDiaDiem());
            preStatement.setString(4, BuoiHop.getMaBuoiHop());
            preStatement.executeUpdate();
        }catch (Exception ex) {
              ex.printStackTrace();
        }   
    }
    public void deleteBuoiHop (BuoiHop BuoiHop){
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        String sql1;
        SimpleDateFormat fmt;
        try{
            conn =MysqlConnection.getMysqlConnection();
            fmt = new SimpleDateFormat("yyyy-MM-dd");
            sql="DELETE FROM buoihoptable WHERE id=?";
            System.out.println(sql);
            preStatement=conn.prepareStatement(sql);
            preStatement.setString(1, BuoiHop.getMaBuoiHop());
            preStatement.executeUpdate();
            sql1="DELETE FROM diemdanhtable WHERE idbuoihop=?";
            System.out.println(sql1);
            preStatement=conn.prepareStatement(sql1);
            preStatement.setString(1, BuoiHop.getMaBuoiHop());
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
            query = "SELECT buoihoptable.id, buoihoptable.chude, buoihoptable.thoigian,buoihoptable.diadiem, count(diemdanhtable.mahokhau) as soluong\n" +
                    "FROM buoihoptable\n" +
                    "LEFT JOIN diemdanhtable\n" +
                    "ON buoihoptable.id = diemdanhtable.idbuoihop\n"
                    +"WHERE buoihoptable.chude LIKE '%"
                    + keyword
                    + "%' OR buoihoptable.id LIKE '%" +keyword+ "%'"+"OR buoihoptable.diadiem LIKE '%" +keyword+ "%'"
                    +"GROUP BY buoihoptable.id";
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
