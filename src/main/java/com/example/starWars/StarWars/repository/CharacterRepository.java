package com.example.starWars.StarWars.repository;

import com.example.starWars.StarWars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {

    public List<CharacterDTO> findByName(String name);
}
