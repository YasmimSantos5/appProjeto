package com.example.projetoapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val campoEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val campoSenha = findViewById<EditText>(R.id.editTextTextPassword)

        val botaoLogin = findViewById<Button>(R.id.btnLogin)
        val cadastro = findViewById<Button>(R.id.btnCadastro)

        // LOGIN

        botaoLogin.setOnClickListener {

            val email = campoEmail.text.toString()
            val senha = campoSenha.text.toString()

            if (email == "teste@gmail.com" && senha == "123") {

                val intent = Intent(this, PainelActivity::class.java)
                intent.putExtra("nome", "Yasmim")
                startActivity(intent)

            } else {

                Toast.makeText(
                    this,
                    "Usuário ou senha inválido",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


        cadastro.setOnClickListener {

            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)

        }
    }
}