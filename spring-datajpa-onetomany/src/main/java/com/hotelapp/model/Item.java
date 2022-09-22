package com.hotelapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	@Id
	@GeneratedValue(generator = "item_gen",strategy =GenerationType.AUTO )
	@SequenceGenerator(name = "item_gen",sequenceName = "item_sequence",initialValue = 10,allocationSize = 1)
	private Integer itemId;
	@Column(name="itemname",length=25)
	private String itemName;
	@Enumerated(value=EnumType.STRING)
	private Category category;
	@Column(name="itemtype",length=25)
	@Enumerated(value=EnumType.STRING)
	private Type itemType;
	@Column(length=25)
	private String cuisine;
	private double price;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String itemName, Category category, Type itemType, String cuisine, double price) {
		super();
		this.itemName = itemName;
		this.category = category;
		this.itemType = itemType;
		this.cuisine = cuisine;
		this.price = price;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Type getItemType() {
		return itemType;
	}
	public void setItemType(Type itemType) {
		this.itemType = itemType;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", itemType=" + itemType
				+ ", cuisine=" + cuisine + ", price=" + price + "]";
	}
	

}
