package com.ft.product;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ft.file.FileDAO;
import com.ft.file.FileDTO;
import com.ft.util.FileSaver;
import com.ft.util.Pager;

@Service
public class ProductService {
	@Inject
	private ProductDAO productDAO;
	@Inject
	private FileDAO fileDAO;
 	
	public int getNum() throws Exception{
		return productDAO.getNum();
	}
	
	public ModelAndView addProduct(ProductDTO productDTO, List<MultipartFile> upload, HttpSession session) throws Exception{
		//1. sequence num 가져오기
		int num = productDAO.getNum();
		
		//2. Notice Table에 insert
		System.out.println(num);
		productDTO.setNum(num);
		int result = productDAO.addProduct(productDTO);
		
		//transaction 처리
		if(result<1) {
			throw new Exception();
		}
		
		//3. HDD에 File Save
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/images/product");
		for(MultipartFile multipartFile:upload) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fname=fs.saveFile(realPath, multipartFile);
		
		//4. Files table insert
			FileDTO fileDTO = new FileDTO();
			System.out.println(num);
			fileDTO.setNum(num);
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setKind(productDTO.getKind());//게시판구분
			result = fileDAO.insert(fileDTO);
			//transaction 
			if(result<1) {
				throw new Exception();
			}
			
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../mypage/my");
		/*mv.addObject("msg", "상품 추가 완료");*/
		return mv;
}
	
	public ModelAndView updateProduct(ProductDTO productDTO, HttpSession session, List<MultipartFile> upload) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = productDAO.updateProduct(productDTO);

		if(result<1) {
			throw new Exception();
		}
		//HDD save
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/product");
		for(MultipartFile multipartFile:upload) {
			String fname=fs.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(productDTO.getNum());
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setFname(fname);
			fileDTO.setKind(productDTO.getKind());
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		
		
		String msg = "Update Success";
		
		mv.setViewName("redirect:./productSelectOne?num="+productDTO.getNum());
		mv.addObject("msg", msg);
		return mv;
	}
	
	public ModelAndView selectOne(int num) throws Exception{
		ModelAndView mv = new ModelAndView();
		ProductDTO productDTO = productDAO.selectOne(num);
		FileDTO fileDTO = fileDAO.selectOne(num);
		
		if(productDTO != null) {
			mv.setViewName("product/productSelectOne");
			mv.addObject("dto", productDTO);
			mv.addObject("photo", fileDTO);
		}else {
			mv.setViewName("redirect:./productList");
			mv.addObject("msg", "해당 상품은 존재하지 않습니다");
		}
		
		return mv;
	}
	
	public ModelAndView selectById(int product_id) throws Exception{
		ModelAndView mv = new ModelAndView();
		ProductDTO productDTO = productDAO.selectOne(product_id);
		System.out.println(product_id);
		FileDTO fileDTO = fileDAO.selectOne(product_id);
		
		if(productDTO != null) {
			mv.setViewName("product/productSelectOne");
			mv.addObject("dto", productDTO);
			mv.addObject("photo", fileDTO);
		}else {
			mv.setViewName("redirect:./productList");
			mv.addObject("msg", "해당 상품은 존재하지 않습니다");
		}
		
		return mv;
	}
	
	public ModelAndView productList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		int totalCount = productDAO.totalCount(pager);
		
		pager.makeRow();
		pager.makePage(totalCount);

		List<ProductDTO> p = productDAO.productList(pager);
		List<FileDTO> filelist = new ArrayList<FileDTO>();
		
		for(int i=0; i<p.size();i++) {
			int photoNum = p.get(i).getNum();
			FileDTO fileDTO = fileDAO.selectOne(photoNum);
			filelist.add(fileDTO);
			/*System.out.println(photoNum);*/
		}
		
		
		/*	List<ProductDTO> p = productDAO.productList(pager);
		
		System.out.println(p.size());//리스트 갯수
		
		System.out.println(pager.getStartRow());
		System.out.println(pager.getLastRow());
		System.out.println(pager.getKind());*/
		
		mv.addObject("productList", p);
		mv.addObject("files", filelist);
		
		mv.addObject(pager);
		mv.setViewName("product/productList");
		
		return mv;
	}
	
	public ModelAndView deleteProduct(int num, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		//1. notice Delete
		int result = productDAO.deleteProduct(num);
		if(result<1) {
			throw new Exception();
		}
		//2. HDD Delete 준비
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind(fileDTO.getKind());
		List<FileDTO> ar = fileDAO.list(fileDTO);
		
		//3. Files table Delete
		result=fileDAO.deleteAll(fileDTO);
		
		
		//4. HDD Delete 
		String realPath = session.getServletContext().getRealPath("resources/product");
		for(FileDTO fileDTO2:ar) {
			File file = new File(realPath, fileDTO2.getFname());
			file.delete();
		}
		
		mv.setViewName("redirect:./productList");
		mv.addObject("msg", "삭제 완료");
		return mv;
	}
	/*
	public int getNum() throws Exception{
		return productDAO.getNum();
	}
	
	public int addProduct(ProductDTO productDTO) throws Exception{
		return productDAO.addProduct(productDTO);
	}
	
	public int updateProduct(ProductDTO productDTO) throws Exception{
		return productDAO.updateProduct(productDTO);
	}
	
	public ProductDTO selectOne(int num) throws Exception{
		return productDAO.selectOne(num);
	}
	
	public List<ProductDTO> list(Pager pager) throws Exception{
		return productDAO.list(pager);
	}*/
	
}
