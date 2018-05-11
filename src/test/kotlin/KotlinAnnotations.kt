import org.junit.Test

class KotlinAnnotations {

	@JvmOverloads
	fun jvmOverloads(a : Int = 1, b : Int = a) = Unit

	@Test
	fun run() {
		jvmOverloads(b = 1)
	}
}