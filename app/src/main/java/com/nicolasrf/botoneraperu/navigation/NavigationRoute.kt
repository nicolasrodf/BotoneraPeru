package com.nicolasrf.botoneraperu.navigation

sealed class NavigationRoute(val route: String) {
    data object OnDetail : NavigationRoute("detail/{${NavArgs.ItemId.key}}") {
        fun createRoute(id: Int) = "detail/$id"
    }
}

enum class NavArgs(val key: String) {
    ItemId("itemId")
}