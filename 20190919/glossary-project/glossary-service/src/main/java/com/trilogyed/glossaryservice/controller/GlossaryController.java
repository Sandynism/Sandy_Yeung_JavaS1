package com.trilogyed.glossaryservice.controller;

import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.model.Glossary;
import com.trilogyed.glossaryservice.repository.GlossaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GlossaryController {

    @Autowired
    GlossaryRepository repo;

    @RequestMapping(value="/glossary/term/{term}", method = RequestMethod.GET)
    public List<Glossary> getDefinitionsForTerm(@PathVariable(name="term") String term) {
        return repo.findDefinitionByTerm(term);
    }

    @RequestMapping(value="/glossary", method = RequestMethod.POST)
    public Definition addDefinition(@RequestBody Definition definition) {
        return repo.save(definition);
    }
}
