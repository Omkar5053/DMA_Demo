package com.dma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dma.entities.QuestionMaster;
import com.dma.entities.SectionMaster;
import com.dma.repository.QuestionMasterRepository;
import com.dma.repository.SectionMasterRepository;

@RestController
@RequestMapping("/dma")
@CrossOrigin(origins = "*")
public class SectionMasterController {
	
	@Autowired
	private SectionMasterRepository sectionMasterRepository;
	
	@Autowired
	private QuestionMasterRepository questionMasterRepository;
	
	@GetMapping("/getSections")
	public List<SectionMaster> getAllSection()
	{
		return sectionMasterRepository.findAll();
	}
	
	@PostMapping("/addSection")
	public SectionMaster createSection(@RequestBody SectionMaster sectionMaster) {
		return sectionMasterRepository.save(sectionMaster);
	}
	
	@PostMapping("/addQuestionBySection")
	public ResponseEntity<String> addQuestion(@RequestParam long sectionId,
											 @RequestParam long questionId)
	{
		//Optional<SectionMaster> section = sectionMasterRepository.findById(sectionId);
		Optional<SectionMaster> section = sectionMasterRepository.findById(sectionId);
		if(section.isPresent())
		{
			QuestionMaster question = questionMasterRepository.getById(questionId);
			List<QuestionMaster> list = new ArrayList<QuestionMaster>(); 
			list.add(question);
			section.get().setQuestions(list);
			sectionMasterRepository.save(section.get());
		}
		return new ResponseEntity<String>("Question Added Successfuly",HttpStatus.CREATED);
	}
}
