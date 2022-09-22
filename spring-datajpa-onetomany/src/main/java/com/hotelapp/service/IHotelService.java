package com.hotelapp.service;

import java.util.List;
import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;

public interface IHotelService {
	public void addHotel(Hotel hotel);
	public void deleteHotel(int hotelId);
	public void updateHotel(Hotel hotel);
	
	List<Hotel>  getAll();
	public void  getById(int hotelId);
	//derived queries
	List<Hotel>  getByCity(String city);
	List<Hotel>  getByType(Type type);
	List<Hotel>  getByRating(double rating);
	//custom queries
	List<Hotel> getByItemName(String itemName);
	List<Hotel> getByItemNameCategory(String itemName, Category category);
	List<Hotel> getByCuisine(String cuisine);
	List<Hotel> getByCategory(Category category);
	List<Hotel> getByCuisineAndType(String cuisine ,Type type);
	List<Hotel> getByItemNameLessPrice(String itemName, double price);

}
