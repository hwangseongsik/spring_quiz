package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;

@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// http://localhost/lesson04/quiz01/1
	@RequestMapping(path="/lesson04/quiz01/1", method=RequestMethod.GET)
	public String quiz01() {
		return "lesson04/add_seller";
	}
	
	// http://localhost/lesson04/quiz01/add_seller
	@PostMapping("/lesson04/quiz01/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value="profileImageUrl", required=false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		// insert DB
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과 jsp
		return "lesson04/after_add_seller";	// 결과 경로
	}
	
	// http://localhost/lesson04/quiz01/seller_info
	@GetMapping("/lesson04/quiz01/seller_info")
	public String quiz01_2(Model model) {
		// DB select - 가장 최근 추가된 사람 한명 가져오기
		Seller seller = sellerBO.getLastSeller();
		
		model.addAttribute("result", seller);	// 결과 jsp뷰화면에 결과 객체값을 내려준다.
		model.addAttribute("subject", "판매자 정보");
		return "lesson04/seller_info";
	}
}
