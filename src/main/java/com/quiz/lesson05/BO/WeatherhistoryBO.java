package com.quiz.lesson05.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.DAO.WeatherhistoryDAO;
import com.quiz.lesson05.model.Weatherhistory;

@Service
public class WeatherhistoryBO {
	@Autowired
	private WeatherhistoryDAO weatherhistoryDAO;
	
	public List<Weatherhistory> getWeatherhistoryList() {
		return weatherhistoryDAO.selectWeatherhistoryList();
	}
}
