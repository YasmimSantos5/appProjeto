package com.example.projetoapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoapp.adapter.MuralAdapter
import com.example.projetoapp.R

class MuralActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mural)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbarMural = findViewById<Toolbar>(R.id.toolbarMural2)
        setSupportActionBar(toolbarMural)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        val mural = listOf(
            "Novo Bicicletário",
            "Portão de Veículos",
            "Alarme de Incêndio",
            "Festa Junina",
            "Jogo do Brasil",
            "Festa de Aniversário",
            "Festa Junina",
            "Jogo do Brasil",
            "Festa de Aniversário",
            )
        val rc = findViewById<RecyclerView>(R.id.RecylerViewMural)
        rc.layoutManager = LinearLayoutManager(this)
        rc.adapter = MuralAdapter(mural)

        val botaoVoltar = findViewById<Button>(R.id.Btnvoltarpainel)

        botaoVoltar.setOnClickListener {
            startActivity(Intent(this, PainelActivity::class.java))
            finish()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}