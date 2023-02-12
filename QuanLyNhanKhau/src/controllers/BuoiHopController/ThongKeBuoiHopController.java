package controllers.BuoiHopController;
import Bean.HoKhauBean;
import Bean.NhanKhauBean;
import models.ThongKeBH;
import utility.ClassTableModel;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import services.*;

import models.BuoiHop;

import utility.TableModelHoKhau;
import views.BuoiHopManagerFrame.ThongKeBuoiHop;

public class ThongKeBuoiHopController {
    //private final services.ThongKeBuoiHopService ThongkeBuoiHopService;
    private ViewBuoiHopController parentController;
    private BuoiHop buoiHop;

    private ThongKeBuoiHopService ThongKeBuoiHopService =new ThongKeBuoiHopService();
    private BuoiHopService BuoiHopService;
    private final TableModelHoKhau tableModelHoKhau = new TableModelHoKhau();
    private JFrame parentJFrame;

    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
    private JButton jButton1;
    private JButton btn;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField NamJtf;
    private List<HoKhauBean> list;
    private JPanel jpnView;
    private JTextField searchJtf;
    private JPanel tableJpn;
    private final HoKhauService hoKhauService = new HoKhauService();
    private List<ThongKeBH> listThongKeBH ;
    private ClassTableModel classTableModel;
    private final String[] COLUMNS = {"Mã hộ khẩu", "Họ tên chủ hộ", "Địa chỉ","Tổng số buổi họp"};
    public ThongKeBuoiHopController(JTextField searchJtf, JPanel tableJpn, JButton btn) {
        this.searchJtf = searchJtf;
        this.tableJpn = tableJpn;
        this.btn = btn;

        this.listThongKeBH = this.ThongKeBuoiHopService.layThongKeBH();

//        initAction();
        btn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonShow();
//                JOptionPane.showMessageDialog(null, "Chỉ được tìm kiếm bằng CCCD hoặc sổ hộ khẩu vui lòng xóa 1 trong hai");
            }
        });
        this.list = hoKhauService.getListHoKhau();
        themBuoiHop();
        setData();
    }
    public JPanel getJpnView() {
        return jpnView;
    }
    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }
    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }

    public void initAction() {
        this.searchJtf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
                if (key.isEmpty()) {
                    listThongKeBH =ThongKeBuoiHopService.layThongKeBH();
                } else {
                    listThongKeBH =ThongKeBuoiHopService.searchThongKeBH(key);
                }
                themBuoiHop();
                setData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
                if (key.isEmpty()) {
                    listThongKeBH =ThongKeBuoiHopService.layThongKeBH();
                } else {
                    listThongKeBH =ThongKeBuoiHopService.searchThongKeBH(key);
                }
                themBuoiHop();
                setData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                    String key = searchJtf.getText().trim();
                    if (key.isEmpty()) {
                        listThongKeBH =ThongKeBuoiHopService.layThongKeBH();
                    } else {
                        listThongKeBH =ThongKeBuoiHopService.searchThongKeBH(key);
                    }
                    themBuoiHop();
                    setData();
            }
        });
    }

    public void setData() {
        setDataTable();
    }
    public void buttonShow(){
        String key = searchJtf.getText().trim();
        this.list = hoKhauService.getListHoKhau();
        if (key.isEmpty()) {
            listThongKeBH =ThongKeBuoiHopService.layThongKeBH();
        } else {
            listThongKeBH =ThongKeBuoiHopService.searchThongKeBH(key);
        }
        themBuoiHop();
        setData();


    }
    public void themBuoiHop(){


        for(int i=0;i<list.size();i++){

            for (int j=0; j<this.listThongKeBH.size();j++) {

                if (list.get(i).getHoKhauModel().getMaHoKhau().equals(this.listThongKeBH.get(j).getMaHoKhau()) ){
                    list.get(i).setTongSoBuoiHop(this.listThongKeBH.get(j).getTongBuoiHop());
                }
            }
        }

    }
    public void sapXepTuCaoXuongThap(){
        Collections.sort(list, new Comparator<HoKhauBean>() {
            @Override
            public int compare(HoKhauBean o1, HoKhauBean o2) {
                return o2.getTongSoBuoiHop()-o1.getTongSoBuoiHop();
            }
        });
    }
    public void setDataTable() {
        sapXepTuCaoXuongThap();
        List<HoKhauBean> listItem = new ArrayList<HoKhauBean>();
        this.list.forEach(TK -> {
            listItem.add(TK);
        });



        DefaultTableModel model = ClassTableModel.setThongKeBH(listItem,COLUMNS);
        JTable table = new JTable(model);

        // thiet ke bang

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        // table.addMouseListener();

        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(720, 340));
        tableJpn.removeAll();
        tableJpn.setLayout(new CardLayout());
        tableJpn.add(scroll);
        tableJpn.validate();
        tableJpn.repaint();
    }
    //this.listBuoiHopBeans = this.ThongKeBuoiHopService.statisticBuoiHop(Nam);
    //setDataTable();




}