package com.ft.comment;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ft.util.Pager;

@Repository
public class CommentDAO {
	@Inject
	private SqlSession sqlSession;
	private final static String NAMESPACE="commentMapper.";
	
	public int getNum() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getNum");
	}
	
	public int insert(CommentDTO commentDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"insert", commentDTO);
	}
	
	public int update(CommentDTO commentDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update", commentDTO);
	}
	
	public int delete(int num) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", num);
	}
	
	public List<CommentDTO> list(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	
	public CommentDTO selectOne(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectOne", num);
	}
	
	public int reply(CommentDTO commentDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"reply", commentDTO);
	}
	
	public int replyUpdate(CommentDTO commentDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"replyUpdate", commentDTO);
	}
	
	public int totalCount(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"totalCount", pager);
	}
}
