package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener{ rollDice() }
        rollDice()
    }


    class Dice(val numSide : Int){
        fun roll(): Int {
            return (1..numSide).random()
        }
    }

    private fun rollDice() {
        //Creamos un nuevo objeto llamado Dice con 6 lados para girarlo
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Actualizamos la pantalla con el resultado del dado
        val diceImage : ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

        /**
         * Tambien se podia usar este codigo pero esta m,enos optimizado
         * when (diceRoll) {
        1 -> diceImage.setImageResource(R.drawable.dice_1)
        2 -> diceImage.setImageResource(R.drawable.dice_2)
        3 -> diceImage.setImageResource(R.drawable.dice_3)
        4 -> diceImage.setImageResource(R.drawable.dice_4)
        5 -> diceImage.setImageResource(R.drawable.dice_5)
        6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
         */

    }
}