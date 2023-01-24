import controllers.SWController
import db.MongoManager
import kotlinx.coroutines.runBlocking
import models.Personaje
import org.litote.kmongo.getCollection
import repositories.CacheRepository
import repositories.KtorFitRepository
import repositories.MongoRepository
import services.cache.PersonajesCache

private val cache = PersonajesCache()
private val controller = SWController(CacheRepository(cache), MongoRepository(), KtorFitRepository())

fun main() = runBlocking {

    limpiarDatos()

    while (true) {
        println(
            """
        1. Buscar Personaje
    """.trimIndent()
        )
        val data1 = readln()

        if (data1 == "1") {
            println("ID: ")
            val data2 = readln()

            val personaje = controller.findById(data2)
            if (personaje != null) {
                controller.save(personaje)
                println(
                    """
            -----------
            $personaje
            -----------
        """.trimIndent()
                )
            }
        }
    }

}

private fun limpiarDatos() {
    if (MongoManager.database.getCollection<Personaje>().countDocuments() > 0) {
        MongoManager.database.getCollection<Personaje>().drop()
    }
}