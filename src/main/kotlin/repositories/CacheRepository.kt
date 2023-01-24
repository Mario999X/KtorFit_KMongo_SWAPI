package repositories

import kotlinx.coroutines.*
import models.Personaje
import services.cache.PersonajesCache

class CacheRepository(
    private val cache: PersonajesCache
) : CrudRepository<Personaje, String> {
    private var refreshJob: Job? = null

    private val listaBusquedas = mutableListOf<Personaje>()

    init {
        refreshCache()
    }

    private fun refreshCache() {
        if (refreshJob != null) refreshJob?.cancel()

        refreshJob = CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                if (listaBusquedas.isNotEmpty()) {
                    listaBusquedas.forEach {
                        cache.cache.put(it.id, it)
                    }

                    listaBusquedas.clear()
                    println("\tCache actualizado: ${cache.cache.asMap().size}")
                }

                println("\tCache actual: ${cache.cache.asMap().size}")
                delay(cache.refreshTime.toLong())
            }
        }
    }

    override fun findAll(): List<Personaje> {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun save(i: Personaje): Personaje {
        println("\t🧡save")
        listaBusquedas.add(i)
        return i
    }

    override suspend fun findById(id: String): Personaje? {
        println("\t❤findById")
        return cache.cache.get(id)
    }
}