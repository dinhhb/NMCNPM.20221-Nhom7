/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.BuoiHopController;

import Bean.HoKhauBean;
import models.BuoiHop;
import models.DiemDanhModel;
import services.DiemDanhService;
import services.HoKhauService;
import utility.Render;
import views.infoViews.InfoJframe;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import services.HoKhauService;
import utility.TableModelHoKhau;
import views.infoViews.InfoJframe;
import javax.swing.JOptionPane;

/**
 *
 */
public class DiemDanhBuoiHopController  {

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

    public DiemDanhBuoiHopController(ViewBuoiHopController parentController, JFrame parentJFrame, BuoiHop bh) {
        this.parentController = parentController;
        this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.buoiHop = bh;
    }


    public void setParentJFrame(JFrame parentJFrame) {
        this.parentFrame = parentJFrame;
    }

    public DiemDanhBuoiHopController(JTextField searchJtf,JTextField searchJtf1, JPanel tableJpn, JButton btn,BuoiHop bh ) {
        this.searchJtf = searchJtf;
        this.searchJtf1=searchJtf1;
        this.tableJpn = tableJpn;
        this.btn = btn;
        this.buoiHop = bh;
        this.list = hoKhauService.getListHoKhau();
        themTrangThai();
        setData();
        initAction1();
        initAction();

    }

    public void initAction() {
        this.searchJtf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                    String key = searchJtf.getText().trim();
                    if (key.isEmpty()) {
                        searchJtf1.setEnabled(true);
                        list = hoKhauService.getListHoKhau();
                    } else {
                        searchJtf1.setEnabled(false);
                        list = hoKhauService.search(key);
                    }
                    themTrangThai();
                    setData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
                if (key.isEmpty()) {
                    searchJtf1.setEnabled(true);
                    list = hoKhauService.getListHoKhau();
                } else {
                    searchJtf1.setEnabled(false);
                    list = hoKhauService.search(key);
                }
                themTrangThai();
                setData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (checksearch()) {
                    String key = searchJtf.getText().trim();
                    if (key.isEmpty()) {
                        searchJtf1.setEnabled(true);
                        list = hoKhauService.getListHoKhau();
                    } else {
                        searchJtf1.setEnabled(false);
                        list = hoKhauService.search(key);
                    }
                    themTrangThai();
                    setData();
                }
            }
        });
    }
    public void initAction1() {
        this.searchJtf1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                    String key = searchJtf1.getText().trim();

                    if (key.isEmpty()) {
                        searchJtf.setEnabled(true);
                        list = hoKhauService.getListHoKhau();
                    } else {
                        searchJtf.setEnabled(false);
                        String key1= null;
                        try {
                            key1 = new DiemDanhService().ChuyenCMTthanhMaHoKhau(key);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        list = hoKhauService.search(key1);

                    }
                    themTrangThai();
                    setData();

            }


            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = searchJtf1.getText().trim();

                if (key.isEmpty()) {
                    searchJtf.setEnabled(true);
                    list = hoKhauService.getListHoKhau();
                } else {
                    searchJtf.setEnabled(false);
                    String key1= null;
                    try {
                        key1 = new DiemDanhService().ChuyenCMTthanhMaHoKhau(key);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    list = hoKhauService.search(key1);
                }
                themTrangThai();
                setData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                    String key = searchJtf1.getText().trim();

                    if (key.isEmpty()) {
                        searchJtf.setEnabled(true);
                        list = hoKhauService.getListHoKhau();
                    } else {
                        searchJtf.setEnabled(false);
                        String key1= null;
                        try {
                            key1 = new DiemDanhService().ChuyenCMTthanhMaHoKhau(key);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        list = hoKhauService.search(key1);
                    }
                    themTrangThai();
                    setData();
            }
        });
    }
    public void setData() {

        DefaultTableModel model = tableModelHoKhau.setTableHoKhauDiemDanh(list, COLUNMS);

        table = new JTable(model) ;
//        {
//            @Override
//            public boolean editCellAt(int row, int column, EventObject e) {
//                return false;
//            }

//        };
        table.setDefaultRenderer(Object.class,new Render());
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() > 1) {
////                    temp = list.get(table.getSelectedRow());
////                    InfoJframe infoJframe = new InfoJframe(temp.toString(), parentJFrame);
////                    infoJframe.setLocationRelativeTo(null);
////                    infoJframe.setVisible(true);
//                } else if(e.getClickCount() == 1) {
//                    btn.setEnabled(true);
//                    temp = list.get(table.getSelectedRow());
//                }
            }

        }
        );

        JScrollPane scroll = new JScrollPane();

        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(749, 334));
        tableJpn.removeAll();
        tableJpn.setLayout(new BorderLayout());
        tableJpn.add(scroll);
        tableJpn.validate();
        tableJpn.repaint();

    }

    public List<DiemDanhModel> getDiemDanh() {
        String soHoKhau = null;
        String trangThai = null;
        List<DiemDanhModel> listDiemDanhModel= new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            soHoKhau = String.valueOf(table.getValueAt(i, 0));
            trangThai = String.valueOf(table.getValueAt(i, 3));
            listDiemDanhModel.add(new DiemDanhModel(soHoKhau, this.buoiHop.getMaBuoiHop(), trangThai));
        }
        return listDiemDanhModel;
    }

    public void themTrangThai(){

        List<String> listMaHoKhau = new DiemDanhService().getMaHoKhau(buoiHop.getMaBuoiHop());
        for(int i=0;i<list.size();i++){
            for (int j=0; j<listMaHoKhau.size();j++) {
                if (list.get(i).getHoKhauModel().getMaHoKhau().equals(listMaHoKhau.get(j).toString()) ){

                        list.get(i).setTrangThai(true);
                }
            }
        }

    }
    public void refreshData() {
        this.list = hoKhauService.getListHoKhau();
        themTrangThai();
        setData();
    }
    private boolean checksearch(){
        if(searchJtf.getText().trim().isEmpty()!=true){
            if(searchJtf1.getText().trim().isEmpty()!=true){
//                JOptionPane.showMessageDialog(null, "Chỉ được tìm kiếm bằng CCCD hoặc sổ hộ khẩu vui lòng xóa 1 trong hai");
                System.out.println("Chỉ được tìm kiếm bằng CCCD hoặc sổ hộ khẩu vui lòng xóa 1 trong hais");
                return false;
            }
        }
        return true;

    }

    
}
