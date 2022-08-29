package com.dgsh.rest.web.services.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 getName1() {
		return new PersonV1("Durgesh Yadav");
	}
	
	
	@GetMapping("/v2/person")
	public PersonV2 getName2() {
		return new PersonV2(new Name("Durgesh","Yadav"));
	}
}
