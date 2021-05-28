package com.example.starWars.StarWars.controller;

import com.example.starWars.StarWars.dto.CharacterDTO;
import com.example.starWars.StarWars.services.CharaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starWars")
public class StarWarsController {

    @Autowired
    CharaterService charaterService;

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharacters (@PathVariable String name){
        return ResponseEntity.status(200).body(charaterService.findByName(name));
    }


}
