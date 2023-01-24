package repositories

import db.MongoManager
import models.Personaje
import org.litote.kmongo.findOneById
import org.litote.kmongo.getCollection
import org.litote.kmongo.save

class MongoRepository : CrudRepository<Personaje, String> {

    override fun findAll(): List<Personaje> {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun save(i: Personaje): Personaje {
        println("\t🧡🧡save")
        MongoManager.database.getCollection<Personaje>().save(i)
        return i
    }

    override suspend fun findById(id: String): Personaje? {
        println("\t❤❤findById")
        return MongoManager.database.getCollection<Personaje>().findOneById(id)
    }

}