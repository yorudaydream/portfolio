package com.ft.order;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {
	@Inject
	private SqlSession session;
	private static final String NAMESPACE="orderMapper.";
	
	public List<OrderDTO> orderList(String id) throws Exception{
		return session.selectList(NAMESPACE+"orderList", id);
	}
	
	public OrderDTO selectOrder(int orderNum) throws Exception{
		return session.selectOne(NAMESPACE+"selectOrder", orderNum);
	}
	
	public int addOrder(OrderDTO orderDTO) throws Exception{
		return session.insert(NAMESPACE+"addOrder", orderDTO);
	}
	
	public int updateOrder(OrderDTO orderDTO) throws Exception{
		return session.update(NAMESPACE+"updateOrder", orderDTO);
	}
	
	public int deleteOrder(int orderNum) throws Exception{
		return session.delete(NAMESPACE+"deleteOrder", orderNum);
	}
	
	public int getNum() throws Exception{
		return session.selectOne(NAMESPACE+"getNum");
	}
	
	public int orderMan(OrderManDTO orderManDTO) throws Exception{
		return session.insert(NAMESPACE+"orderMan", orderManDTO);
		
	}
	
}
