package functions

import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import data.Post
import java.io.InputStream

fun parseFeed(inputStream: InputStream?): List<Post> {

    val feed = SyndFeedInput().build(XmlReader(inputStream))

    return feed.entries.map { entry -> Post(title = entry.title, preview = "foo", content = "") }
}