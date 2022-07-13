package com.dma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dma.entities.QuestionMaster;
import com.dma.entities.SectionMaster;
import com.dma.repository.QuestionMasterRepository;



@RestController
@RequestMapping("/dma")
@CrossOrigin(origins = "*")
public class QuestionMasterController {
	
	@Autowired
	private QuestionMasterRepository questionMasterRepository;
	
	@GetMapping("/getQuestionsBySectionId/{id}")
	public List<QuestionMaster> getAllSection(@PathVariable (value = "id") long section_id)
	{
		return questionMasterRepository.findAllBySection_Section_id(section_id);
	}
	
	@PostMapping("/addQuestion") 
	public QuestionMaster createQuestion(@RequestBody QuestionMaster questionMaster) {
		return questionMasterRepository.save(questionMaster);
	}
	
	
}
