/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Bean.DanhMucBean;
import controllers.MainController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.Panel;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Hai
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setTitle("QUẢN LÍ NHÂN KHẨU");
        List<DanhMucBean> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMucBean("TrangChu", Home, jblTrangChu));
        listDanhMuc.add(new DanhMucBean("NhanKhau", NhanKhauBtn, jlbNhanKhau));
        listDanhMuc.add(new DanhMucBean("HoKhau", HoKhauBtn, jlbHoKhau));
        listDanhMuc.add(new DanhMucBean("ThongKe", ThongKeBtn, jlbThongKe));
        listDanhMuc.add(new DanhMucBean("TimKiem", TimKiemBtn, lblTimKiem));
        listDanhMuc.add(new DanhMucBean("BuoiHop", BuoiHopBtn, lblBuoiHop));
        
        MainController controller = new MainController(jpnBean, this);
        controller.setView(Home, jblTrangChu, "TrangChu");
        controller.setEvent(listDanhMuc);
        
        // confirm de thuc hien dong
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                    dispose();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnContainer = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        jblTrangChu = new javax.swing.JLabel();
        NhanKhauBtn = new javax.swing.JPanel();
        jlbNhanKhau = new javax.swing.JLabel();
        HoKhauBtn = new javax.swing.JPanel();
        jlbHoKhau = new javax.swing.JLabel();
        ThongKeBtn = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jpnBean = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnContainer.setBackground(new java.awt.Color(255, 255, 255));

        jpnMenu.setBackground(new java.awt.Color(153, 153, 153));

        Home.setBackground(new java.awt.Color(0, 160, 50));

        jblTrangChu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jblTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jblTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/app.png"))); // NOI18N
        jblTrangChu.setText("Trang chủ");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        HomeLayout.setHorizontalGroup(
        	HomeLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(HomeLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jblTrangChu)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
        	HomeLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, HomeLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jblTrangChu)
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        Home.setLayout(HomeLayout);

        NhanKhauBtn.setBackground(new java.awt.Color(102, 102, 102));
        NhanKhauBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlbNhanKhau.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbNhanKhau.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhanKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/multiple-users-silhouette.png"))); // NOI18N
        jlbNhanKhau.setText("Nhân khẩu");

        javax.swing.GroupLayout NhanKhauBtnLayout = new javax.swing.GroupLayout(NhanKhauBtn);
        NhanKhauBtn.setLayout(NhanKhauBtnLayout);
        NhanKhauBtnLayout.setHorizontalGroup(
            NhanKhauBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhanKhauBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNhanKhau)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        NhanKhauBtnLayout.setVerticalGroup(
            NhanKhauBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NhanKhauBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbNhanKhau)
                .addContainerGap())
        );

        HoKhauBtn.setBackground(new java.awt.Color(102, 102, 102));

        jlbHoKhau.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbHoKhau.setForeground(new java.awt.Color(255, 255, 255));
        jlbHoKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home.png"))); // NOI18N
        jlbHoKhau.setText("Hộ khẩu");

        javax.swing.GroupLayout HoKhauBtnLayout = new javax.swing.GroupLayout(HoKhauBtn);
        HoKhauBtn.setLayout(HoKhauBtnLayout);
        HoKhauBtnLayout.setHorizontalGroup(
            HoKhauBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoKhauBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbHoKhau)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HoKhauBtnLayout.setVerticalGroup(
            HoKhauBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoKhauBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbHoKhau)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ThongKeBtn.setBackground(new java.awt.Color(102, 102, 102));

        jlbThongKe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/increasing-stocks-graphic.png"))); // NOI18N
        jlbThongKe.setText("Thống kê");

        javax.swing.GroupLayout ThongKeBtnLayout = new javax.swing.GroupLayout(ThongKeBtn);
        ThongKeBtn.setLayout(ThongKeBtnLayout);
        ThongKeBtnLayout.setHorizontalGroup(
            ThongKeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThongKeBtnLayout.setVerticalGroup(
            ThongKeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThongKeBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbThongKe)
                .addContainerGap())
        );
        
        TimKiemBtn = new JPanel();
        TimKiemBtn.setBackground(new Color(102, 102, 102));
        
        lblTimKiem = new JLabel();
        lblTimKiem.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/magnifying-glass.png")));
        lblTimKiem.setText("Tìm kiếm");
        lblTimKiem.setForeground(Color.WHITE);
        lblTimKiem.setFont(new Font("Arial", Font.BOLD, 14));
        GroupLayout gl_TimKiemBtn = new GroupLayout(TimKiemBtn);
        gl_TimKiemBtn.setHorizontalGroup(
        	gl_TimKiemBtn.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_TimKiemBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblTimKiem, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(77, Short.MAX_VALUE))
        );
        gl_TimKiemBtn.setVerticalGroup(
        	gl_TimKiemBtn.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_TimKiemBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblTimKiem, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TimKiemBtn.setLayout(gl_TimKiemBtn);
        
        BuoiHopBtn = new JPanel();
        BuoiHopBtn.setBackground(new Color(102, 102, 102));
        
        lblBuoiHop = new JLabel();
        lblBuoiHop.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/BuoiHop.png")));
        lblBuoiHop.setText("Buổi Họp");
        lblBuoiHop.setForeground(Color.WHITE);
        lblBuoiHop.setFont(new Font("Arial", Font.BOLD, 14));
        GroupLayout gl_BuoiHopBtn = new GroupLayout(BuoiHopBtn);
        gl_BuoiHopBtn.setHorizontalGroup(
        	gl_BuoiHopBtn.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_BuoiHopBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblBuoiHop, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_BuoiHopBtn.setVerticalGroup(
        	gl_BuoiHopBtn.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_BuoiHopBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblBuoiHop, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BuoiHopBtn.setLayout(gl_BuoiHopBtn);
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenuLayout.setHorizontalGroup(
        	jpnMenuLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jpnMenuLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jpnMenuLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(NhanKhauBtn, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        				.addComponent(HoKhauBtn, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        				.addComponent(ThongKeBtn, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        				.addComponent(Home, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        				.addComponent(TimKiemBtn, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        				.addComponent(BuoiHopBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        		.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        jpnMenuLayout.setVerticalGroup(
        	jpnMenuLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jpnMenuLayout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(43)
        			.addComponent(Home, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(NhanKhauBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(HoKhauBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(ThongKeBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(TimKiemBtn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(BuoiHopBtn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(78, Short.MAX_VALUE))
        );
        
        ThongKeBtn_1 = new JPanel();
        panel.add(ThongKeBtn_1);
        ThongKeBtn_1.setBackground(Color.WHITE);
        
        lblEdit = new JLabel();
        lblEdit.setBackground(Color.BLACK);
        lblEdit.setText("Edit");
        lblEdit.setForeground(Color.BLACK);
        lblEdit.setFont(new Font("Arial", Font.BOLD, 14));
        GroupLayout gl_ThongKeBtn_1 = new GroupLayout(ThongKeBtn_1);
        gl_ThongKeBtn_1.setHorizontalGroup(
        	gl_ThongKeBtn_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_ThongKeBtn_1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblEdit)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_ThongKeBtn_1.setVerticalGroup(
        	gl_ThongKeBtn_1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_ThongKeBtn_1.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(lblEdit))
        );
        ThongKeBtn_1.setLayout(gl_ThongKeBtn_1);
        
        ThongKeBtn_2 = new JPanel();
        ThongKeBtn_2.setForeground(Color.BLACK);
        ThongKeBtn_2.setBackground(Color.WHITE);
        panel.add(ThongKeBtn_2);
        
        lblHistory = new JLabel();
        lblHistory.setText("History");
        lblHistory.setForeground(Color.BLACK);
        lblHistory.setFont(new Font("Arial", Font.BOLD, 14));
        GroupLayout gl_ThongKeBtn_2 = new GroupLayout(ThongKeBtn_2);
        gl_ThongKeBtn_2.setHorizontalGroup(
        	gl_ThongKeBtn_2.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 47, Short.MAX_VALUE)
        		.addGroup(gl_ThongKeBtn_2.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblHistory)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_ThongKeBtn_2.setVerticalGroup(
        	gl_ThongKeBtn_2.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 27, Short.MAX_VALUE)
        		.addGroup(gl_ThongKeBtn_2.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(lblHistory))
        );
        ThongKeBtn_2.setLayout(gl_ThongKeBtn_2);
        
        ThongKeBtn_3 = new JPanel();
        ThongKeBtn_3.setBackground(Color.WHITE);
        panel.add(ThongKeBtn_3);
        
        lblEdit_2 = new JLabel();
        lblEdit_2.setText("Help");
        lblEdit_2.setForeground(Color.BLACK);
        lblEdit_2.setFont(new Font("Arial", Font.BOLD, 14));
        GroupLayout gl_ThongKeBtn_3 = new GroupLayout(ThongKeBtn_3);
        gl_ThongKeBtn_3.setHorizontalGroup(
        	gl_ThongKeBtn_3.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_ThongKeBtn_3.createSequentialGroup()
        			.addComponent(lblEdit_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_ThongKeBtn_3.setVerticalGroup(
        	gl_ThongKeBtn_3.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_ThongKeBtn_3.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(lblEdit_2))
        );
        ThongKeBtn_3.setLayout(gl_ThongKeBtn_3);
        jpnMenu.setLayout(jpnMenuLayout);

        javax.swing.GroupLayout jpnBeanLayout = new javax.swing.GroupLayout(jpnBean);
        jpnBean.setLayout(jpnBeanLayout);
        jpnBeanLayout.setHorizontalGroup(
            jpnBeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        jpnBeanLayout.setVerticalGroup(
            jpnBeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnContainerLayout = new javax.swing.GroupLayout(jpnContainer);
        jpnContainerLayout.setHorizontalGroup(
        	jpnContainerLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jpnContainerLayout.createSequentialGroup()
        			.addComponent(jpnMenu, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
        			.addGap(30)
        			.addComponent(jpnBean, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jpnContainerLayout.setVerticalGroup(
        	jpnContainerLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jpnContainerLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jpnBean, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        			.addContainerGap())
        		.addComponent(jpnMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnContainer.setLayout(jpnContainerLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HoKhauBtn;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel NhanKhauBtn;
    private javax.swing.JPanel ThongKeBtn;
    private javax.swing.JLabel jblTrangChu;
    private javax.swing.JLabel jlbHoKhau;
    private javax.swing.JLabel jlbNhanKhau;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JPanel jpnBean;
    private javax.swing.JPanel jpnContainer;
    private javax.swing.JPanel jpnMenu;
    private JPanel BuoiHopBtn;
    private JLabel lblBuoiHop;
    private JPanel TimKiemBtn;
    private JLabel lblTimKiem;
    private JPanel panel;
    private JPanel ThongKeBtn_1;
    private JLabel lblEdit;
    private JPanel ThongKeBtn_2;
    private JLabel lblHistory;
    private JPanel ThongKeBtn_3;
    private JLabel lblEdit_2;
}
