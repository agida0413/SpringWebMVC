package com.itmeservice.web.basic;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmeservice.domain.item.Item;
import com.itmeservice.domain.item.ItemRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

	private final ItemRepository itemRepository;

	@GetMapping
	public String items(Model model) {
		
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items",items);
		return "basic/items";
	}
	
	@GetMapping("/{itemId}")
	public String item(@PathVariable("itemId") Long itemId,Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item",item);
		return "basic/item";
	}
	
	@GetMapping("/add")
	public String addForm() {
		return "basic/addForm";
	}
	@PostConstruct
	public void init() {
		itemRepository.save(new Item("itemA", 12000, 200));
		itemRepository.save(new Item("itemB", 12333, 300));
	}
	
	
}
