package com.kea.kommunalvalg.model;
import javax.persistence.*;

@Entity
@Table(name = "politikere")
public class Kommunalpolitiker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;
    @Column(name = "partyshort")
    private String partyShort;
    @Column(name = "partyname")
    private String partyName;
    private double votes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartyShort() {
        return partyShort;
    }

    public void setPartyShort(String partyShort) {
        this.partyShort = partyShort;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public double getVotes() {
        return votes;
    }

    public void setVotes(double votes) {
        this.votes = votes;
    }

    public Kommunalpolitiker() {
    }

    public Kommunalpolitiker(int id, String name, String partyShort, String partyName, double votes) {
        this.id = id;
        this.name = name;
        this.partyShort = partyShort;
        this.partyName = partyName;
        this.votes = votes;
    }
}