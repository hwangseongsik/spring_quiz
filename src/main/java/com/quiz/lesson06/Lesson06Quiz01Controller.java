package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	private FavoriteBO favoriteBO;
	
	// 즐겨찾기추가하기 뷰
	@RequestMapping("/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/add_new_favorite";
	}
	
	// 즐겨찾기추가
	@ResponseBody
	@PostMapping("/add_favorite")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// TODO insert db
		favoriteBO.addFavorite(name, url);
		
		return "성공";
	}
	
	// 결과 페이지
	@RequestMapping("/get_favorite_view")
	public String getFavoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		model.addAttribute("favoriteList", favoriteList);
		
		favoriteBO.getFavoriteList();
		
		return "lesson06/get_favorite";
	}
}
