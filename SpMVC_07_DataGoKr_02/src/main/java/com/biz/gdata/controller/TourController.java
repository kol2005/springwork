package com.biz.gdata.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.gdata.domain.AreaBaseDTO;
import com.biz.gdata.domain.CityVO;
import com.biz.gdata.domain.TourDTO;
import com.biz.gdata.service.TourAppService;
import com.google.gson.JsonSyntaxException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TourController {

	@ModelAttribute
	public TourDTO newTour() {
		return new TourDTO();
	}

	@Autowired
	TourAppService tService;

	@RequestMapping(value = "total", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String total(@RequestParam(value = "t_city", required = false, defaultValue = "1") String t_city,
			@RequestParam(value = "t_sigun", required = false, defaultValue = "1") String t_sigun,
			Model model) throws JsonSyntaxException, IOException {
		
		log.debug("메인 컨트롤러");

		List<CityVO> sigunList = tService.getAreaData(t_city);
		model.addAttribute("SI", sigunList);

		List<AreaBaseDTO> baseList = tService.getAreaBaseListData(t_city,t_sigun);
		model.addAttribute("BASELIST", baseList);

		List<CityVO> cityList = null;
		try {
			cityList = tService.getAreaData();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TourDTO tDTO = new TourDTO();
		tDTO.setT_city(t_city);
		tDTO.setT_sigun(t_sigun);

		model.addAttribute("tourDTO", tDTO);
		model.addAttribute("CITY", cityList);
		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "city", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String city(Model model) {

		String cityString = null;
//		try {
//			cityString = tService.getDataString();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return cityString;
	}

}
