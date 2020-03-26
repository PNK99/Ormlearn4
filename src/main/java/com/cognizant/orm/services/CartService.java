package com.cognizant.orm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm.models.Cart;
import com.cognizant.orm.models.MenuItem;
import com.cognizant.orm.models.User;
import com.cognizant.orm.repositories.CartRepository;
import com.cognizant.orm.repositories.MenuItemRepository;
import com.cognizant.orm.repositories.UserRepository;

@Service
public class CartService {
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	CartRepository cartRepo;

	@Autowired
	MenuItemRepository menuRepo;

	public void addCartItem(long userId, long menuItemId) {
		
		User user = userRepo.findById(userId).get();
		Cart cart = user.getCart();

		MenuItem menu = menuRepo.findById(menuItemId).get();

		cart.getMenuItemList().add(menu);

		cartRepo.save(cart);
		
	}

	public List<MenuItem> getAllCartItems(long userId) {
		
		User user = userRepo.findById(userId).get();
		Cart cart = user.getCart();

		return cart.getMenuItemList();
		
	}

	public void removeCartItem(long userId, long menuItemId) {
		
		User user = userRepo.findById(userId).get();
		Cart cart = user.getCart();

		MenuItem menu = menuRepo.findById(menuItemId).get();

		cart.getMenuItemList().remove(menu);

		cartRepo.save(cart);
	
	}
}
