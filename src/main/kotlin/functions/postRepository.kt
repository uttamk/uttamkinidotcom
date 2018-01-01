package functions

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import data.Post
import com.beust.klaxon.Parser
import com.beust.klaxon.string

fun getPostList(): List<Post> {
    val postCls = Post::class.java
    val postsJson = Parser().parse(StringBuilder(postCls.getResource("/posts/posts.json").readText()))
            as JsonArray<JsonObject>
    return postsJson.map { json ->
        val title = json.string("title")!!
        val contentFileName = "/posts/${title.toLowerCase().replace(' ', '-')}.html"
        val content = postCls.getResource(contentFileName).readText()

        Post(title = title, preview = json.string("preview")!!, content = content)
    }
}

