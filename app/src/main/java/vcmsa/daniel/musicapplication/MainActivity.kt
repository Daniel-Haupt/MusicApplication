// ST10492718
// Daniel Johannes Haupt
package vcmsa.daniel.musicapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        // Created variables that relate to the UI elements

        var tvMainScreenTitle = findViewById<TextView>(R.id.tvMainScreenTitle)
        var btExitMainScreen = findViewById<Button>(R.id.btExitMainScreen)
        var btAddToPlaylist = findViewById<Button>(R.id.btAddToPlaylist)
        var btNextMainScreen = findViewById<Button>(R.id.btNextMainScreen)
        var etSongTitle = findViewById<EditText>(R.id.etSongTitle)
        var etArtistName = findViewById<EditText>(R.id.etArtistName)
        var etRatings = findViewById<EditText>(R.id.etRatings)
        var etComments = findViewById<EditText>(R.id.etComments)
        var tvGuidanceAndErrors = findViewById<TextView>(R.id.tvGuidanceAndErrors)


        if (etRatings.text.toString().toInt() > 5) {
            tvGuidanceAndErrors.text = "Rating can only be from 1 to 5"
        }
        else if (etRatings.text.toString().toIntOrNull() == null) {
            tvGuidanceAndErrors.text = "Please enter only a number in the rating field"
        }
        else if (etRatings.text.toString().contains(".")){
            tvGuidanceAndErrors.text = "No decimals are allowed in the rating field. Please enter a whole number"
            }


        // Created arrays to store the user input
        val song = arrayListOf<String>()
        val artist = arrayListOf<String>()
        val comments = arrayListOf<String>()
        val ratings = arrayListOf<Int>()


        // Created onclick listeners for the buttons

        // Exit button that exits the app
        btExitMainScreen.setOnClickListener {
            finish()
        }
        // Add to playlist button that adds the user input to the arrays and clears the input
        btAddToPlaylist.setOnClickListener {

            song.add(etSongTitle.text.toString())
            artist.add(etArtistName.text.toString())
            comments.add(etComments.text.toString())
            ratings.add(etRatings.text.toString().toInt())
            etSongTitle.text.clear()
            etArtistName.text.clear()
            etRatings.text.clear()
            etComments.text.clear()
        }
        // Next screen button that takes the user to the detailed view screen and passes the user input to it as an intent.
        // ( Adds array information to the DetailedViewScreen )

        btNextMainScreen.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            intent.putExtra("song", song)
            intent.putExtra("artist", artist)
            intent.putExtra("ratings", ratings)
            intent.putExtra("comments", comments)
            startActivity(intent)
        }


































    }
}