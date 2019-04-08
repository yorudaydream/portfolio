package com.ft.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ft.cart.CartDTO;
import com.ft.cart.CartService;
import com.ft.member.MemberDTO;
import com.ft.product.ProductDTO;

@Controller
@RequestMapping("/cart/**")
public class CartController {
	
	@Inject
	private CartService cartService;
	private CartDTO cartDTO;
	
	
	@RequestMapping(value="cartList")
	public ModelAndView cartList(HttpSession session, CartDTO cartDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("cartList");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		/*//회원id 가져오기
		String id = (String)session.getAttribute("id");*/
		//Map 만들기
		Map<String, Object> map = new HashMap<String, Object>();
		//장바구니 정보 가져오기
		List<CartDTO> list = cartService.cartList(memberDTO);
		//장바구니 전체 금액 계산
		int sum = cartService.sumPrice(memberDTO.getId());
		//장바구니 금액에 따라 배송비 구분(10만원 이상 무료배송)
		int shipping = sum >= 100000 ? 0 : 2500;
		
		//장바구니 정보를 map에 저장
		map.put("cartlist", list);
		//장바구니 상품의 유무
		map.put("count", list.size());
		//장바구니 전체 금액
		map.put("sum", sum);
		//배송비
		map.put("fee", shipping);
		//주문상품 전체 금액
		map.put("total", sum+shipping);
		//view 페이지 이름 저장
		mv.setViewName("cart/cartList");
		//map 변수 저장
		mv.addObject("map",map);
		return mv;
	}
	
	@RequestMapping(value="addCart.do", method=RequestMethod.POST)
	public String insert(ProductDTO productDTO, HttpSession session) throws Exception{
		String id =(String)session.getAttribute("id");
		System.out.println("addCartdo");
		
		//장바구니에 기존 상품 있는지 검사하고 없으면 insert 원래 있으면 update
		cartService.insert(id, productDTO, cartDTO);
		
		return "redirect:cart/cartList";
	}
	
/*	@RequestMapping(value="addCart.do", method=RequestMethod.POST)
	public String insert(ProductDTO productDTO, HttpSession session) throws Exception{
		String id =(String)session.getAttribute("id");
		System.out.println("addCartdo");
		
		//장바구니에 기존 상품 있는지 검사하고 없으면 insert 원래 있으면 update
		cartService.insert(id, productDTO, cartDTO);
		
		return "redirect:cart/cartList";
	}
	*/
	
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String update(HttpSession session, @RequestParam int[] amount, @RequestParam int[] product_id) throws Exception{
		String id = (String)session.getAttribute("id");
		
		
		
		for(int i=0; i<product_id.length; i++) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.setId(id);
			cartDTO.setAmount(amount[i]);
			cartDTO.setProduct_id(product_id[i]);
			cartService.update(cartDTO);
		}
				
		return "redirect: cart/cartList";
	}
	
		
	@RequestMapping(value="updateAmount", method = RequestMethod.POST)
	public void updateAmount() throws Exception{
		
	}
	
	@RequestMapping(value="delete.do")
	public String delete(int num) throws Exception{
		//장바구니 삭제
		cartService.delete(num);
		//삭제하고 페이지 이동
		return "redirect: cart/cartList";
	}
}
