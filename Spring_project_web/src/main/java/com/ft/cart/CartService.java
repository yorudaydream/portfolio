package com.ft.cart;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ft.member.MemberDTO;
import com.ft.product.ProductDTO;

@Service
public class CartService {

	@Inject
	private CartDAO cartDAO;
	
	public List<CartDTO> cartList(MemberDTO memberDTO) throws Exception{
		return cartDAO.cartList(memberDTO);
	}
	
	public void insert(String id,ProductDTO productDTO, CartDTO cartDTO) throws Exception{
		int count = cartDAO.countCart(id, productDTO.getProduct_id());
		if(count == 0) {
			cartDAO.insert(cartDTO);
		}else {
			cartDAO.update(cartDTO);
		}
	}
	
	public void delete(int num) throws Exception{
		cartDAO.delete(num);
	}
	
	public void update(CartDTO cartDTO) throws Exception{
		cartDAO.update(cartDTO);
	}
	
	public void updateAmount(CartDTO cartDTO) throws Exception{
		cartDAO.updateAmount(cartDTO);
	}
	
	public int sumPrice(String id) throws Exception{
		return cartDAO.sumPrice(id);
	}
	
	public int countCart(String id, int product_id) throws Exception{
		return cartDAO.countCart(id, product_id);
	}
}
