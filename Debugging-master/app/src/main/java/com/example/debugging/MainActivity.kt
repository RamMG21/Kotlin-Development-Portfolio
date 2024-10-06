package com.example.debugging

import android.app.Activity
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.concurrent.thread

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "this is where the app crashed before")
       val helloTextView: TextView = findViewById(R.id.division_textview)
        Log.d(TAG, "this should be logged if the bug is fixed")
        helloTextView.text = "Hello, debugging!"
        logging()
        division()
        first()
    }
}
fun logging() {
    Log.e(TAG, "ERROR: a serious error like an app crash")
    Log.w(TAG, "WARN: warns about the potential for serious errors")
    Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
    Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
    Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
}
/*
Agrega la siguiente función a tu MainActivity.kt sobre la función logging().
Este código comienza con dos números y usa repeat para registrar el resultado de dividir el numerador por el denominador cinco veces.
 Cada vez que se ejecuta el código en el bloque repeat, el valor del denominador se reduce en uno.
 En la quinta y última iteración, la app intenta dividir por cero.
 */

private fun division() {
    val numerator = 60
    var denominator = 4
    thread(start = true) {
        repeat(4) {

            Log.v(TAG, "${numerator / denominator}")
                denominator--
            }
        }
    }




fun first() {
    second()
    Log.v(TAG, "1")
}

fun second() {
    third()
    Log.v(TAG, "2")
    fourth()
}

fun third() {
    Log.v(TAG, "3")
}

fun fourth() {
    Log.v(TAG, "4")
}