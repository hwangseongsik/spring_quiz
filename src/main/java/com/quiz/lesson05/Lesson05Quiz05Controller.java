package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.BO.WeatherhistoryBO;
import com.quiz.lesson05.model.Weatherhistory;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Quiz05Controller {

	@Autowired
	private WeatherhistoryBO weatherhistoryBO;
	
	@RequestMapping("/weather_history")
	public String weatherhistory(Model model) {
		
		List<Weatherhistory> weatherhistoryList = weatherhistoryBO.getWeatherhistoryList();
		
		model.addAttribute("weatherhistoryList", weatherhistoryList);
		
		return "lesson05/quiz05";
	}
}
