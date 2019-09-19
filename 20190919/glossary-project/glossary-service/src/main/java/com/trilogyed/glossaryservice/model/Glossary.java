package com.trilogyed.glossaryservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "glossary")
public class Glossary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "Glossary", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private Set<Definition> definitions;

    public Glossary(Integer id, Definition... definitions) {
        this.id = id;
        this.definitions = Stream.of(definitions).collect(Collectors.toSet());
        this.definitions.forEach(def -> def.setDefinition(this));
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Set<Definition> definitions) {
        this.definitions = definitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glossary glossary = (Glossary) o;
        return getId().equals(glossary.getId()) &&
                getDefinitions().equals(glossary.getDefinitions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDefinitions());
    }






}
