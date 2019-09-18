package com.trilogyed.rsvp.model;

import java.io.Serializable;
import java.util.Objects;

//This class must implement the Serializable interface so the caching framework can cache Rsvp objects.
// Serializable is a marker interface that indicates that an implementing class can be serialized and deserialized.
// Marker interfaces have no properties or defined methods.
public class Rsvp implements Serializable {
    private int id;
    private String guestName;
    private int totalAttending;

    public Rsvp() {

    }

    public Rsvp(String guestName, int totalAttending) {
        this.guestName = guestName;
        this.totalAttending = totalAttending;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getTotalAttending() {
        return totalAttending;
    }

    public void setTotalAttending(int totalAttending) {
        this.totalAttending = totalAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rsvp rsvp = (Rsvp) o;
        return id == rsvp.id &&
                totalAttending == rsvp.totalAttending &&
                Objects.equals(guestName, rsvp.guestName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guestName, totalAttending);
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", totalAttending=" + totalAttending +
                '}';
    }
}
