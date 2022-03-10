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


class Second : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_second, container, false)
        var seekBar = view.findViewById<SeekBar>(R.id.fg_second_seekbar)


        activity?.let { it ->
            ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory(it.application)).get(VmSeekbar::class.java)
        }
        var vm = activity?.let {
            val vm = ViewModelProvider(it,
                ViewModelProvider.AndroidViewModelFactory(requireActivity().application)).get(
                VmSeekbar::class.java)
            vm.getProgress().observe(it) { i ->
                seekBar.progress = i
            }
            vm

        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, boolean: Boolean) {
                vm ?: Log.e("SeekBar", "====onProgressChanged====")
                vm?.getProgress()?.value = progress
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
        return view

    }

}