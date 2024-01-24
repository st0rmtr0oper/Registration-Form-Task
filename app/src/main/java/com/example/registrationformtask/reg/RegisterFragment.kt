package com.example.registrationformtask.reg

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.registrationformtask.databinding.FragmentRegisterBinding
import java.util.Calendar
import com.example.registrationformtask.R
import java.text.SimpleDateFormat
import java.util.Locale
import androidx.navigation.fragment.findNavController


class RegisterFragment: Fragment() {
    //for DatePicker
    private val myCalendar: Calendar = Calendar.getInstance()

    //DataBinding
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //DataBinding
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_register, container, false
        )

        //DatePicker
        val date =
            DatePickerDialog.OnDateSetListener { _, year, month, day ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, day)
                updateLabel()
            }
        binding.date.editText?.setOnClickListener {
            DatePickerDialog(
                requireActivity(),
                date,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        //ClickListener
        binding.materialButton.setOnClickListener {
            val check: Boolean = validate()
            if (check) {
                val username = binding.name.editText?.text.toString()
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToGreetingsFragment(username))
            }
        }

        return binding.root
    }
    private fun updateLabel() {
        val myFormat = "MM.dd.yyyy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        binding.date.editText?.setText(dateFormat.format(myCalendar.time))
    }

    private fun validate(): Boolean {
        val name: String = binding.name.editText?.text.toString()
        val surname: String = binding.surname.editText?.text.toString()
        val birthday: String = binding.date.editText?.text.toString()
        val password: String = binding.password.editText?.text.toString()
        val confirmedPassword: String = binding.passwordConfirm.editText?.text.toString()


        if (name.isEmpty() || name.length < 2) {
            showHint(binding.name.editText, "Имя должно содержать более 2 символов")
            return false
        } else if (name.contains("[0-9]".toRegex()) || name.contains("[!\"#$%&'()*+,./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())) {
            showHint(binding.name.editText, "Имя должно содержать только буквы")
            return false
        } else if (surname.isEmpty() || surname.length < 2) {
            showHint(binding.surname.editText, "Фамилия должна содержать более 2 символов")
            return false
        } else if (surname.contains("[0-9]".toRegex()) || surname.contains("[!\"#$%&'()*+,./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())) {
            showHint(binding.surname.editText, "Фамилия должно содержать только буквы")
            return false
        } else if (birthday.isEmpty()) {
            showHint(binding.date.editText, "Введите значение")
            return false
        } else if (password.length < 5) {
            showHint(binding.password.editText, "Пароль должен содержать более 5 символов")
            return false
        } else if (password.isEmpty() || !password.contains("[0-9]".toRegex()) || !password.contains(
                "[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex()
            )
        ) {
            showHint(binding.password.editText, "Слабый пароль. Пожалуйста, добавьте цифры и другие символы (!?.,=<> и тд.)")
            return false
        } else if (confirmedPassword.isEmpty() || confirmedPassword != password) {
            showHint(binding.passwordConfirm.editText, "Пароли не сходятся")
            return false
        } else {
            return true
        }

    }
    private fun showHint(text: EditText?, hint: String) {
        text?.error = hint
        text?.requestFocus()
    }
}