package Lec10

class KotlinCat(
    species: String
) : KotlinAnimal(species, 4) {

    override fun move() {
        println("냐옹")
    }
}
