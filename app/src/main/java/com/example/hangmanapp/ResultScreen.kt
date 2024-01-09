import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.hangmanapp.R

@Composable
fun ResultScreen(navController: NavController, victoria: Boolean, tries: Int) {

    var imatgeVictoria = when(victoria) {
        true -> R.drawable.step6
        false ->R.drawable.step6
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (victoria) {
                Text(text = "YOU WIN \nTries: $tries")
            }
            else {
                Text(text = "YOU LOSE",)
            }

            Button(onClick = { navController.navigate(Routes.MenuScreen.route) }) {
                Text(text = "PLAY AGAIN")
            }
        }
        }

}