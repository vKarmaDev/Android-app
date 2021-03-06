package com.vkarmaedu.vkarma.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vkarmaedu.vkarma.R
import com.vkarmaedu.vkarma.adapters.TestAdapter
import com.vkarmaedu.vkarma.dataModels.Results
import com.vkarmaedu.vkarma.utility.popBackStack
import kotlinx.android.synthetic.main.fragment_result_detail.view.*

class ResultDetailFragment : Fragment() {

    private val myAdapter = TestAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_result_detail, container, false)
        root.recycler_view.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
        }

        root.toolbar.setNavigationOnClickListener {
            popBackStack(activity)
        }

        val list = ArrayList<Results>()
        for (i in 0..6){
            list.add(Results("Test Name 1", "Physics", 25, 20))
        }
        myAdapter.updateData(list)

        return root
    }
}