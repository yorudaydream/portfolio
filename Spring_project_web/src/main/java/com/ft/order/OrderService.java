package com.ft.order;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ft.file.FileDAO;
import com.ft.file.FileDTO;
import com.ft.member.MemberDTO;
import com.ft.product.ProductDAO;
import com.ft.product.ProductDTO;
import com.ft.product.ProductService;

@Service
public class OrderService {

	@Inject
	private OrderDAO orderDAO;
	@Inject
	private ProductDAO productDAO;
	@Inject
	private FileDAO fileDAO;
	
	

	public List<OrderDTO> orderList(String id) throws Exception{
		return orderDAO.orderList(id);
	}
	
	public OrderDTO selectOrder(int orderNum) throws Exception{
		return orderDAO.selectOrder(orderNum);
	}
	
	public ModelAndView addOrder(OrderDTO orderDTO, OrderManDTO orderManDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		Calendar today = Calendar.getInstance();//객체를 얻어오자 new 대신 getInstance 씀
		long date= today.getTimeInMillis();
		Random random = new Random();
		int frontNum = random.nextInt(999999);
		String orderNum = frontNum+"-"+date;
		orderDTO.setOrderNum(orderNum);
		orderManDTO.setOrderNum(orderNum);
		orderDAO.addOrder(orderDTO);
		orderDAO.orderMan(orderManDTO);
		return mv;
	}
	
	public int updateOrder(OrderDTO orderDTO) throws Exception{
		return orderDAO.updateOrder(orderDTO);
	}
	
	public int deleteOrder(int orderNum) throws Exception{
		return orderDAO.deleteOrder(orderNum);
	}
	
	public int getNum() throws Exception{
		return orderDAO.getNum();
	}
	
	public int orderMan(OrderManDTO orderManDTO) throws Exception{
		return orderDAO.orderMan(orderManDTO);
	}
}
