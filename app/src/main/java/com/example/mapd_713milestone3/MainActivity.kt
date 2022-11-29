package com.example.mapd_713milestone3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddPatient = findViewById<Button>(R.id.buttonAddPatient)
        val buttonViewPatientInfo = findViewById<Button>(R.id.buttonViewPatientInfo)
        val buttonListAllAPatients = findViewById<Button>(R.id.buttonListAllPatient)

        buttonAddPatient.setOnClickListener()
        {
            val i = Intent(this,AddPatientActivity::class.java)
            startActivity(i)
        }

        buttonViewPatientInfo.setOnClickListener()
        {
            val i = Intent(this,ViewPatientInfoActivity::class.java)
            startActivity(i)
        }

        buttonListAllAPatients.setOnClickListener{
            val i = Intent(this,ListAllPatientsActivity::class.java)
            startActivity(i)
        }
    }

}