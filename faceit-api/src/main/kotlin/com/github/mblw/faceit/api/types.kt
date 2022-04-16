package com.github.mblw.faceit.api

import com.github.mblw.faceit.api.json.Json
import com.github.mblw.faceit.api.match.descs.MatchDetails
import com.github.mblw.faceit.api.match.descs.Roster
import com.github.mblw.faceit.api.stats.descs.MatchStats
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

// required for valid deserialization
class ListOfUUIDs : ArrayList<UUID>()
class ListOfJsons : ArrayList<Json>()
class ListOfMatchStats : ArrayList<MatchStats>()
class ListOfURLs : ArrayList<URL>()
class ListOfRosters : ArrayList<Roster>()
class ListOfMatchDetails : ArrayList<MatchDetails>()
