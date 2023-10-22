package com.example.semana06fragments.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.example.semana06fragments.R

class RegistroFragment : Fragment() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_registro, container, false)

        val btnSave: Button = view.findViewById(R.id.btnSave)
        val etFullName: EditText = view.findViewById(R.id.etFullName)
        val etEmail: EditText = view.findViewById(R.id.etEmail)
        val spCountry: Spinner = view.findViewById(R.id.spnCountry)
        val rgGender: RadioGroup = view.findViewById(R.id.rgGender)
        val chkLicense: CheckBox = view.findViewById(R.id.chkLicense)
        val chkCar: CheckBox = view.findViewById(R.id.chkCar)

        ArrayAdapter.createFromResource(requireContext(),
            R.array.country_array,
            android.R.layout.simple_spinner_item).also{
                adapter -> adapter
                    .setDropDownViewResource(
                        android.R.layout.simple_spinner_dropdown_item)
                spCountry.adapter = adapter
        }

        var spCountryValue = ""

        spCountry.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                spCountryValue = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnSave.setOnClickListener{
            var fullNameValue = etFullName.text.toString()
            var emailValue = etEmail.text.toString()
            var intSelectedButton = rgGender!!.checkedRadioButtonId
            var rbtSelected: RadioButton = view.findViewById(intSelectedButton)
            var genderValue = rbtSelected.text

            var allValues = "Full Name: $fullNameValue \nEmail: $emailValue \nGender: $genderValue"
                            " \nCountry: $spCountryValue \nLicense: ${chkLicense.isChecked}"
                            " \nCar: ${chkCar.isChecked}"

            Toast.makeText(requireContext(),allValues,Toast.LENGTH_LONG).show()
        }

        return view
    }
}