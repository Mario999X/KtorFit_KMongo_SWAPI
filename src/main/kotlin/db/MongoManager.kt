package db

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

object MongoManager {
    private lateinit var mongoClient: MongoClient
    lateinit var database: MongoDatabase

    init {
        println("Iniciando Mongo")

        mongoClient = KMongo.createClient("mongodb://mongoadmin:mongopass@localhost/starWarsTest?authSource=admin")
        database = mongoClient.getDatabase("starWarsTest")
    }
}