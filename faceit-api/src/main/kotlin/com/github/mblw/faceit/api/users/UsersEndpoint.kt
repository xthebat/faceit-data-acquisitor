package com.github.mblw.faceit.api.users

import com.github.mblw.faceit.api.Faceit
import com.github.mblw.faceit.api.json.Json
import java.util.UUID

class UsersEndpoint(faceit: Faceit) {
    private val requests = faceit.requests("users", "v1")

    internal data class PlayerDetailsResponse(val payload: Json)

    fun playerDetailsByNickname(nickname: String) =
        requests.get<PlayerDetailsResponse>("nicknames/$nickname").payload.toPlayerDetails()

    fun playerDetailsById(id: String) =
        requests.get<PlayerDetailsResponse>("users/$id").payload.toPlayerDetails()

    fun playerDetailsById(id: UUID) = playerDetailsById(id.toString())
}