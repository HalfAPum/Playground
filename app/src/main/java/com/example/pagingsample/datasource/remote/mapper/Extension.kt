package com.example.pagingsample.datasource.remote.mapper

import com.example.CharactersPagingQuery
import com.example.EpisodesPagingQuery
import com.example.LocationsPagingQuery
import com.example.pagingsample.model.Character
import com.example.pagingsample.model.Episode
import com.example.pagingsample.model.Location

fun CharactersPagingQuery.Data.map() = characters.results.mapCharacters()

private fun List<CharactersPagingQuery.Result>.mapCharacters() = map { it.toCharacter() }

private fun CharactersPagingQuery.Result.toCharacter(): Character {
    return Character(id, name)
}

fun LocationsPagingQuery.Data.map() = locations.results.mapLocations()

private fun List<LocationsPagingQuery.Result>.mapLocations() = map { it.toLocation() }

private fun LocationsPagingQuery.Result.toLocation(): Location {
    return Location(id, name)
}

fun EpisodesPagingQuery.Data.map() = episodes.results.mapEpisodes()

private fun List<EpisodesPagingQuery.Result>.mapEpisodes() = map { it.toEpisode() }

private fun EpisodesPagingQuery.Result.toEpisode(): Episode {
    return Episode(id, name)
}
