package com.company.polymorphism;

public class TeamLead extends Developer {

    public void planSprint() {
        System.out.println("Planning sprint. (TeamLead)");
    }

    public void assignWork(Developer dev) {
        System.out.println("Assigning work (Developer)");
    }

    public void estimateStoryPoints() {
        System.out.println("Estimating my story points (TeamLead)");
        System.out.println("Make sure everyone on my team has estimated their story points.");
    }
}