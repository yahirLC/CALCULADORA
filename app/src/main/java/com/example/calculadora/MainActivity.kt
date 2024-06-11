package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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


    }

    fun CAMBIAOPERADOR(b: View){
        if (tvtemp.text.isNotEmpty() || PRIMERO.toString()!= "NaN"){
            CALCULAR()
            val boton:Button = b as Button
            if (boton.text.toString().trim() == "x"){
                OPERACION = "*"
            }else{
                OPERACION = boton.text.toString().trim()
            }

            tvresultado.text = DECIMAL.format(PRIMERO) + OPERACION
            tvtemp.text = ""
        }

    }
    fun CALCULAR(){
       try{
           if (PRIMERO.toString()!="NaN") {
               if (tvtemp.text.toString().isEmpty()){
                   tvtemp.text = tvresultado.text.toString()
               }
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
       }catch (e:Exception){

       }

    }

    fun SELECCIONARNUM(b: View){
        val boton:Button = b as Button
        tvtemp.text = tvtemp.text.toString() + boton.text.toString()
    }

    fun BORRAR(b: View){
        val boton:Button = b as Button
        if (boton.text.toString().trim() == "C"){
            if(tvtemp.text.toString().isNotEmpty()){
                var Datos:CharSequence = tvtemp.text as CharSequence
                tvtemp.text = Datos.subSequence(0,Datos.length-1)
            }else{
                PRIMERO = Double.NaN
                SEGUNDO = Double.NaN
                tvtemp.text = ""
                tvresultado.text = ""
            }
        }else if (boton.text.toString().trim() == "CA"){
            PRIMERO = Double.NaN
            SEGUNDO = Double.NaN
            tvtemp.text = ""
            tvresultado.text = ""
        }
    }

    fun IGUAL(b:View){
        CALCULAR()
        tvresultado.text = DECIMAL.format(PRIMERO)
        OPERACION = ""
    }
}