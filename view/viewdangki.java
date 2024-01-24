package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class viewdangki extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField TK_text;
    private JTextField Gmail_text;
    private JPasswordField mk_text;
    private JPasswordField nhaplaiMk_text;

    // Database connection details
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/qlktx";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	viewdangki frame = new viewdangki();
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
    public viewdangki() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2023-12-06 202316.png"));
        setTitle("Kí túc xá -VKU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 675, 690);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel taikhoan = new JLabel("Tài khoản: ");
        taikhoan.setForeground(SystemColor.window);
        taikhoan.setBackground(SystemColor.window);
        taikhoan.setFont(new Font("Arial", Font.BOLD, 20));
        taikhoan.setBounds(199, 190, 123, 35);
        contentPane.add(taikhoan);

        JLabel matkhau = new JLabel("Mật khẩu: ");
        matkhau.setForeground(SystemColor.textHighlightText);
        matkhau.setFont(new Font("Arial", Font.BOLD, 20));
        matkhau.setBounds(200, 329, 144, 35);
        contentPane.add(matkhau);

        TK_text = new JTextField();
        TK_text.setBounds(200, 232, 253, 31);
        contentPane.add(TK_text);
        TK_text.setColumns(10);

        String drive = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/qlktx";
        String user = "root";
        String pas = "";
        PreparedStatement st;
        ResultSet rs;

        JButton Nut_DK = new JButton("Đăng kí");
        Nut_DK.setBackground(SystemColor.activeCaption);
        Nut_DK.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
                int DK = JOptionPane.showConfirmDialog(null, "Đăng kí tài khoản", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (DK != JOptionPane.YES_OPTION) {
                    return;
                }

                try {
                    Class.forName(drive);
                    Connection c = DriverManager.getConnection(url, user, pas);

                    // Kiểm tra dữ liệu nhập
                    String TK = TK_text.getText();
                    String Gmail = Gmail_text.getText();
                    String mk = mk_text.getText();
                    String nhaplaiMk = nhaplaiMk_text.getText();

                    if (TK.equals("") || Gmail.equals("") || mk.equals("") || nhaplaiMk.equals("")) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                        return;
                    }

                    // Kiểm tra xác nhận mật khẩu
                    if (!mk.equals(nhaplaiMk)) {
                        JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu không trùng khớp");
                        return;
                    }

                    // Kiểm tra định dạng Gmail
                    if (!isValidGmail(Gmail)) {
                        JOptionPane.showMessageDialog(null, "Gmail không hợp lệ");
                        return;
                    }

                    String sql = "INSERT INTO dangnhap VALUES (?, ?, ?)";
                    PreparedStatement st = c.prepareStatement(sql);
                    st.setString(1, TK);
                    st.setString(2, Gmail);
                    st.setString(3, mk);

                    // Update dữ liệu
                    int n = st.executeUpdate();

                    if (n != 0) {
                        JOptionPane.showMessageDialog(null, "Đăng kí thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Đăng kí thất bại");
                    }

                } catch (SQLException | ClassNotFoundException e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Đăng kí thất bại. Mã lỗi: " + e2.getMessage());
                }
            }
        });
        Nut_DK.setFont(new Font("Arial", Font.BOLD, 18));
        Nut_DK.setBounds(200, 493, 103, 35);
        contentPane.add(Nut_DK);

        JButton Nut_dangnhap = new JButton("Quay lại");
        Nut_dangnhap.setBackground(SystemColor.activeCaption);
        Nut_dangnhap.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152803.png"));
        Nut_dangnhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewdangnhap dn = new viewdangnhap();
                dn.setVisible(true);
            }
        });
        Nut_dangnhap.setFont(new Font("Arial", Font.BOLD, 18));
        Nut_dangnhap.setBounds(313, 493, 146, 35);
        contentPane.add(Nut_dangnhap);

        JLabel nhaplaimk = new JLabel("Nhập lại mật khẩu: ");
        nhaplaimk.setForeground(SystemColor.textHighlightText);
        nhaplaimk.setFont(new Font("Arial", Font.BOLD, 20));
        nhaplaimk.setBounds(200, 399, 187, 60);
        contentPane.add(nhaplaimk);

        JLabel Gmail = new JLabel("Gmail:");
        Gmail.setForeground(SystemColor.window);
        Gmail.setFont(new Font("Arial", Font.BOLD, 20));
        Gmail.setBounds(200, 260, 144, 42);
        contentPane.add(Gmail);

        Gmail_text = new JTextField();
        Gmail_text.setColumns(10);
        Gmail_text.setBounds(200, 302, 253, 31);
        contentPane.add(Gmail_text);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(402, 213, 60, 35);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(402, 217, 60, 35);
        contentPane.add(lblNewLabel_2);

        mk_text = new JPasswordField();
        mk_text.setBounds(200, 374, 253, 31);
        contentPane.add(mk_text);

        nhaplaiMk_text = new JPasswordField();
        nhaplaiMk_text.setBounds(200, 452, 253, 31);
        contentPane.add(nhaplaiMk_text);

        JToggleButton Nut_hienMK = new JToggleButton("");
        Nut_hienMK.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 194914.png"));
        Nut_hienMK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Nut_hienMK.isSelected()) {
                    mk_text.setEchoChar('\0');
                    nhaplaiMk_text.setEchoChar('\0');
                } else {
                    mk_text.setEchoChar('*');
                    nhaplaiMk_text.setEchoChar('*');
                }
            }
        });
        Nut_hienMK.setFont(new Font("Arial", Font.BOLD, 16));
        Nut_hienMK.setBackground(Color.LIGHT_GRAY);
        Nut_hienMK.setBounds(393, 343, 60, 21);
        contentPane.add(Nut_hienMK);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(SystemColor.activeCaption);
        lblNewLabel.setIcon(new ImageIcon("D:\\C++ Tren lop\\chap7\\Screenshot 2023-12-23 195222.png"));
        lblNewLabel.setBounds(343, 55, 174, 170);
        contentPane.add(lblNewLabel);

        Box verticalBox_2 = Box.createVerticalBox();
        verticalBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        verticalBox_2.setBackground(SystemColor.inactiveCaptionText);
        verticalBox_2.setBounds(176, 115, 233, 0);
        contentPane.add(verticalBox_2);

        Box verticalBox_2_1_1 = Box.createVerticalBox();
        verticalBox_2_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        verticalBox_2_1_1.setBackground(SystemColor.inactiveCaptionText);
        verticalBox_2_1_1.setBounds(485, 114, 225, 0);
        contentPane.add(verticalBox_2_1_1);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(153, 70, 277, 137);
        contentPane.add(lblNewLabel_6);
        lblNewLabel_6.setIcon(new ImageIcon("D:\\C++ Tren lop\\chap7\\Screenshot 2023-12-06 202316.png"));
        lblNewLabel_6.setBackground(SystemColor.activeCaption);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBackground(SystemColor.windowText);
        verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        verticalBox.setBounds(153, 167, 336, 393);
        contentPane.add(verticalBox);

        JLabel lblNewLabel_3 = new JLabel("");
        verticalBox.add(lblNewLabel_3);
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2024-01-19 131405.png"));
        lblNewLabel_3.setBackground(SystemColor.activeCaption);

        JLabel lblNewLabel_3_1 = new JLabel("");
        lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2024-01-19 131446.png"));
        lblNewLabel_3_1.setBackground(SystemColor.activeCaption);
        lblNewLabel_3_1.setBounds(0, 0, 661, 653);
        contentPane.add(lblNewLabel_3_1);
    }

 // Kiểm tra định dạng Gmail
    private boolean isValidGmail(String gmail) {
        // Định dạng Gmail hợp lệ: user@gmail.com
        String gmailRegex = ".*@gmail\\.com$";
        return gmail.matches(gmailRegex);
    }

}
