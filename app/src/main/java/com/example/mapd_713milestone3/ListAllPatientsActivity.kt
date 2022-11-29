package com.example.mapd_713milestone3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class ListAllPatientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_all_patients)

        val listViewPatients = findViewById<ListView>(R.id.listViewPatients)
        val patients = arrayOf<String>()
        val plist = ArrayList<String>(listOf(*patients))
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, plist)
        listViewPatients.adapter = arrayAdapter


        val url = "https://lit-castle-65770.herokuapp.com/patients"
        val queue = Volley.newRequestQueue(this)

        var currentIDString = ""

        val request = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                //  Log.e("Error", response.toString())
                val data = response.toString()
                var jArray = JSONArray(data)


                //Get Each object
                for(i in 0..jArray.length()-1)
                {
                    var jObject = jArray.getJSONObject(i)

                    // playerID = jObject.getString("_id")
                    var patient_ID = jObject.getString("_id")
                    var first_name = jObject.getString("first_name")
                    val last_name = jObject.getString("last_name")
                    var phone = jObject.getString("phone_number")

                    currentIDString = "$currentIDString\n$patient_ID"


                   // println("$patient_ID | $first_name | $last_name")

                    arrayAdapter.add("Patient ID:    $patient_ID\nFirst Name:  $first_name\nLast Name:  $last_name\nPhone:          $phone")

                }


            }, Response.ErrorListener {  })

        queue.add(request)
        println(currentIDString)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menufile,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.itemGoBack ->
            {
                finish()
            }
        }

        return true
    }
}