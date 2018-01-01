package functions

import data.Post
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert

class PostRepositoryTest : Spek({
    describe("Post Repository") {
        describe("getPostList") {
            val posts = getPostList()

            it("should get the correct number of posts") {
                Assert.assertEquals(posts.count(), 2)
            }
            describe("post data") {
                val firstPost = posts.first()
                val secondPost = posts[1]
                it("posts should have the right title") {
                    Assert.assertEquals("Programming in your head", firstPost.title)
                    Assert.assertEquals("Scaling Redux part 3: Reducing Boilerplate and other stories",
                            secondPost.title)
                }
                it("posts should have the right preview") {
                    Assert.assertEquals("<p>Programming started out as just a job for me. I started enjoying it with time and still do. When I started out, I was like most programmers; Start hacking code and try to make it work. I copied pasted code from other files, Stack-overflow and the rest of the internet. I did not understand the programming language, the frameworks or the domain much. The focus was on ‘getting something to work’. Naturally, I was not a productive developer.</p>",
                            firstPost.preview)
                    Assert.assertEquals("<p>In Scaling Redux part 1 and 2, I talked about how codebase and state architecture impacts complex applications. This post is about some other common problems that you encounter when your Redux codebase grows.</p>",
                            secondPost.preview)
                }
                it("should have the right content") {
                    Assert.assertEquals(Post::class.java.getResource("/posts/programming-in-your-head.html")
                            .readText(),
                            firstPost.content)

                    Assert.assertEquals(Post::class.java.getResource("/posts/scaling-redux-part-3:-reducing-boilerplate-and-other-stories.html")
                            .readText(),
                            secondPost.content)
                }
            }

        }
    }
})