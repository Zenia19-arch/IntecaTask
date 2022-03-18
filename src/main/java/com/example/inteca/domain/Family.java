package com.example.inteca.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Family_DB")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String familyName;
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;

    @OneToMany(mappedBy = "familyId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FamilyMember> familyId;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<FamilyMember> getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Set<FamilyMember> familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(int nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public int getNrOfChildren() {
        return nrOfChildren;
    }

    public void setNrOfChildren(int nrOfChildren) {
        this.nrOfChildren = nrOfChildren;
    }

    public int getNrOfInfants() {
        return nrOfInfants;
    }

    public void setNrOfInfants(int nrOfInfants) {
        this.nrOfInfants = nrOfInfants;
    }
}
