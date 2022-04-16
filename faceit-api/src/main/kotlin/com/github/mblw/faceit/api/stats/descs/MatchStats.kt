package com.github.mblw.faceit.api.stats.descs

import com.github.mblw.faceit.api.stats.enums.MatchStatus
import java.util.*

data class MatchStats(
    val competitionId: UUID,

    val matchId: String,

    val createdAt: Date,
    val updatedAt: Date,

    val status: MatchStatus,
    val played: Int,

    val game: String,
    val gameMode: String,
    val playerId: UUID,

    val nickname: String,
    val elo: Int?,

    val map: String,
    val team: String?,
    val kills: Int,
    val assists: Int,
    val deaths: Int,
    val mvps: Int,
    val rounds: Int,
    val headshots: Int,
    val score: Pair<Int, Int>
)