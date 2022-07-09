package com.dma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_responsemaster")
public class CustomerResponseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerResponseId; 
	
	@OneToOne
	@JoinColumn(name = "answer_id")
	private AnswerMaster answer;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerMaster customer;
	
	@OneToOne
	@JoinColumn(name = "question_id")
	private QuestionMaster question;
	
	@OneToOne
	@JoinColumn(name = "section_id")
	private SectionMaster section;
}
