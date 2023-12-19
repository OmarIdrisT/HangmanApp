import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
    var intentsAverage by remember { mutableStateOf(6) }
    var paraulesEasy = listOf("HOME","DICE", "ROSE", "ROCK", "ROLL", "MEAT", "KICK", "BEAT", "SHIP", "DRIP")
    var paraulesMedium = listOf("HOME","DICE", "", "", "", "", "", "", "", "")
    var paraulesHard = listOf("ATLANTIS","", "", "", "", "", "", "", "", "")
    var paraulesInsanity = listOf("","", "", "", "", "", "", "", "", "")
    var paraulaEscollida = ""
    var paraulaSecreta = ""
    var inici = 0
    var final = 5
    var abecedari = listOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z")
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)


            Text(text = "EASY")
            paraulaEscollida = paraulesEasy.random()
            for (i in paraulaEscollida.indices) {
                paraulaSecreta += "_ "
            }
            Text(text = paraulaSecreta.trim(), style = TextStyle(fontSize = 30.sp, color = Color.Black))


        repeat (intentsAverage) {
            Row() {
                for (i in inici .. final) {
                    Button(
                        modifier = Modifier.size(55.dp),
                        onClick = { }
                    ) {
                        Text(text = abecedari[i], style = TextStyle(fontSize = 15.sp))
                    }
                }
                inici = final + 1
                if (final+5< abecedari.size - 1){
                    final += 6
                }else{
                    final=abecedari.lastIndex
                }

            }
        }

    }
}