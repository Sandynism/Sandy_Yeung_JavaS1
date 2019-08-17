package com.example.wordapi.model;

import javax.validation.constraints.*;

public class Definition {
    @NotEmpty(message="Must not be empty.")
    @Size(min=1, message="Word must be more than 1 character.")
    public String word;
    @NotEmpty(message="Must not be empty.")
    @Size(min=5, message="Definition must be more than 5 characters.")
    public String definition;

    public Definition() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}
