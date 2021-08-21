package com.samuelting.qrscanner

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class AboutActivity : AppCompatActivity() {

    private lateinit var phone: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        phone = findViewById(R.id.phone)
        phone.setOnClickListener {
            phoneCall()
        }
    }

    private fun phoneCall(){
        var phoneIntent = Intent(Intent.ACTION_DIAL)
        phoneIntent.setData(Uri.parse("tel:27802291"))
        try{
            startActivity(phoneIntent)
            finish()
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this,
            "Call failed, please try again later.",
            Toast.LENGTH_SHORT).show()
        }
    }
}