import functions.urlFriendlyFormat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert

class UtilsTest : Spek({

    describe("functions.urlFriendlyFormat") {
        it("should replace spaces by a dash and change uppercase to lowercase") {
            Assert.assertEquals("foo-bar-baz", urlFriendlyFormat("Foo Bar Baz"))
        }
    }

})

