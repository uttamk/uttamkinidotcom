package webapp

import data.Post
import functions.urlFriendlyFormat

class PostViewModel(post: Post) : Post(post.title, post.preview, post.content) {
    val urlFriendlyTitle: String
        get() = urlFriendlyFormat(this.title)
}