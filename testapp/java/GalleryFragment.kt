package com.example.fourrwallsrsbtestapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fourrwallsrsbtestapp.data.model.GalleryViewModel
import com.example.fourrwallsrsbtestapp.data.model.GalleryViewModelFactory
import com.example.fourrwallsrsbtestapp.data.repositories.GalleryRepository
import com.example.fourrwallsrsbtestapp.network.PostApi
import com.ouattararomuald.slider.ImageSlider
import com.ouattararomuald.slider.SliderAdapter
import com.ouattararomuald.slider.loaders.picasso.PicassoImageLoaderFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GalleryFragment : Fragment() {

    private lateinit var imageSlider: ImageSlider


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        imageSlider = view.findViewById(R.id.image_slider)
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = PostApi()
        val repository = GalleryRepository(api)

        GlobalScope.launch(Dispatchers.Main) {
            val photos = repository.getPhotos()
            var imageUrls = ArrayList<String>()
            for (i in 0 until photos.size) {
                imageUrls.add(photos[i].url)
            }
            imageSlider.adapter = SliderAdapter(
                requireContext(),
                PicassoImageLoaderFactory(),
                imageUrls = imageUrls,
            )
//            Log.v("Photos", "" + imageUrls)
        }


    }


}