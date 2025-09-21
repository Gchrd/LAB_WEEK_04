    package com.example.lab_week_04

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import androidx.fragment.app.FragmentManager
    import androidx.lifecycle.Lifecycle
    import androidx.viewpager2.adapter.FragmentStateAdapter
    import android.widget.TextView

    val TABS_FIXED = listOf(
        R.string.starbucks_title,
        R.string.janjijiwa_title,
        R.string.kopikenangan_title,
    )

    val TABS_CONTENT = listOf(
        R.string.starbucks_desc,
        R.string.janjijiwa_desc,
        R.string.kopikenangan_desc,
    )

    class CafeAdapter(
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle
    ) : FragmentStateAdapter(fragmentManager, lifecycle) {

        override fun getItemCount(): Int = TABS_FIXED.size

        override fun createFragment(position: Int): Fragment {
            return CafeDetailFragment.newInstance(TABS_CONTENT[position])
        }

        class CafeDetailFragment : Fragment() {

            private var cafeDescription: String? = null

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                arguments?.let {
                    val stringResId = it.getInt(ARG_CAFE_DESC_RES_ID)
                    cafeDescription = getString(stringResId)
                }
            }

            override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                val view = inflater.inflate(
                    R.layout.fragment_cafe_detail,
                    container,
                    false
                )

                val descriptionTextView: TextView =
                    view.findViewById(R.id.content_description)
                descriptionTextView.text = cafeDescription

                return view
            }

            companion object {
                private const val ARG_CAFE_DESC_RES_ID = "cafe_desc_res_id"

                @JvmStatic
                fun newInstance(cafeDescResId: Int) =
                    CafeDetailFragment().apply {
                        arguments = Bundle().apply {
                            putInt(ARG_CAFE_DESC_RES_ID, cafeDescResId)
                        }
                    }
            }
        }
    }
