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
        val postModels = getPostList().map { post -> PostViewModel(post) }
        val postModel = postModels.find { post -> post.urlFriendlyTitle == title }
        model.addAttribute("post", postModel)
        return "post"
    }

}