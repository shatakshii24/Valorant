sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Home : Screen("home")
    object Agents : Screen("agents")
    object AgentDetail : Screen("agentDetail/{uuid}") {
        fun createRoute(uuid: String) = "agentDetail/$uuid"
    }
}
