/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import models.*;


/**
 *
 */
public class ThongKeBuoiHopService {
    private static Connection conn;
    public List<ThongKeBH> layThongKeBH() {
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;
        List<ThongKeBH> danhSachThongKeBH = null;
        ThongKeBH ThongKeBH;

        try {
            danhSachThongKeBH = new ArrayList<ThongKeBH>();
            conn = MysqlConnection.getMysqlConnection();
            sql = "SELECT diemdanhtable.mahokhau, count(diemdanhtable.idbuoihop) as TongBuoiHop\n" +
                    "FROM diemdanhtable\n" +
                    "LEFT JOIN buoihoptable\n" +
                    "ON diemdanhtable.idbuoihop = buoihoptable.id\n" +
                    "GROUP BY diemdanhtable.mahokhau;";
            preStatement = conn.prepareStatement(sql);
            resultSet = preStatement.executeQuery();
            while(resultSet.next()) {
                ThongKeBH = new ThongKeBH(resultSet.getString(1), resultSet.getInt(2));
                danhSachThongKeBH.add(ThongKeBH);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachThongKeBH;


    }
    public List<ThongKeBH> searchThongKeBH( String nam) {
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;
        List<ThongKeBH> danhSachThongKeBH = null;
        ThongKeBH ThongKeBH;

        try {
            danhSachThongKeBH = new ArrayList<ThongKeBH>();
            conn = MysqlConnection.getMysqlConnection();
            sql = "SELECT diemdanhtable.mahokhau, count(diemdanhtable.idbuoihop) as TongBuoiHop\n" +
                    "FROM diemdanhtable\n" +
                    "LEFT JOIN buoihoptable\n" +
                    "ON diemdanhtable.idbuoihop = buoihoptable.id\n" +
                    "WHERE YEAR(buoihoptable.thoigian) = '" + nam +
                    "'GROUP BY diemdanhtable.mahokhau"
                    +" ORDER BY TongBuoiHop asc ";
            preStatement = conn.prepareStatement(sql);
            resultSet = preStatement.executeQuery();
            while(resultSet.next()) {
                ThongKeBH = new ThongKeBH(resultSet.getString(1), resultSet.getInt(2));
                danhSachThongKeBH.add(ThongKeBH);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachThongKeBH;


    }


    public void getListMaHoKhau() {
    }
}
