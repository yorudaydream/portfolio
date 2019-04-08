package com.ft.project;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ft.file.FileDAO;
import com.ft.member.MemberDTO;
import com.ft.order.OrderDTO;
import com.ft.order.OrderManDTO;
import com.ft.order.OrderService;
import com.ft.product.ProductDAO;
import com.ft.product.ProductDTO;

@Controller
@RequestMapping(value="/order/**")
public class OrderController {
	@Inject
	private OrderService orderService;
/*	@Inject
	private MemberDTO memberDTO;*/
	@Inject
	private ProductDAO productDAO;
	@Inject
	private FileDAO fileDAO;
	
	@RequestMapping(value="orderList")
	public ModelAndView orderList(String id) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("orderList", orderService.orderList(id));
		
		mv.setViewName("order/orderList");
		
		return mv;
	}
	
	@RequestMapping(value="selectOrder")
	public String selectOrder(int orderNum) throws Exception{
		return "order/orderSelectOne";
	}
	
	@RequestMapping(value="addOrder", method=RequestMethod.GET)
	public ModelAndView addOrder(int product_id, int amount, int shipping, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int num = product_id;
		ProductDTO productDTO = productDAO.selectOne(num);
		mv.addObject("order", productDTO);
		mv.addObject("amount", amount);//selectOne 페이지에서 넘어오는 갯수 값 받아서 넣어주기
		mv.addObject("shipping", shipping);//selectOne 페이지에서 넘어오는 배송료 값 받아서 넣어주기
		mv.addObject("photo", fileDAO.selectOne(num));
		mv.setViewName("order/order");
		return mv;
	}
	
	
	@RequestMapping(value="addOrder.do", method=RequestMethod.POST)
	public ModelAndView addOrder(OrderDTO orderDTO, OrderManDTO ordermanDTO, ProductDTO productDTO, HttpSession session, int total) throws Exception{
		ModelAndView mv = orderService.addOrder(orderDTO, ordermanDTO);
		System.out.println("orderResult");
		mv.addObject("product", productDTO);
		mv.addObject("order", orderDTO);
		mv.addObject("orderman", ordermanDTO);		
		/*mv.addObject("addOrder", orderService.addOrder(orderDTO, ordermanDTO));*/
		mv.setViewName("order/orderResult");
		
		return mv;
		
	}
	

	
	@RequestMapping(value="updateOrder", method=RequestMethod.GET)
	public String updateOrder() throws Exception{
		
		return "order/orderUpdate";
	}

	@RequestMapping(value="updateOrder", method=RequestMethod.POST)
	public void updateOrder(OrderDTO orderDTO) throws Exception{
		
	}
	
	@RequestMapping(value="deleteOrder",  method=RequestMethod.GET)
	public void deleteOrder(int orderNum) throws Exception{
		
	}
	
	
	
}
