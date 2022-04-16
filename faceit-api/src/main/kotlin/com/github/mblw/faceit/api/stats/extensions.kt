@file:Suppress("NOTHING_TO_INLINE")

package com.github.mblw.faceit.api.stats

import com.github.mblw.faceit.api.FACEIT_PREMIUM_5v5_COMPETITION_ID
import com.github.mblw.faceit.api.FACEIT_RANKED_5v5_COMPETITION_ID
import com.github.mblw.faceit.api.json.*
import com.github.mblw.faceit.api.stats.descs.MatchStats
import ru.inforion.lab403.common.extensions.int
import ru.inforion.lab403.common.extensions.splitBy

fun String.toScore() = splitBy("/").map { it.int }.run { this[0] to this[1] }

fun Json.toMatchStats() = MatchStats(
    competitionId = uuid("competitionId"),
    matchId = string("matchId"),
    createdAt = timestamp("created_at"),
    updatedAt = timestamp("updated_at"),
    status = enum("status"),
    played = string2int("played"),
    game = string("game"),
    gameMode = string("gameMode"),
    playerId = uuid("playerId"),
    nickname = string("nickname"),
    elo = string2intOrNull("elo"),
    map = string("i1"),
    team = string("i5"),
    kills = string2int("i6"),
    assists = string2int("i7"),
    deaths = string2int("i8"),
    mvps = string2int("i10"),
    rounds = string2int("i12"),
    headshots = string2int("i13"),
    score = string("i18").toScore()
)

fun MatchStats.isFaceitRanked5v5() = competitionId == FACEIT_RANKED_5v5_COMPETITION_ID ||
        competitionId == FACEIT_PREMIUM_5v5_COMPETITION_ID