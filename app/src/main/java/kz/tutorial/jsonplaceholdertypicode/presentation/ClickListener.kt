package kz.tutorial.jsonplaceholdertypicode.presentation

fun interface ClickListener<T : Any> {
    fun onClick(item: T)
}