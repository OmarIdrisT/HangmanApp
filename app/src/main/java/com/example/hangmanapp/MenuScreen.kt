import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.hangmanapp.R

@Composable
fun MenuScreen(navController: NavController) {
    var musicaOn = true
    var musica = MediaPlayer.create(LocalContext.current,R.raw.win)
    if (musicaOn) {
        musica.start()
    }
    else {
        musica.stop()
    }
    Box (modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "portada", modifier = Modifier.size(200.dp))
            Spacer(modifier = Modifier.height(30.dp))
            val dificultatEscollida = myDropDownMenu()
            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier
                .width(130.dp)
                .clickable {
                    (navController.navigate(
                        Routes.GameScreen.createRoute(
                            dificultatEscollida
                        )
                    ))
                }
                .background(Color.DarkGray)
                .height(60.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "PLAY", fontFamily = FontFamily(Font(R.font.peachcake)),  style = TextStyle(color = Color.White, fontSize = 30.sp))
            }

            Spacer(modifier = Modifier.height(30.dp))

            var help by remember { mutableStateOf(false) }

            Box(modifier = Modifier
                .width(130.dp)
                .clickable { help = true }
                .background(Color.DarkGray)
                .height(60.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "HELP", fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(color = Color.White, fontSize = 30.sp), modifier = Modifier.align(Alignment.Center))
            }
            MyDialog(help, { help = false }) { help = false }

            Spacer(modifier = Modifier.height(30.dp))

            Box(modifier = Modifier
                .width(50.dp)
                .clickable { musicaOn = false }
                .background(Color.DarkGray)
                .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.soundicon),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myDropDownMenu(): String {
    var dificultatGame by remember { mutableStateOf("Easy") }
    var expanded by remember { mutableStateOf(false) }
    val opcions = listOf("Easy", "Normal", "Hard")

    Column (modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = dificultatGame,
            onValueChange = { dificultatGame = it },
            enabled = false,
            readOnly = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.White),
            modifier = Modifier
                .clickable { expanded = true }
                .width(200.dp)
                .background(color = Color.DarkGray)
                .border(1.dp, Color.Black)
                .align(alignment = CenterHorizontally)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            opcions.forEach { dificultat ->
                DropdownMenuItem(modifier = Modifier.background(color = Color.DarkGray) ,text = { Text(text = dificultat, style = TextStyle(color = Color.White)) }, onClick = {
                    expanded = false
                    dificultatGame = dificultat
                })
            }
        }
    }

    return dificultatGame
}

@Composable
fun MyDialog(help: Boolean, onDismiss: () -> Unit, function: () -> Unit){
    if(help){
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()) {
                Text(text = "This is my dialog", color = Color.Black)
            }
        }
    }
}

