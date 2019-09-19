package com.trilogyed.glossaryservice.repository;

import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.model.Glossary;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GlossaryRepositoryTest {

    @Autowired
    GlossaryRepository repo;

    @Before
    public void setUp() throws Exception {
        List<Glossary> glossaryList = repo.findAll();
        for(Glossary g: glossaryList) {
            repo.delete(g);
        }
    }

    @Test
    public void findDefinitionByTerm(String term) {
        List<Glossary> termList = repo.findDefinitionByTerm(term);
        Set<Glossary> definitions = new HashSet<>(termList);


    }
}