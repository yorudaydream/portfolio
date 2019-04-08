package com.ft.order;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.servlet.ModelAndView;

import com.ft.file.FileDAO;
import com.ft.product.ProductDAO;

public class OrderService_bak {

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
		
		public ModelAndView addOrder(OrderDTO orderDTO) throws Exception{
			ModelAndView mv = new ModelAndView();
			/*ProductDTO productDTO = productDAO.selectOne(num);
			FileDTO fileDTO = fileDAO.selectOne(num);
			
			if(productDTO != null) {
				mv.addObject("dto", productDTO);
				mv.addObject("photo", fileDTO);
			}
			
			return orderDAO.addOrder(orderDTO);*/
			Calendar today = Calendar.getInstance();//객체를 얻어오자 new 대신 getInstance 씀
			long date= today.getTimeInMillis();
			System.out.println(date);
			
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

