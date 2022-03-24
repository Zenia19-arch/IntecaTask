package com.example.inteca.controller;

import com.example.inteca.component.FamilyApp;
import com.example.inteca.domain.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private FamilyApp familyApp;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Family> getFamily(@PathVariable Long id){

        // Checking the existence of a family under the specified number
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Returning the number of the created family
        return familyApp.getFamily(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createFamily(@RequestBody @Valid Family family){

        // Checking if the specified family is null
        if(family == null){
            return "Nie udało się stworzyć rodzine.";
        }

        // Checking if a family has been created with the specified parameters
        if(familyApp.createFamily(family))
            return "Numer utworzonej rodziny: " + family.getId();
        else
            return "Nie udało się stworzyć rodzine, ponieważ dane rodziny są niepoprawne.";


    }

}
