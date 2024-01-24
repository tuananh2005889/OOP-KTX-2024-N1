package model;

import java.util.Date;
import java.util.Objects;

public class Phong {
    protected String daynha;
    protected String soPhong;
    protected String soLuong;
    protected String ngayDangKi;
    protected String ngayHetHan;
    protected String thanhtoan;
	public Phong() {
		
	}

	public Phong(String daynha, String soPhong, String soLuong, String ngayDangKi, String ngayHetHan) {
		super();
		this.daynha = daynha;
		this.soPhong = soPhong;
		this.soLuong = soLuong;
		this.ngayDangKi = ngayDangKi;
		this.ngayHetHan = ngayHetHan;
	}

	
	public Phong(String daynha, String soPhong, String soLuong, String ngayDangKi, String ngayHetHan,
			String thanhtoan) {
		this.daynha = daynha;
		this.soPhong = soPhong;
		this.soLuong = soLuong;
		this.ngayDangKi = ngayDangKi;
		this.ngayHetHan = ngayHetHan;
		this.thanhtoan = thanhtoan;
	}

	public String getThanhtoan() {
		return thanhtoan;
	}

	public void setThanhtoan(String thanhtoan) {
		this.thanhtoan = thanhtoan;
	}

	public String getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}

	public String getDaynha() {
		return daynha;
	}

	public void setDaynha(String daynha) {
		this.daynha = daynha;
	}

	public String getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}

	public String getNgayDangKi() {
		return ngayDangKi;
	}

	public void setNgayDangKi(String ngayDangKi) {
		this.ngayDangKi = ngayDangKi;
	}

	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(daynha, ngayDangKi, ngayHetHan, soLuong, soPhong);
	}

	

	
	
	
}
