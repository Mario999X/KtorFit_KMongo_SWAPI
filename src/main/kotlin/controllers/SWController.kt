package controllers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import models.Personaje
import models.fromDTO
import repositories.CacheRepository
import repositories.KtorFitRepository
import repositories.MongoRepository

class SWController(
    private val cacheRepository: CacheRepository,
    private val mongoRepository: MongoRepository,
    private val ktorFitRepository: KtorFitRepository
) {
    suspend fun findById(id: String): Personaje? = withContext(Dispatchers.IO){
        var personajeSearch = cacheRepository.findById(id)
        if (personajeSearch == null) {
            personajeSearch = mongoRepository.findById(id)
            if (personajeSearch == null) {
                personajeSearch = ktorFitRepository.findById(id)?.fromDTO(id)
            }
        }
        return@withContext personajeSearch
    }

    suspend fun save(entity: Personaje) = withContext(Dispatchers.IO) {
        launch {
            cacheRepository.save(entity)
        }

        launch {
            mongoRepository.save(entity)
        }

        joinAll()
    }
}