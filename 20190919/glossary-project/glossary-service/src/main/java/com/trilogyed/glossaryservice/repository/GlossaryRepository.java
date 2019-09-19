package com.trilogyed.glossaryservice.repository;

import com.trilogyed.glossaryservice.model.Glossary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlossaryRepository extends JpaRepository<Glossary, Integer> {
    List<Glossary> findDefinitionByTerm(String term);
}
