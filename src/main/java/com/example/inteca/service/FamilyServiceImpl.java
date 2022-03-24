package com.example.inteca.service;

import com.example.inteca.domain.Family;
import com.example.inteca.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements FamilyService{

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public Family getFamily(Long Id) {
        return familyRepository.findById(Id).get();
    }

    @Override
    public void createFamily(Family family) {
        familyRepository.save(family);
    }
}
