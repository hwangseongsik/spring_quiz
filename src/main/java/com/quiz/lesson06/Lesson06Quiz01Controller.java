package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, String> addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// insert DB
		favoriteBO.addFavorite(name, url);
		
		// 응답값 구성(map -> json string)
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		// return 응답값
		return result;
	}
	
	// 즐겨찾기 목록 화면
	@RequestMapping("/favorite_list_view")
	public String FavoriteListView(Model model) {
		
		//db select
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		// model에 담는다.
		model.addAttribute("favoriteList", favoriteList);
		
		return "lesson06/get_favorite";
	}
	
	// 주소의 중복확인 - AJAX를 통해 오는 요청
	@ResponseBody
	@PostMapping("/lesson06/quiz02/check_duplication_url")
	public Map<String, Boolean> checkDuplicationUrl(
			@RequestParam("url") String url) {
		
		Map<String, Boolean> result = new HashMap<>();
		Favorite favorite = favoriteBO.getFavortieByUrl(url);
		
		if (favorite == null) {	// 중복아님
			result.put("result", false);
		} else {	// 중복
			result.put("result", true);
		}
		result.put("result", true);
		
		return result;
	}
	
	// AJAX 요청
	@ResponseBody
	@PostMapping("/lesson06/quiz02/delete_favorite")
	public Map<String, String> deleteFavorite(
			@RequestParam("id") int id) {
			
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		int row = favoriteBO.deleteFavoriteById(id);
		if (row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
			result.put("errorMessage", "삭제하는데 실패했습니다");
		}
		return result;
	}
}
