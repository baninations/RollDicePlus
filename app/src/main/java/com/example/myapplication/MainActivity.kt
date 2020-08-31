package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn: Button = findViewById(R.id.button2)
        rollBtn.setOnClickListener { rollDice() }

    }

    private fun rollDice() {
        val dice = Dice(6)
        val rollDice = dice.roll()
        val diceImage: ImageView = findViewById(R.id.diceIV)
        val resultTV: TextView = findViewById(R.id.tvRes)
        resultTV.text = rollDice.toString()
        val drawableResource =
            when(rollDice){
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }
        diceImage.setImageResource(drawableResource)
    }
}
class Dice(val sides: Int){
    val numSides = 1..sides
    fun roll(): Int{
        return numSides.random()
    }


}