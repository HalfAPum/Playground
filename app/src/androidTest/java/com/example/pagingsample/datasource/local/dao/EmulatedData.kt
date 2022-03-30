package com.example.pagingsample.datasource.local.dao

import com.example.pagingsample.model.local.character.Character
import com.example.pagingsample.model.local.character.CharacterLocation

object EmulatedData {

    val character = Character("70","Concerto","Dead","Humanoid","",
        "Male", CharacterLocation("unknown",""),"https://rickandmortyapi.com/api/character/avatar/70.jpeg",
        "2017-11-30T11:31:41.926Z")

    val characterList = listOf(
        Character("815","Punk Rick","Dead","Human","",
            "Male", CharacterLocation("Rick's Memories","https://rickandmortyapi.com/api/location/126"),
            "https://rickandmortyapi.com/api/character/avatar/815.jpeg", "2021-11-02T15:19:11.398Z"),
        Character("354","Toby Matthews","Alive","Human","",
            "Male", CharacterLocation("Earth (Replacement Dimension)","https://rickandmortyapi.com/api/location/20"),
            "https://rickandmortyapi.com/api/character/avatar/354.jpeg", "2018-01-10T18:02:03.402Z"),
        Character("759","Turkey Morty","Alive","Animal","Turkey",
            "Male", CharacterLocation("Earth (Replacement Dimension)","https://rickandmortyapi.com/api/location/20"),
            "https://rickandmortyapi.com/api/character/avatar/759.jpeg", "2021-10-17T15:01:58.524Z"),
    )

}