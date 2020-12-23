package com.capgemini.census.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.census.entity.MemberInformation;
import com.capgemini.census.exception.MemberInformationException;
import com.capgemini.census.service.MemberInformationService;

@RestController
@RequestMapping("/api/member")

public class UserController {
	@Autowired
	//@Qualifier(value = "productServiceSpringData")
	private MemberInformationService memberInformationService;

	
	// http://localhost:8081/api-new/products/
	// add product
	@PostMapping("/{id}")
	public void addMember(@PathVariable Integer id,  @RequestBody MemberInformation memberInformation) {
		try {
			memberInformationService.addMember(memberInformation,id);
			
		} catch (MemberInformationException e) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
