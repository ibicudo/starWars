package com.example.starWars.StarWars.services;

import com.example.starWars.StarWars.dto.CharacterDTO;

import java.util.List;

public interface CharaterService {
    public List<CharacterDTO> findByName(String name);
}
