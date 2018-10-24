package com.ahasanidea.kotlin.androidservice.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ahasanidea.kotlin.androidservice.PlayService
import com.ahasanidea.kotlin.androidservice.R
import com.ahasanidea.kotlin.androidservice.SecondActivity

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view=inflater.inflate(R.layout.main_fragment, container, false)
        val btnStart=view.findViewById<Button>(R.id.buttonStart)
        btnStart.setOnClickListener{
         context!!.startService(Intent(context,PlayService::class.java))
        }
        val btnStop=view.findViewById<Button>(R.id.buttonStop)
        btnStop.setOnClickListener {
            context!!.stopService(Intent(context,PlayService::class.java))
        }
        val btnNext=view.findViewById<Button>(R.id.buttonNext)
        btnNext.setOnClickListener {
         val intent=Intent(context,SecondActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
