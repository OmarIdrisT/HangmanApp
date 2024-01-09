import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangmanapp.R


val colorBotoEncert = Color(0xff0db121)
val colorBotoFals = Color(0xffd32c2c)
val colorPredeterminat = Color(0xff2f9ac5)

@Composable
fun GameScreen(navController: NavController, dificultatEscollida : String) {

    var tries by remember { mutableStateOf(0) }
    var errors by remember { mutableStateOf(0) }
    var gamePhase = when(errors) {
        0 -> R.drawable.step0w
        1 -> R.drawable.step1w
        2 -> R.drawable.step2w
        3 -> R.drawable.step3w
        4 -> R.drawable.step4w
        5 -> R.drawable.step5w
        else -> R.drawable.step6w
    }

    var paraulesEasy = listOf("ROSA","HIELO", "LUZ", "ROCK", "ROLL", "MEAT", "KICK", "BEAT", "SHIP", "DRIP")
    var paraulesMedium = listOf("HOME", "WORD1", "WORD2", "WORD3", "WORD4", "WORD5", "WORD6", "WORD7", "ATLANTIS", "LUGUBRE")
    var paraulesHard = listOf("APOCALIPSIS", "LICANTROPO", "PERIPECIA", "PAUPERRIMO", "LOGARITMO", "CONOCIMIENTO", "ATARAXIA", "TURBULENCIA", "MURCIELAGO", "ATLANTIS")
    var palabrasJugando =when(dificultatEscollida){
        "Easy"->paraulesEasy
        "Normal"->paraulesMedium
        else->paraulesHard
    }
    var victoria=false
    var paraulaRandom by remember { mutableStateOf((palabrasJugando.indices).random())  }
    var paraulaEscollida by remember { mutableStateOf(palabrasJugando[paraulaRandom]) }
    var inici = 0
    var final = 5
    var lletraValida = false
    var abecedari = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            var paraulaSecreta by remember { mutableStateOf("_".repeat(paraulaEscollida.length)) }
            var nuevaParaulaSecreta=paraulaSecreta.toCharArray()
            Text(text = paraulaSecreta,
                 letterSpacing = 5.sp,
                 style = TextStyle(fontSize = 50.sp,
                 color = Color.White),
                 fontFamily = FontFamily(Font(R.font.peachcake))
            )
            Spacer(modifier = Modifier.height(40.dp))
            Image(painter = painterResource(id = gamePhase), contentDescription = null)
            Spacer(modifier = Modifier.height(40.dp))


            repeat(6) {
                Row() {

                    for (i in inici..final) {
                        val tecla = abecedari[i]
                        var colorBoton by remember { mutableStateOf(Color.Transparent) }
                        var botoClicat by remember { mutableStateOf(false) }
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .padding(6.dp)
                                .background(colorBoton)
                                .border(1.dp, Color.Black)
                                .clickable(enabled = !botoClicat) {
                                    for (j in paraulaEscollida.indices) {
                                        if (paraulaEscollida[j] == tecla) {
                                            nuevaParaulaSecreta[j] = tecla
                                            lletraValida = true
                                        }
                                    }
                                    if (lletraValida) {
                                        colorBoton = colorBotoEncert
                                        botoClicat = true
                                    } else {
                                        colorBoton = colorBotoFals
                                        errors++
                                        botoClicat = true
                                    }
                                    tries++
                                    paraulaSecreta = String(nuevaParaulaSecreta)
                                }
                        ) {
                            Text(text = tecla.toString(), modifier = Modifier.align(Alignment.Center), style = TextStyle(fontSize = 15.sp))
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
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Nº de intentos: $tries", fontFamily = FontFamily(Font(R.font.peachcake)))
            if (errors == 6) {
                navController.navigate(Routes.ResultScreen.createRoute(victoria, tries, dificultatEscollida))
            }
            if (paraulaSecreta == paraulaEscollida) {
                victoria = true
                navController.navigate(Routes.ResultScreen.createRoute(victoria, tries, dificultatEscollida))
            }
        }
    }

}


