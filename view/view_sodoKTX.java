package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.Box;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class view_sodoKTX extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_sodoKTX frame = new view_sodoKTX();
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
	public view_sodoKTX() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 643);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2023-12-20 155735.png"));
		lblNewLabel.setBounds(590, 36, 469, 177);
		contentPane.add(lblNewLabel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox.setBackground(Color.WHITE);
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(151, 62, 93, 209);
		contentPane.add(verticalBox);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1.setBackground(Color.WHITE);
		verticalBox_1.setBounds(305, 62, 93, 209);
		contentPane.add(verticalBox_1);
		
		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1_1.setBackground(Color.WHITE);
		verticalBox_1_1.setBounds(458, 62, 93, 209);
		contentPane.add(verticalBox_1_1);
		
		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_2.setBackground(SystemColor.inactiveCaptionText);
		verticalBox_2.setBounds(242, 91, 65, 22);
		contentPane.add(verticalBox_2);
		
		Box verticalBox_2_1 = Box.createVerticalBox();
		verticalBox_2_1.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_2_1.setBackground(SystemColor.inactiveCaptionText);
		verticalBox_2_1.setBounds(396, 91, 65, 22);
		contentPane.add(verticalBox_2_1);
		
		Box verticalBox_3 = Box.createVerticalBox();
		verticalBox_3.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_3.setBackground(Color.WHITE);
		verticalBox_3.setBounds(46, 62, 57, 209);
		contentPane.add(verticalBox_3);
		
		Box verticalBox_3_1 = Box.createVerticalBox();
		verticalBox_3_1.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_3_1.setBackground(Color.WHITE);
		verticalBox_3_1.setBounds(33, 62, 57, 209);
		contentPane.add(verticalBox_3_1);
		
		Box verticalBox_3_2_2 = Box.createVerticalBox();
		verticalBox_3_2_2.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_3_2_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_3_2_2.setBackground(SystemColor.inactiveCaptionText);
		verticalBox_3_2_2.setBounds(320, 338, 57, 108);
		contentPane.add(verticalBox_3_2_2);
		
		Box verticalBox_3_2_3 = Box.createVerticalBox();
		verticalBox_3_2_3.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_3_2_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_3_2_3.setBackground(SystemColor.inactiveCaptionText);
		verticalBox_3_2_3.setBounds(431, 350, 107, 75);
		contentPane.add(verticalBox_3_2_3);
		
		Box verticalBox_3_2_2_1 = Box.createVerticalBox();
		verticalBox_3_2_2_1.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_3_2_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_3_2_2_1.setBackground(SystemColor.inactiveCaptionText);
		verticalBox_3_2_2_1.setBounds(250, 338, 57, 108);
		contentPane.add(verticalBox_3_2_2_1);
		
		Box verticalBox_3_2_2_2 = Box.createVerticalBox();
		verticalBox_3_2_2_2.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_3_2_2_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_3_2_2_2.setBackground(SystemColor.inactiveCaptionText);
		verticalBox_3_2_2_2.setBounds(172, 338, 57, 108);
		contentPane.add(verticalBox_3_2_2_2);
		
		Box verticalBox_3_2_2_2_1 = Box.createVerticalBox();
		verticalBox_3_2_2_2_1.setFont(new Font("Dialog", Font.BOLD, 12));
		verticalBox_3_2_2_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_3_2_2_2_1.setBackground(Color.WHITE);
		verticalBox_3_2_2_2_1.setBounds(151, 322, 408, 156);
		contentPane.add(verticalBox_3_2_2_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("DÃY 1");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_1.setBounds(464, 18, 87, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DÃY 2");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(305, 18, 87, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("DÃY 3");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(151, 18, 87, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("NHÀ XE");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(33, 21, 87, 34);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("SAN BONGCHUYEN");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(195, 477, 183, 34);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("SAN BONG RO");
		lblNewLabel_1_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_1.setBounds(419, 477, 183, 34);
		contentPane.add(lblNewLabel_1_3_1_1);
		
		JButton Nut_quaylai = new JButton("QUAY LẠI");
		Nut_quaylai.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152803.png"));
		Nut_quaylai.setBackground(new Color(221, 160, 221));
		Nut_quaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				viewQLSV view = new viewQLSV();
				view.setVisible(true);
			}
		});
		Nut_quaylai.setFont(new Font("Arial", Font.BOLD, 22));
		Nut_quaylai.setBounds(854, 464, 193, 34);
		contentPane.add(Nut_quaylai);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("");
		lblNewLabel_1_3_1_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 154909.png"));
		lblNewLabel_1_3_1_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_2.setBounds(600, 200, 416, 209);
		contentPane.add(lblNewLabel_1_3_1_2);
		
		JLabel lblNewLabel_1_3_1_3 = new JLabel("");
		lblNewLabel_1_3_1_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 155135.png"));
		lblNewLabel_1_3_1_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_3.setBounds(242, 232, 183, 312);
		contentPane.add(lblNewLabel_1_3_1_3);
		
		JLabel lblNewLabel_1_3_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1_3_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 155135.png"));
		lblNewLabel_1_3_1_3_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_3_1.setBounds(161, 232, 183, 312);
		contentPane.add(lblNewLabel_1_3_1_3_1);
		
		JLabel lblNewLabel_1_3_1_3_2 = new JLabel("");
		lblNewLabel_1_3_1_3_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 155135.png"));
		lblNewLabel_1_3_1_3_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_3_2.setBounds(315, 232, 100, 312);
		contentPane.add(lblNewLabel_1_3_1_3_2);
		
		JLabel lblNewLabel_1_3_1_3_3 = new JLabel("");
		lblNewLabel_1_3_1_3_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 155345.png"));
		lblNewLabel_1_3_1_3_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_3_3.setBounds(441, 301, 183, 177);
		contentPane.add(lblNewLabel_1_3_1_3_3);
		
		JLabel lblNewLabel_1_3_1_3_4 = new JLabel("");
		lblNewLabel_1_3_1_3_4.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 155508.png"));
		lblNewLabel_1_3_1_3_4.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_3_4.setBounds(20, 105, 120, 123);
		contentPane.add(lblNewLabel_1_3_1_3_4);
		
		JLabel lblNewLabel_1_3_1_3_4_1 = new JLabel("");
		lblNewLabel_1_3_1_3_4_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2023-12-23 155625.png"));
		lblNewLabel_1_3_1_3_4_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_3_4_1.setBounds(151, 105, 107, 123);
		contentPane.add(lblNewLabel_1_3_1_3_4_1);
		
		JLabel lblNewLabel_1_3_1_3_4_1_1 = new JLabel("");
		lblNewLabel_1_3_1_3_4_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2023-12-23 155625.png"));
		lblNewLabel_1_3_1_3_4_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_3_4_1_1.setBounds(305, 105, 130, 123);
		contentPane.add(lblNewLabel_1_3_1_3_4_1_1);
		
		JLabel lblNewLabel_1_3_1_3_4_1_1_1 = new JLabel("");
		lblNewLabel_1_3_1_3_4_1_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2023-12-23 155949.png"));
		lblNewLabel_1_3_1_3_4_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_3_4_1_1_1.setBounds(472, 116, 130, 123);
		contentPane.add(lblNewLabel_1_3_1_3_4_1_1_1);
		
		JLabel lblNewLabel_1_3_1_3_4_1_1_1_1 = new JLabel("");
		lblNewLabel_1_3_1_3_4_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2024-01-19 131841.png"));
		lblNewLabel_1_3_1_3_4_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_3_4_1_1_1_1.setBounds(0, -113, 1096, 767);
		contentPane.add(lblNewLabel_1_3_1_3_4_1_1_1_1);
		
		JLabel lblNewLabel_1_3_1_2_1 = new JLabel("");
		lblNewLabel_1_3_1_2_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2024-01-19 132245.png"));
		lblNewLabel_1_3_1_2_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_3_1_2_1.setBounds(-107, 264, 416, 209);
		contentPane.add(lblNewLabel_1_3_1_2_1);
	}
}
