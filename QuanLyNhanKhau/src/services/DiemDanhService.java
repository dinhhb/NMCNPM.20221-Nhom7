package services;

import Bean.NhanKhauBean;
import models.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DiemDanhService {

    private static Connection conn;
    public BuoiHop getBuoiHop(String maBuoiHop) {
        BuoiHop BuoiHop = new BuoiHop();
        // truy cap db
        try {
            String  query = "SELECT * FROM buoihoptable WHERE id = '" + maBuoiHop +"'";
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
               BuoiHop = new BuoiHop(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), 0, s);
            }
            connection.close();
        } catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return BuoiHop;
    }

    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }

//    public boolean getTrangThai(String maBuoiHop) {
//        BuoiHop BuoiHop = new BuoiHop();
//        // truy cap db
//        try {
//            String  query = "SELECT * FROM buoihoptable WHERE id = '" + maBuoiHop +"'";
//            Connection connection = MysqlConnection.getMysqlConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
//                long millis=System.currentTimeMillis();
//                java.sql.Date now=new java.sql.Date(millis);
//                long tmp = Long.parseLong(fmt.format(rs.getDate(3))) - Long.parseLong(fmt.format(now));
//                String s = null;
//                if(tmp > 0) {
//                    s = "Chưa diễn ra";
//                } else if(tmp < 0) {
//                    s = "Đã diễn ra";
//                } else {
//                    s = "Đang diễn ra";
//                }
//                BuoiHop = new BuoiHop(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), 0, s);
//            }
//            connection.close();
//        } catch (Exception e) {
//            this.exceptionHandle(e.getMessage());
//        }
//        return BuoiHop;
//    }

    public List<String> getMaHoKhau(String maBuoiHop) {
            List<String> listMaHoKhau =new ArrayList<>();
            // truy cap db
            try {
                String  query = "SELECT mahokhau FROM diemdanhtable WHERE idbuoihop = '" + maBuoiHop +"'";
                Connection connection = MysqlConnection.getMysqlConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    listMaHoKhau.add(rs.getString(1));
                }
                connection.close();
            } catch (Exception e) {
                this.exceptionHandle(e.getMessage());
            }
            return listMaHoKhau;
        }
}
