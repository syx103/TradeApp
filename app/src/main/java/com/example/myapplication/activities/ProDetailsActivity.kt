package com.example.myapplication.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.base.SwipeCloseActivity
import com.example.myapplication.databinding.ActivityProductDetailsBinding
import com.example.myapplication.utils.InjectorUtils
import com.example.myapplication.viewModels.ProDetailsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProDetailsActivity : SwipeCloseActivity() {

    private val viewModel by lazy {
        ViewModelProviders
                .of(this, InjectorUtils.injectorUtils.productDetailsModelFactory)
                .get(ProDetailsViewModel::class.java)
    }

    private val binding: ActivityProductDetailsBinding by lazy {
        DataBindingUtil
                .setContentView<ActivityProductDetailsBinding>(this, R.layout.activity_product_details)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

        MainScope().launch(Dispatchers.Main) {
            viewModel.isLoading.value = true
            val details = withContext(Dispatchers.IO) {
                viewModel.getProDetails(intent.getIntExtra("id", 0))
            }
            viewModel.productDetails.value = details
            viewModel.isLoading.value = false
        }

        viewModel.isLoading.observe(this, Observer {
            binding.loadingView.visibility = if (it == true) View.VISIBLE else View.GONE
        })
    }

    private fun initView() {
        binding.apply {
            proDetailsViewModel = viewModel
            lifecycleOwner = this@ProDetailsActivity
        }
    }

    fun backToProListActivity(view: View?) {
        onBackPressed()
    }

    fun jumpToCall(view: View?) {
        val tel = binding.tvTel.text
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$tel")
        startActivity(intent)
    }
}