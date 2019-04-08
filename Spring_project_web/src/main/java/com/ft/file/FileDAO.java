package com.ft.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class FileDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "fileMapper.";
	
	public int insert(FileDTO fileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"insertFile", fileDTO);
		//NAMESPACE+"mapper 해당 메서드 id"
	};
	
	public int delete(int fnum) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", fnum); 
	};
	
	public int deleteAll(FileDTO fileDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"deleteAll", fileDTO);
		
	};
	
	public FileDTO selectOne(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectOne", num);
	}
	
	public FileDTO select(int fnum) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"select", fnum);
	};
	
	public List<FileDTO> list(FileDTO fileDTO) throws Exception{

		return sqlSession.selectOne(NAMESPACE+"fileList", fileDTO);
	};
}
