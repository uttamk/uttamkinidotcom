package functions

fun urlFriendlyFormat(title: String): String {
    return title.toLowerCase().replace(' ', '-')
}