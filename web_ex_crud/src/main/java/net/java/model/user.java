package net.java.model;

public class user {

	protected int id;
	protected String taikhoan;
	protected String matkhau;
	
	public user() {
	super();
	}
	public user(String taikhoan, String matkhau) {
		super();
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}
	public user(int id, String taikhoan, String matkhau) {
		super();
		this.id = id;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	
}
