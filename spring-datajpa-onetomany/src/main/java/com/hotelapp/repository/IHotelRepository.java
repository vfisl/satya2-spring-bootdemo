package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer>{
	List<Hotel>  findByCity(String city);
	List<Hotel>  findByType(Type type, Sort sort);
	List<Hotel>  findByRating(double rating);
	List<Hotel>  findByItemListItemName(String item);
	
	
	@Query(value="select * from hotel h inner join item i on h.hotelid=i.hotel_id where i.itemName=?1",nativeQuery = true)
	List<Hotel> findByItemName(String itemName);
	//custome query
	@Query("from Hotel h inner join h.itemList i where i.itemName=?1 or i.category=?2")
	List<Hotel> findByItemNameCategory(String itemName, Category category);
	@Query("from Hotel h inner join h.itemList i where i.cuisine=?1")
	List<Hotel> findByCuisine(String cuisine);
	//NamedQuery
	@Query(name="readByCat")
	List<Hotel> findByCategory(Type category);
	@Query("from Hotel h inner join h.itemList i where i.cuisine=?1 and i.itemType=?2")
	List<Hotel> findByCuisineAndType(String cuisine ,Type type);
	@Query("from Hotel h inner join h.itemList i where i.itemName=?1 and i.price<=?2")
	List<Hotel> findByItemNameLessPrice(String itemName, double price);

}
