package com.example.inteca.service;

import com.example.inteca.domain.FamilyMember;
import com.example.inteca.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService{

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Override
    public void createFamilyMember(FamilyMember familyMember) {
        familyMemberRepository.save(familyMember);
    }

}
