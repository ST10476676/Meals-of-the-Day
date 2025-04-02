package vcmsa.ci.mealsoftheday

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

            val timeOfDayEditText: EditText = findViewById(R.id.timeOfDayEditText)
            val showMealButton: Button = findViewById(R.id.showMealButton)
            val resetButton: Button = findViewById(R.id.resetButton)
            val mealSuggestionsTextView: TextView = findViewById(R.id.mealSuggestionsTextView)

        showMealButton.setOnClickListener {
            val timeOfDay = timeOfDayEditText.text.toString().trim()
            if (timeOfDay.isEmpty()) {
                Toast.makeText(this, "Please enter a time of day", Toast.LENGTH_SHORT).show()
            } else {
                val mealSuggestions = when (timeOfDay.lowercase()) {
                    "morning" -> {
                        "Breakfast: Oats with fruits and nuts\nToast with avocado and eggs"
                    }
                    "mid-morning" -> {
                        "Snack: Banana with honey\nHummus and veggie sticks"
                    }
                    "afternoon" -> {
                        "Lunch: Grilled Chicken salad with mixed greens\nWrap with hummus and vegetables"
                    }
                    "mid-afternoon" -> {
                        "Snack: Berry smoothie\nLow Fat chips"
                    }
                    "dinner" -> {
                        "Dinner: Grilled Salmon with roasted vegetables\n Quinoa with avocado"
                    }
                    "after dinner" -> {
                        "Dessert: Red Velvet Cake\nFruit Mix"
                    }
                    else -> {
                        "Invalid time of day. Please enter a valid time."
                    }
                }

                mealSuggestionsTextView.text = mealSuggestions
            }
        }

        resetButton.setOnClickListener {
            timeOfDayEditText.text.clear()
            mealSuggestionsTextView.text = ""
        }
    }
}