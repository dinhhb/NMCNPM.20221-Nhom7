/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.BuoiHopController;

import Bean.NhanKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import models.BuoiHop;
import models.NhanKhauModel;
import services.BuoiHopService;
import services.NhanKhauService;
import utility.ClassTableModel;
import views.infoViews.InfoJframe;

/**
 *
 * @author ADMIN
 */
public class ViewBuoiHopController {
     private JButton btn;
    private JPanel jpnView;
    private JTextField jtfSearch;
    private BuoiHopService BuoiHopService;
    private List<BuoiHop> listBuoiHop;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Mã buổi họp", "Chủ đề", "Thời gian", "Địa điểm", "Số lượng", "Trạng thái"};
    private JFrame parentJFrame;
    private NhanKhauBean temp;
    public ViewBuoiHopController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.btn = btn;
        classTableModel = new ClassTableModel();
        this.BuoiHopService = new BuoiHopService();
        this.listBuoiHop = this.BuoiHopService.layDanhSachBuoiHop();
        initAction();
    }

//    public NhanKhauManagerPanelController() {
//    }
    
    
    //
    public void initAction(){
//        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                String key = jtfSearch.getText();
//                listBuoiHop = nhanKhauService.search(key.trim());
//                setDataTable();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                String key = jtfSearch.getText();
//                listNhanKhauBeans = nhanKhauService.search(key.trim());
//                setDataTable();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                String key = jtfSearch.getText();
//                listNhanKhauBeans = nhanKhauService.search(key.trim());
//                setDataTable();
//            }
//        });
    }
    
    public void setDataTable() {
        List<BuoiHop> listItem = new ArrayList<>();
        this.listBuoiHop.forEach(buoihop -> {
            listItem.add(buoihop);
        });
        DefaultTableModel model = classTableModel.setTableCuocHop(listItem, COLUMNS);
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        
        // thiet ke bang
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if (e.getClickCount() > 1) {
//                    temp = listNhanKhauBeans.get(table.getSelectedRow());
//                    NhanKhauBean info = nhanKhauService.getNhanKhau(temp.getChungMinhThuModel().getSoCMT());
//                    InfoJframe infoJframe = new InfoJframe(info.toString(), parentJFrame);
//                    infoJframe.setLocationRelativeTo(null);
//                    infoJframe.setVisible(true);
                } else if(e.getClickCount() == 1){
//                		btn.setEnabled(true);              		
                		BuoiHop temp = listBuoiHop.get(table.getSelectedRow());
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public void refreshData() {
        this.listBuoiHop = this.BuoiHopService.layDanhSachBuoiHop();
        setDataTable();
    }
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public JTextField getJtfSearch() {
        return jtfSearch;
    }

    public void setJtfSearch(JTextField jtfSearch) {
        this.jtfSearch = jtfSearch;
    }

//    public NhanKhauBean getInfo() {
//    	NhanKhauBean info = nhanKhauService.getNhanKhau(temp.getChungMinhThuModel().getSoCMT());
//    	return info;
//    }
}
