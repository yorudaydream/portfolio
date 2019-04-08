package com.ft.project;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ft.comment.CommentDTO;
import com.ft.comment.CommentService;
import com.ft.util.Pager;

@Controller
@RequestMapping(value="/comment/**")
public class CommentController {
	@Inject
	private CommentService commentService;

	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception{
		return commentService.list(pager);
	}
	@RequestMapping(value="selectOne", method=RequestMethod.GET)
	public ModelAndView selectOne(int num)throws Exception{
		return commentService.selectOne(num);
	}
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public ModelAndView insert(CommentDTO commentDTO, List<MultipartFile> f1, HttpSession session) throws Exception{
		return commentService.insert(commentDTO, f1, session);
	}
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public void insert() throws Exception{
		
	}
 	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView update(CommentDTO commentDTO, List<MultipartFile> f1, HttpSession session) throws Exception{
 		return commentService.update(commentDTO, f1, session);
 	}
 	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public void update() throws Exception{
		
	}
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public ModelAndView delete(int num, HttpSession session) throws Exception{
		return commentService.delete(num, session);
	}
}
