package model;

public class taikhoan_model {
	private String tendangnhap;
	private String gmail;
	private String mk;
	private String mk_2;
	
	public taikhoan_model() {
		
	}
	
	public taikhoan_model(String tendangnhap, String gmail, String mk, String mk_2) {
		super();
		this.tendangnhap = tendangnhap;
		this.gmail = gmail;
		this.mk = mk;
		this.mk_2 = mk_2;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getMk() {
		return mk;
	}

	public void setMk(String mk) {
		this.mk = mk;
	}

	public String getMk_2() {
		return mk_2;
	}

	public void setMk_2(String mk_2) {
		this.mk_2 = mk_2;
	}
	
	
}
