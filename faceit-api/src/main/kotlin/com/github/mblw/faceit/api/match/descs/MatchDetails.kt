package com.github.mblw.faceit.api.match.descs

import com.github.mblw.faceit.api.match.enums.MatchState
import com.github.mblw.faceit.api.match.enums.MatchType
import java.net.URL
import java.util.*

data class MatchDetails(
    val id: String,
    val type: MatchType,
    val game: String,
    val region: String,
    val organizerId: String,
    val calculateElo: Boolean,
    val state: MatchState,
    val teams: MatchTeams,
    val createdAt: Date,
    val startedAt: Date?,
    val demoURLs: List<URL>
)

