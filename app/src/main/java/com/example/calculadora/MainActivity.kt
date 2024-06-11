package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat
import java.time.temporal.IsoFields
import java.time.temporal.Temporal

class MainActivity : AppCompatActivity() {

    val SUMA = "+"
    val RESTA = "-"
    val MULTIPLICACION = "*"
    val DIVISION = "/"
    val PORCENTAJE = "%"

    var OPERACION = ""

    var PRIMERO:Double = Double.NaN
    var SEGUNDO:Double = Double.NaN

    lateinit var tvtemp:TextView
    lateinit var tvresultado:TextView

    lateinit var DECIMAL:DecimalFormat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DECIMAL = DecimalFormat("#.##########")
        tvtemp = findViewById(R.id.tvtemp)
        tvresultado = findViewById(R.id.tvresultado)

        fun CAMBIAOPERADOR(b: View){
            val boton:Button = b as Button
            if (boton.text.toString().trim() == "x"){
                OPERACION = "*"
            }else{
                OPERACION = boton.text.toString().trim()
            }
    }
        fun CALCULAR(b:View){
            if (Double.NaN != PRIMERO) {
                SEGUNDO = tvtemp.text.toString().toDouble()
                tvtemp.text = ""

                when (OPERACION) {
                    "+" -> PRIMERO = (PRIMERO + SEGUNDO)
                    "-" -> PRIMERO = (PRIMERO - SEGUNDO)
                    "*" -> PRIMERO = (PRIMERO * SEGUNDO)
                    "/" -> PRIMERO = (PRIMERO / SEGUNDO)
                    "%" -> PRIMERO = (PRIMERO % SEGUNDO)
                }
            }else{

                PRIMERO = tvtemp.text.toString().toDouble()
            }



        }

        fun SELECCIONARNUM(b: View){
            val boton:Button = b as Button
            if (tvtemp.text.toString() == "0"){
                tvtemp.text = ""
            }
            tvtemp.text = tvtemp.text.toString() + boton.text.toString()
        }
    }
}