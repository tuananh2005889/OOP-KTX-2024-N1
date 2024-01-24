package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class viewdangnhap extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField taikhoan_text;
    private JPasswordField mk_text;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    viewdangnhap frame = new viewdangnhap();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public viewdangnhap() {
        setTitle("Kí túc xá - VKU");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2023-12-06 202316.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 686, 568);
        contentPane = 	new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel taikhoan = new JLabel("Tài khoản: ");
        taikhoan.setForeground(SystemColor.window);
        taikhoan.setFont(new Font("Arial", Font.BOLD, 20));
        taikhoan.setBounds(217, 154, 115, 29);
        contentPane.add(taikhoan);
        
        taikhoan_text = new JTextField();
        taikhoan_text.setBounds(217, 193, 232, 29);
        contentPane.add(taikhoan_text);
        taikhoan_text.setColumns(10);
        
        JLabel mk = new JLabel("Mật khẩu: ");
        mk.setForeground(SystemColor.window);
        mk.setFont(new Font("Arial", Font.BOLD, 20));
        mk.setBounds(217, 232, 115, 29);
        contentPane.add(mk);
        
        mk_text = new JPasswordField();
        mk_text.setBounds(217, 270, 232, 27);
        contentPane.add(mk_text);
        
        JButton Nut_Dangki = new JButton("Đăng kí");
        Nut_Dangki.setBackground(SystemColor.activeCaptionBorder);
        Nut_Dangki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewdangki dk = new viewdangki();
                dk.setVisible(true);
            }
        });
        
        Nut_Dangki.setFont(new Font("Arial", Font.BOLD, 17));
        Nut_Dangki.setBounds(217, 307, 103, 29);
        contentPane.add(Nut_Dangki);
        
        String drive = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mySQL://localhost:3306/qlktx";
        String user = "root";
        String pas = "";
        
        JButton Nut_Dangnhap = new JButton("Đăng nhập");
        Nut_Dangnhap.setBackground(SystemColor.activeCaptionBorder);
        Nut_Dangnhap.addActionListener(new ActionListener() {
            ResultSet rs;
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
                try {     
                    Connection c = DriverManager.getConnection(url, user, pas);
                    // Kiểm tra nếu không nhập dữ liệu tài khoản và mật khẩu
                    if (taikhoan_text.getText().isEmpty() || mk_text.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản và mật khẩu");
                        return;
                    }

                    String sql = "select * from dangnhap where (taikhoan=? or gmail=?) and matkhau=?";
                    PreparedStatement ps = c.prepareStatement(sql);

                    ps.setString(1, taikhoan_text.getText());
                    ps.setString(2, taikhoan_text.getText());
                    ps.setString(3, mk_text.getText());

                    rs = ps.executeQuery();

                    if (rs.next()) {
                    		JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                            dispose();
                            viewQLSV view = new viewQLSV();
                            view.setVisible(true);
                         
                    } else {
                        JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại tài khoản và mật khẩu");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập");
                }
            }
        });
        Nut_Dangnhap.setFont(new Font("Arial", Font.BOLD, 17));
        Nut_Dangnhap.setBounds(321, 307, 128, 29);
        contentPane.add(Nut_Dangnhap);
        
        JButton Nut_thoat = new JButton("");
        Nut_thoat.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152951.png"));
        Nut_thoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  System.exit(0);
            }
        });
        Nut_thoat.setBackground(SystemColor.activeCaptionBorder);
        Nut_thoat.setFont(new Font("Arial", Font.BOLD, 17));
        Nut_thoat.setBounds(374, 346, 79, 29);
        contentPane.add(Nut_thoat);
        
        JButton Nut_DoiMk = new JButton("Đổi mật khẩu");
        Nut_DoiMk.setBackground(SystemColor.activeCaptionBorder);
        Nut_DoiMk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                view_doimatkhau view = new view_doimatkhau();
                view.setVisible(true);
            }
        });
        Nut_DoiMk.setFont(new Font("Arial", Font.BOLD, 17));
        Nut_DoiMk.setBounds(217, 346, 147, 29);
        contentPane.add(Nut_DoiMk);
        
        JToggleButton Nut_hienMK = new JToggleButton("");
        Nut_hienMK.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 194914.png"));
        Nut_hienMK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 if (Nut_hienMK.isSelected()) {
                        mk_text.setEchoChar('\0');
                    } else {
                        mk_text.setEchoChar('*');
                    }
                
            }
        });
        Nut_hienMK.setFont(new Font("Arial", Font.BOLD, 18));
        Nut_hienMK.setBackground(Color.LIGHT_GRAY);
        Nut_hienMK.setForeground(Color.BLACK);
        Nut_hienMK.setBounds(387, 232, 53, 22);
        contentPane.add(Nut_hienMK);
        
        JLabel dangnhap_1 = new JLabel("");
        dangnhap_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 195222.png"));
        dangnhap_1.setFont(new Font("Arial", Font.BOLD, 27));
        dangnhap_1.setBounds(345, 39, 154, 114);
        contentPane.add(dangnhap_1);
        
        JLabel dangnhap_1_1 = new JLabel("");
        dangnhap_1_1.setIcon(new ImageIcon("D:\\C++ Tren lop\\chap7\\Screenshot 2023-12-06 202316.png"));
        dangnhap_1_1.setFont(new Font("Arial", Font.BOLD, 27));
        dangnhap_1_1.setBounds(172, 39, 184, 114);
        contentPane.add(dangnhap_1_1);
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        verticalBox.setBounds(170, 116, 329, 303);
        contentPane.add(verticalBox);
        
        JLabel dangnhap_1_2 = new JLabel("");
        verticalBox.add(dangnhap_1_2);
        dangnhap_1_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2024-01-19 124733.png"));
        dangnhap_1_2.setFont(new Font("Arial", Font.BOLD, 27));
        
        JLabel dangnhap_1_3 = new JLabel("");
        dangnhap_1_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2024-01-19 124542.png"));
        dangnhap_1_3.setFont(new Font("Arial", Font.BOLD, 27));
        dangnhap_1_3.setBounds(0, 0, 672, 531);
        contentPane.add(dangnhap_1_3);
    }  
}
