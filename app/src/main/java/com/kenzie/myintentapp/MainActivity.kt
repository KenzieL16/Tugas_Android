package com.kenzie.myintentapp

import android.app.Person
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityWithDataActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveActivityWithObjectActivity: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveActivityWithObjectActivity.setOnClickListener(this)

        val btnMoveActivityWithResult: Button = findViewById(R.id.btn_move_activity_result)
        btnMoveActivityWithResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

        if (intent.extras != null){
            val hasil = intent.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
            val text = "Hasil = $hasil"
            tvResult.setText(text)
        }

}

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)

            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Kenzie Liviano")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 17)
                startActivity(moveWithDataIntent)
                }
            R.id.btn_dial_number -> {
                val phoneNumber = "081212506522"
                val dialPhoneIntent =
                    Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
                }
            R.id.btn_move_activity_object -> {
                val person = Person("Kenzie", "kenzieliviano16@gmail.com", "Malang")
                val moveWithObjectActivity = Intent(this@MainActivity,
                    MoveWithObjectActivity::class.java)
                moveWithObjectActivity.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectActivity)
            }
            R.id.btn_move_activity_result-> {
                val moveForResultIntent=
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                startActivity(moveForResultIntent)
            }
        }

    }




}