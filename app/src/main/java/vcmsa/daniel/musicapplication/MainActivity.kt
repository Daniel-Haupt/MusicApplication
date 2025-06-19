// ST10492718
// Daniel Johannes Haupt
package vcmsa.daniel.musicapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var tvMainScreenTitle = findViewById<TextView>(R.id.tvMainScreenTitle)
        var btExitMainScreen = findViewById<Button>(R.id.btExitMainScreen)
        var btAddToPlaylist = findViewById<Button>(R.id.btAddToPlaylist)
        var btNextMainScreen = findViewById<Button>(R.id.btNextMainScreen)
        var etSongTitle = findViewById<TextView>(R.id.etSongTitle)
        var etArtistName = findViewById<TextView>(R.id.etArtistName)
        var etRatings = findViewById<TextView>(R.id.etRatings)
        var etComments = findViewById<TextView>(R.id.etComments)

        val song = arrayListOf<String>()
        val artist = arrayListOf<String>()
        val ratings = arrayListOf<Int>()
        val comments = arrayListOf<String>()

        btExitMainScreen.setOnClickListener {
            finish()
        }
        btAddToPlaylist.setOnClickListener {

            song.add(etSongTitle.text.toString())
            artist.add(etArtistName.text.toString())
            ratings.add(etRatings.text.toString().toInt())
            comments.add(etComments.text.toString())
            etSongTitle.text = ""
            etArtistName.text = ""
            etRatings.text = ""
            etComments.text = ""


        }



        btNextMainScreen.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }




































    }
}