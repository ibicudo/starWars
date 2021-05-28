package com.example.starWars.StarWars.repository;

import com.example.starWars.StarWars.dto.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository{

    @Override
    public List<CharacterDTO> findByName(String name) {

        List<CharacterDTO> characters = new ArrayList<>();
        List<CharacterDTO> listCharacters = new ArrayList<>();

        characters = loadDataBase();
        CharacterDTO result = null;
        if(characters != null){
            listCharacters = characters.stream()
                    .filter(character -> character.getName().contains(name))
                    .collect(Collectors.toList());
        }

        return listCharacters;
    }

    private List<CharacterDTO> loadDataBase() {

        File file = null;
        List<CharacterDTO> characters = null;
        try{
            file = ResourceUtils.getFile("src/main/resources/starwars.json");

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<CharacterDTO>> typeRef = new TypeReference<List<CharacterDTO>>() {};

            characters = objectMapper.readValue(file, typeRef);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return characters;
    }


}
