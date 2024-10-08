package com.android.androidtrainingclass

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        Log.d("Frg onStart", "Frg onStart started")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first, container, false)


        val btn:Button=  view.findViewById(R.id.btn1)

        btn.setOnClickListener {

            val bundle =Bundle()

            bundle.putString("msg","From Fragment A")


         /*   val fragmentB= SecondFragment()

            fragmentB.arguments=bundle

            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentB)
                .addToBackStack(null)
                .commit()*/

        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Frg onViewCreated", "Frg onViewCreated")

    }

    override fun onStart() {
        super.onStart()

        Log.d("Frg onStart", "Frg onStart")

    }

    override fun onResume() {
        super.onResume()

        Log.d("Frg onResume", "Frg onResume")

    }


    override fun onPause() {
        super.onPause()

        Log.d("Frg onPause", "Frg onPause")

    }

    override fun onStop() {
        super.onStop()

        Log.d("Frg onStop", "Frg onStop")

    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.d("Frg onDestroyView", "Frg onDestroyView")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Frg onDestroy", "Frg onDestroy")

    }

    override fun onDetach() {
        super.onDetach()

        Log.d("Frg onDetach", "Frg onDetach")

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}