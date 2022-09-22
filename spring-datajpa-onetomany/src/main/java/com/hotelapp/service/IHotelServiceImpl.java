package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;
import com.hotelapp.repository.IHotelRepository;
@Service
public class IHotelServiceImpl implements IHotelService {

	
	IHotelRepository iHotelRepository;
	@Autowired
	public void setiHotelRepository(IHotelRepository iHotelRepository) {
		this.iHotelRepository = iHotelRepository;
	}

	@Override
	public void addHotel(Hotel hotel) {
		iHotelRepository.save(hotel);
		
	}

	@Override
	public void deleteHotel(int hotelId) {
		iHotelRepository.deleteById(hotelId);
		
	}

	@Override
	public void updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> getAll() {
		//Sort sort =Sort.by("name");
		 Sort sort=Sort.by(Direction.DESC, "name");
		return iHotelRepository.findAll(sort);
	}

	@Override
	public void getById(int hotelId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> getByCity(String city) {
		// TODO Auto-generated method stub
		return iHotelRepository.findByCity(city);
	}
	

	@Override
	public List<Hotel> getByType(Type type) {
		// TODO Auto-generated method stub
		return iHotelRepository.findByType(type,Sort.by("name"));
	}

	@Override
	public List<Hotel> getByRating(double rating) {
		// TODO Auto-generated method stub
		return iHotelRepository.findByRating(rating);
	}

	@Override
	public List<Hotel> getByItemName(String itemName) {
		// TODO Auto-generated method stub
		//return iHotelRepository.findByItemListItemName(itemName);
		
		return iHotelRepository.findByItemListItemName(itemName);
	}

	@Override
	public List<Hotel> getByItemNameCategory(String itemName, Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getByCuisine(String cuisine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getByCuisineAndType(String cuisine, Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getByItemNameLessPrice(String itemName, double price) {
		// TODO Auto-generated method stub
		return iHotelRepository.findByItemNameLessPrice(itemName, price);
	}

}
