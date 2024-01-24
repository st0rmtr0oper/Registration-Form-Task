package com.example.registrationformtask.greetings

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.registrationformtask.R
import com.example.registrationformtask.databinding.FragmentGreetingsBinding
import com.example.registrationformtask.reg.RegisterFragmentArgs

class GreetingsFragment: Fragment() {
    //Data binding
    private lateinit var binding: FragmentGreetingsBinding

    //ViewModels for receiving data
    private lateinit var viewModel: GreetingsViewModel
    private lateinit var viewModelFactory: GreetingsViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //ViewModels
        viewModelFactory =
            GreetingsViewModelFactory(RegisterFragmentArgs.fromBundle(requireArguments()).username)
        viewModel = ViewModelProvider(this, viewModelFactory)[GreetingsViewModel::class.java]

        //DataBinding
            binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_greetings, container, false
        )

        //ClickListener
        binding.greetButton.setOnClickListener {
            val dialogInflater = layoutInflater.inflate(R.layout.window, null)
            val dialog = Dialog(requireActivity())
            dialog.setContentView(dialogInflater)
            dialog.setCancelable(true)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val welcomeModal = dialogInflater.findViewById<TextView>(R.id.greetings_window)
            welcomeModal.text = "Добро пожаловать, ${viewModel.username.value}, чувствуйте себя как дома!))"
            dialog.show()
        }

        return binding.root
    }
}