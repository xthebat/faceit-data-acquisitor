package com.github.mblw.faceit.api.match.descs

import java.net.URL
import java.util.*

data class Roster(
    val id: UUID?,
    val nickname: String,
    val avatar: URL?,
    val gameId: String,
    val gameName: String?,
    val elo: Double,
    val gameSkillLevel: Double,
    val partyId: UUID?
)