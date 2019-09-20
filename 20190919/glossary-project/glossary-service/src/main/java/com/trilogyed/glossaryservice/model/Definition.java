package com.trilogyed.glossaryservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "definition")
public class Definition extends Glossary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String term;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Glossary definition;

    public Definition(Integer id, Definition... definitions) {
        super(id, definitions);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Glossary getDefinition() {
        return definition;
    }

    public void setDefinition(Glossary definition) {
        this.definition = definition;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Definition that = (Definition) o;
        return getId().equals(that.getId()) &&
                getTerm().equals(that.getTerm()) &&
                getDefinition().equals(that.getDefinition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getTerm(), getDefinition());
    }




}

