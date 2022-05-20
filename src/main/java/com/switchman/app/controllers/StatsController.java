package com.switchman.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.switchman.app.dto.StatsDTO;
import com.switchman.app.services.StatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/stats")
public class StatsController {

	@Autowired
	protected StatsService statsService;

	@Autowired
	protected ObjectMapper objectMapper;

	@GetMapping
	public ResponseEntity<String> GetStats() throws JsonProcessingException {
		try {
		StatsDTO stats = statsService.getStats();
		String body = objectMapper.writeValueAsString(stats);
		return ResponseEntity.ok(body);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}