sealed class Routes(val route: String) {
    object LaunchScreen:Routes("LaunchScreen")
    object MenuScreen:Routes("MenuScreen")
    object GameScreen:Routes("GameScreen/{dificultatEscollida}") {
        fun createRoute(dificultatEscollida:String) = "GameScreen/$dificultatEscollida"
    }
    object ResultScreen:Routes("ResultScreen/{victoria}/{tries}/{dificultatEscollida}") {
        fun createRoute(victoria: Boolean, tries: Int, dificultatEscollida: String) = "ResultScreen/$victoria/$tries/$dificultatEscollida"
    }
}
