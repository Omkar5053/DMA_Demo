package com.dma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answer_master")
public class AnswerMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long answer_id;
	
	@Column(name = "answer_name")
	private String answer_name;
}
