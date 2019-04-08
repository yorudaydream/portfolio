package com.ft.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ft.member.MemberDTO;

@Repository
public class CartDAO {
	@Inject
	SqlSession sqlSession;
	private final static String NAMESPACE="cartMapper.";
	
	public List<CartDTO> cartList(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"cartList", memberDTO);
	}
	public void insert(CartDTO cartDTO) throws Exception{
		sqlSession.insert(NAMESPACE+"insert", cartDTO);
	}
	
	public void delete(int num) throws Exception{
		sqlSession.delete(NAMESPACE+"delete", num);
	}
	
	public void update(CartDTO cartDTO) throws Exception{
		sqlSession.update(NAMESPACE+"update", cartDTO);
	}
	
	public void updateAmount(CartDTO cartDTO)throws Exception{
		sqlSession.update(NAMESPACE+"updateAmount", cartDTO);
	}
	
	public int sumPrice(String id) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"sumPrice", id);
	}
	
	public int countCart(String id, int product_id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product_id", product_id);
		map.put("id", id);
		return sqlSession.selectOne(NAMESPACE+"countCart", map);
	}

}
