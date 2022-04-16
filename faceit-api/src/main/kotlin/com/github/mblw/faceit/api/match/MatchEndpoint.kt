package com.github.mblw.faceit.api.match

import com.github.mblw.faceit.api.Faceit
import com.github.mblw.faceit.api.ListOfJsons
import com.github.mblw.faceit.api.json.Json

class MatchEndpoint(faceit: Faceit) {
    private val requests = faceit.requests("match", "v2")

    data class MatchDetailsResponse(val payload: Json)
    data class ChampionshipMatchesResponse(val payload: ListOfJsons)

    fun matchDetails(matchId: String) =
        requests.get<MatchDetailsResponse>("match/$matchId")
            .payload.toMatchDetails()

    fun championshipMatches(championshipId: String) =
        requests.get<ChampionshipMatchesResponse>("match?entityId=$championshipId&entityType=championship")
            .payload.map { it.toMatchDetails() }
}