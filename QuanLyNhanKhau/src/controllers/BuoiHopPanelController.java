package controllers;

import models.BuoiHop;
import services.BuoiHopService;
import utility.ClassTableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class BuoiHopPanelController {

    /**
     * @param args the command line arguments
     */
    private JPanel jpnView;
    private JTextField jtfSearch;
    private BuoiHopService buoiHopService;
    private List<BuoiHop> listBuoiHop;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"ID", "Chủ đề", "Thời gian", "Địa điểm"};
    private JFrame parentJFrame;

    public BuoiHopPanelController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        classTableModel = new ClassTableModel();
        this.buoiHopService = new BuoiHopService();
        this.listBuoiHop = this.buoiHopService.layDanhSachBuoiHop();
        System.out.println("controllers.BuoiHopPanelController.<init>()");
        initAction();
    }

    public void initAction(){
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listBuoiHop = buoiHopService.search(key.trim());
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listBuoiHop = buoiHopService.search(key.trim());
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listBuoiHop = buoiHopService.search(key.trim());
                setDataTable();
            }
        });
    }

    public void setDataTable() {
        List<BuoiHop> listItem = new ArrayList<>();
        this.listBuoiHop.forEach(BuoiHop -> {
            listItem.add(BuoiHop);
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
        table.getTableHeader().setPreferredSize(new Dimension(70, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(40);
        table.getColumnModel().getColumn(0).setMinWidth(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if (e.getClickCount() > 1) {
                    BuoiHop temp = listBuoiHop.get(table.getSelectedRow());
                }
            }

        });

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(800, 400));
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
        this.listBuoiHop = this.buoiHopService.layDanhSachBuoiHop();
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
    public BuoiHopPanelController() {
    }
}

