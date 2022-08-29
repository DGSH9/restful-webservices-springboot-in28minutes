package com.dgsh.rest.web.services.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController{
	
	public static List<SomeBean> list1 = new ArrayList<SomeBean>();
	static {
		list1.add(new SomeBean("field1","field2","field3"));
		list1.add(new SomeBean("field12","field22","field32"));
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> filterBean() {
		return list1;
	}
}