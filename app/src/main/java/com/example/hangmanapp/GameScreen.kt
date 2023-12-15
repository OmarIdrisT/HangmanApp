import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hangmanapp.R

@Composable
fun GameScreen(navController: NavController, dificultatEscollida : String) {
    var intentsAverage by remember { mutableStateOf(6) }
    var inici = 0
    var final = 5
    var abecedari = listOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z")
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)

        repeat (6) {
            Row() {
                for (i in inici .. final) {
                    Button(
                        modifier = Modifier.size(55.dp),
                        onClick = { }
                    ) {
                        Text(text = abecedari[i])
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