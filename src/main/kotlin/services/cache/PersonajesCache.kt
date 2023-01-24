package services.cache

import io.github.reactivecircus.cache4k.Cache
import models.Personaje
import kotlin.time.Duration.Companion.minutes


class PersonajesCache {

    val refreshTime = 20000

    val cache = Cache.Builder()
        .maximumCacheSize(10)
        .expireAfterAccess(1.minutes)
        .build<String, Personaje>()
}