package webapp

import functions.getPostList
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HomeController {

    @RequestMapping("/")
    fun home(model: Model, @RequestParam(value = "name", required = false, defaultValue = "World") name: String): String {
        model.addAttribute("posts", getPostList().map { post -> PostViewModel(post) })
        return "home"
    }

}


