package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.Action;
import javax.swing.Box;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.mysql.cj.jdbc.JdbcConnection;

import controller.QLKTX_control_SV;
import model.QLKTX_model;
import model.SinhVien;

import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Rectangle;
import java.awt.Canvas;
import javax.swing.JCheckBox;
import java.awt.ScrollPane;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.Component;
import java.awt.Choice;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import com.toedter.calendar.JDateChooser;

public class viewQLSV extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField hotentext;
	public JLabel TieuDe;
	public JTable table;
	public JTextField Loptext;
	public JTextField MaSVtext;
	public JTextField MaSVcantim_text;
	public ButtonGroup chonGioiTinh;
	public JComboBox ChonDay_text;
	private JComboBox ChonDay_Jbox;
	public JComboBox ChonPhong_text;
	private JComboBox soPhong_Jbox;
	public QLKTX_model model;
	public JComboBox SoNguoi_text;
	private JComboBox SoNguoi_Jbox;
	private JRadioButton Nut_Nam;
	private JRadioButton Nut_nu;
	private JButton Nut_luu;
	private JButton Nut_dangxuat;
	private JButton nut_them;
	private JButton Nut_hienthiALL;
	private JButton Nut_Xoa;
	private JComboBox comboBox;
	private JComboBox sophongtim_Jbox;
	private JComboBox thanhtoan_Jcombo;
	private JButton Nut_in;
	private JDateChooser dateChooser_NgaySinh;
	private JDateChooser dateChooser_NgayDK;
	private JDateChooser dateChooser_NgayHH;
	private JButton Nut_Sua;
	private JComboBox Timtheoday_JCombo;
	private JLabel soPhongTim_1;
	private JLabel TieuDe_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewQLSV frame = new viewQLSV();
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
	
	@SuppressWarnings("rawtypes")
	public viewQLSV() {
		setRootPaneCheckingEnabled(false);
		setBounds(new Rectangle(6, 0, 0, 0));
		setAlwaysOnTop(true);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setForeground(Color.DARK_GRAY);
		setBounds(1, 1, 1450, 712);
		Action a = new QLKTX_control_SV(this);

		
		
		setTitle("Kí Túc Xá - VKU");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2023-12-06 202316.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 750);
		setLocationRelativeTo(null);
		contentPane =  new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hoten = new JLabel("Họ và tên: ");
		hoten.setForeground(new Color(255, 255, 255));
		hoten.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		hoten.setToolTipText("");
		hoten.setBounds(20, 190, 129, 47);
		contentPane.add(hoten);
		
		hotentext = new JTextField();
		hotentext.setBounds(121, 203, 164, 27);
		contentPane.add(hotentext);
		hotentext.setColumns(10);
		
		table = new JTable();
		table.setBackground(UIManager.getColor("Button.light"));
		table.setForeground(Color.BLACK);
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn SV", "Ng\u00E0y Sinh", "Gi\u1EDBi t\u00EDnh", "L\u1EDBp", "M\u00E3 SV", "D\u00E3y", "S\u1ED1 l\u01B0\u1EE3ng", "S\u1ED1 ph\u00F2ng", "Ng\u00E0y d\u0103ng k\u00ED", "Ng\u00E0y h\u1EBFt h\u1EA1n", "Thanh to\u00E1n","test"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(33);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(123);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(61);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(43);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(53);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(53);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.getColumnModel().getColumn(8).setPreferredWidth(55);
		table.getColumnModel().getColumn(9).setResizable(false);
		table.getColumnModel().getColumn(10).setResizable(false);
		
		table.addMouseListener(new MouseAdapter() {
			public int r;

			@Override
			public void mouseClicked(MouseEvent e) {
				r= table.getSelectedRow();
				if(r!=-1) {
					hotentext.setText(table.getValueAt(r, 1)+"");
					 Date ngaySinhDate = null;
			            try {
			                ngaySinhDate = new SimpleDateFormat("dd-MM-yyyy").parse(table.getValueAt(r, 2) + "");
			            } catch (ParseException ex) {
			                ex.printStackTrace();
			            }
			         
			        dateChooser_NgaySinh.setDate(ngaySinhDate);
					
					String gt=table.getValueAt(r, 3)+"";
					Nut_Nam.setSelected(gt.equals("Nam"));
					Nut_nu.setSelected(gt.equals("Nữ"));
					
					Loptext.setText(table.getValueAt(r, 4)+"");
					MaSVtext.setText(table.getValueAt(r, 5)+"");
					int z = ChonDay_Jbox.getSelectedIndex()-1;
					ChonDay_Jbox.setSelectedItem(table.getValueAt(r, 6)+"");
					int x = SoNguoi_Jbox.getSelectedIndex()-1;
					SoNguoi_Jbox.setSelectedItem(table.getValueAt(r, 7));
					int i = soPhong_Jbox.getSelectedIndex()-1;
					soPhong_Jbox.setSelectedItem(table.getValueAt(r, 8)+"");
	
					Date ngayDKDate = null;
					Date ngayHHDate = null;
		            try {
		            	ngayDKDate = new SimpleDateFormat("dd-MM-yyyy").parse(table.getValueAt(r, 9) + "");
		            } catch (ParseException ex) {
		                ex.printStackTrace();
		            }    
		            dateChooser_NgayDK.setDate(ngayDKDate);
		            try {
		            	ngayHHDate = new SimpleDateFormat("dd-MM-yyyy").parse(table.getValueAt(r, 10) + "");
		            } catch (ParseException ex) {
		                ex.printStackTrace();
		            }
		            dateChooser_NgayHH.setDate(ngayHHDate);
					int a = thanhtoan_Jcombo.getSelectedIndex()-1;
					thanhtoan_Jcombo.setSelectedItem(table.getValueAt(r, 11)+"");
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(558, 133, 855, 406);
		contentPane.add(scrollPane);
		
		JLabel NgaySinh = new JLabel("Ngày sinh: ");
		NgaySinh.setForeground(new Color(255, 255, 255));
		NgaySinh.setToolTipText("");
		NgaySinh.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		NgaySinh.setBounds(20, 238, 129, 31);
		contentPane.add(NgaySinh);
		
		JLabel GioiTinh = new JLabel("Giới tính: ");
		GioiTinh.setForeground(new Color(255, 255, 255));
		GioiTinh.setToolTipText("");
		GioiTinh.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		GioiTinh.setBounds(20, 269, 88, 47);
		contentPane.add(GioiTinh);
		
		JLabel lop = new JLabel("Lớp:");
		lop.setForeground(new Color(255, 255, 255));
		lop.setToolTipText("");
		lop.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lop.setBounds(20, 308, 76, 59);
		contentPane.add(lop);
		
		Loptext = new JTextField();
		Loptext.setColumns(10);
		Loptext.setBounds(121, 316, 104, 27);
		contentPane.add(Loptext);
		
		JLabel MaSV = new JLabel("Mã SV:");
		MaSV.setForeground(new Color(255, 255, 255));
		MaSV.setToolTipText("");
		MaSV.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		MaSV.setBounds(20, 346, 129, 47);
		contentPane.add(MaSV);
		
		MaSVtext = new JTextField();
		MaSVtext.setColumns(10);
		MaSVtext.setBounds(121, 353, 104, 27);
		contentPane.add(MaSVtext);
		
		JLabel Day = new JLabel("Dãy:");
		Day.setForeground(new Color(255, 255, 255));
		Day.setToolTipText("");
		Day.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		Day.setBounds(310, 184, 76, 59);
		contentPane.add(Day);
		
		JLabel SoPhong = new JLabel("Số phòng:");
		SoPhong.setForeground(new Color(255, 255, 255));
		SoPhong.setToolTipText("");
		SoPhong.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		SoPhong.setBounds(310, 269, 93, 47);
		contentPane.add(SoPhong);
		
		JLabel NgayDangKi = new JLabel("Ngày ĐK:");
		NgayDangKi.setForeground(new Color(255, 255, 255));
		NgayDangKi.setToolTipText("");
		NgayDangKi.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		NgayDangKi.setBounds(310, 308, 93, 47);
		contentPane.add(NgayDangKi);
		
		JLabel NgayHetHan = new JLabel("Ngày HH:");
		NgayHetHan.setForeground(new Color(255, 255, 255));
		NgayHetHan.setToolTipText("");
		NgayHetHan.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		NgayHetHan.setBounds(310, 346, 129, 47);
		contentPane.add(NgayHetHan);
		
		nut_them = new JButton("Thêm SV");
		nut_them.setForeground(Color.WHITE);
		nut_them.setHorizontalAlignment(SwingConstants.LEFT);
		nut_them.setIcon(new ImageIcon("D:\\luutru_JAVA\\QLCB\\src\\Test\\Screenshot 2023-12-23 150032.png"));
		nut_them.setBackground(new Color(0, 0, 0));
		nut_them.addActionListener(a);
		nut_them.setFont(new Font("Tahoma", Font.BOLD, 17));
		nut_them.setBounds(0, 648, 164, 65);
		contentPane.add(nut_them);
		
		Nut_Xoa = new JButton("Xóa");
		Nut_Xoa.setForeground(Color.WHITE);
		Nut_Xoa.setHorizontalAlignment(SwingConstants.LEFT);
		Nut_Xoa.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 150953.png"));
		Nut_Xoa.setBackground(new Color(0, 0, 0));
		Nut_Xoa.addActionListener(a);
		Nut_Xoa.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nut_Xoa.setBounds(158, 648, 138, 65);
		contentPane.add(Nut_Xoa);
		
		JLabel MaSV_timkiem = new JLabel("Mã SV cần tìm:");
		MaSV_timkiem.setForeground(Color.CYAN);
		MaSV_timkiem.setToolTipText("");
		MaSV_timkiem.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		MaSV_timkiem.setBounds(20, 465, 129, 37);
		contentPane.add(MaSV_timkiem);
		
		MaSVcantim_text = new JTextField();
		MaSVcantim_text.setColumns(10);
		MaSVcantim_text.setBounds(158, 473, 107, 27);
		contentPane.add(MaSVcantim_text);
		MaSVcantim_text.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
		    public void insertUpdate(DocumentEvent e) {	      
		        timkiemSV();
		    }
		    public void removeUpdate(DocumentEvent e) {
		        timkiemSV();
		    }

		    public void changedUpdate(DocumentEvent e) {
		       
		    }
		});
		
		ChonDay_text = new JComboBox();
		ChonDay_Jbox = new JComboBox<>(new String[]{"","1 - Nữ", "2 - Nam", "3 - Nam"});
		ChonDay_Jbox.setBounds(409, 203, 70, 27);
		contentPane.add(ChonDay_Jbox);
		
		ChonPhong_text = new JComboBox();
		soPhong_Jbox = new JComboBox<>(SoPhong());
		soPhong_Jbox.setBounds(409, 282, 64, 27);
		contentPane.add(soPhong_Jbox);
		
		
		
		Nut_Nam = new JRadioButton("Nam");
		Nut_Nam.setBackground(SystemColor.controlHighlight);
		Nut_Nam.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Nut_Nam.setBounds(121, 281, 70, 21);
		contentPane.add(Nut_Nam);
		
		Nut_nu = new JRadioButton("Nữ");
		Nut_nu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Nut_nu.setBackground(SystemColor.controlHighlight);
		Nut_nu.setBounds(191, 281, 70, 21);
		contentPane.add(Nut_nu);
		
		chonGioiTinh = new ButtonGroup();
		chonGioiTinh.add(Nut_Nam);
		chonGioiTinh.add(Nut_nu);
		
		Nut_luu = new JButton("Lưu");
		Nut_luu.setForeground(Color.WHITE);
		Nut_luu.setHorizontalAlignment(SwingConstants.LEFT);
		Nut_luu.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 151959.png"));
		Nut_luu.setBackground(new Color(0, 0, 0));
		Nut_luu.addActionListener(a);
		Nut_luu.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nut_luu.setBounds(294, 648, 145, 65);
		contentPane.add(Nut_luu);
		
		Nut_dangxuat = new JButton("Đăng xuất");
		Nut_dangxuat.setForeground(Color.BLACK);
		Nut_dangxuat.setHorizontalAlignment(SwingConstants.LEFT);
		Nut_dangxuat.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152951.png"));
		Nut_dangxuat.setBackground(Color.ORANGE);
		Nut_dangxuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				viewdangnhap dn = new viewdangnhap();
				dn.setVisible(true);
				JOptionPane.showMessageDialog(null, "Đăng xuất thành công");
			}
			
			
		});
		Nut_dangxuat.addActionListener(a);
		Nut_dangxuat.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nut_dangxuat.setBounds(1229, 648, 207, 65);
		contentPane.add(Nut_dangxuat);
		
		JLabel SoNguoi = new JLabel("Số người:");
		SoNguoi.setForeground(new Color(255, 255, 255));
		SoNguoi.setToolTipText("");
		SoNguoi.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		SoNguoi.setBounds(310, 230, 83, 47);
		contentPane.add(SoNguoi);
		
		SoNguoi_text = new JComboBox();
		SoNguoi_Jbox = new JComboBox<>(new String[]{"","4", "6", "8"});
		SoNguoi_Jbox.setBounds(409, 243, 64, 27);
		contentPane.add(SoNguoi_Jbox);
		
		JButton Nut_SoDoKTX = new JButton("Sơ đồ KTX");
		Nut_SoDoKTX.setForeground(Color.WHITE);
		Nut_SoDoKTX.setHorizontalAlignment(SwingConstants.LEFT);
		Nut_SoDoKTX.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152200.png"));
		Nut_SoDoKTX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				view_sodoKTX ktx = new view_sodoKTX();
				ktx.setVisible(true);
			}
		});
		Nut_SoDoKTX.setBackground(new Color(0, 0, 0));
		Nut_SoDoKTX.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nut_SoDoKTX.setBounds(676, 648, 190, 65);
		contentPane.add(Nut_SoDoKTX);
		
		
		
		Nut_hienthiALL = new JButton("Hiển thị ALL SV");
		Nut_hienthiALL.setForeground(Color.WHITE);
		Nut_hienthiALL.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 153821.png"));
		Nut_hienthiALL.addActionListener(a);
		Nut_hienthiALL.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nut_hienthiALL.setBackground(new Color(0, 0, 0));
		Nut_hienthiALL.setBounds(438, 648, 244, 65);
		contentPane.add(Nut_hienthiALL);
		
		Nut_Sua = new JButton("Thay đổi");
		Nut_Sua.setForeground(Color.WHITE);
		Nut_Sua.setHorizontalAlignment(SwingConstants.LEFT);
		Nut_Sua.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152420.png"));
		Nut_Sua.addActionListener(a);
		Nut_Sua.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nut_Sua.setBackground(new Color(0, 0, 0));
		Nut_Sua.setBounds(862, 648, 164, 65);
		contentPane.add(Nut_Sua);
		
		TieuDe = new JLabel("");
		TieuDe.setBounds(723, 10, 600, 83);
		contentPane.add(TieuDe);
		TieuDe.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\images (1).jpg"));
		TieuDe.setFont(new Font("Segoe UI Black", Font.PLAIN, 32));
		TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel soPhongTim = new JLabel("Số phòng tìm:");
		soPhongTim.setForeground(Color.CYAN);
		soPhongTim.setToolTipText("");
		soPhongTim.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		soPhongTim.setBounds(294, 454, 132, 59);
		contentPane.add(soPhongTim);
		
		sophongtim_Jbox = new JComboBox();
		sophongtim_Jbox = new JComboBox<>(SoPhong());
		sophongtim_Jbox.setBounds(424, 472, 69, 29);
		contentPane.add(sophongtim_Jbox);
		sophongtim_Jbox.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            timkiemSV();
		        }
		    }
		});

		
		JLabel lblNewLabel_1 = new JLabel("NHAP THONG TIN");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Freestyle Script", Font.BOLD, 68));
		lblNewLabel_1.setBounds(56, 37, 499, 82);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SINH VIÊN");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 153215.png"));
		lblNewLabel_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 27));
		lblNewLabel_1_1.setBounds(51, 133, 234, 47);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PHÒNG");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 153656.png"));
		lblNewLabel_1_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 27));
		lblNewLabel_1_1_1.setBounds(334, 125, 177, 49);
		contentPane.add(lblNewLabel_1_1_1);
		
		thanhtoan_Jcombo = new JComboBox();
		thanhtoan_Jcombo = new JComboBox<>(new String[]{"","Chưa thanh toán","Đã thanh toán"});
		thanhtoan_Jcombo.setBounds(123, 390, 114, 27);
		contentPane.add(thanhtoan_Jcombo);
		
		JLabel lblThanhTon = new JLabel("thanh toán:");
		lblThanhTon.setForeground(new Color(255, 255, 255));
		lblThanhTon.setToolTipText("");
		lblThanhTon.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblThanhTon.setBounds(20, 377, 129, 47);
		contentPane.add(lblThanhTon);
		
		Nut_in = new JButton("Tạo file excel");
		Nut_in.setForeground(Color.WHITE);
		Nut_in.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2024-01-06 162354.png"));
		Nut_in.addActionListener(a);
		Nut_in.setHorizontalAlignment(SwingConstants.LEFT);
		Nut_in.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nut_in.setBackground(new Color(0, 0, 0));
		Nut_in.setBounds(1021, 648, 212, 65);
		contentPane.add(Nut_in);
		
		Box verticalBox_1_1 = Box.createVerticalBox();
		verticalBox_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1_1.setBounds(294, 190, 254, 265);
		contentPane.add(verticalBox_1_1);
		
		Box verticalBox_1_1_1 = Box.createVerticalBox();
		verticalBox_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1_1_1.setBounds(0, 190, 295, 265);
		contentPane.add(verticalBox_1_1_1);
		
		dateChooser_NgaySinh = new JDateChooser();
		dateChooser_NgaySinh.setBounds(121, 241, 164, 28);
		contentPane.add(dateChooser_NgaySinh);
		
		dateChooser_NgayDK = new JDateChooser();
		dateChooser_NgayDK.setBounds(409, 316, 130, 27);
		contentPane.add(dateChooser_NgayDK);
		
		dateChooser_NgayHH = new JDateChooser();
		dateChooser_NgayHH.setBounds(409, 353, 130, 27);
		contentPane.add(dateChooser_NgayHH);
		
		Timtheoday_JCombo = new JComboBox();
		Timtheoday_JCombo = new JComboBox<>(new String[]{"","1 - Nữ", "2 - Nam", "3 - Nam"});
		Timtheoday_JCombo.setBounds(424, 511, 70, 27);
		contentPane.add(Timtheoday_JCombo);
		
		soPhongTim_1 = new JLabel("Số dãy tìm:");
		soPhongTim_1.setToolTipText("");
		soPhongTim_1.setForeground(Color.CYAN);
		soPhongTim_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		soPhongTim_1.setBounds(294, 494, 132, 59);
		contentPane.add(soPhongTim_1);
		
		TieuDe_1 = new JLabel("");
		TieuDe_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\Screenshots\\Screenshot 2024-01-19 131841.png"));
		TieuDe_1.setHorizontalAlignment(SwingConstants.CENTER);
		TieuDe_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 32));
		TieuDe_1.setBounds(0, 0, 1436, 713);
		contentPane.add(TieuDe_1);
		Timtheoday_JCombo.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            timkiemSV();
		        }
		    }
		});
	}

	private String[] SoPhong() {
        String[] sophong = new String[151];
        sophong[0] = "";
        int cong = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 30; j++) {
            	sophong[cong++] = String.format("%d%02d", i, j);
            }
        }
        return sophong;
    }

	public void XoaForm() {
		hotentext.setText("");
		dateChooser_NgaySinh.setDate(null);
		chonGioiTinh.clearSelection();
		Loptext.setText("");
		MaSVtext.setText("");
		ChonDay_Jbox.setSelectedIndex(-1);
		SoNguoi_Jbox.setSelectedIndex(-1);
		soPhong_Jbox.setSelectedIndex(-1);
		dateChooser_NgayDK.setDate(null);
		dateChooser_NgayHH.setDate(null);
		thanhtoan_Jcombo.setSelectedIndex(-1);
		
	}

	public void themSV(SinhVien svien) {
	    String d = ChonDay_Jbox.getSelectedItem() + "";
	    int dayNha = (d != null) ? ChonDay_Jbox.getSelectedIndex() : 0;

	    String sl = SoNguoi_Jbox.getSelectedItem() + "";
	    int soLuong = (sl != null) ? Integer.parseInt(sl) : 0;

	    String sp = soPhong_Jbox.getSelectedItem() + "";
	    int soPhong = (sp != null) ? Integer.parseInt(sp) : 0;

	    Date NgaySinh = dateChooser_NgaySinh.getDate();
	    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	    String ngaySinhFormatted = (NgaySinh != null) ? sdf1.format(NgaySinh) : "N/A";
	    
	    Date DangKi = dateChooser_NgaySinh.getDate();
	    SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
	    String ngayDKFormatted = (DangKi != null) ? sdf2.format(DangKi) : "N/A";
	    
	    Date HetHan = dateChooser_NgaySinh.getDate();
	    SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy");
	    String ngayHHFormatted = (HetHan != null) ? sdf3.format(HetHan) : "N/A";
	    
	    boolean gt = Nut_Nam.isSelected();

	    if (dayNha < 0) dayNha = 0;
	    if (soLuong < 0) soLuong = 0;
	    if (soPhong < 0) soPhong = 0;
	    svien.setNgaySinh(ngaySinhFormatted);
	    svien.setDaynha(d);
	    svien.setSoLuong(sl);
	    svien.setSoPhong(sp);
	    svien.setGioiTinh(gt);
	    svien.setNgayDangKi(ngayDKFormatted);
	    svien.setNgayHetHan(ngayHHFormatted);

	    try {
	        // Kết nối cơ sở dữ liệu
	        Connection connection = connectToDatabase();
	        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	        // Kiểm tra mã sinh viên trùng
	        String checkSql = "SELECT * FROM sinhvien WHERE maSv = ?";
	        try (PreparedStatement pre = connection.prepareStatement(checkSql)) {
	        	pre.setString(1, svien.getMaSV());
	            try (ResultSet re = pre.executeQuery()) {
	           
	            	if (re.next()) {
	            			JOptionPane.showMessageDialog(this, "Sinh viên với mã " + svien.getMaSV() + " đã tồn tại!");
	                } else {
	                	//check số người theo sơ đồ ktx đã để
	                	if((soLuong == 4 && soPhong >= 501 && soPhong <= 530) 
	                			|| (soLuong == 6 && soPhong >= 301 && soPhong <= 430) 
	                			|| (soLuong == 8 && soPhong >= 101 && soPhong <= 230)) { 
	                    // Kiểm tra giới tính và dãy
	                    if ((svien.isGioiTinh() && dayNha == 1) || (!svien.isGioiTinh() && dayNha != 1)) {
	                        // Nếu là Nữ thì chỉ được ở dãy 1, ngược lại Nam chỉ được ở dãy 2,3
	                        JOptionPane.showMessageDialog(this, svien.isGioiTinh() ? "Dãy 1 chỉ có Nữ mới được ở" : "Dãy 2 và 3 chỉ có Nam mới được ở");
	                    } else {
	                        // Kiểm tra số lượng người trong phòng trước khi thêm mới
	                        if (kiemTraPhongDu(connection, svien.getSoPhong(), soLuong, svien.isGioiTinh(), svien.getDaynha())) {
	                            // Thêm sinh viên vào cơ sở dữ liệu và bảng
	                            themSinhVienVaoDatabase(connection, svien);
	                        } else {
	                            JOptionPane.showMessageDialog(this, "Phòng " + svien.getSoPhong() + " của dãy " + svien.getDaynha() + " đã đủ người!");
	                        }
	                    }
	                	}else {
	                		JOptionPane.showMessageDialog(this, "vui lòng xem lại sơ đồ KTX để nắm rõ!");
	                	}
	                }
	             } 
	          }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private void themSinhVienVaoDatabase(Connection connection, SinhVien svien) throws SQLException {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    
	    // Lấy ngày sinh từ JDateChooser và định dạng theo chuẩn yyyy-MM-dd
	    Date ngaySinhDate = dateChooser_NgaySinh.getDate();
	    String ngaySinhFormatted = (ngaySinhDate != null) ? sdf.format(ngaySinhDate) : "N/A";
	    Date ngayDK = dateChooser_NgayDK.getDate();
	    String ngayDKFormatted = (ngayDK != null) ? sdf.format(ngayDK) : "N/A";
	    Date ngayHH = dateChooser_NgayHH.getDate();
	    String ngayHHFormatted = (ngayHH != null) ? sdf.format(ngayHH) : "N/A";
	 
	    // Chuẩn bị truy vấn SQL và thêm sinh viên
	    String sql = "INSERT INTO sinhvien (hoVaTen, ngaySinh, gioiTinh, lop, maSv, dayNha, soLuong, soPhong, ngayDangKi, ngayHetHan, thanhtoan) " +
	            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement pst = connection.prepareStatement(sql)) {
	        // Đặt các tham số của truy vấn
	        pst.setString(1, svien.getHoVaTen());
	        pst.setString(2, ngaySinhFormatted); 
	        pst.setString(3, svien.isGioiTinh() ? "Nam" : "Nữ");
	        pst.setString(4, svien.getLop());
	        pst.setString(5, svien.getMaSV());
	        pst.setString(6, svien.getDaynha());
	        pst.setString(7, svien.getSoLuong());
	        pst.setString(8, svien.getSoPhong());
	        pst.setString(9, ngayDKFormatted);
	        pst.setString(10,ngayHHFormatted);
	        pst.setString(11, "Chưa thanh toán");
	        // Thực hiện truy vấn và đóng kết nối
	        pst.executeUpdate();
	    }
	    
	    // Thêm hàng mới vào bảng
	    Object[] row = new Object[]{
	        model_table.getRowCount() + 1,
	        svien.getHoVaTen(),
	        ngaySinhFormatted, // Sử dụng ngày sinh đã định dạng
	        svien.isGioiTinh() ? "Nam" : "Nữ",
	        svien.getLop(),
	        svien.getMaSV(),
	        svien.getDaynha(),
	        svien.getSoLuong(),
	        svien.getSoPhong(),
	        svien.getNgayDangKi(),
	        svien.getNgayHetHan(),
	        "Chưa thanh toán"
	    };
	    model_table.addRow(row);
	}


	private boolean kiemTraPhongDu(Connection connection, String soPhong, int soLuong,
			boolean gioiTinh, String dayNha) throws SQLException {
	    
		String sql = "SELECT COUNT(*) AS soLuong FROM sinhvien WHERE soPhong = ? AND gioiTinh = ? AND dayNha = ?";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, soPhong);
	        preparedStatement.setString(2, gioiTinh ? "Nam" : "Nữ");
	        preparedStatement.setString(3, dayNha);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                int soNguoiHienTai = resultSet.getInt("soLuong");
	                return soNguoiHienTai < soLuong;
	            }
	        }
	    }
	    return false;
	}


	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/qlktx";
    private static final String USER = "root";
    private static final String PASSWORD = "";
   
    public static Connection connectToDatabase() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Kết nối đến cơ sở dữ liệu thành công.");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy driver MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
        return connection;
    }

	public void xoaSV() {
	    try {
	        Connection connection = connectToDatabase();

	        // Lấy số dòng được chọn từ bảng
	        int selectedRow = table.getSelectedRow();

	        if (selectedRow != -1) {
	            // Lấy thông tin của sinh viên từ dòng được chọn
	            String maSVToDelete = table.getValueAt(selectedRow, 5).toString();

	            // Chuẩn bị truy vấn SQL để xóa sinh viên
	            String sql = "DELETE FROM sinhvien WHERE maSV = ?";
	            try (PreparedStatement pre = connection.prepareStatement(sql)) {
	            	pre.setString(1, maSVToDelete);
	            	pre.executeUpdate();

	                // Xóa sinh viên khỏi bảng hiển thị
	                DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	                model_table.removeRow(selectedRow);
	                XoaForm();
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public void laydulieu_themSV() {
	    String hoVaTen = hotentext.getText();
	  
	    Date ngaySinhDate = dateChooser_NgaySinh.getDate();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String ngaySinh = (ngaySinhDate != null) ? sdf.format(ngaySinhDate) : "";
	    
	    boolean gender = "Nam".equalsIgnoreCase(chonGioiTinh.getSelection() + "");
	    String lop = Loptext.getText();
	    String maSV = MaSVtext.getText();
	    String daynha = (String) ChonDay_Jbox.getSelectedItem();
	    String soLuong = (String) SoNguoi_Jbox.getSelectedItem();
	    String soPhong = (String) soPhong_Jbox.getSelectedItem();
	 
	    Date ngayDKDate = dateChooser_NgayDK.getDate();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		String ngayDangKi = (ngayDKDate != null) ? sdf.format(ngayDKDate) : "";
		
		Date ngayHHDate = dateChooser_NgayHH.getDate();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		String ngayHetHan = (ngayHHDate != null) ? sdf.format(ngayHHDate) : "";
	    
		String thanhToan = "Chưa thanh toán";

	    SinhVien svien = new SinhVien(hoVaTen, ngaySinh, gender, lop, maSV, daynha, soLuong, soPhong, ngayDangKi, ngayHetHan, thanhToan);

	    String luaChon = model.getLuaChon();

	    themSV(svien);
	}


	 
	
	public void timkiemSV() {
	    try {
	        Connection connection = connectToDatabase();
	        DefaultTableModel model_table = (DefaultTableModel) table.getModel();

	        // Lấy mã sinh viên cần tìm từ MaSVcantim_text
	        String maSVCanTim = MaSVcantim_text.getText().trim();

	        if (!maSVCanTim.isEmpty()) {
	            // Tìm kiếm theo mã sinh viên
	            String sql = "SELECT * FROM sinhvien WHERE maSV = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	                preparedStatement.setString(1, maSVCanTim);

	                try (ResultSet re = preparedStatement.executeQuery()) {
	                    model_table.setRowCount(0); // Xóa dữ liệu cũ trên bảng

	                    if (re.next()) {
	                        Object[] row = new Object[]{
	                                1,
	                                re.getString("hoVaTen"),
	                                re.getString("ngaySinh"),
	                                re.getString("gioiTinh").equals("Nam") ? "Nam" : "Nữ",
	                                re.getString("lop"),
	                                re.getString("maSV"),
	                                re.getString("dayNha"),
	                                re.getString("soLuong"),
	                                re.getString("soPhong"),
	                                re.getString("ngayDangKi"),
	                                re.getString("ngayHetHan"),
	                                re.getString("thanhtoan")
	                        };
	                        model_table.addRow(row);
	                    }
	                }
	            }
	        } else {
	            // Tìm kiếm theo số phòng
	        	String phongCanTim = sophongtim_Jbox.getSelectedItem().toString().trim();
	        	String daycantim = Timtheoday_JCombo.getSelectedItem().toString().trim();
	            String sql = "SELECT * FROM sinhvien WHERE soPhong = ? and daynha = ?";
	              try (PreparedStatement pre = connection.prepareStatement(sql)) {
	                  pre.setString(1, phongCanTim);
	                  pre.setString(2, daycantim);
	                  try (ResultSet re = pre.executeQuery()) {
	                      model_table.setRowCount(0); // Xóa dữ liệu cũ trên bảng

	                      int stt = 1; 
	                      while (re.next()) {
	                          Object[] row = new Object[]{
	                                  stt++,
	                                  re.getString("hoVaTen"),
	                                  re.getString("ngaySinh"),
	                                  re.getString("gioiTinh").equals("Nam") ? "Nam" : "Nữ",
	                                  re.getString("lop"),
	                                  re.getString("maSV"),
	                                  re.getString("dayNha"),
	                                  re.getString("soLuong"),
	                                  re.getString("soPhong"),
	                                  re.getString("ngayDangKi"),
	                                  re.getString("ngayHetHan"),
	                                  re.getString("thanhtoan")
	                          };
	                          model_table.addRow(row);
	                      }
	                  }
	          }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}

	
	
	public void hienthiSV() {
	    try {
	        Connection connection = connectToDatabase();

	        String sql = "SELECT * FROM sinhvien";
	        try (PreparedStatement p = connection.prepareStatement(sql)) {
	            try (ResultSet re = p.executeQuery()) {
	                DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	                model_table.setRowCount(0); // Xóa dữ liệu cũ trên bảng
	                int stt =1;
	                while (re.next()) {
	                    Object[] row = new Object[]{
	                    		stt++,
	                            re.getString("hoVaTen"),
	                            re.getString("ngaySinh"),
	                            re.getString("gioiTinh").equals("Nam") ? "Nam" : "Nữ",
	                            re.getString("lop"),
	                            re.getString("maSV"),
	                            re.getString("dayNha"),
	                            re.getString("soLuong"),
	                            re.getString("soPhong"),
	                            re.getString("ngayDangKi"),
	                            re.getString("ngayHetHan"),
	                            re.getString("thanhtoan")
	                    };
	                    model_table.addRow(row);
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } 	
	}

	public void suathongtin(SinhVien svien) {
		 String d = ChonDay_Jbox.getSelectedItem() + "";
		 int dayNha = (d != null) ? ChonDay_Jbox.getSelectedIndex() : 0;
		
		 String sl = SoNguoi_Jbox.getSelectedItem() + "";
		 int soLuong = (sl != null) ? Integer.parseInt(sl) : 0;
		 
		 String sp = soPhong_Jbox.getSelectedItem() + "";
		 int soPhong = (sp != null) ? Integer.parseInt(sp) : 0;
		 
		 boolean gt = Nut_Nam.isSelected();
		 
		 if (dayNha < 0) dayNha = 0;
		 if (soLuong < 0) soLuong = 0;
		 if (soPhong < 0) soPhong = 0;
		 svien.setDaynha(d);
		 svien.setSoLuong(sl);
		 svien.setSoPhong(sp);
		 svien.setGioiTinh(gt);
		 int columnIndex = 0;
		    try {
		        // Kết nối cơ sở dữ liệu
		        Connection connection = connectToDatabase();
		        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		        // Kiểm tra mã sinh viên trùng
		        String checkSql = "SELECT * FROM sinhvien WHERE maSv = ?";
		        try (PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
		            checkStatement.setString(1, svien.getMaSV());
		            try (ResultSet resultSet = checkStatement.executeQuery()) {
		            	if (this.model.kiemtratontai(svien)) {
		    				JOptionPane.showMessageDialog(this, "chưa có sinh viên nào trong bảng");
		    			} else {
		    				 if (check_Ma_SV_cothaydoikhong(svien, resultSet)) {
		    					 JOptionPane.showMessageDialog(this, "Mã sinh viên không được thay đổi");
		                } else {
		                	// Mã sinh viên không trùng, tiếp tục thêm mới
		                	//check số người theo sơ đồ ktx đã để
		                	if((soLuong == 4 && soPhong >= 501 && soPhong <= 530) 
		                		|| (soLuong == 6 && soPhong >= 301 && soPhong <= 430) 
		                		|| (soLuong == 8 && soPhong >= 101 && soPhong <= 230)) { 
		                    // Kiểm tra giới tính và dãy
		                    if ((svien.isGioiTinh() && dayNha == 1) || (!svien.isGioiTinh() && dayNha != 1)) {
		                        // Nếu là Nữ thì chỉ được ở dãy 1, ngược lại Nam chỉ được ở dãy 2,3
		                        JOptionPane.showMessageDialog(this, svien.isGioiTinh() ? "Dãy 1 chỉ có Nữ mới được ở" : "Dãy 2 và 3 chỉ có Nam mới được ở");
		                    } else {
		                        // Kiểm tra số lượng người trong phòng trước khi thêm mới
		                        if (kiemTraPhongDu(connection, svien.getSoPhong(), soLuong, svien.isGioiTinh(), svien.getDaynha())) {
		                            // Thêm sinh viên vào cơ sở dữ liệu và bảng
		                           this.model.updateAndInsert(svien);
		           			    int soluong = model_table.getRowCount();
		           			    for (int i = 0; i < soluong; i++) {
		           			        String masv = model_table.getValueAt(i, 5) + "";
		           			        if (masv.equals(svien.getMaSV() + "")) {
		           			            // Cập nhật thông tin trong bảng
		           			            model_table.setValueAt(svien.getHoVaTen() + "", i, 1);
		           			            model_table.setValueAt(svien.getNgaySinh() + "", i, 2);
		           			            model_table.setValueAt(svien.isGioiTinh() ? "Nam" : "Nữ" + "", i, 3);
		           			            model_table.setValueAt(svien.getLop() + "", i, 4);
		           			            model_table.setValueAt(svien.getMaSV() + "", i, 5);
		           			            model_table.setValueAt(svien.getDaynha() + "", i, 6);
		           			            model_table.setValueAt(svien.getSoLuong() + "", i, 7);
		           			            model_table.setValueAt(svien.getSoPhong() + "", i, 8);
		           			            model_table.setValueAt(svien.getNgayDangKi() + "", i, 9);
		           			            model_table.setValueAt(svien.getNgayHetHan() + "", i, 10);
		           			            model_table.setValueAt(svien.getThanhtoan() +"",i, 11);
		           			        }
		           			   }
		                        } else {
		                            JOptionPane.showMessageDialog(this, "Phòng " + svien.getSoPhong() + " của dãy " + svien.getDaynha() + " đã đủ người!");
		                        }
		                    }
		                	}else {
		                		JOptionPane.showMessageDialog(this, "vui lòng xem lại sơ đồ KTX để nắm rõ!");
		                	}
		                }
		    		 }
		          } 
		       }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	private boolean check_Ma_SV_cothaydoikhong(SinhVien svien, ResultSet resultSet) throws SQLException {
		if (!resultSet.next()) {
	        return true;
	    }

	    // Lấy mã sinh viên từ kết quả truy vấn
	    String maSVDB = resultSet.getString("maSV");

	    // So sánh mã sinh viên từ cơ sở dữ liệu và mã sinh viên mới
	    return !maSVDB.equals(svien.getMaSV());
	}

	public void laydulieusuathongtin() {
		String hoVaTen = hotentext.getText();
		
		Date ngaySinhDate = dateChooser_NgaySinh.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String ngaySinh = (ngaySinhDate != null) ? sdf.format(ngaySinhDate) : "";
       
		boolean gender = "Nam".equals(chonGioiTinh.getSelection() + "");
        String lop = Loptext.getText();
        String maSV = MaSVtext.getText();
        String daynha = ChonDay_Jbox.getSelectedItem().toString();
        String soLuong = SoNguoi_Jbox.getSelectedItem().toString();
        String soPhong =  soPhong_Jbox.getSelectedItem().toString();
        
        Date ngayDKDate = dateChooser_NgayDK.getDate();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		String ngayDangKi = (ngayDKDate != null) ? sdf.format(ngayDKDate) : "";
		
		Date ngayHHDate = dateChooser_NgayHH.getDate();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		String ngayHetHan = (ngayHHDate != null) ? sdf.format(ngayHHDate) : "";
			
        String thanhtoan = thanhtoan_Jcombo.getSelectedItem().toString();
        SinhVien svien = new SinhVien(hoVaTen, ngaySinh, gender, lop, maSV, daynha, soLuong, soPhong, ngayDangKi, ngayHetHan, thanhtoan);

        String luaChon = model.getLuaChon();
       
        suathongtin(svien);
		
	}
	public void inDSSV_execel() {
	    try {
	        Connection connection = connectToDatabase();

	        // Truy vấn SQL để lấy danh sách sinh viên đã thanh toán
	        String sql = "SELECT * FROM sinhvien";
	        try (PreparedStatement pre = connection.prepareStatement(sql);
	             ResultSet re = pre.executeQuery()) {

	            // Tạo một Workbook và Sheet mới
	            Workbook workbook = new XSSFWorkbook();
	            Sheet sheet = workbook.createSheet("DanhSachDaThanhToan_KTX");

	            // Tạo dòng tiêu đề
	            Row headerRow = sheet.createRow(0);
	            String[] columns = {"STT", "Tên", "Ngày Sinh", "Giới Tính", "Lớp", "Mã SV", "Dãy Nhà", "Số Lượng", "Số Phòng", "Ngày Đăng Kí", "Ngày Hết Hạn", "Thanh Toán"};
	            CellStyle headerCellStyle = workbook.createCellStyle();
	            org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
	            headerFont.setBold(true);
	            headerCellStyle.setFont(headerFont);
	            setAllBorders(headerCellStyle);

	            for (int i = 0; i < columns.length; i++) {
	                Cell cell = headerRow.createCell(i);
	                cell.setCellValue(columns[i]);
	                cell.setCellStyle(headerCellStyle);
	            }

	            int rowNum = 1;
	            while (re.next()) {
	                Row row = sheet.createRow(rowNum++);
	                CellStyle cellStyle = workbook.createCellStyle();
	                setAllBorders(cellStyle);

	                row.createCell(0).setCellValue(rowNum - 1);
	                row.createCell(1).setCellValue(re.getString("hoVaTen"));
	                row.createCell(2).setCellValue(re.getString("ngaySinh"));
	                row.createCell(3).setCellValue(re.getString("gioiTinh"));
	                row.createCell(4).setCellValue(re.getString("lop"));
	                row.createCell(5).setCellValue(re.getString("maSV"));
	                row.createCell(6).setCellValue(re.getString("dayNha"));
	                row.createCell(7).setCellValue(re.getString("soLuong"));
	                row.createCell(8).setCellValue(re.getString("soPhong"));
	                row.createCell(9).setCellValue(re.getString("ngayDangKi"));
	                row.createCell(10).setCellValue(re.getString("ngayHetHan"));
	                row.createCell(11).setCellValue(re.getString("thanhtoan"));

	                for (int i = 0; i < columns.length; i++) {
	                    row.getCell(i).setCellStyle(cellStyle);
	                }
	            }

	            // Hộp thoại để lấy tên file và vị trí lưu
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setDialogTitle("Chọn nơi lưu và đặt tên file");
	            int userSelection = fileChooser.showSaveDialog(this);

	            if (userSelection == JFileChooser.APPROVE_OPTION) {
	                java.io.File fileToSave = fileChooser.getSelectedFile();

	                // Ghi Workbook vào tệp Excel
	                try (FileOutputStream fileOut = new FileOutputStream(fileToSave.getAbsolutePath() + ".xlsx")) {
	                    workbook.write(fileOut);
	                }

	                JOptionPane.showMessageDialog(this, "Xuất danh sách SV ra file Excel thành công");
	            } else {
	                JOptionPane.showMessageDialog(this, "Hủy");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi");
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi khi ghi vào tệp Excel.");
	    }
	}

	private void setAllBorders(CellStyle cellStyle) {
	    cellStyle.setBorderBottom(BorderStyle.THIN);
	    cellStyle.setBorderTop(BorderStyle.THIN);
	    cellStyle.setBorderLeft(BorderStyle.THIN);
	    cellStyle.setBorderRight(BorderStyle.THIN);
	}
}
	