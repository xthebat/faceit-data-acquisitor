package com.github.mblw.faceit.api.users.descs

import com.github.mblw.faceit.api.users.enums.PlayerGender
import com.github.mblw.faceit.api.users.enums.PlayerStatus
import java.net.URL
import java.util.Date
import java.util.UUID


data class PlayerDetails(
    val id: UUID,
    val activatedAt: Date,
    val avatar: URL?,
    val coverImageUrl: URL?,
    val createdAt: Date?,
    val createdBy: String?,
    val flag: String,
    val country: String,
    val nickname: String,
    val phoneVerified: Boolean?,
    val gender: PlayerGender?,
    val friends: List<UUID>,
    val matchingSound: String?,
    val registrationStatus: String,
    val status: PlayerStatus,
    val userType: String,
    val timezone: String?, // maybe float or something else for +3 => 3.0
    val version: Int
)
