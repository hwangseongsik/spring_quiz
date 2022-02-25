package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.model.Realtor;

@Controller
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO;
	
	@RequestMapping("/lesson04/quiz02/1")
	public String quiz02_1() {
		return "lesson04/add_realtor";		
	}
	
	@PostMapping("/lesson04/quiz02/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,	// name에 있는 값과 일치하는 필드에 값이 들어간다.
			Model model) {
		
		realtorBO.addRealtor(realtor);
		
		realtor = realtorBO.getRealtorByid(realtor.getId());
		
		
		model.addAttribute("subject", "공인중개사 정보");
		model.addAttribute("result", realtor);
		
		return "lesson04/after_add_realtor";
	}
}
