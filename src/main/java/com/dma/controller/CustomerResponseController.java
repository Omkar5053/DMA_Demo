package com.dma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dma.entities.CustomerResponseMaster;
import com.dma.repository.AnswerMasterRepository;
import com.dma.repository.CustomerMasterRepository;
import com.dma.repository.CustomerResponseRepository;
import com.dma.repository.QuestionMasterRepository;
import com.dma.repository.SectionMasterRepository;

@RestController
@RequestMapping("/dma")
public class CustomerResponseController {

	@Autowired
	private CustomerResponseRepository customerResponseRepository;
	@Autowired
	private AnswerMasterRepository answerMasterRepository;
	@Autowired
	private QuestionMasterRepository questionMasterRepository;
	@Autowired
	private CustomerMasterRepository customerMasterRepository;
	@Autowired
	private SectionMasterRepository sectionMasterRepository;
	
	@PostMapping("/addResponse")
	public ResponseEntity<String> addCustomerReponse(@RequestParam long answer_id,
													@RequestParam long question_id,
													@RequestParam long customer_id,
													@RequestParam long section_id)
	{
		CustomerResponseMaster response = new CustomerResponseMaster();
		
		response.setAnswer(answerMasterRepository.getById(answer_id));
		response.setQuestion(questionMasterRepository.getById(question_id));
		response.setCustomer(customerMasterRepository.getById(customer_id));
		response.setSection(sectionMasterRepository.getById(section_id));
		
		customerResponseRepository.save(response);
		return new ResponseEntity<String>("Response added..",HttpStatus.OK);
	}
}
