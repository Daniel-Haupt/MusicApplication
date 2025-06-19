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

        tvGuidanceAndErrors.text = "*IMPORTANT* Do not leave fields empty, do not make use of letters symbols commas or dots in the ratings field."
            // Created arrays to store the user input
            val song = arrayListOf<String>()
            val artist = arrayListOf<String>()
            val comments = arrayListOf<String>()
            val ratings = arrayListOf<String>()

            // Created onclick listeners for the buttons

            // Exit button that exits the app
            btExitMainScreen.setOnClickListener {
                finish()
            }
            // Add to playlist button that adds the user input to the arrays and clears the input fields. Also checks if the fields are empty.
            btAddToPlaylist.setOnClickListener {
                if (etSongTitle.text.isEmpty() || etArtistName.text.isEmpty() || etRatings.text.isEmpty() || etComments.text.isEmpty()) {
                    tvGuidanceAndErrors.text = "Please fill in all fields"
                    return@setOnClickListener

                }
                else{
                    song.add(etSongTitle.text.toString())
                    artist.add(etArtistName.text.toString())
                    comments.add(etComments.text.toString())
                    ratings.add(etRatings.text.toString())
                    etSongTitle.text.clear()
                    etArtistName.text.clear()
                    etRatings.text.clear()
                    etComments.text.clear()
                    tvGuidanceAndErrors.text = "Song Added"
                }
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