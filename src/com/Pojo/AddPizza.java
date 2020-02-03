package com.Pojo;

public class AddPizza {

	private int id;
	private String categories;
	private String pizzaname;
	private String price;
	private String addphoto;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getPizzaname() {
		return pizzaname;
	}

	public void setPizzaname(String pizzaname) {
		this.pizzaname = pizzaname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAddphoto() {
		return addphoto;
	}

	public void setAddphoto(String addphoto) {
		this.addphoto = addphoto;
	}

	@Override
	public String toString() {
		return "AddPizza [id=" + id + ", categories=" + categories + ", pizzaname=" + pizzaname + ", price=" + price
				+ ", addphoto=" + addphoto + "]";
	}
	
	
	
	
}
