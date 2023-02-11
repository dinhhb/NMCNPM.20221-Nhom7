package controllers.BuoiHopController;

import models.BuoiHop;
import services.MysqlConnection;

import java.sql.*;

public class AddNewController {
    public boolean themBuoiHop(BuoiHop buoiHop) throws SQLException, ClassNotFoundException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO buoihoptable (id, chude, thoigian, diadiem)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, buoiHop.getMaBuoiHop());
//        java.sql.Date thoiGianHop = new java.sql.Date(buoiHop.getThoiGian().getTime());
        preparedStatement.setString(2, buoiHop.getChuDe());
        java.sql.Date createDate = new java.sql.Date(quanlynhankhau.QuanLyNhanKhau.calendar.getTime().getTime());
        preparedStatement.setDate(3, createDate);
        preparedStatement.setString(4, buoiHop.getDiaDiem());
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        connection.close();
        return true;
    }
}


