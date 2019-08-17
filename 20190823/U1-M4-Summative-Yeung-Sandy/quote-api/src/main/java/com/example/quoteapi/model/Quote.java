package com.example.quoteapi.model;

import javax.validation.constraints.*;

public class Quote {
    @NotEmpty
    @Size(min = 2, message = "Author name must be more than 2 characters.")
    public String author;
    @NotEmpty
    @Size(min = 2, message = "Quote must be more than 2 characters.")
    public String quote;

//    public Quote(String author, String quote){
//        this.author = author;
//        this.quote = quote;
//    }

    public Quote() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
