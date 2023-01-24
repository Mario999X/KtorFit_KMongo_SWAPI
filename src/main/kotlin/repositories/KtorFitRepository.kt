package repositories

import dto.PersonajeDTO
import services.ktorFit.KtorFitClient

class KtorFitRepository : CrudRepository<PersonajeDTO, String> {

    // Inyectamos dependencia
    private val client by lazy {
        KtorFitClient.instance
    }

    override fun findAll(): List<PersonajeDTO> {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun save(i: PersonajeDTO): PersonajeDTO {
        TODO("Not yet implemented")
    }

    override suspend fun findById(id: String): PersonajeDTO? {
        println("\t❤❤❤findById")
        return client.getById(id)
    }
}