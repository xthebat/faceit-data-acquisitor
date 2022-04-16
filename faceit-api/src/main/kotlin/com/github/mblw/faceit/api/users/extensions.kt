@file:Suppress("NOTHING_TO_INLINE")

package com.github.mblw.faceit.api.users

import com.github.mblw.faceit.api.json.*
import com.github.mblw.faceit.api.users.descs.PlayerDetails
import com.github.mblw.faceit.api.users.enums.PlayerGender
import ru.inforion.lab403.common.uuid.toUUID


fun Json.toPlayerDetails() = PlayerDetails(
    id = uuid("id"),
    activatedAt = date("activated_at"),
    createdAt = dateOrNull("created_at"),

    avatar = urlOrNull("avatar"),
    coverImageUrl = urlOrNull("cover_image_url"),

    createdBy = stringOrNull("created_by"),
    flag = string("flag"),
    country = string("country"),
    nickname = string("nickname"),
    phoneVerified = boolOrNull("phone_verified"),
    gender = enumOrElse("gender") { PlayerGender.unknown },
    friends = listOf<String>("friends").map { it.toUUID() },
    matchingSound = stringOrNull("matching_sound"),
    registrationStatus = string("registration_status"),
    status = enum("status"),
    userType = string("user_type"),
    timezone = stringOrNull("timezone"),
    version = int("version")
)