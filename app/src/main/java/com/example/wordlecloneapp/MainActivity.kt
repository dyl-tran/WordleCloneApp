package com.example.wordlecloneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.wordlecloneapp.FourLetterWordList.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.guessButton)
        val userGuess = findViewById<EditText>(R.id.editText)

        // user inputs a guess, and then presses button. Updates the textView using setText to that of the user guess
        val userAttempts1 = findViewById<TextView>(R.id.userAttempt1)
        val userAttempts2 = findViewById<TextView>(R.id.userAttempt2)
        val userAttempts3 = findViewById<TextView>(R.id.userAttempt3)

        val correctAnswer = getRandomFourLetterWord()

        // hide answers until user guess it correctly OR user uses all 3 guesses up
        val answers = findViewById<TextView>(R.id.answer)
        var guessCounter = 0;
        var attemptCounter = 0;

        if (guessCounter >= 3 || userGuess.equals(correctAnswer)) {
            answers.visibility = View.VISIBLE

        }

        answers.visibility = View.INVISIBLE
        // Button functionality
        button.setOnClickListener {
            Log.v("Answer", "The correct answer is: $correctAnswer")
            Toast.makeText(this, "Guess button works", Toast.LENGTH_SHORT).show()

            userAttempts1.text = userGuess.toString()
            

        }
    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            var wordToGuess = ""
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}

