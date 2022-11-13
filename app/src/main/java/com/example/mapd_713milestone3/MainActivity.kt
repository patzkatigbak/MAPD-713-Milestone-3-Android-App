package com.example.mapd_713milestone3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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

    val postPatient = "https://lit-castle-65770.herokuapp.com/patients"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun request_pressed(v: View)
    {
        val editTextFirstName = findViewById<EditText>(R.id.editTextFirstName)
        val editTextLastName = findViewById<EditText>(R.id.editTextLastName)
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        val editTextDateOfBirth = findViewById<EditText>(R.id.editTextDateOfBirth)
        val editTextDepartment = findViewById<EditText>(R.id.editTextDepartment)
        val editTextDoctor = findViewById<EditText>(R.id.editTextTextDoctor)
        val editTextSex = findViewById<EditText>(R.id.editTextSex)
        val editTextPhoneNumber = findViewById<EditText>(R.id.editTextPhoneNumber)
        val editTextEmergencyFirstName = findViewById<EditText>(R.id.editTextEmergencyFirstName)
        val editTextEmergencyLastName = findViewById<EditText>(R.id.editTextEmergencyLastName)
        val editTextEmergencyPhoneNumber = findViewById<EditText>(R.id.editTextPhoneNumber)
        val editTextDateOfAdmission = findViewById<EditText>(R.id.editTextDateOfAdmission)
        val editTextBedNumber = findViewById<EditText>(R.id.editTextBedNumber)
        val editTextPhoto = findViewById<EditText>(R.id.editTextPhoto)

        val firstName = editTextFirstName.text.toString()
        val lastName = editTextLastName.text.toString()
        val address = editTextAddress.text.toString()
        val dateOfBirth = editTextDateOfBirth.text.toString()
        val department = editTextDepartment.text.toString()
        val doctorName = editTextDoctor.text.toString()
        val sex = editTextSex.text.toString()
        val phoneNumber = editTextPhoneNumber.text.toString()
        val emergencyFirstName = editTextEmergencyFirstName.text.toString()
        val emergencyLastName = editTextEmergencyLastName.text.toString()
        val emergencyPhoneNumber = editTextEmergencyPhoneNumber.text.toString()
        val dateOfAdmission = editTextDateOfAdmission.text.toString()
        val bedNumber = editTextBedNumber.text.toString()
        val photo = editTextPhoto.text.toString()

        val jsonBody = JSONObject()
        jsonBody.put("first_name",firstName)
        jsonBody.put("last_name",lastName)
        jsonBody.put("address",address)
        jsonBody.put("date_of_birth",dateOfBirth)
        jsonBody.put("department",department)
        jsonBody.put("doctor",doctorName)
        jsonBody.put("sex",sex)
        jsonBody.put("phone_number",phoneNumber)
        jsonBody.put("emergency_contact_first_name",emergencyFirstName)
        jsonBody.put("emergency_contact_last_name",emergencyLastName)
        jsonBody.put("emergency_contact_phone_number",emergencyPhoneNumber)
        jsonBody.put("date_of_admission",dateOfAdmission)
        jsonBody.put("bed_number",bedNumber)
        jsonBody.put("photo",photo)

//            jsonBody.put("sex",sex)
//            jsonBody.put("phoneNumber",phoneNumber)
        val queue = Volley.newRequestQueue(this)
        val requestBody = "first_name=${jsonBody.get("first_name")}" +
                "&last_name=${jsonBody.get("last_name")}" +
                "&address=${jsonBody.get("address")}"+
                "&date_of_birth=${jsonBody.get("date_of_birth")}" +
                "&department=${jsonBody.get("department")}" +
                "&doctor=${jsonBody.get("doctor")}" +
                "&sex=${jsonBody.get("sex")}" +
                "&phone_number=${jsonBody.get("phone_number")}" +
                "&emergency_contact_first_name=${jsonBody.get("emergency_contact_first_name")}" +
                "&emergency_contact_last_name=${jsonBody.get("emergency_contact_last_name")}" +
                "&emergency_contact_phone_number=${jsonBody.get("emergency_contact_phone_number")}" +
                "&date_of_admission=${jsonBody.get("date_of_admission")}" +
                "&bed_number=${jsonBody.get("bed_number")}" +
                "&photo=${jsonBody.get("photo")}"

        val stringReq : StringRequest =
            object : StringRequest(Method.POST, postPatient,
                Response.Listener { response ->
                    // response
                    var strResp = response.toString()
                },
                Response.ErrorListener { error ->
                    print(error)
                }
            ){
                override fun getBody(): ByteArray {
                    return requestBody.toByteArray(Charset.defaultCharset())
                }
            }
        queue.add(stringReq)


    }


}