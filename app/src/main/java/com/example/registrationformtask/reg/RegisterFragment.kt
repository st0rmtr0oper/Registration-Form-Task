package com.example.registrationformtask.reg

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.registrationformtask.databinding.FragmentRegisterBinding
import java.util.Calendar
import com.example.registrationformtask.R

class RegisterFragment: Fragment() {
    //for DatePicker
    private val myCalendar: Calendar = Calendar.getInstance()

    //DataBinding
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //DataBinding
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_register, container, false
        )

        //DatePicker
//        val date =
//            DatePickerDialog.OnDateSetListener { _, year, month, day ->
//                myCalendar.set(Calendar.YEAR, year)
//                myCalendar.set(Calendar.MONTH, month)
//                myCalendar.set(Calendar.DAY_OF_MONTH, day)
//                updateLabel()
//            }
//        binding.birthday.editText?.setOnClickListener {
//            DatePickerDialog(
//                requireActivity(),
//                date,
//                myCalendar.get(Calendar.YEAR),
//                myCalendar.get(Calendar.MONTH),
//                myCalendar.get(Calendar.DAY_OF_MONTH)
//            ).show()
//        }

        //ClickListener
//        binding.regButton.setOnClickListener {
//            val check: Boolean = validate()
//            if (check) {
//                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToMainFragment())
//                //TODO args? (name)
//            }
//        }



        return binding.root
    }
}