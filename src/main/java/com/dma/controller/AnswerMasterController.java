package com.dma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dma.entities.AnswerMaster;
import com.dma.repository.AnswerMasterRepository;

@RestController
@RequestMapping("/dma")
@CrossOrigin(origins = "*")
public class AnswerMasterController {

	@Autowired
	private AnswerMasterRepository answerMasterRepository;
	
	@GetMapping("/getAnswers")
	public List<AnswerMaster> getAnswers()
	{
		return answerMasterRepository.findAll();
	}
	
	@PostMapping("/addAnswer")
	public ResponseEntity<String> addAnswer(@RequestBody AnswerMaster answer)
	{
		answerMasterRepository.save(answer);
		return new ResponseEntity<String> ("Answer Added..",HttpStatus.CREATED);
	}
}
