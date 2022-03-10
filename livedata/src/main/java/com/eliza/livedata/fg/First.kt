package com.eliza.livedata.fg

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider
import com.eliza.livedata.R
import com.eliza.livedata.vm.VmSeekbar

class First : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_first, container, false)
        var seekBar = view.findViewById<SeekBar>(R.id.fg_first_seekbar)


        var vm = ViewModelProvider(requireActivity(),
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)).get(
            VmSeekbar::class.java)
        vm.getProgress().observe(requireActivity()) { i ->
            seekBar.progress = i
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, boolean: Boolean) {
                Log.e("SeekBar", "====onProgressChanged====")
                vm.getProgress().value = progress
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        return view
    }

}