package services.ktorFit

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import dto.PersonajeDTO

interface KtorFitRest {

    @GET("people/{id}/")
    suspend fun getById(@Path("id") id: String): PersonajeDTO

}