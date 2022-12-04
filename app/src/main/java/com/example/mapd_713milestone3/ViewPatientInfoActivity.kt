package com.example.mapd_713milestone3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class ViewPatientInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_patient_info)

    }

    fun viewButton_Clicked(v: View)
    {

        var editTextPatientID = findViewById<EditText>(R.id.editTextPatientID)
        val patientID = editTextPatientID.text.toString().trim()

        val url = "https://mapd714server.onrender.com/patients/$patientID"
       // val url = "http://127.0.0.1:3000/patients/$patientID"
        val queue = Volley.newRequestQueue(this)

        val textViewFirstName = findViewById<TextView>(R.id.textViewFirstName)
        val textViewLastName = findViewById<TextView>(R.id.textViewLastName)
        val textViewAddress = findViewById<TextView>(R.id.textViewAddress)
        val textViewDateOfBirth = findViewById<TextView>(R.id.textViewDateOfBirth)
        val textViewDepartment = findViewById<TextView>(R.id.textViewDepartment)
        val textViewDoctor = findViewById<TextView>(R.id.textViewDoctor)
        val textViewSex = findViewById<TextView>(R.id.textViewSex)
        val textViewPhoneNumber = findViewById<TextView>(R.id.textViewPhoneNumber)
        val textViewDateOfAdmission = findViewById<TextView>(R.id.textViewDateOfAdmission)
        val textViewBedNumber = findViewById<TextView>(R.id.textViewBedNumber)
        val textViewPhoto = findViewById<TextView>(R.id.textViewPhoto)
        val textViewEmergencyFirstName = findViewById<TextView>(R.id.textViewEmergencyFirstName)
        val textViewEmergencyLastName = findViewById<TextView>(R.id.textViewEmergencyLastName)
        val textViewEmergencyPhoneNumber = findViewById<TextView>(R.id.textViewEmergencyPhoneNumber)




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
                    var first_name = jObject.getString("first_name")
                    val last_name = jObject.getString("last_name")
                    val address = jObject.getString("address")
                    val date_of_birth = jObject.getString("date_of_birth")
                    val department = jObject.getString("department")
                    val doctor = jObject.getString("doctor")
                    val sex = jObject.getString("sex")
                    val phone_number = jObject.getString("phone_number")
                    val emergency_contact_first_name = jObject.getString("emergency_contact_first_name")
                    val emergency_contact_last_name = jObject.getString("emergency_contact_last_name")
                    val emergency_contact_phone_number = jObject.getString("emergency_contact_phone_number")
                    val date_of_admission = jObject.getString("date_of_admission")
                    val bed_number = jObject.getString("bed_number")
                    val photo = jObject.getString("photo")

                    textViewFirstName.setText(first_name.toString())
                    textViewLastName.setText(last_name.toString())
                    textViewAddress.setText(address.toString())
                    textViewDateOfBirth.setText(date_of_birth.toString())
                    textViewDepartment.setText(department.toString())
                    textViewDoctor.setText(doctor.toString())
                    textViewSex.setText(sex.toString())
                    textViewPhoneNumber.setText(phone_number.toString())
                    textViewDateOfAdmission.setText(date_of_admission.toString())
                    textViewBedNumber.setText(bed_number.toString())
                    textViewPhoto.setText(photo.toString())
                    textViewEmergencyFirstName.setText(emergency_contact_first_name.toString())
                    textViewEmergencyLastName.setText(emergency_contact_last_name.toString())
                    textViewEmergencyPhoneNumber.setText(emergency_contact_phone_number.toString())

                }


            }, Response.ErrorListener {

                println(it.toString())
            })

        queue.add(request)

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