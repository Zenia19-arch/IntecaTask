package com.example.inteca.service;

import com.example.inteca.domain.Family;


public interface FamilyService {
    Family getFamily(Long Id);

    void createFamily(Family family);
}
