package vcmsa.daniel.musicapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Created variables that relate to the UI elements
        var btSongDisplay = findViewById<Button>(R.id.btSongDisplay)
        var tvOutputFromButtonActions = findViewById<TextView>(R.id.tvOutputFromButtonActions)
        var btAverageRating = findViewById<Button>(R.id.btAverageRating)
        var btReturnToHomeScreen = findViewById<Button>(R.id.btReturnToHomeScreen)

        // Getting the extra data from the intent from the MainActivity to use in the DetailedViewScreen
        val song = intent.getStringArrayListExtra("song")
        val artist = intent.getStringArrayListExtra("artist")
        val ratings = intent.getStringArrayListExtra("ratings")
        val comments = intent.getStringArrayListExtra("comments")



        // Created onclick listeners for the buttons
        btSongDisplay.setOnClickListener {
            // making use of a loop to loop through arrays and display the information
            for (i in song?.indices!!)
                tvOutputFromButtonActions.text = "Song Name: " + song.joinToString() + "\n" + "Artist Name: " + artist?.joinToString() + "\n" +
                        "Rating: " + ratings?.joinToString() + "\n" + "Comments: " + comments?.joinToString()
        }
        // Gets the average rating from the ratings array and displays it in the tvOutputFromButtonActions
        btAverageRating.setOnClickListener {
                val average = ratings?.mapNotNull { it.toIntOrNull() }?.average()
                tvOutputFromButtonActions.text = "The average rating is: " + average.toString().toDouble()

            }

        // Returns to the main screen and resets the arrays
        btReturnToHomeScreen.setOnClickListener {
         val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }























    }
}