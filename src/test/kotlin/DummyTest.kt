import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.junit.Assert

class DummyTest : Spek({
    describe("Dummy Spec") {
        Assert.assertEquals(1, 1)
    }
})