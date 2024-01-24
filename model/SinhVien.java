	package model;
	
	import java.util.Date;
	import java.util.Objects;
	
	public class SinhVien extends Phong {
		String hoVaTen;
		String ngaySinh;
		boolean gioiTinh; 
		String lop;
		String maSV;
		
		public SinhVien(String hoVaTen, String ngaySinh, boolean gioiTinh, String lop, String maSV, String daynha, String soPhong, String soLuong, String ngayDangKi, String ngayHetHan ) {
			super(daynha, soPhong, soLuong, ngayDangKi, ngayHetHan);
			this.hoVaTen = hoVaTen;
			this.ngaySinh = ngaySinh;
			this.gioiTinh = gioiTinh;
			this.lop = lop;
			this.maSV = maSV;
		}

		public SinhVien(String hoVaTen, String ngaySinh, boolean gioiTinh, String lop, String maSV, String daynha, String soPhong, String soLuong, String ngayDangKi, String ngayHetHan, String thanhtoan ) {
			super(daynha, soPhong, soLuong, ngayDangKi, ngayHetHan,thanhtoan);
			this.hoVaTen = hoVaTen;
			this.ngaySinh = ngaySinh;
			this.gioiTinh = gioiTinh;
			this.lop = lop;
			this.maSV = maSV;
		}
		
		public SinhVien(String thanhtoan) {
			
		}
		public String getHoVaTen() {
			return hoVaTen;
		}
	
		public void setHoVaTen(String hoVaTen) {
			this.hoVaTen = hoVaTen;
		}
	
		public String getNgaySinh() {
			return ngaySinh;
		}
	
		public void setNgaySinh(String ngaySinh) {
			this.ngaySinh = ngaySinh;
		}
	
		public boolean isGioiTinh() {
			return gioiTinh;
		}
	
		public void setGioiTinh(boolean gioiTinh) {
			this.gioiTinh = gioiTinh;
		}
	
		public String getLop() {
			return lop;
		}
	
		public void setLop(String lop) {
			this.lop = lop;
		}
	
		public String getMaSV() {
			return maSV;
		}
	
		public void setMaSV(String maSV) {
			this.maSV = maSV;
		}
	
	
		public String getGioiTinhAsString() {
		    return gioiTinh ? "Nam" : "Nữ";
		}

	}
