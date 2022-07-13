package com.dma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dma.entities.QuestionMaster;
import org.springframework.data.repository.query.Param;

public interface QuestionMasterRepository extends JpaRepository<QuestionMaster, Long> {

	@Query(value = "SELECT * FROM question_master q where q.section_section_id=:section_section_id", nativeQuery = true)
	public List<QuestionMaster> findAllBySection_Section_id(@Param("section_section_id") long section_section_id);
}
