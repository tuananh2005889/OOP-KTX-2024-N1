package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import view.viewQLSV;

public class QLKTX_model extends database {
	private ArrayList<SinhVien> dsSV;
	private String luaChon;
	viewQLSV view = new viewQLSV();
	public QLKTX_model() {
		
	}
	public QLKTX_model(ArrayList<SinhVien> dsSV, String luaChon) {
		super();
		this.dsSV = new ArrayList<>();
		this.luaChon = "";
	}
	public ArrayList<SinhVien> getDsSV() {
		return dsSV;
	}
	public void setDsSV(ArrayList<SinhVien> dsSV) {
		this.dsSV = dsSV;
	}
	public String getLuaChon() {
		return luaChon;
	}
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
	@Override
	public String toString() {
		return "QLKTX_model [dsSV=" + dsSV + ", luaChon=" + luaChon + "]";
	}
	public void insert(SinhVien sinhvien) {
		if (dsSV == null) {
            dsSV = new ArrayList<>();
        }
        dsSV.add(sinhvien);
	}
	
	public void delete(SinhVien sinhvien) {
		this.dsSV.remove(sinhvien);
	}
	 public boolean kiemtratontai(SinhVien svien) {
	        try (Connection connection = view.connectToDatabase()) {
	            String sql = "SELECT * FROM sinhvien";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    if (resultSet.next()) {
	                        int count = resultSet.getInt(1);
	                        return count > 0;
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }
	 public void updateAndInsert(SinhVien svien) {
		    try (Connection connection = view.connectToDatabase()) {
		        // Cập nhật dữ liệu của sinh viên
		        String updateSql = "UPDATE sinhvien SET hoVaTen=?, ngaySinh=?, gioiTinh=?, lop=?, daynha=?, soLuong=?, soPhong=?, ngayDangKi=?, ngayHetHan=?, thanhtoan=? WHERE maSV=?";
		        try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
		        	
		            // Đặt giá trị cho các tham số tương ứng, kiểm tra và xử lý giá trị null
		            updateStatement.setString(1, svien.getHoVaTen() != null ? svien.getHoVaTen() : "");
		            updateStatement.setString(2, svien.getNgaySinh() != null ? svien.getNgaySinh() : "");
		            updateStatement.setString(3, svien.isGioiTinh()? "Nam" : "Nữ");
		            updateStatement.setString(4, svien.getLop() != null ? svien.getLop() : "");
		            updateStatement.setString(5, svien.getMaSV());
		            updateStatement.setString(6, svien.getDaynha() != null ? svien.getDaynha() : "");
		            updateStatement.setString(7, svien.getSoLuong() != null ? svien.getSoLuong() : "");
		            updateStatement.setString(8, svien.getSoPhong() != null ? svien.getSoPhong() : "");
		            updateStatement.setString(9, svien.getNgayDangKi() != null ? svien.getNgayDangKi() : "");
		            updateStatement.setString(10, svien.getNgayHetHan() != null ? svien.getNgayHetHan() : "");
		            updateStatement.setString(11, svien.getThanhtoan() != null ? svien.getThanhtoan() : "");

		            int cot = updateStatement.executeUpdate();

		            // Kiểm tra xem có bản ghi nào được cập nhật không
		            if (cot <= 0) {
		            	String deleteSql = "DELETE FROM sinhvien WHERE maSV=?";
		                try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
		                    deleteStatement.setString(1, svien.getMaSV());
		                    deleteStatement.executeUpdate();
		                }
		                // Thêm thông tin vào cơ sở dữ liệu
		                String insertSql = "INSERT INTO sinhvien (hoVaTen, ngaySinh, gioiTinh, lop, maSV, daynha, soLuong, soPhong, ngayDangKi, ngayHetHan, thanhtoan ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		                try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
		                    // Đặt giá trị cho các tham số tương ứng
		                    insertStatement.setString(1, svien.getHoVaTen());
		                    insertStatement.setString(2, svien.getNgaySinh());
		                    insertStatement.setString(3, svien.isGioiTinh() ? "Nam" : "Nữ");
		                    insertStatement.setString(4, svien.getLop());
		                    insertStatement.setString(5, svien.getMaSV());
		                    insertStatement.setString(6, svien.getDaynha());
		                    insertStatement.setString(7, svien.getSoLuong());
		                    insertStatement.setString(8, svien.getSoPhong());
		                    insertStatement.setString(9, svien.getNgayDangKi());
		                    insertStatement.setString(10, svien.getNgayHetHan());
		                    insertStatement.setString(11, svien.getThanhtoan());
		                    insertStatement.executeUpdate();
		                }
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
}
