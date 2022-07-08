package com.dma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dma.entities.SectionMaster;
import com.dma.repository.SectionMasterRepository;

@RestController
@RequestMapping("/dma")
public class SectionMasterController {
	
	@Autowired
	private SectionMasterRepository sectionMasterRepository;
	
	@PostMapping("/addSection")
	public SectionMaster createSection(@RequestBody SectionMaster sectionMaster) {
		return sectionMasterRepository.save(sectionMaster);
	}
}
