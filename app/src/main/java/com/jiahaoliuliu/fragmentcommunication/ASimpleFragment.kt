package com.jiahaoliuliu.fragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 * Use the [ASimpleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ASimpleFragment : Fragment() {
    companion object {
        const val REQUEST_KEY = "RequestKey"
        const val CONTENT_KEY = "Content"
        const val CONTENT_VALUE = "Surprise!"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a_simple, container, false)
        val sendDataBackButton = view.findViewById<Button>(R.id.send_data_back_button)
        sendDataBackButton.setOnClickListener {
            sendDataBack()
        }
        return view
    }

    private fun sendDataBack() {
        val data = Bundle()
        data.putString(CONTENT_KEY, CONTENT_VALUE)
        parentFragmentManager.setFragmentResult(REQUEST_KEY, data)
        activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
    }
}