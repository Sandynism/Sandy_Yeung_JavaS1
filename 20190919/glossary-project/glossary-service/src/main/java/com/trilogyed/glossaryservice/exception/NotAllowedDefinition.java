package com.trilogyed.glossaryservice.exception;

public class NotAllowedDefinition extends RuntimeException {
    public NotAllowedDefinition(){
        super("The following terms may not be used: darn; drat; heck; jerk; butt.");
    }
}

