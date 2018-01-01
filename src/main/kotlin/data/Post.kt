package data

import functions.urlFriendlyFormat

data class Post(val title: String, val preview: String = "", val content: String) {
    val urlFriendlyTitle: String
        get() = urlFriendlyFormat(this.title)
}