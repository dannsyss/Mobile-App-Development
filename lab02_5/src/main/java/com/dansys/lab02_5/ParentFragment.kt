package com.dansys.lab02_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
class ParentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // создаем экземпляр вложенного фрагмента и добавляем его в контейнер
        childFragmentManager.beginTransaction()
            .replace(R.id.child_container, ChildFragment())
            .commit()

        return inflater.inflate(R.layout.fragment_parent, container, false)
    }
}