package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RestController
public class Lesson03Quiz02RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/lesson03/quiz02/1")
	public String quiz02_1() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int rowCount = realEstateBO.addRealEstate(realEstate);
		return "입력 성공 :" + rowCount;
	}
	
	@RequestMapping("/lesson03/quiz02/2")
	public String quiz02_2() {
		int row = realEstateBO.addRealEstateAsField("썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공 : " + row;
	}
}
