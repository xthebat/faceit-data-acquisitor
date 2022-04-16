package com.github.mblw.faceit.api.match.descs

import java.net.URL
import java.util.*

data class Faction(
    val id: UUID,
    val type: String?,
    val name: String,
    val avatar: URL?,
    val leader: UUID?,
    val stats: FactionStats?,
    val roster: List<Roster>
)