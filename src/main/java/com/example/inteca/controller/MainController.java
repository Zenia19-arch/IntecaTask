package com.example.inteca.controller;

import com.example.inteca.domain.Family;
import com.example.inteca.domain.FamilyMember;
import com.example.inteca.repository.FamilyMemberRepository;
import com.example.inteca.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private FamilyService familyService;
    @Autowired
    FamilyMemberRepository familyMemberRepository;


    @RequestMapping(value = "{Id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Family> getFamily(@PathVariable Long Id){
        if(Id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Family family = this.familyService.getFamily(Id);

        if(family == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(family, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Family>> getAllFamily(){
        List<Family> family = this.familyService.getAll();

        if(family.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(family,HttpStatus.OK);
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<FamilyMember> getAllUsers() {
        // This returns a JSON or XML with the users
        return familyMemberRepository.findAll();
    }

}
