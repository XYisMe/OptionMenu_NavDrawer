package com.example.bottomnavview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.bottomnavview.R


/**
 * A simple [Fragment] subclass.
 * Use the [ScanFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScanFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_scan, container, false)
        val tv_scan:TextView = view.findViewById(R.id.tv_scan)
        tv_scan.setOnClickListener {
            val action = ScanFragmentDirections.actionScanToProfile()
            findNavController().navigate(action)
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = ScanFragment()
    }
}