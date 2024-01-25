package com.learning.springboot.toDoWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //this handles web requests
public class SayHelloConrtroller {
	
	@RequestMapping("say-Hello")
	@ResponseBody //this will spring the string as it is on browser
	public String sayHello() {
		return "Hello! What are you learning today";
	}
	
	@RequestMapping("say-Hello-html")
	@ResponseBody
	public String sayHello1() {
		
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First web page  </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My First web page using spring! ");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
