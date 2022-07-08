package com.dma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dma.entities.QuestionMaster;
import com.dma.repository.QuestionMasterRepository;



@RestController
@RequestMapping("/dma")
public class QuestionMasterController {
	
	@Autowired
	private QuestionMasterRepository questionMasterRepository;
	
	@PostMapping("/addQuestion")
	public QuestionMaster createQuestion(@RequestBody QuestionMaster questionMaster) {
		return questionMasterRepository.save(questionMaster);
	}
}
