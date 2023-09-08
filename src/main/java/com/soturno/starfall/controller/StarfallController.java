package com.soturno.starfall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soturno.starfall.services.StarfallService;

@Controller
@RequestMapping("/starfall")
public class StarfallController {

	@Autowired
	StarfallService service;
	
	@GetMapping
	ResponseEntity<String> doThings() {
		String texto = service.getText();
		return ResponseEntity.ok(texto);
	}
}
