package com.example.inteca.component;

import com.example.inteca.domain.Family;
import com.example.inteca.domain.FamilyMember;
import com.example.inteca.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FamilyApp {

    @Autowired
    private FamilyService familyService;
    @Autowired
    private FamilyMemberApp familyMemberApp;

    // Function "createFamily" is designed to create a family
    // The function takes one parameter - an object of Family type
    public boolean createFamily(Family family){

        // Checking whether the family data is correct
        if(validateFamilyData(family)){

            // Each member of the family is called in turn
            for(FamilyMember familyMember : family.getFamilyId()){

                // Each family member is given a family number
                familyMember.setFamilyId(family);

                // Each family member is saved to the family members database
                familyMemberApp.createFamilyMember(familyMember);

            }

            // The family is saved to the family database
            this.familyService.createFamily(family);

            return true;
        }

        // If the family data is not correct - return false
        return false;
    }


    // Family Data Validation Function with one parameter - "Family" type object
    public boolean validateFamilyData(Family family){

        // Declaring infant, child and adult variables and giving them a start value of 0
        int infants = 0;
        int children = 0;
        int adults = 0;

        for(FamilyMember familyMember : family.getFamilyId()){

            // Checking the age of each member
            if(familyMember.getAge() >= 0 && familyMember.getAge() <= 4)
                infants++;
            else if(familyMember.getAge() > 4 && familyMember.getAge() <= 16)
                children++;
            else
                adults++;

        }

        // Checking the number of infants, children and adults with data sent to the family
        if(infants == family.getNrOfInfants()
            && children == family.getNrOfChildren()
            && adults == family.getNrOfAdults()){
            return true;
        }

        return false;
    }


    // The "createFamily" function is for returning a family
    // The function takes one parameter - the family number of the Long type
    public ResponseEntity<Family> getFamily(Long id){

        // Checking the existence of a family under the specified number
        if(id == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Getting a family with a specified number
        Family family = this.familyService.getFamily(id);

        // Checking if the specified family is null
        if(family == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(family, HttpStatus.OK);
    }

}
