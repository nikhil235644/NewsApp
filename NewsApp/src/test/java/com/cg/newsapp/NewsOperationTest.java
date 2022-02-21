package com.cg.newsapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


import com.cg.newsapp.controller.NewsController;
import com.cg.newsapp.exception.BadRequestException;
import com.cg.newsapp.exception.CategoryNotFoundException;
import com.cg.newsapp.exception.CountryNotFoundException;
import com.cg.newsapp.service.NewsService;

@TestInstance(Lifecycle.PER_CLASS)
public class NewsOperationTest {

	
	NewsController op;
	
	@BeforeAll
	public void init() {
		System.out.println("Testing Started..");
		op = new NewsController();
	}
	
	@BeforeEach
	public void initEachTest() {
		System.out.println("Test Begin..");
	}
	
	@AfterEach
	public void finalizeEachTest() {
		System.out.println("Test End..");
	}
	
	@AfterAll
	public void finalizeAllTest() {
		System.out.println("All test Completed..");
	}
	
	@Test
	public void LogInTest()
	{
		assertEquals("LogIn is successfull",op.LogIn("nikhil","AbraKaDabra"));
	}
	
	@Test
	public void sendCategorizedUpdateTest() throws BadRequestException, CountryNotFoundException, CategoryNotFoundException
	{
		String country="us";
		String category="sports";
		assertEquals(NewsService.sendCategorizedUpdate(country,category),op.sendCategorizedUpdate("us","sports"));
	}
	@Test
	public void sendSourcedUpdateTest() throws BadRequestException, CountryNotFoundException
	{
		String country="us";
		String source="source123";
		assertEquals(NewsService.sendSourcedUpdate(country,source),op.sendSourcedUpdate("us","source123"));
	}
	@Test
	public void sendRefinedUpdateTest() throws BadRequestException, CountryNotFoundException, CategoryNotFoundException
	{
		String country="in";
		String category="general";
		String source="source123";
		assertEquals(NewsService.sendRefinedUpdate(country,category,source),op.sendRefinedUpdate("in","general","source123"));
	}
	
	@Test
	public void sendFavouriteNewsTest()
	{
		
		assertEquals(NewsService.sendFavouriteNews(),op.sendFavouriteNews());
	}
	


	
}




