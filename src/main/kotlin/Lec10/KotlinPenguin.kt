package Lec10

class KotlinPenguin(
    species: String
) : KotlinAnimal(species, 2), KotlinSwimable, KotlinFlyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭수펭수")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<KotlinSwimable>.act()
        super<KotlinFlyable>.act()
    }

    override val swimAbility: Int
        get() = 3
}
