package com.company.polymorphism;

public class App {

    public static void main(String[] args) {
        Developer dev = new Developer();
        TeamLead lead = new TeamLead();
        Architect arch = new Architect();

        // Use Intellisense to show all the methods and features that you'd expect
        // to see on these objects.

        Developer dev2 = new TeamLead();
        Developer dev3 = new Architect();

        // This doesn't work b/c Developer doesn't have a planSprint() method
        // dev2.planSprint();
        // This doesn't work b/c Developer doesn't have an evaluateVendor() method
        // dev3.evaluateVendor();

        TeamLead lead2;
        // This causes a problem b/c TeamLead has more features than Developer so the
        // compiler can't do this conversion for us
        // lead2 = dev2;

        // This works b/c the dev2 reference is pointing to a TeamLead.  We constructed
        // a TeamLead object, we just happened to point at it with a Developer reference.
        // Here we have to cast (i.e. tell the compiler how to treat he type of dev2) dev2
        // into a TeamLead type...and everything just works!
        lead2 = (TeamLead)dev2;
        lead2.planSprint();

        // Interface examples
        SchoolRecord record = new SchoolRecord();

        // This works because we can use an interface reference to point to an instance of a class
        // that implements that interface
        Auditable auditableRecord = record;
        Storable storableRecord = record;
    }
}
