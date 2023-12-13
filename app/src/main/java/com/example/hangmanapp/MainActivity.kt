import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hangmanapp.GamePhase
import com.example.hangmanapp.GameScreen
import com.example.hangmanapp.LaunchScreen
import com.example.hangmanapp.MenuScreen
import com.example.hangmanapp.ResultScreen
import com.example.hangmanapp.ui.theme.HangmanAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HangmanAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = GamePhase.Pantalla1.route
                    ) {
                        composable(GamePhase.Pantalla1.route) { LaunchScreen(navigationController) }
                        composable(GamePhase.Pantalla2.route) { MenuScreen(navigationController) }
                        composable(GamePhase.Pantalla3.route) { GameScreen(navigationController) }
                        composable(GamePhase.Pantalla4.route) { ResultScreen(navigationController) }
                    }

                }
            }
        }
    }
}