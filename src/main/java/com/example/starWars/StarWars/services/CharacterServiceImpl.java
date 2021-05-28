package com.example.starWars.StarWars.services;


import com.example.starWars.StarWars.dto.CharacterDTO;
import com.example.starWars.StarWars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharaterService{
    public final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @Override
    public List<CharacterDTO> findByName(String name) {
        return characterRepository.findByName(name);
    }
}
