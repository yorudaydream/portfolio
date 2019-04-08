package com.ft.product;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ft.util.Pager;

@Repository
public class ProductDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="productMapper.";
	
	public int getNum() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getNum");
	}
	
	public int addProduct(ProductDTO productDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"addProduct", productDTO);
	}
	public int deleteProduct(int num) throws Exception{
		return sqlSession.delete(NAMESPACE+"deleteProduct", num);
	}
	public int updateProduct(ProductDTO productDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"updateProduct", productDTO);
	}
	public List<ProductDTO> productList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"productList", pager);
		
	}
	public ProductDTO selectOne(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectOne", num);
	}
	
	public int totalCount(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"totalCount", pager);
	}

	public ProductDTO selectById(int product_id) {
		return sqlSession.selectOne(NAMESPACE+"selectOne", product_id);
	}
	
	
}
