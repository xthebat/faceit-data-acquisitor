@file:Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST")

package com.github.mblw.faceit.api.json

import ru.inforion.lab403.common.extensions.*
import ru.inforion.lab403.common.uuid.toUUID
import java.util.*

inline fun Json.string(key: String) = getValue(key) as String
inline fun Json.stringOrNull(key: String) = get(key) as String?

inline fun Json.int(key: String) = getValue(key) as Int
inline fun Json.long(key: String) = getValue(key) as Long
inline fun Json.float(key: String) = getValue(key) as Float

inline fun Json.double(key: String) = when (val value = getValue(key)) {
    is Double -> value
    is Int -> value.double
    is String -> value.double
    else -> error("Can't convert to double from ${value::class}")
}

inline fun Json.bool(key: String) = getValue(key) as Boolean
inline fun Json.boolOrNull(key: String) = get(key) as Boolean?

inline fun Json.json(key: String) = getValue(key) as Json
inline fun Json.jsonOrNull(key: String) = get(key) as Json?

//inline fun Json.list(key: String) = getValue(key) as List<*>
inline fun <T> Json.listOf(key: String) = getValue(key) as List<T>
inline fun <T> Json.listOfOrNull(key: String) = get(key) as List<T>?

inline fun <reified T: Enum<T>> Json.enum(key: String) = string(key).toEnum<T>()
inline fun <reified T: Enum<T>> Json.enumOrNull(key: String) = stringOrNull(key)?.toEnum<T>()
inline fun <reified T: Enum<T>> Json.enumOrElse(key: String, default: () -> T) =
    stringOrNull(key)?.toEnum() ?: default()

inline fun Json.uuid(key: String) = string(key).toUUID()
inline fun Json.uuidOrNull(key: String) = stringOrNull(key)?.toUUID()

inline fun Json.timestamp(key: String) = Date(long(key))

inline fun Json.date(key: String) = string(key).toDate()
inline fun Json.dateOrNull(key: String) = stringOrNull(key)?.toDate()

inline fun Json.url(key: String) = string(key).toURL()
inline fun Json.urlOrNull(key: String) = stringOrNull(key)?.toURL()

inline fun Json.string2int(key: String) = string(key).int

inline fun Json.string2intOrNull(key: String) = stringOrNull(key)?.int



