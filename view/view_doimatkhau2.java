package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class view_doimatkhau2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nhapMK_text;
    private JTextField NhaplaiMK_text;
	private JRadioButton ok;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    view_doimatkhau2 frame = new view_doimatkhau2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public view_doimatkhau2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 245);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nhapMK = new JLabel("Mật khẩu mới:");
        nhapMK.setFont(new Font("Tahoma", Font.BOLD, 15));
        nhapMK.setBounds(37, 41, 131, 25);
        contentPane.add(nhapMK);

        JLabel NhaplaiMk = new JLabel("Nhập lại mật khẩu:");
        NhaplaiMk.setFont(new Font("Tahoma", Font.BOLD, 15));
        NhaplaiMk.setBounds(37, 84, 155, 25);
        contentPane.add(NhaplaiMk);

        nhapMK_text = new JTextField();
        nhapMK_text.setBounds(199, 44, 131, 24);
        contentPane.add(nhapMK_text);
        nhapMK_text.setColumns(10);

        NhaplaiMK_text = new JTextField();
        NhaplaiMK_text.setColumns(10);
        NhaplaiMK_text.setBounds(199, 85, 131, 24);
        contentPane.add(NhaplaiMK_text);

        String drive = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/qlktx"; // Thay đổi URL kết nối MySQL của bạn
        String user = "root";
        String pas = "";

        JButton btnNewButton = new JButton("Xác nhận");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection(url, user, pas);
                
                    String gmail = view_doimatkhau.gmail_text.getText();
                    // Kiểm tra Gmail
                    if (gmail == null || gmail.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập Gmail");
                        return;
                    }

                    String sql = "UPDATE dangnhap SET matkhau=? WHERE gmail=?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, nhapMK_text.getText());
                    ps.setString(2, gmail);

                    int thaydoi = ps.executeUpdate();

                    String MK = nhapMK_text.getText();
                    String NhapLai_MK = NhaplaiMK_text.getText();

                    if (thaydoi > 0) {
                        if (MK.equals(NhapLai_MK)) {
                        	if(ok.isSelected()) {
                        		
                        	
                            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
                            setVisible(false); // Ẩn frame thay vì thoát chương trình
                        } else {
                        	JOptionPane.showMessageDialog(null, "vui long chon test");
                        }
                        } else {
                            JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setBounds(325, 146, 131, 36);
        contentPane.add(btnNewButton);
        
        ok = new JRadioButton("test");
        ok.setBounds(76, 156, 103, 21);
        contentPane.add(ok);
    }
}
