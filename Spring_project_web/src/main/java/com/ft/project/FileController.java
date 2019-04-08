package com.ft.project;

import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ft.file.FileDTO;
import com.ft.file.FileService;
import com.ft.file.PhotoDTO;
import com.ft.util.FileSaver;

@Controller
@RequestMapping(value="/file/**")
public class FileController {

	@Inject
	private FileService fileService;
	
	@RequestMapping(value="delete")
	public ModelAndView delete(int fnum) throws Exception{
		//DB가기 전 Service거치기
		ModelAndView mv = fileService.delete(fnum);
		return mv;
	}

	@RequestMapping(value="deleteAll")
	public ModelAndView deleteAll(FileDTO fileDTO) throws Exception{
		//DB가기 전 Service거치기
		ModelAndView mv = fileService.deleteAll(fileDTO);
		return mv;
	}
	
	
	public ModelAndView fileDown(FileDTO fileDTO) throws Exception{
		ModelAndView mv =  new ModelAndView();
		mv.addObject("file", fileDTO);
		mv.setViewName("fileDown");
		return mv;
	}
	
	public String insertFile(PhotoDTO photoDTO, HttpSession session) throws Exception{
		String realPath=session.getServletContext().getRealPath("resources/images/product");
		String contextName = session.getServletContext().getContextPath();
		
		FileSaver fs = new FileSaver();
		String fname=fs.saveFile(realPath, photoDTO.getFiledata());
		String result="&bNewLine=true&sFileName="+URLEncoder.encode(photoDTO.getFiledata().getOriginalFilename(), "UTF-8");
		result = result+"&sFileURL="+contextName+"/resources/images/product"+URLEncoder.encode(fname, "UTF-8");
		System.out.println("redirect:"+photoDTO.getCallback()+"?callback_func="+photoDTO.getCallback_func()+result);
		return "redirect:"+photoDTO.getCallback()+"?callback_func="+photoDTO.getCallback_func()+result;
		
	}
	
}
