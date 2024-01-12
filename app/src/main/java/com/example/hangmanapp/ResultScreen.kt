import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangmanapp.R

@Composable
fun ResultScreen(navController: NavController, victoria: Boolean, tries: Int, dificultatEscollida: String, musicaOn: Boolean) {

    var imatgeVictoria = when(victoria) {
        true -> R.drawable.victory
        false ->R.drawable.lose
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
            verticalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = imatgeVictoria),
                    modifier = Modifier.size(200.dp),
                    contentDescription = null

                )
                Spacer(modifier = Modifier.height(20.dp))
                if (victoria) {
                    Text(text = "YOU WIN", fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(color = Color.White, fontSize = 50.sp))
                }
                else {
                    Text(text = "YOU FAILED", fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(color = Color.White, fontSize = 50.sp))
                }
            Text(text = "Tries: $tries", fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(color = Color.White, fontSize = 30.sp))
                Spacer(modifier = Modifier.height(40.dp))
                Box(modifier = Modifier
                    .width(130.dp)
                    .clickable { navController.navigate(Routes.GameScreen.createRoute(dificultatEscollida, musicaOn)) }
                    .background(Color.DarkGray)
                    .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "PLAY AGAIN", fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(color = Color.White, fontSize = 20.sp), modifier = Modifier.align(Alignment.Center))
                }
                Spacer(modifier = Modifier.height(40.dp))
                Box(modifier = Modifier
                    .width(130.dp)
                    .clickable { navController.navigate(Routes.MenuScreen.route) }
                    .background(Color.DarkGray)
                    .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "MENU", fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(color = Color.White, fontSize = 30.sp), modifier = Modifier.align(Alignment.Center))
                }
            }
        }

}