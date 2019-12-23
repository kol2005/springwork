package com.biz.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.product.domain.ProductDTO;
import com.biz.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService pService;
	
	//@ResponseBody
	@RequestMapping(value="plist",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public String getPlist(Model model) {
		List<ProductDTO> proList = pService.selectAll();
		model.addAttribute("PLIST",proList);
		return "p-List";
	}
	
	@ResponseBody
	@RequestMapping(value="plist/name",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public List<ProductDTO> getNames(String p_name) {
		List<ProductDTO> proDTO = pService.findByPNames(p_name);
		return proDTO;
	}
	
	@ResponseBody
	@RequestMapping(value="product",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public ProductDTO getProduct(String p_code) {
		
		ProductDTO proDTO = pService.findByPCode(p_code);
		
		return proDTO;
	}
	
	/*
	 * produces의 content-Type
	 * 서버에서 문자열, 객체 등등의 실제 데이터를 response할때
	 * 어떤 type으로 보낼것인가를 나타내는 문자열
	 */
	@ResponseBody
	@RequestMapping(value="pname",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public String getPName(String p_code) {
		
		ProductDTO proDTO = pService.findByPCode(p_code);
		
		//return proDTO.getP_name();
		
		return "<h1>" + proDTO.getP_name() + "</h1>";
	}
	
	@ResponseBody
	@RequestMapping(value="oprice",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String getOPrice(String p_code) {
		
		ProductDTO proDTO = pService.findByPCode(p_code);
		
		return proDTO.getP_oprice()+"";
	}
	@ResponseBody
	@RequestMapping(value="iprice",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String getIPrice(String p_code) {
		
		ProductDTO proDTO = pService.findByPCode(p_code);
		
		return proDTO.getP_iprice()+"";
	}
	
}
