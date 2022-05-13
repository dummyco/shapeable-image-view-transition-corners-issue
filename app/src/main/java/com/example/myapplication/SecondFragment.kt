package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSecondBinding
import com.google.android.material.transition.MaterialContainerTransform

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shapeableImageView.shapeAppearanceModel =
            binding.shapeableImageView.shapeAppearanceModel.toBuilder()
                .setAllCornerSizes(
                    resources.getDimensionPixelOffset(R.dimen.corner_radius)
                        .toFloat()
                )
                .build()

        sharedElementEnterTransition = MaterialContainerTransform().also {
            it.drawingViewId = R.id.nav_host_fragment_content_main
            it.duration = 2000
        }

        sharedElementReturnTransition = MaterialContainerTransform().also {
            it.drawingViewId = R.id.nav_host_fragment_content_main
            it.duration = 2000
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
