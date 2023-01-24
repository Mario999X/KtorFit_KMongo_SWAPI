package models

import dto.PersonajeDTO
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId

@Serializable
data class Personaje(
    @BsonId
    var id: String,
    val birth_year: String,
    val created: String,
    val edited: String,
    val eye_color: String,
    val films: List<String>,
    val gender: String,
    val hair_color: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val skin_color: String,
    val starships: List<String>,
    val url: String
)

fun PersonajeDTO.fromDTO(id: String): Personaje {
    return Personaje(
        id = id,
        birth_year,
        created,
        edited, eye_color, films, gender, hair_color, height, homeworld, mass, name, skin_color, starships, url
    )
}