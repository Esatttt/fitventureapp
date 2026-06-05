import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.konyali.fitventure.R
import com.konyali.fitventure.ui.theme.BrandGreen
import com.konyali.fitventure.ui.theme.CardColor

@Composable
fun bottombarapp(
    modifiercall: Modifier = Modifier,
    onMacroClick: () -> Unit,
    onGYMclick: () -> Unit,
    currentRoute: String?
) {
    val isMacroActive = currentRoute == "macroscreen"
    val isGymActive = currentRoute == "exercisescreen"

    // 1. Menüyü ekranın ortasında tutacak ana kutu
    Box(
        modifier = modifiercall
            .fillMaxWidth()
            .padding(bottom = 24.dp), // Ekranın en altından biraz yukarıda "yüzmesi" için boşluk
        contentAlignment = Alignment.Center
    ) {
        // 2. O meşhur beyaz/koyu gri hap şeklindeki kart (Gölgesiyle birlikte)
        Card(
            modifier = Modifier
                .fillMaxWidth(0.90f) // Tasarımdaki gibi ekranın %85'ini kaplasın
                .height(80.dp),      // Kalınlığı
            shape = CircleShape,     // Hap görünümü (Tam yuvarlak köşeler)
            colors = CardDefaults.cardColors(
                containerColor = CardColor // Bizim jilet gibi global dark/light rengimiz
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Hafif havalı bir gölge
        ) {
            // 3. İçindeki butonları yan yana dizecek Row
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp), // Yeşil arka plan kartın sınırlarına yapışmasın diye iç boşluk
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // --- SOL BUTON (DİYET / MAKRO) ---
                Box(
                    modifier = Modifier
                        .weight(1f) // İki buton da alanın tam yarısını kaplasın
                        .fillMaxHeight()
                        .clip(CircleShape) // Tıklanma efekti ve yeşil arka plan da hap şeklinde olsun
                        .background(if (isMacroActive) BrandGreen else Color.Transparent)
                        .clickable { onMacroClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        // Tasarımdaki çatal bıçak ikonu (Kendi R.drawable ikonun varsa değiştirebilirsin)
                        painter = painterResource(R.drawable.forkandspoon),
                        contentDescription = "Diet",
                        // Aktifse siyah, pasifse gri renk
                        tint = if (isMacroActive) Color.Black else Color.LightGray,
                        modifier = Modifier.size(28.dp)
                    )
                }

                // --- SAĞ BUTON (GYM / EGZERSİZ) ---
                Box(
                    modifier = Modifier
                        .weight(1f) // Bu da diğer yarısını kaplıyor
                        .fillMaxHeight()
                        .clip(CircleShape)
                        .background(if (isGymActive) BrandGreen else Color.Transparent)
                        .clickable { onGYMclick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        // Tasarımdaki dambıl ikonu
                        painter = painterResource(R.drawable.dumbell),
                        contentDescription = "Exercise",
                        tint = if (isGymActive) Color.Black else Color.LightGray,
                        modifier = Modifier.size(28.dp)
                    )
                }

            }
        }
    }
}