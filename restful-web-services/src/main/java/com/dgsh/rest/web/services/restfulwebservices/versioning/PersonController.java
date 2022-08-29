package com.dgsh.rest.web.services.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
//	================>1(v1 and v2)  --uri versioning used by twitter
	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Durgesh Yadav");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Durgesh","Yadav"));
	}
	
//	================>2(params)  ---request parameter versioning used by amazon	
	@GetMapping(value ="/person/param",params = "version=1")
	public PersonV1 paramsV1() {
		return new PersonV1("Durgesh Yadav");
	}
	
	@GetMapping(value = "/person/param",params = "version=2")
	public PersonV2 paramsV2() {
		return new PersonV2(new Name("Durgesh","Yadav"));
	}
	
//	================>3(headers) ---custom header used in microsoft
	@GetMapping(value ="/person/header",headers =  "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Durgesh Yadav");
	}
	
	
	@GetMapping(value ="/person/header",headers =  "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Durgesh","Yadav"));
	}
	
//	================>4(produces)	--media type versioning used by github
	@GetMapping(value ="/person/produces",produces =  "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Durgesh Yadav");
	}
	
	
	@GetMapping(value ="/person/produces",produces =  "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Durgesh","Yadav"));
	}
	
	
}
