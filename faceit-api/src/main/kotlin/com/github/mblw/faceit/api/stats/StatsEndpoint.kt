package com.github.mblw.faceit.api.stats

import com.github.mblw.faceit.api.Faceit
import com.github.mblw.faceit.api.ListOfJsons
import ru.inforion.lab403.common.extensions.sequence
import java.util.UUID

class StatsEndpoint(faceit: Faceit) {
    private val requests = faceit.requests("stats", "v1")

    private fun playerMatchesStatsRequest(playerId: UUID, game: String = "csgo", page: Int = 0, size: Int = 0) =
        requests.get<ListOfJsons>("stats/time/users/$playerId/games/$game?page=$page&size=$size")

    fun playerMatchesStats(playerId: UUID, size: Int = 0, game: String = "csgo") = sequence {
        var page = 0
        var index = 0
        while (true) {
            val response = playerMatchesStatsRequest(playerId, game, page, 0)
            if (response.isEmpty()) return@sequence
            response.forEach {
                yield(it.toMatchStats())
                if (size > 0 && ++index == size) return@sequence
            }
            page++
        }
    }
}