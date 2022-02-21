package com.cg.newsapp.service;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.newsapp.model.Articles;
import com.cg.newsapp.exception.BadRequestException;
import com.cg.newsapp.exception.CategoryNotFoundException;
import com.cg.newsapp.exception.CountryNotFoundException;
import com.cg.newsapp.model.*;



@Service
public class NewsService extends MappingJackson2HttpMessageConverter {


	private static NewsService ourInstance = new NewsService();

	public static NewsService getInstance() {
		return ourInstance;
	}

	private NewsService() {
		setPrettyPrint(true);
	}

	public static List<Example> sendRefinedUpdate(String country, String category, String source123) throws BadRequestException,CountryNotFoundException, CategoryNotFoundException{

		String urlString = "https://newsapi.org/v2/top-headlines?apiKey=" + "75ac7ad234824de88362435294e7177f"+ "&country=" + country + "&category=" + category + "&source=" + source123 + "";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(urlString, String.class);

		JSONObject root = new JSONObject(result);

		String status = null;
		Integer totalResults = null;
		String id = null;
		String name = null;
		String author = null;
		String title = null;
		String description = null;
		String urlother = null;
		String urlToImage = null;
		String publishedAt = null;
		String content = null;

		List<Example> newsList = new ArrayList<>();

		status = root.getString("status");
		totalResults = root.getInt("totalResults");

		JSONArray articlesObject = root.getJSONArray("articles");

		for (int i = 0; i < articlesObject.length(); i++) {

			JSONObject arrayElement = articlesObject.getJSONObject(i);

			JSONObject sourceother = arrayElement.getJSONObject("source");

			if (!sourceother.isNull("id")) {
				id = sourceother.getString("id");
			} else {
				id = null;
			}

			name = sourceother.getString("name");

			if (!arrayElement.isNull("author")) {
				author = arrayElement.getString("author");
			} else {
				author = null;
			}

			title = arrayElement.getString("title");

			if (!arrayElement.isNull("description")) {
				description = arrayElement.getString("description");
			} else {
				description = null;
			}

			urlother = arrayElement.getString("url");

			if (!arrayElement.isNull("urlToImage")) {
				urlToImage = arrayElement.getString("urlToImage");
			} else {
				urlToImage = null;
			}

			publishedAt = arrayElement.getString("publishedAt");

			if (!arrayElement.isNull("content")) {
				content = arrayElement.getString("content");
			} else {
				content = null;
			}
			
			  
			  Example emp = new Example(); 
			  Articles articles = new Articles(); 
			  Source source = new Source();
			 

			emp.setStatus(status);
			emp.setTotalResults(totalResults);
			articles.setAuthor(author);
			articles.setContent(content);
			articles.setDescription(description);
			articles.setPublishedAt(publishedAt);
			articles.setTitle(title);
			articles.setUrlother(urlother);
			articles.setUrlToImage(urlToImage);
			source.setId(id);
			source.setName(name);

			articles.setSource(source);
			emp.setArticles(articles);
			newsList.add(emp);
		}
		return newsList;
	}

	public static List<Example> sendCategorizedUpdate(String country, String category) throws BadRequestException ,CountryNotFoundException, CategoryNotFoundException {

		String urlString = "https://newsapi.org/v2/top-headlines?apiKey=75ac7ad234824de88362435294e7177f&country="
				+ country + "&category=" + category + "";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(urlString, String.class);

		JSONObject root = new JSONObject(result);

		String status = null;
		Integer totalResults = null;
		String id = null;
		String name = null;
		String author = null;
		String title = null;
		String description = null;
		String urlother = null;
		String urlToImage = null;
		String publishedAt = null;
		String content = null;

		List<Example> newsList = new ArrayList<>();

		status = root.getString("status");
		totalResults = root.getInt("totalResults");

		JSONArray articlesObject = root.getJSONArray("articles");

		for (int i = 0; i < articlesObject.length(); i++) {

			JSONObject arrayElement = articlesObject.getJSONObject(i);

			JSONObject sourceother = arrayElement.getJSONObject("source");

			if (!sourceother.isNull("id")) {
				id = sourceother.getString("id");
			} else {
				id = null;
			}

			name = sourceother.getString("name");

			if (!arrayElement.isNull("author")) {
				author = arrayElement.getString("author");
			} else {
				author = null;
			}

			title = arrayElement.getString("title");

			if (!arrayElement.isNull("description")) {
				description = arrayElement.getString("description");
			} else {
				description = null;
			}

			urlother = arrayElement.getString("url");

			if (!arrayElement.isNull("urlToImage")) {
				urlToImage = arrayElement.getString("urlToImage");
			} else {
				urlToImage = null;
			}

			publishedAt = arrayElement.getString("publishedAt");

			if (!arrayElement.isNull("content")) {
				content = arrayElement.getString("content");
			} else {
				content = null;
			}

			Example emp = new Example();
			Articles articles = new Articles();
			Source source = new Source();

			emp.setStatus(status);
			emp.setTotalResults(totalResults);
			articles.setAuthor(author);
			articles.setContent(content);
			articles.setDescription(description);
			articles.setPublishedAt(publishedAt);
			articles.setTitle(title);
			articles.setUrlother(urlother);
			articles.setUrlToImage(urlToImage);
			source.setId(id);
			source.setName(name);

			articles.setSource(source);
			emp.setArticles(articles);
			newsList.add(emp);
		}
		return newsList;

	}

	public static List<Example> sendSourcedUpdate(String country, String source123) throws BadRequestException, CountryNotFoundException{

		String urlString = "https://newsapi.org/v2/top-headlines?apiKey=75ac7ad234824de88362435294e7177f&country="
				+ country + "&source=" + source123 + "";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(urlString, String.class);

		JSONObject root = new JSONObject(result);
		String status = null;
		Integer totalResults = null;
		String id = null;
		String name = null;
		String author = null;
		String title = null;
		String description = null;
		String urlother = null;
		String urlToImage = null;
		String publishedAt = null;
		String content = null;

		List<Example> newsList = new ArrayList<>();

		status = root.getString("status");
		totalResults = root.getInt("totalResults");

		JSONArray articlesObject = root.getJSONArray("articles");

		for (int i = 0; i < articlesObject.length(); i++) {

			JSONObject arrayElement = articlesObject.getJSONObject(i);

			JSONObject sourceother = arrayElement.getJSONObject("source");

			if (!sourceother.isNull("id")) {
				id = sourceother.getString("id");
			} else {
				id = null;
			}

			name = sourceother.getString("name");

			if (!arrayElement.isNull("author")) {
				author = arrayElement.getString("author");
			} else {
				author = null;
			}

			title = arrayElement.getString("title");

			if (!arrayElement.isNull("description")) {
				description = arrayElement.getString("description");
			} else {
				description = null;
			}

			urlother = arrayElement.getString("url");

			if (!arrayElement.isNull("urlToImage")) {
				urlToImage = arrayElement.getString("urlToImage");
			} else {
				urlToImage = null;
			}

			publishedAt = arrayElement.getString("publishedAt");

			if (!arrayElement.isNull("content")) {
				content = arrayElement.getString("content");
			} else {
				content = null;
			}

			Example emp = new Example();
			Articles articles = new Articles();
			Source source = new Source();

			emp.setStatus(status);
			emp.setTotalResults(totalResults);
			articles.setAuthor(author);
			articles.setContent(content);
			articles.setDescription(description);
			articles.setPublishedAt(publishedAt);
			articles.setTitle(title);
			articles.setUrlother(urlother);
			articles.setUrlToImage(urlToImage);
			source.setId(id);
			source.setName(name);

			articles.setSource(source);
			emp.setArticles(articles);
			newsList.add(emp);
		}
		return newsList;
		
	}
	public static List<String> sendFavouriteNews() {
		List<String> favourite=new ArrayList<>();
		favourite.add("Total Results:03");
		
		favourite.add("Title: Starlink surprises NASA as rivals seek FCC protection of ~30000 satellites - BollyInside");
		favourite.add("https://www.bollyinside.com/news/starlink-surprises-nasa-as-rivals-seek-fcc-protection-of-30000-satellites");
	
		favourite.add("Title: Kiara Advani sparkles in a sunset-hued Tarun Tahiliani saree for the Dadasaheb Phalke Awards: Yay or Nay? - PINKVILLA");
		favourite.add("https://www.pinkvilla.com/fashion/celebrity-style/kiara-advani-sparkles-sunset-hued-tarun-tahiliani-saree-dadasaheb-phalke-awards-yay-or-nay-1028625");
	
		favourite.add("Title: Man United respond to Leeds hostility with thrilling win as Harry Maguire & Co. step up - ESPN India");
		favourite.add("https://www.espn.in/football/english-premier-league/story/4598110/man-united-respond-to-leeds-hostility-with-thrilling-win-as-maguire-and-co-step-up");
		

		return favourite;
		
	}

}