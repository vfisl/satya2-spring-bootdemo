package com.hotelapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Item;
import com.hotelapp.model.Type;
import com.hotelapp.service.IHotelService;

@SpringBootApplication
public class SpringDatajpaOnetomanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetomanyApplication.class, args);
	}
	@Autowired
  IHotelService iHotelService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Item item1=new Item("Fried Rice",Category.FASTFOOD,Type.VEG,"Chineese",100);
		Item item2=new Item("Mushroom Noodles",Category.FASTFOOD,Type.VEG,"Chineese",150);
		Item item3=new Item("Vanilla Shake",Category.BEVERAGES,Type.VEG,"Juices",100);
		Set<Item>itemList1=new HashSet<Item>(Arrays.asList(item1,item2,item3));
		Hotel hoytel=new Hotel("Mainland",Type.VEG,"Hyderabad",4.5,itemList1);
		
		//iHotelService.addHotel(hoytel);
		
		Item item4=new Item("Chicken noodles",Category.FASTFOOD,Type.NONVEG,"Chineese",100);
		Item item5=new Item("Chicken masala",Category.STARTERS,Type.NONVEG,"Chineese",150);
		Item item6=new Item("Chicken Biriyani",Category.MAINCOURSE,Type.NONVEG,"Juices",200);
		Set<Item>itemList2=new HashSet<Item>(Arrays.asList(item4,item5,item6));
		Hotel hotel2=new Hotel("Dragon King",Type.NONVEG,"Mumbai",4.7,itemList2);
		//iHotelService.addHotel(hotel2);
		System.out.println("************");
		System.out.println();
		iHotelService.getAll().forEach(System.out::println);
//		System.out.println();
//		System.out.println("********Find Hotel By itemName********");
//		System.out.println();
//		iHotelService.getByItemName("Fried Rice").forEach((hotel)->System.out.println(hotel.getName()));
//		System.out.println();
//		System.out.println("********Find Hotel By rating********");
//		System.out.println();
//		iHotelService.getByRating(4.5).forEach(System.out::println);
		//iHotelService.deleteHotel(104);
//		
		System.out.println();
		System.out.println("********Find Hotel By type********");
		System.out.println();
		iHotelService.getByType(Type.NONVEG).forEach((hotel)->System.out.println(hotel.getName()));
//		System.out.println();
//		System.out.println("********Find Hotel By item name and less price********");
//		System.out.println();
//		iHotelService.getByItemNameLessPrice("Mushroom Noodles", 150).forEach((hotel)->
//		{
//			System.out.println("hotel name"+hotel.getName());
//			hotel.getItemList().forEach(item->{
//				System.out.println("item name"+item.getItemName());
//				System.out.println("item price"+item.getPrice());
//				
//			});
//			
//		});
	}

}
