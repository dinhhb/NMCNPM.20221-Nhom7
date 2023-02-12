package controllers.BuoiHopController;

import Bean.HoKhauBean;
import models.BuoiHop;
import services.HoKhauService;
import utility.TableModelHoKhau;

import javax.swing.*;
import java.util.List;

public class CapNhatBuoiHopController {

    private ViewBuoiHopController parentController;
    private BuoiHop buoiHop;

    private JTextField searchJtf;
    private JTextField searchJtf1;
    private JPanel tableJpn;
    private JButton btn;
    private List<HoKhauBean> list;
    private List<HoKhauBean> listThemTrangThai;
    private HoKhauBean temp;
    private final HoKhauService hoKhauService = new HoKhauService();
    private final TableModelHoKhau tableModelHoKhau = new TableModelHoKhau();
    private JFrame parentFrame;
    private final String COLUNMS[] = {"Mã hộ khẩu", "Họ tên chủ hộ", "Địa chỉ","Điểm danh"};
    private JFrame parentJFrame;
    private JTable table;

    public CapNhatBuoiHopController(ViewBuoiHopController parentController, JFrame parentJFrame, BuoiHop bh) {

    }
    public void setParentJFrame(JFrame parentJFrame) {
    this.parentFrame = parentJFrame;
}
}
