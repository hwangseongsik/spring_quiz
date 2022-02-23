package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController
public class Lesson03Quiz03RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// http://localhost/lesson03/quiz03/1?id=8&price=70000
	@RequestMapping("/lesson03/quiz03")
	public String quiz03(
			@RequestParam(value="id") int id,
			@RequestParam(value="price") int price) {
		
		int row = realEstateBO.updateRealEstateById(id, price);
		return "수정 성공 : " + row;
	}
}
