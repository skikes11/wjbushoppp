package net.java.model;

public class waifu {
	protected int id;
	protected String name;
	protected int age;
	protected String type;
	protected int price;
	protected String image;
	
	public waifu(String name, int age, String type, int price, String image) {
		super();
		this.name = name;
		this.age = age;
		this.type = type;
		this.price = price;
		this.image = image;
	}
	public waifu(int id, String name, int age, String type, int price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.type = type;
		this.price = price;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
