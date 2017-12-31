package functions

import data.Post

fun getPostList(): List<Post> {
    return listOf(
            Post(title = "Programming in your head",
                    preview = "<p>Programming started out as just a job for me. I started enjoying it with time and still do. When I started out, I was like most programmers; Start hacking code and try to make it work. I copied pasted code from other files, Stack-overflow and the rest of the internet. I did not understand the programming language, the frameworks or the domain much. The focus was on ‘getting something to work’. Naturally, I was not a productive developer.</p>"),
            Post(title = "Scaling Redux part 3: Reducing Boilerplate and other stories", preview = "<p>In Scaling Redux part 1 and 2, I talked about how codebase and state architecture impacts complex applications. This post is about some other common problems that you encounter when your Redux codebase grows. </p>"))
}