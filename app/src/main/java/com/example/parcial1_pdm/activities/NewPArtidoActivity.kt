package com.example.parcial1_pdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.parcial1_pdm.R
import com.example.parcial1_pdm.viewmodel.PartidoViewmodel

class NewPArtidoActivity : AppCompatActivity() {

    private lateinit var ET_id: EditText
    private lateinit var ET_fecha: EditText
    private lateinit var ET_horas: EditText
    private lateinit var ET_eq1: EditText
    private lateinit var ET_ptseq1: EditText
    private lateinit var ET_eq2: EditText
    private lateinit var ET_ptseq2: EditText

    private lateinit var PartidoViewmodel: PartidoViewmodel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_partido)

        val cont: Int = this.intent.extras.getInt("cont")
        ET_id = findViewById(R.id.ET_idPartido)
        PartidoViewmodel = ViewModelProviders.of(this).get(PartidoViewmodel::class.java)
        ET_fecha = findViewById(R.id.ET_fecha)
        ET_horas = findViewById(R.id.ET_horas)
        ET_eq1 = findViewById(R.id.ET_nombreEQ1)
        ET_ptseq1 = findViewById(R.id.ET_ptsEQ1)
        ET_eq2 = findViewById(R.id.ET_nombreEQ2)
        ET_ptseq2 = findViewById(R.id.ET_ptsEQ2)
        val button = findViewById<Button>(R.id.btn_aceptar)

        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(ET_id.text) ) {
                Toast.makeText(this, "no se puede ingresar", Toast.LENGTH_SHORT).show()
            }

            else {
                var sizeb  = 0
                PartidoViewmodel.allPartidos.observe(this, Observer { partidos ->
                    partidos?.let { sizeb = it.size }
                })

                Log.d("tamaño", sizeb.toString())

                val idpartido = ET_id.text.toString()
                val fecha = ET_fecha.text.toString()
                val hora = ET_horas.text.toString()
                val equipo1 = ET_eq1.text.toString()
                val equipo2 = ET_eq2.text.toString()
                val ptsequipo1 = ET_ptseq1.text.toString()
                val ptsequipo2 = ET_ptseq2.text.toString()






                val book = Book(cont, "",word ,"", "", "", false, 0)
                val author = Author(cont, auth)
                val publisher = Publisher(cont, publ)
                bookViewModel.insertBook(book)
                bookViewModel.insertAuthor(author)
                bookViewModel.insertPublisher(publisher)
                //val author = editAuthorView.text.toString()
                //replyIntent.putExtra(EXTRA_REPLY, word)
                //replyIntent.putExtra(EXTRA_REPLY2, author)
                //setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    }

}
