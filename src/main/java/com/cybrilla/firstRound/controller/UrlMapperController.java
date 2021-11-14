package com.cybrilla.firstRound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybrilla.firstRound.service.MapperServiceImpl;


@RestController
public class UrlMapperController {


	@Autowired
	private MapperServiceImpl mapperServiceImpl;


	
	@GetMapping("/mappers/{shortUrl}")
	public ResponseEntity<String> getLongUrl(@PathVariable("shortUrl")String shortUrl) {
		return new ResponseEntity<>(mapperServiceImpl.getLongUrl(shortUrl),HttpStatus.OK);
	}
	
	@PostMapping("/mappers/{longUrl}")
	public ResponseEntity<String>  saveUrl(@PathVariable("longUrl")String longUrl) {
		return new ResponseEntity<>(mapperServiceImpl.saveUrl(longUrl),HttpStatus.OK);
		
	}
	
}
