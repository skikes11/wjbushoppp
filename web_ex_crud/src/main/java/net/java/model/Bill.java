package net.java.model;

public class Bill {
	private int id;
	private user buyer;// nguoi mua
	private String buyDate;// ngay mua
	private long priceTotal;// tong tien
	public Bill( user buyer, String buyDate, long priceTotal) {
		super();
		this.buyer = buyer;
		this.buyDate = buyDate;
		this.priceTotal = priceTotal;
	}
	public Bill(int id, user buyer, String buyDate, long priceTotal) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.buyDate = buyDate;
		this.priceTotal = priceTotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public user getBuyer() {
		return buyer;
	}
	public void setBuyer(user buyer) {
		this.buyer = buyer;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public long getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(long priceTotal) {
		this.priceTotal = priceTotal;
	}
	
}
