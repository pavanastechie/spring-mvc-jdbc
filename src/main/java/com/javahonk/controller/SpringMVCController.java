package com.javahonk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javahonk.domain.Person;
import com.javahonk.services.IPersonService;


@Controller
public class SpringMVCController {
	
	@Autowired 
	IPersonService transformService;
	
	private static final Logger logger = Logger.getLogger(SpringMVCController.class);
	
	@RequestMapping(value = "/firstPage")
	public String firstPage(ModelMap model) {
		
		logger.info("Log4j info is working");
        logger.warn("Log4j warn is working");       
        logger.debug("Log4j debug is working");
        logger.error("Log4j error is working");
        System.out.println("System out is working");
		model.addAttribute("message", "Spring MVC JDBCTemplate welcome page");
		
		return "index";		
	}

	@RequestMapping(value = "/databasetest")
	public @ResponseBody List<Map<String, Object>> databasetest() {
		
		return transformService.selectAllPerson();
	}
	
	@RequestMapping(consumes ="application/json", produces = "application/json", value = "users",method = RequestMethod.POST)
	@ResponseBody
	public void postingData(@RequestBody List<Person> user, HttpServletRequest request, HttpServletResponse response) {
//		List<Person> a = new ArrayList<Person>();
//		for(int i=0;i<user.length; i++){
//			a.add(user[i]);
//		}
		 transformService.postData(user);
	}
	
//	@RequestMapping(value = "/getSampleJSONData/{name}/{password}")
//	public @ResponseBody String getSampleJSONData(@PathVariable String name, @PathVariable String password) {
//		
//
//		JSONObject jo = new JSONObject();
//		jo.put("values", new JSONArray(new Long[][]{{1025409600000L,23L},{1028088000000L,19L},{1030766400000L,21L},{1033358400000L,22L}}));		
//		jo.put("key", "North America");
//		
//		JSONArray ja = new JSONArray();
//		
//		for (int i = 0; i < 10; i++) {
//			ja.put(jo);
//		}
//		
//		return ja.toString();	
//	}


}
