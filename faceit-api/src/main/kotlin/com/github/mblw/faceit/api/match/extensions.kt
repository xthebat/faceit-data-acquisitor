@file:Suppress("NOTHING_TO_INLINE")

package com.github.mblw.faceit.api.match

import com.github.mblw.faceit.api.json.*
import com.github.mblw.faceit.api.match.descs.*
import ru.inforion.lab403.common.extensions.toURL
import java.util.UUID


val zeroGuid = UUID(0, 0)


fun Json.uuidBye(key: String) = if (string(key) == "bye") zeroGuid else uuid(key)


fun Json.toMatchTeams() = MatchTeams(
    faction1 = json("faction1").toFaction(),
    faction2 = json("faction2").toFaction(),
)

fun Json.toFaction() = Faction(
    id = uuidBye("id"),
    type = stringOrNull("type"),
    name = string("name"),
    avatar = urlOrNull("avatar"),
    leader = uuidOrNull("leader"),
    stats = jsonOrNull("stats")?.toFactionStats(),
    roster = listOfOrNull<Json>("roster")?.map { it.toRoster() } ?: listOf()
)

fun Json.toRoster() = Roster(
    id = uuidBye("id"),
    nickname = string("nickname"),
    avatar = urlOrNull("avatar"),
    gameId = string("gameId"),
    gameName = stringOrNull("gameName"),
    elo = double("elo"),
    gameSkillLevel = double("gameSkillLevel"),
    partyId = uuidOrNull("partyId")
)

fun Json.toFactionStats() = FactionStats(
    winProbability = double("winProbability"),
    rating = double("rating")
)

fun Json.toMatchDetails() = MatchDetails(
    id = string("id"),
    type = enum("type"),
    game = string("game"),
    region = string("region"),
    organizerId = string("organizerId"),
    calculateElo = bool("calculateElo"),
    state = enum("state"),
    teams = json("teams").toMatchTeams(),
    createdAt = date("createdAt"),
    startedAt = dateOrNull("startedAt"),
    demoURLs = listOfOrNull<String>("demoURLs")?.map { it.toURL() } ?: listOf()
)
