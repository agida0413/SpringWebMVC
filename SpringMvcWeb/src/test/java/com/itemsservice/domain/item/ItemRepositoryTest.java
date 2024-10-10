package com.itemsservice.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.itmeservice.domain.item.Item;
import com.itmeservice.domain.item.ItemRepository;

public class ItemRepositoryTest {
ItemRepository itemRepository = new ItemRepository();

	@AfterEach
	void aftereach() {
		itemRepository.clearStore();
	}
	
	@Test
	void save() {
		//given
		Item item= new Item("itemA", 10000, 10);
		
		//when
		Item savedItem = itemRepository.save(item);
		//then
		Item findItem = itemRepository.findById(item.getId());
		Assertions.assertThat(findItem).isEqualTo(savedItem);
	}
	
	@Test
	void findall() {
		//given
		Item item1= new Item("itemA", 10000, 10);
		Item item2= new Item("itemB", 20000, 20);
		
		itemRepository.save(item1);
		itemRepository.save(item2);
		
		//when
		List<Item> result = itemRepository.findAll();
		//then
		assertThat(result.size()).isEqualTo(2);
		assertThat(result).contains(item1,item2);
	}
	
	
	@Test
	void updateitem() {
		//given
		Item item1= new Item("itemA", 10000, 10);
		Item savedItem=	itemRepository.save(item1);
		Long itemId= savedItem.getId();
		
		//when
		Item udpateParam = new Item("item2",20000,20);
		itemRepository.update(itemId, udpateParam);
		
		//then
		Item findItem = itemRepository.findById(itemId);
		
		Assertions.assertThat(findItem.getItemName()).isEqualTo(udpateParam.getItemName());
		Assertions.assertThat(findItem.getPrice()).isEqualTo(udpateParam.getPrice());
		Assertions.assertThat(findItem.getQuantity()).isEqualTo(udpateParam.getQuantity());
		
	}
}
