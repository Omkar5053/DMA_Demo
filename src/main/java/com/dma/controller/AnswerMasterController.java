package com.dma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dma.entities.AnswerMaster;
import com.dma.repository.AnswerMasterRepository;

@RestController
@RequestMapping("/dma")
public class AnswerMasterController {

	@Autowired
	private AnswerMasterRepository answerMasterRepository;
	
	@PostMapping("/addAnswer")
	public ResponseEntity<String> addAnswer(@RequestBody AnswerMaster answer)
	{
		answerMasterRepository.save(answer);
		return new ResponseEntity<String> ("Answer Added..",HttpStatus.CREATED);
	}
}
