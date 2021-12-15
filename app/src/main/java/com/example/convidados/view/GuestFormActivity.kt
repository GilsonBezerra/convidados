package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.viewmodel.GuestFormViewModel
import com.example.convidados.R
import com.example.convidados.service.model.GuestModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        // Atribuir a referência da ViewModel da activity
        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observe()

    }

    override fun onClick(v: View) {
        val id = v.id
        if(id == R.id.btn_save) {
            val name = findViewById<EditText>(R.id.edt_input_nome).text.toString()
            val presence = findViewById<RadioButton>(R.id.radio_presente).isChecked

            mViewModel.save(name, presence)
        }
    }

    private fun setListeners() {
        val buttonSave = findViewById<Button>(R.id.btn_save)
        buttonSave.setOnClickListener(this)
    }

    // Observer
    private fun observe() {
        mViewModel.saveGuest.observe(this, Observer {
            if(it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
            finish()
        })
    }

}