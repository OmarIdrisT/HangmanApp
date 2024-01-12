sealed class Routes(val route: String) {
    object LaunchScreen:Routes("LaunchScreen")
    object MenuScreen:Routes("MenuScreen")
    object GameScreen:Routes("GameScreen/{dificultatEscollida}/{musicaOn}") {
        fun createRoute(dificultatEscollida:String, musicaOn: Boolean) = "GameScreen/$dificultatEscollida/$musicaOn"
    }
    object ResultScreen:Routes("ResultScreen/{victoria}/{tries}/{dificultatEscollida}/{musicaOn}") {
        fun createRoute(victoria: Boolean, tries: Int, dificultatEscollida: String, musicaOn: Boolean) = "ResultScreen/$victoria/$tries/$dificultatEscollida/$musicaOn"
    }
}
