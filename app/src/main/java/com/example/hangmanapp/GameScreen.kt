import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangmanapp.R

@Composable
fun GameScreen(navController: NavController, dificultatEscollida : String) {

    var tries by remember { mutableStateOf(0) }
    var gamePhase = when(tries) {
        0 -> R.drawable.logo
        1 -> R.drawable.logo
        2 -> R.drawable.logo
        3 -> R.drawable.logo
        4 -> R.drawable.logo
        5 -> R.drawable.logo
        else -> {R.drawable.logo}
    }

    var paraulesEasy = listOf("HOME","DICE", "ROSE", "ROCK", "ROLL", "MEAT", "KICK", "BEAT", "SHIP", "DRIP")
    var paraulesMedium = listOf("HOME", "WORD1", "WORD2", "WORD3", "WORD4", "WORD5", "WORD6", "WORD7", "WORD8", "WORD9")
    var paraulesHard = listOf("ATLANTIS", "WORD1", "WORD2", "WORD3", "WORD4", "WORD5", "WORD6", "WORD7", "WORD8", "WORD9")
    var palabrasJugando =when(dificultatEscollida){
        "Easy"->paraulesEasy
        "Normal"->paraulesEasy
        else->paraulesHard
    }
    var victoria=false
    var paraulaRandom by remember { mutableStateOf((palabrasJugando.indices).random())  }
    var paraulaEscollida by remember { mutableStateOf(palabrasJugando[paraulaRandom]) }
    var inici = 0
    var final = 5
    var abecedari = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = gamePhase), contentDescription = null)
        var paraulaSecreta by remember { mutableStateOf("_".repeat(paraulaEscollida.length)) }
        var nuevaParaulaSecreta=paraulaSecreta.toCharArray()
        Text(text = paraulaSecreta, letterSpacing = 5.sp, style = TextStyle(fontSize = 30.sp, color = Color.Black))

        repeat(6) {
            Row() {

                for (i in inici..final) {
                    val tecla = abecedari[i]
                    var colorBoton by remember { mutableStateOf(Color.White) }
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(colorBoton)
                            .clickable {
                                for (j in paraulaEscollida.indices) {
                                    if (paraulaEscollida[j] == tecla) {
                                        colorBoton = Color.Green
                                        nuevaParaulaSecreta[j] = tecla
                                    } else {
                                        colorBoton = Color.Red
                                        tries++
                                    }
                                }
                                paraulaSecreta = String(nuevaParaulaSecreta)
                            }
                    ) {
                        Text(text = tecla.toString(), style = TextStyle(fontSize = 15.sp))
                      }
                }
                inici = final + 1
                if (final + 5 < abecedari.size - 1) {
                    final += 6
                } else {
                    final = abecedari.lastIndex
                }
            }
        }
        if (tries == 6) {
            navController.navigate(Routes.ResultScreen.createRoute(victoria, tries))
        }
        else if (paraulaSecreta == paraulaEscollida) {
            victoria = true
            navController.navigate(Routes.ResultScreen.createRoute(victoria, tries))
        }
    }
}


