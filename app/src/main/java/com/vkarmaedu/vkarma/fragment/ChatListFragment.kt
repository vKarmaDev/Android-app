package com.vkarmaedu.vkarma.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vkarmaedu.vkarma.R
import com.vkarmaedu.vkarma.utility.replaceFragmentAddToBackStack
import kotlinx.android.synthetic.main.fragment_chat_list.view.*

class ChatListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_chat_list, container, false)
        root.button.setOnClickListener {
            activity?.let { it1 -> replaceFragmentAddToBackStack(it1, ChatFragment()) }
        }
        return root
    }

}
