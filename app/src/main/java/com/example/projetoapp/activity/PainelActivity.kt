package com.example.projetoapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoapp.R

class PainelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_painel)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botaoBoleto = findViewById<Button>(R.id.btnBoleto)
        botaoBoleto.setOnClickListener {
            val intent = Intent(this, BoletoActivity::class.java)
            startActivity(intent)
        }

        val botaoReserva = findViewById<Button>(R.id.botaoReserva)
        botaoReserva.setOnClickListener {
            val intent = Intent(this, ReservaActivity::class.java)
            startActivity(intent)
        }

        val buttonAutorizacaoPainel = findViewById<Button>(R.id.buttonAutorizacaoPainel)
        buttonAutorizacaoPainel.setOnClickListener {
            val intent = Intent(this, CadastroAutorizacaoActivity::class.java)
            startActivity(intent)
        }

        val buttonMural = findViewById<Button>(R.id.BtnMural)
        buttonMural.setOnClickListener {
            val intent = Intent(this, MuralActivity::class.java)
            startActivity(intent)
        }

        val buttonmudanca = findViewById<Button>(R.id.btnmudanca)
        buttonmudanca.setOnClickListener {
            val intent = Intent(this, MudancaActivity::class.java)
            startActivity(intent)
        }

        val buttonPortaria = findViewById<Button>(R.id.btnPortaria)
        buttonPortaria.setOnClickListener {
            val intent = Intent(this, ContatosActivity::class.java)
            startActivity(intent)
        }
    }
}