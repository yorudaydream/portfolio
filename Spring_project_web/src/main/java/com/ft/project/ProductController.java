package com.ft.project;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ft.product.ProductDTO;
import com.ft.product.ProductService;
import com.ft.util.Pager;

@Controller
@RequestMapping(value="/product/**")
public class ProductController {

	@Inject
	private ProductService productService;
	
	@RequestMapping(value="addProduct", method=RequestMethod.GET)
	public String insert() throws Exception{
		return "product/addProduct";
	}	
	
/*	@RequestMapping(value="addProduct.do", method=RequestMethod.POST)
	public String insert(ProductDTO productDTO, List<MultipartFile> f1, HttpSession session, RedirectAttributes rd) throws Exception{
		String realpath = session.getServletContext().getRealPath("resources/images/product");		
		System.out.println("lllll"+realpath);
		String path = "";
		ModelAndView mv =productService.addProduct(productDTO, f1, session); 
		if(mv != null) {
			session.setAttribute("product", productDTO);
			path = "redirect:../mypage/my";
		}else {
			path="redirect:./addProduct";
			rd.addFlashAttribute("msg", "상품등록이 실패했습니다");
		}
		
		return path;
	}*/
	
	@RequestMapping(value="addProduct.do", method=RequestMethod.POST)
	public ModelAndView insert(ProductDTO productDTO, List<MultipartFile> upload, HttpSession session) throws Exception{
		String realpath = session.getServletContext().getRealPath("resources/images/product");			
		ModelAndView mv =productService.addProduct(productDTO, upload, session); 
		return mv;
	}
	
	@RequestMapping(value="updateProduct", method=RequestMethod.GET)
	public ModelAndView update(Model model, int num) throws Exception{
		ModelAndView mv = productService.selectOne(num);
		mv.setViewName("product/updateProduct");
		return mv;
	}
	
	@RequestMapping(value="updateProduct.do", method=RequestMethod.POST)
	public ModelAndView update(ProductDTO productDTO, HttpSession session, List<MultipartFile> f1) throws Exception{
		ModelAndView mv = productService.updateProduct(productDTO, session, f1);
		return mv;
	}
	
	@RequestMapping(value="productSelectOne", method=RequestMethod.GET)
	public ModelAndView oneload(Model model, RedirectAttributes rd, int num) throws Exception{
		ModelAndView mv = productService.selectOne(num);
		return mv;
	}
	
	@RequestMapping(value="productList", method=RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception{
		ModelAndView mv=productService.productList(pager);
		System.out.println("productList");
		return mv;
	}
	
	@RequestMapping(value="delete.do", method=RequestMethod.POST)
	public ModelAndView delete(int num, HttpSession session) throws Exception{
		ModelAndView mv = productService.deleteProduct(num, session);
		return mv;
	}
	
	
	
}
