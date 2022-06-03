package com.a2r.codereview.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.a2r.codereview.databinding.FragmentResidentsBinding
import com.a2r.codereview.viewmodel.ResidentsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentResidents : Fragment() {

    private lateinit var binding: FragmentResidentsBinding
    private lateinit var text: TextView
    private lateinit var btn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //used viewBinding instead of the manual findViewById method
        binding = FragmentResidentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val residentViewModel =
            ViewModelProvider(requireActivity()).get(ResidentsViewModel::class.java)

        text = binding.residentsText
        btn = binding.btn

        //observing outside button click scope in order to survive screen rotate event
        residentViewModel.getResidentsObservable().observe(viewLifecycleOwner) {
            //used join instead of looping
            text.text = it.joinToString("\n")
        }
        btn.setOnClickListener {
            // removed thread call and used coroutines on viewModel side
            residentViewModel.getResidents()
        }
    }
}
