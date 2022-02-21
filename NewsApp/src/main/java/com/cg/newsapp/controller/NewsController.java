package com.cg.newsapp.controller;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.newsapp.exception.BadRequestException;
import com.cg.newsapp.exception.CategoryNotFoundException;
import com.cg.newsapp.exception.CountryNotFoundException;
import com.cg.newsapp.model.Example;
import com.cg.newsapp.service.*;

@RestController()
public class NewsController {
	
	@RequestMapping(value = "/LogIn/{username}/{password}", method = RequestMethod.GET)
	public String LogIn(@PathVariable String username, @PathVariable String password) {
		String user="nikhil";
		String paswrd="AbraKaDabra";
		if(user.equals(username) && paswrd.equals(password))
		   return "LogIn is successfull";
		else
			return "LogIn is Unsuccessfull";
	}	
			
	@GetMapping(value = "/Categorizednews/country/{country}/category/{category}")
	public List<Example> sendCategorizedUpdate(@PathVariable String country,@PathVariable String category) throws BadRequestException,CountryNotFoundException,CategoryNotFoundException{
		if(country.isEmpty() && category.isEmpty())
		{
			throw new CountryNotFoundException("Please enter country and category code");
		}
		return NewsService.sendCategorizedUpdate(country,category);
	} 
	
	@GetMapping(value = "/NewsByCountry/country/{country}/{source123}")
	public List<Example> sendSourcedUpdate(@PathVariable String country,@PathVariable String source123) throws BadRequestException ,CountryNotFoundException{
		if(country.isEmpty())
		{
			throw new CountryNotFoundException("Please enter country code");
		}
		return NewsService.sendSourcedUpdate(country,source123);
	}
	
	@GetMapping(value = "/NewsByCategory/{country}/category/{category}/{source123}")
	public List<Example> sendRefinedUpdate(@PathVariable String country,@PathVariable String category,@PathVariable String source123) throws BadRequestException ,CountryNotFoundException, CategoryNotFoundException{
		if(country.isEmpty() && category.isEmpty())
		{
			throw new CountryNotFoundException("Please enter country and category code");
		}
		return NewsService.sendRefinedUpdate(country,category,source123);
	} 
	@GetMapping(value = "/Categorizednews/favouriteNewsList")
	public List<String> sendFavouriteNews() {
		return NewsService.sendFavouriteNews();
	} 
	

}
