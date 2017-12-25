import data.Post
import functions.parseFeed
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert
import java.io.InputStream


class ParseFeedTest : Spek({
    describe("Parse Feed") {
        val inputStream: InputStream = Thread.currentThread().contextClassLoader.getResourceAsStream("test_feed.xml")
        val parsedOutput: List<Post> = parseFeed(inputStream)

        it("parses the correct number of records") {
            Assert.assertEquals(2, parsedOutput.count())
        }

        it("parses the title correctly") {
            Assert.assertEquals("Programming in your head", parsedOutput[0].title)
            Assert.assertEquals("Scaling Redux part 3: Reducing Boilerplate and other stories",
                    parsedOutput[1].title)
        }

    }
})


