package com.example.inteca.component;

import com.example.inteca.domain.FamilyMember;
import com.example.inteca.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FamilyMemberApp {

    @Autowired
    private FamilyMemberService familyMemberService;

    // Function "createFamilyMember" is designed to create a family member
    // The function takes one parameter - an object of FamilyMember type
    public void createFamilyMember(FamilyMember familyMember){

        // The family member is saved to the family member database
        this.familyMemberService.createFamilyMember(familyMember);
    }

}
