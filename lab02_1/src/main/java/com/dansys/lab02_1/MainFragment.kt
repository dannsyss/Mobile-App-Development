package com.dansys.lab02_1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MainFragment : Fragment() {

    private var someFragmentClickListener: SomeFragmentClickListener?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view?.findViewById<Button>(R.id.btn_change_backbround)?.apply {
            setOnClickListener{
                someFragmentClickListener?.onChangeColorButtonClicked()
            }
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is SomeFragmentClickListener){
            someFragmentClickListener=context
        }
    }

    override fun onDetach() {
        super.onDetach()
        someFragmentClickListener=null
    }

    interface SomeFragmentClickListener{
        fun onChangeColorButtonClicked()
    }
}