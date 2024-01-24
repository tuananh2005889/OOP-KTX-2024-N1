package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.google.protobuf.Message;

import model.QLKTX_model;
import model.SinhVien;
import model.database;
import view.viewQLSV;

public class QLKTX_control_SV implements Action {
	
	public viewQLSV view;
	public List<SinhVien> studentList = new ArrayList<>();
	
	public QLKTX_control_SV() {
	}
	
	public QLKTX_control_SV(viewQLSV view) {
		super();
		this.view = view;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	    String chon = e.getActionCommand();

	    if ("Thêm SV".equals(chon)) {
	    	themSV();
	    } else if ("Lưu".equals(chon)) {
	        luuSinhVien();
	    } else if ("Hiển thị ALL SV".equals(chon)) {
	    	hienthiALLSV();
	    } else if ("Xóa".equals(chon)) {
	    	xoasinhvien();
	    } else if ("Thay đổi".equals(chon)) {
	    	suathongtinn();
	    } else if("Tạo file excel".equals(chon)) {
	    	xuatDS_excel();
	    }
	}

	private void xuatDS_excel() {
		if (this.view.model == null) {
            this.view.model = new QLKTX_model();
        } else {
        	this.view.inDSSV_execel();
        }
		
	}

	private void themSV() {
		if (this.view.model == null) {
            this.view.model = new QLKTX_model();
        } else {
        	this.view.XoaForm();
        }
		
	}

	private void suathongtinn() {
		 if (this.view.model == null) {
	            this.view.model = new QLKTX_model();
	        } else {
	        	this.view.laydulieusuathongtin();
	        }
		
	}

	private void xoasinhvien() {
		if (this.view.model == null) {
	        this.view.model = new QLKTX_model();
	    } else {
	    	this.view.xoaSV();
	    }
	}


	private void luuSinhVien() {
		if (this.view.model == null) {
	        this.view.model = new QLKTX_model();
	    } else {
	       this.view.laydulieu_themSV();
	    }
	 
	}
	

	public void hienthiALLSV() {
		if (this.view.model == null) {
	        this.view.model = new QLKTX_model();
	    } else {
	    	this.view.hienthiSV();
	    }
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
