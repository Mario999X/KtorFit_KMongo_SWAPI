package repositories

interface CrudRepository<I, ID> {

    fun findAll(): List<I>

    suspend fun findById(id: ID): I?

    fun save(i: I): I

    fun delete(id: ID): Boolean

}