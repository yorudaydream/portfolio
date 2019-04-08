package com.ft.comment;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ft.file.FileDAO;
import com.ft.file.FileDTO;
import com.ft.util.FileSaver;
import com.ft.util.Pager;

@Service
public class CommentService {
	@Autowired
	private CommentDAO commentDAO;
	@Inject
	private FileDAO fileDAO;
	
	public int getNum() throws Exception{
		return commentDAO.getNum();
	}
	
	public ModelAndView list(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		int totalCount = commentDAO.totalCount(pager);
		pager.makeRow();
		pager.makePage(totalCount);
		
		mv.addObject("list", commentDAO.list(pager));
		mv.addObject(pager);
		mv.setViewName("comment/commentList");
		return mv;
	}
	
	public ModelAndView selectOne(int num) throws Exception{
		ModelAndView mv = new ModelAndView();
		CommentDTO commentDTO = commentDAO.selectOne(num);
		
		if(commentDTO != null) {
			mv.setViewName("comment/commentSelect");
			mv.addObject("dto", commentDTO);
		}else {
			mv.setViewName("redirect:./commentList");
			mv.addObject("msg", "해당 코멘트가 삭제되었습니다.");
		}

		return mv;

	}
	
	public ModelAndView insert(CommentDTO commentDTO, List<MultipartFile> f1, HttpSession session) throws Exception{
		//1. sequence num 가져오기
		int num = commentDAO.getNum(); 
				
		//2. Notice Table에 insert
		commentDTO.setNum(num);	
		int result = commentDAO.insert(commentDTO);
		
		//transaction 처리
		if(result<1) {
			throw new Exception();
		}
		
		//3. HDD에 File Save
		FileSaver fs = new FileSaver();
		String realpath = session.getServletContext().getRealPath("resources/comment");
		
		for(MultipartFile multipartFile:f1) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fname = fs.saveFile(realpath, multipartFile);
			//4. Files table insert
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setKind("c");
			result = fileDAO.insert(fileDTO);
			
			if(result<1) {
				throw new Exception();
			}
			
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("comment/commentList");
		mv.addObject("msg", "상품평 작성 성공");
		return mv;
	}
	
	public ModelAndView update(CommentDTO commentDTO, List<MultipartFile> f1, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = commentDAO.update(commentDTO);
		
		if(result<1) {
			throw new Exception();
		}
		
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/comment");
		
		for(MultipartFile multipartFile:f1) {
			String fname = fs.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(commentDTO.getNum());
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setFname(fname);
			fileDTO.setKind("c");
			result = fileDAO.insert(fileDTO);
			
			if(result<1) {
				throw new Exception();
			}
			
		}
		
		
		return mv;
	}
	
	public ModelAndView delete(int num, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = commentDAO.delete(num);
		
		if(result<1) {
			throw new Exception();
		}
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("c");
		List<FileDTO> ar = fileDAO.list(fileDTO);
		
		result = fileDAO.deleteAll(fileDTO);
		
		String realPath = session.getServletContext().getRealPath("resources/notice");
		for(FileDTO fileDTO2:ar) {
			File file = new File(realPath, fileDTO2.getFname());
			file.delete();
		}
		
		mv.setViewName("redirect:./commentList");
		mv.addObject("msg", "삭제 성공");
		
		return mv;
	}
	
	public int reply(CommentDTO commentDTO) throws Exception{
		CommentDTO pCommentDTO = commentDAO.selectOne(commentDTO.getNum());
		
		commentDAO.replyUpdate(pCommentDTO);
		commentDTO.setRef(pCommentDTO.getRef());
		commentDTO.setDepth(pCommentDTO.getDepth());
		commentDTO.setStep(pCommentDTO.getStep());
		return commentDAO.reply(commentDTO);
	}
	
	/*public int getNum() throws Exception{
		return commentDAO.getNum();
	}
	
	public List<CommentDTO> list(Pager pager) throws Exception{
		return commentDAO.list(pager);
	}
	
	public CommentDTO selectOne(int num) throws Exception{
		return commentDAO.selectOne(num);
	}
	
	public int insert(CommentDTO commentDTO) throws Exception{
		return commentDAO.insert(commentDTO);
	}
	
	public int update(CommentDTO commentDTO) throws Exception{
		return commentDAO.update(commentDTO);
	}
	
	public int delete(int num) throws Exception{
		return commentDAO.delete(num);
	}*/
}
