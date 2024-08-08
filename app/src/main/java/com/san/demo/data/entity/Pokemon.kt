package com.san.demo.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    @SerialName("abilities")
    val abilities: List<Ability?>? = null,
    @SerialName("base_experience")
    val baseExperience: Int? = null,
    @SerialName("cries")
    val cries: Cries? = null,
    @SerialName("forms")
    val forms: List<Form?>? = null,
    @SerialName("game_indices")
    val gameIndices: List<GameIndice?>? = null,
    @SerialName("height")
    val height: Int? = null,
    @SerialName("held_items")
    val heldItems: List<String?>? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("is_default")
    val isDefault: Boolean? = null,
    @SerialName("location_area_encounters")
    val locationAreaEncounters: String? = null,
    @SerialName("moves")
    val moves: List<Move?>? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("order")
    val order: Int? = null,
    @SerialName("past_abilities")
    val pastAbilities: List<String?>? = null,
    @SerialName("past_types")
    val pastTypes: List<String?>? = null,
    @SerialName("species")
    val species: Species? = null,
    @SerialName("sprites")
    val sprites: Sprites? = null,
    @SerialName("stats")
    val stats: List<Stat?>? = null,
    @SerialName("types")
    val types: List<Type?>? = null,
    @SerialName("weight")
    val weight: Int? = null
) {
    @Serializable
    data class Ability(
        @SerialName("ability")
        val ability: Ability? = null,
        @SerialName("is_hidden")
        val isHidden: Boolean? = null,
        @SerialName("slot")
        val slot: Int? = null
    ) {
        @Serializable
        data class Ability(
            @SerialName("name")
            val name: String? = null,
            @SerialName("url")
            val url: String? = null
        )
    }

    @Serializable
    data class Cries(
        @SerialName("latest")
        val latest: String? = null,
        @SerialName("legacy")
        val legacy: String? = null
    )

    @Serializable
    data class Form(
        @SerialName("name")
        val name: String? = null,
        @SerialName("url")
        val url: String? = null
    )

    @Serializable
    data class GameIndice(
        @SerialName("game_index")
        val gameIndex: Int? = null,
        @SerialName("version")
        val version: Version? = null
    ) {
        @Serializable
        data class Version(
            @SerialName("name")
            val name: String? = null,
            @SerialName("url")
            val url: String? = null
        )
    }

    @Serializable
    data class Move(
        @SerialName("move")
        val move: Move? = null,
        @SerialName("version_group_details")
        val versionGroupDetails: List<VersionGroupDetail?>? = null
    ) {
        @Serializable
        data class Move(
            @SerialName("name")
            val name: String? = null,
            @SerialName("url")
            val url: String? = null
        )

        @Serializable
        data class VersionGroupDetail(
            @SerialName("level_learned_at")
            val levelLearnedAt: Int? = null,
            @SerialName("move_learn_method")
            val moveLearnMethod: MoveLearnMethod? = null,
            @SerialName("version_group")
            val versionGroup: VersionGroup? = null
        ) {
            @Serializable
            data class MoveLearnMethod(
                @SerialName("name")
                val name: String? = null,
                @SerialName("url")
                val url: String? = null
            )

            @Serializable
            data class VersionGroup(
                @SerialName("name")
                val name: String? = null,
                @SerialName("url")
                val url: String? = null
            )
        }
    }

    @Serializable
    data class Species(
        @SerialName("name")
        val name: String? = null,
        @SerialName("url")
        val url: String? = null
    )

    @Serializable
    data class Sprites(
        @SerialName("back_default")
        val backDefault: String? = null,
        @SerialName("back_female")
        val backFemale: String? = null,
        @SerialName("back_shiny")
        val backShiny: String? = null,
        @SerialName("back_shiny_female")
        val backShinyFemale: String? = null,
        @SerialName("front_default")
        val frontDefault: String? = null,
        @SerialName("front_female")
        val frontFemale: String? = null,
        @SerialName("front_shiny")
        val frontShiny: String? = null,
        @SerialName("front_shiny_female")
        val frontShinyFemale: String? = null,
        @SerialName("other")
        val other: Other? = null,
        @SerialName("versions")
        val versions: Versions? = null
    ) {
        @Serializable
        data class Other(
            @SerialName("dream_world")
            val dreamWorld: DreamWorld? = null,
            @SerialName("home")
            val home: Home? = null,
            @SerialName("official-artwork")
            val officialArtwork: OfficialArtwork? = null,
            @SerialName("showdown")
            val showdown: Showdown? = null
        ) {
            @Serializable
            data class DreamWorld(
                @SerialName("front_default")
                val frontDefault: String? = null,
                @SerialName("front_female")
                val frontFemale: String? = null
            )

            @Serializable
            data class Home(
                @SerialName("front_default")
                val frontDefault: String? = null,
                @SerialName("front_female")
                val frontFemale: String? = null,
                @SerialName("front_shiny")
                val frontShiny: String? = null,
                @SerialName("front_shiny_female")
                val frontShinyFemale: String? = null
            )

            @Serializable
            data class OfficialArtwork(
                @SerialName("front_default")
                val frontDefault: String? = null,
                @SerialName("front_shiny")
                val frontShiny: String? = null
            )

            @Serializable
            data class Showdown(
                @SerialName("back_default")
                val backDefault: String? = null,
                @SerialName("back_female")
                val backFemale: String? = null,
                @SerialName("back_shiny")
                val backShiny: String? = null,
                @SerialName("back_shiny_female")
                val backShinyFemale: String? = null,
                @SerialName("front_default")
                val frontDefault: String? = null,
                @SerialName("front_female")
                val frontFemale: String? = null,
                @SerialName("front_shiny")
                val frontShiny: String? = null,
                @SerialName("front_shiny_female")
                val frontShinyFemale: String? = null
            )
        }

        @Serializable
        data class Versions(
            @SerialName("generation-i")
            val generationI: GenerationI? = null,
            @SerialName("generation-ii")
            val generationIi: GenerationIi? = null,
            @SerialName("generation-iii")
            val generationIii: GenerationIii? = null,
            @SerialName("generation-iv")
            val generationIv: GenerationIv? = null,
            @SerialName("generation-v")
            val generationV: GenerationV? = null,
            @SerialName("generation-vi")
            val generationVi: GenerationVi? = null,
            @SerialName("generation-vii")
            val generationVii: GenerationVii? = null,
            @SerialName("generation-viii")
            val generationViii: GenerationViii? = null
        ) {
            @Serializable
            data class GenerationI(
                @SerialName("red-blue")
                val redBlue: RedBlue? = null,
                @SerialName("yellow")
                val yellow: Yellow? = null
            ) {
                @Serializable
                data class RedBlue(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_gray")
                    val backGray: String? = null,
                    @SerialName("back_transparent")
                    val backTransparent: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_gray")
                    val frontGray: String? = null,
                    @SerialName("front_transparent")
                    val frontTransparent: String? = null
                )

                @Serializable
                data class Yellow(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_gray")
                    val backGray: String? = null,
                    @SerialName("back_transparent")
                    val backTransparent: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_gray")
                    val frontGray: String? = null,
                    @SerialName("front_transparent")
                    val frontTransparent: String? = null
                )
            }

            @Serializable
            data class GenerationIi(
                @SerialName("crystal")
                val crystal: Crystal? = null,
                @SerialName("gold")
                val gold: Gold? = null,
                @SerialName("silver")
                val silver: Silver? = null
            ) {
                @Serializable
                data class Crystal(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_shiny")
                    val backShiny: String? = null,
                    @SerialName("back_shiny_transparent")
                    val backShinyTransparent: String? = null,
                    @SerialName("back_transparent")
                    val backTransparent: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_shiny_transparent")
                    val frontShinyTransparent: String? = null,
                    @SerialName("front_transparent")
                    val frontTransparent: String? = null
                )

                @Serializable
                data class Gold(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_shiny")
                    val backShiny: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_transparent")
                    val frontTransparent: String? = null
                )

                @Serializable
                data class Silver(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_shiny")
                    val backShiny: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_transparent")
                    val frontTransparent: String? = null
                )
            }

            @Serializable
            data class GenerationIii(
                @SerialName("emerald")
                val emerald: Emerald? = null,
                @SerialName("firered-leafgreen")
                val fireredLeafgreen: FireredLeafgreen? = null,
                @SerialName("ruby-sapphire")
                val rubySapphire: RubySapphire? = null
            ) {
                @Serializable
                data class Emerald(
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null
                )

                @Serializable
                data class FireredLeafgreen(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_shiny")
                    val backShiny: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null
                )

                @Serializable
                data class RubySapphire(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_shiny")
                    val backShiny: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null
                )
            }

            @Serializable
            data class GenerationIv(
                @SerialName("diamond-pearl")
                val diamondPearl: DiamondPearl? = null,
                @SerialName("heartgold-soulsilver")
                val heartgoldSoulsilver: HeartgoldSoulsilver? = null,
                @SerialName("platinum")
                val platinum: Platinum? = null
            ) {
                @Serializable
                data class DiamondPearl(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_female")
                    val backFemale: String? = null,
                    @SerialName("back_shiny")
                    val backShiny: String? = null,
                    @SerialName("back_shiny_female")
                    val backShinyFemale: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_female")
                    val frontFemale: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String? = null
                )

                @Serializable
                data class HeartgoldSoulsilver(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_female")
                    val backFemale: String? = null,
                    @SerialName("back_shiny")
                    val backShiny: String? = null,
                    @SerialName("back_shiny_female")
                    val backShinyFemale: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_female")
                    val frontFemale: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String? = null
                )

                @Serializable
                data class Platinum(
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_female")
                    val backFemale: String? = null,
                    @SerialName("back_shiny")
                    val backShiny: String? = null,
                    @SerialName("back_shiny_female")
                    val backShinyFemale: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_female")
                    val frontFemale: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String? = null
                )
            }

            @Serializable
            data class GenerationV(
                @SerialName("black-white")
                val blackWhite: BlackWhite? = null
            ) {
                @Serializable
                data class BlackWhite(
                    @SerialName("animated")
                    val animated: Animated? = null,
                    @SerialName("back_default")
                    val backDefault: String? = null,
                    @SerialName("back_female")
                    val backFemale: String? = null,
                    @SerialName("back_shiny")
                    val backShiny: String? = null,
                    @SerialName("back_shiny_female")
                    val backShinyFemale: String? = null,
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_female")
                    val frontFemale: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String? = null
                ) {
                    @Serializable
                    data class Animated(
                        @SerialName("back_default")
                        val backDefault: String? = null,
                        @SerialName("back_female")
                        val backFemale: String? = null,
                        @SerialName("back_shiny")
                        val backShiny: String? = null,
                        @SerialName("back_shiny_female")
                        val backShinyFemale: String? = null,
                        @SerialName("front_default")
                        val frontDefault: String? = null,
                        @SerialName("front_female")
                        val frontFemale: String? = null,
                        @SerialName("front_shiny")
                        val frontShiny: String? = null,
                        @SerialName("front_shiny_female")
                        val frontShinyFemale: String? = null
                    )
                }
            }

            @Serializable
            data class GenerationVi(
                @SerialName("omegaruby-alphasapphire")
                val omegarubyAlphasapphire: OmegarubyAlphasapphire? = null,
                @SerialName("x-y")
                val xY: XY? = null
            ) {
                @Serializable
                data class OmegarubyAlphasapphire(
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_female")
                    val frontFemale: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String? = null
                )

                @Serializable
                data class XY(
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_female")
                    val frontFemale: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String? = null
                )
            }

            @Serializable
            data class GenerationVii(
                @SerialName("icons")
                val icons: Icons? = null,
                @SerialName("ultra-sun-ultra-moon")
                val ultraSunUltraMoon: UltraSunUltraMoon? = null
            ) {
                @Serializable
                data class Icons(
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_female")
                    val frontFemale: String? = null
                )

                @Serializable
                data class UltraSunUltraMoon(
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_female")
                    val frontFemale: String? = null,
                    @SerialName("front_shiny")
                    val frontShiny: String? = null,
                    @SerialName("front_shiny_female")
                    val frontShinyFemale: String? = null
                )
            }

            @Serializable
            data class GenerationViii(
                @SerialName("icons")
                val icons: Icons? = null
            ) {
                @Serializable
                data class Icons(
                    @SerialName("front_default")
                    val frontDefault: String? = null,
                    @SerialName("front_female")
                    val frontFemale: String? = null
                )
            }
        }
    }

    @Serializable
    data class Stat(
        @SerialName("base_stat")
        val baseStat: Int? = null,
        @SerialName("effort")
        val effort: Int? = null,
        @SerialName("stat")
        val stat: Stat? = null
    ) {
        @Serializable
        data class Stat(
            @SerialName("name")
            val name: String? = null,
            @SerialName("url")
            val url: String? = null
        )
    }

    @Serializable
    data class Type(
        @SerialName("slot")
        val slot: Int? = null,
        @SerialName("type")
        val type: Type? = null
    ) {
        @Serializable
        data class Type(
            @SerialName("name")
            val name: String? = null,
            @SerialName("url")
            val url: String? = null
        )
    }
}