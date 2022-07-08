package com.dma.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "section_master")
public class SectionMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long section_id;
	
	@Column(name = "section_name")
	private String section_name;
	
	@OneToMany
	@JoinTable(name = "section_questionmaster",
	joinColumns = @JoinColumn(name = "section_id"),
    inverseJoinColumns = @JoinColumn(name = "section_questions_question_id"))
	private List<QuestionMaster> questions;
}
