package com.dgsh.rest.web.services.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filter")
	public MappingJacksonValue filter() {
		SomeBean someBean = new SomeBean("field1", "field2", "field3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean", filter);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue retrievListOfBean() {
		List<SomeBean> list1 = Arrays.asList(new SomeBean("field1", "field2", "field3"),
				new SomeBean("field12", "field22", "field32"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("Filed2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean", filter );
		MappingJacksonValue mapiJacksonValue  = new MappingJacksonValue(list1);
		
		mapiJacksonValue.setFilters(filters);

		return mapiJacksonValue;
	}
}