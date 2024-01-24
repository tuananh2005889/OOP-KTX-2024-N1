package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mail.Mail_teencode;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Color;

public class view_doimatkhau extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField gmail_text;
	private JTextField teencode_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_doimatkhau frame = new view_doimatkhau();
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
	public view_doimatkhau() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gmail_text = new JTextField();
		gmail_text.setBounds(240, 141, 238, 27);
		contentPane.add(gmail_text);
		gmail_text.setColumns(10);
		
		teencode_text = new JTextField();
		teencode_text.setColumns(10);
		teencode_text.setBounds(240, 180, 96, 27);
		contentPane.add(teencode_text);
		
		JButton Nut_xacnhan = new JButton("xác nhận");
		Nut_xacnhan.setFont(new Font("Tahoma", Font.BOLD, 20));
		Nut_xacnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    // Lấy mã xác nhận từ người dùng nhập vào
                String TC_danhap = teencode_text.getText().trim();

                // Lấy mã đã gửi từ lớp Mail_teencode
                String TC_dagui = Mail_teencode.laymaTeenCode();

                // Kiểm tra xem mã nhập vào có khớp với mã đã gửi hay không
                if (TC_danhap.equals(TC_dagui)) {
                    // Mã xác nhận đúng
                    JOptionPane.showMessageDialog(null, "Xác nhận thành công!");
                    //dispose();
                    view_doimatkhau2 view = new view_doimatkhau2();
                    view.setVisible(true);
                } else {
                    // Mã xác nhận không khớp
                    JOptionPane.showMessageDialog(null, "Mã xác nhận không đúng. Vui lòng thử lại!");
                }
			}
		});
		Nut_xacnhan.setBounds(333, 217, 145, 37);
		contentPane.add(Nut_xacnhan);
		
		JLabel gmail = new JLabel("Gmail:");
		gmail.setForeground(Color.WHITE);
		gmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		gmail.setBounds(119, 132, 101, 37);
		contentPane.add(gmail);
		
		JLabel Teencode = new JLabel("TeenCode:");
		Teencode.setForeground(Color.WHITE);
		Teencode.setFont(new Font("Tahoma", Font.BOLD, 20));
		Teencode.setBounds(119, 171, 159, 37);
		contentPane.add(Teencode);
		

		String DATABASE_URL = "jdbc:mysql://localhost:3306/qlktx";
	    String USER = "root";
	   	String PASSWORD = "";
   	
		JButton Nut_guiteencode = new JButton("Gửi TeenCode");
		Nut_guiteencode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c = DriverManager.getConnection(DATABASE_URL,USER, PASSWORD);
					ResultSet rs;
					if (gmail_text.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "vui lòng nhập gmail");
					}
					String sql = "select * from dangnhap where gmail=?";
					PreparedStatement ps = c.prepareStatement(sql);
					
					ps.setString(1, gmail_text.getText());
					rs = ps.executeQuery();
					
					if(rs.next()) {
						Mail_teencode.guiTeenCodequa_gmail(gmail_text.getText());
						JOptionPane.showMessageDialog(null, "gửi thành công đến " + gmail_text.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Gmail không tồn tại");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Nut_guiteencode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Nut_guiteencode.setBounds(346, 178, 132, 27);
		contentPane.add(Nut_guiteencode);
		
		JLabel gmail_1_1 = new JLabel("");
		gmail_1_1.setIcon(new ImageIcon("D:\\C++ Tren lop\\chap7\\Screenshot 2023-12-23 195222.png"));
		gmail_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		gmail_1_1.setBounds(319, 35, 159, 114);
		contentPane.add(gmail_1_1);
		
		JLabel gmail_1_1_2 = new JLabel("");
		gmail_1_1_2.setIcon(new ImageIcon("D:\\C++ Tren lop\\chap7\\Screenshot 2023-12-06 202316.png"));
		gmail_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		gmail_1_1_2.setBounds(119, 35, 195, 114);
		contentPane.add(gmail_1_1_2);
		
		JButton Nut_xacnhan_1 = new JButton("Quay lại");
		Nut_xacnhan_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				viewdangnhap view = new viewdangnhap();
				view.setVisible(true);
			}
		});
		Nut_xacnhan_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152951.png"));
		Nut_xacnhan_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		Nut_xacnhan_1.setBounds(177, 217, 159, 37);
		contentPane.add(Nut_xacnhan_1);
		
		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1_1.setBounds(93, 102, 423, 198);
		contentPane.add(verticalBox_1_1);
		
		JLabel gmail_1_1_1 = new JLabel("");
		verticalBox_1_1.add(gmail_1_1_1);
		gmail_1_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2024-01-19 124733.png"));
		gmail_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel gmail_1_1_1_1 = new JLabel("");
		gmail_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2024-01-19 131841.png"));
		gmail_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		gmail_1_1_1_1.setBounds(-30, -31, 780, 434);
		contentPane.add(gmail_1_1_1_1);
	}
	 public static JTextField layGmail() {
	        return gmail_text;
	    }
}
