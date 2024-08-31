package com.example.egyszeru_szamologep

import android.content.Context
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.egyszeru_szamologep.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTorles.setOnClickListener {
            binding.tvbevitel.text = ""
            binding.tveredmeny.text = ""

        }

        binding.btnZarojelBal.setOnClickListener{
            binding.tvbevitel.text = addToInputText("(")
        }
        binding.btnZarojelJobb.setOnClickListener {
            binding.tvbevitel.text = addToInputText(")")
        }
        binding.btn0.setOnClickListener {
            binding.tvbevitel.text = addToInputText("0")
        }
        binding.btn1.setOnClickListener {
            binding.tvbevitel.text = addToInputText("1")
        }
        binding.btn2.setOnClickListener {
            binding.tvbevitel.text = addToInputText("2")
        }
        binding.btn3.setOnClickListener {
            binding.tvbevitel.text = addToInputText("3")
        }
        binding.btn4.setOnClickListener {
            binding.tvbevitel.text = addToInputText("4")
        }
        binding.btn5.setOnClickListener {
            binding.tvbevitel.text = addToInputText("5")
        }
        binding.btn6.setOnClickListener {
            binding.tvbevitel.text = addToInputText("6")
        }
        binding.btn7.setOnClickListener {
            binding.tvbevitel.text = addToInputText("7")
        }
        binding.btn8.setOnClickListener {
            binding.tvbevitel.text = addToInputText("8")
        }
        binding.btn9.setOnClickListener {
            binding.tvbevitel.text = addToInputText("9")
        }
        binding.btnPont.setOnClickListener {
            binding.tvbevitel.text = addToInputText(".")
        }
        binding.btnOsszeadas.setOnClickListener {
            binding.tvbevitel.text = addToInputText("+")
        }
        binding.btnKivonas.setOnClickListener {
            binding.tvbevitel.text = addToInputText("-")
        }
        binding.btnSzorzas.setOnClickListener {
            binding.tvbevitel.text = addToInputText("×") //alt + 0215
        }
        binding.btnOsztas.setOnClickListener {
            binding.tvbevitel.text = addToInputText("÷") //alt + 0247
        }
        binding.btnEgyenlo.setOnClickListener {
            //binding.tvbevitel.text = addToInputText("=")
            eredmenyMutatasa()
        }



    }

    private fun addToInputText(buttonValue: String): String {
        return "${binding.tvbevitel.text}$buttonValue"
    }
    private fun bemenetiErtekLekerdezese(): String {
        var lekerdezes = binding.tvbevitel.text.replace(Regex("÷"),"/")
        lekerdezes = lekerdezes.replace(Regex("×"),"*")
        return lekerdezes
    }

    private fun eredmenyMutatasa(){
        try {
            val lekerdezes = bemenetiErtekLekerdezese()
            val result = Expression(lekerdezes).calculate()
            if (result.isNaN()){
                //error kiírása
                binding.tveredmeny.text = "Error"
                binding.tveredmeny.setTextColor((ContextCompat.getColor(this,R.color.red)))
            }else{
                //eredmény kiírása
                binding.tveredmeny.text = DecimalFormat("0.######").format(result).toString()
                binding.tveredmeny.setTextColor((ContextCompat.getColor(this,R.color.green)))
            }
        } catch (e: Exception){
            //error kiírása
            binding.tveredmeny.text = "Error"
            binding.tveredmeny.setTextColor((ContextCompat.getColor(this,R.color.red)))
        }

    }


}