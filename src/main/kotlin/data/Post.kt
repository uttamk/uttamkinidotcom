package data

data class Post(val title: String, val preview: String = "") {
    val urlFriendlyTitle: String
        get() = "${this.title.toLowerCase().replace(' ', '-')}"
}