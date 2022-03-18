package com.example.inteca.service;

import com.example.inteca.domain.Family;
import java.util.List;


public interface FamilyService {
    Family getFamily(Long Id);

    List<Family> getAll();
}
