package com.github.mblw.faceit.api

import com.github.mblw.faceit.api.match.MatchEndpoint
import com.github.mblw.faceit.api.stats.StatsEndpoint
import com.github.mblw.faceit.api.users.UsersEndpoint
import ru.inforion.lab403.common.krest.Krest

class Faceit(private val baseUrl: String = FACEIT_API_URL) {
    internal fun requests(endpoint: String, version: String) = Krest("$baseUrl/$endpoint/$version")

    val users = UsersEndpoint(this)
    val stats = StatsEndpoint(this)
    val match = MatchEndpoint(this)
}