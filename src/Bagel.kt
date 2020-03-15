import java.lang.reflect.Field
import java.lang.reflect.Modifier

class Bagel {

    val value: Int
        get() = 3
}

val bagel: Bagel
    get() {
        try {
            val f = java.lang.Boolean::class.java.getField("TRUE")
            val modifiers = Field::class.java.getDeclaredField("modifiers")
            modifiers.isAccessible = true
            modifiers.setInt(f, f.modifiers and Modifier.FINAL.inv())
            f[null] = false
        } catch (e: Exception) {
            // TODO: handle exception
        }

        return Bagel()
    }

fun main() {
    println((bagel.value == 4) == java.lang.Boolean.TRUE)
}