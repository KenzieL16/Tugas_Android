package com.kenzie.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        if (intent != null){
            val tvObject : TextView = findViewById(R.id.tv_object)
            val manusia : Person? = intent.getParcelableExtra(EXTRA_PERSON)
            val nama : String? = manusia?.nama
            val email : String? = manusia?.email
            val alamat : String? = manusia?.alamat
            val text = "Nama : $nama, Email : $email, Alamat : $alamat"
            tvObject.setText(text)
        }
    }
    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
}