package webapp

import functions.getPostList
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class PostController {

    @RequestMapping("/posts/{title}")
    fun post(model: Model, @PathVariable(value = "title") title: String): String {
        val posts = getPostList()
        val post = posts.find { p -> p.urlFriendlyTitle == title }
        model.addAttribute("post", post)
        return "post"
    }

}