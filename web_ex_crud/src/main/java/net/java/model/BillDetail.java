package net.java.model;

public class BillDetail {
	private int id;
	private long unitPrice;
	private int quantity;
	private Bill bill;
	private waifu Waifu;
	
	
	public BillDetail(long unitPrice, int quantity, Bill bill, waifu waifu) {
		super();
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.bill = bill;
		Waifu = waifu;
	}
	public BillDetail(int id, long unitPrice, int quantity, Bill bill, waifu waifu) {
		super();
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.bill = bill;
		Waifu = waifu;
	}
	public BillDetail() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public waifu getWaifu() {
		return Waifu;
	}
	public void setWaifu(waifu waifu) {
		Waifu = waifu;
	}
	
	
	

}
