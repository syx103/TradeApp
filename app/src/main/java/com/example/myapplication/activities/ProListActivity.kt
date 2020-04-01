package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.CommonAdapter
import com.example.myapplication.base.SwipeCloseActivity
import com.example.myapplication.data.bean.ItemInfo
import com.example.myapplication.databinding.ActivityProductListBinding
import com.example.myapplication.utils.InjectorUtils
import com.example.myapplication.viewModels.ProListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProListActivity : SwipeCloseActivity() {
    private var itemInfoList = ArrayList<ItemInfo>()

    private val viewModel by lazy { ViewModelProviders
            .of(this, InjectorUtils.injectorUtils.productListModelFactory)
            .get(ProListViewModel::class.java) }

    private val binding: ActivityProductListBinding by lazy { DataBindingUtil
            .setContentView<ActivityProductListBinding>(this, R.layout.activity_product_list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

        val adapter = CommonAdapter(R.layout.prolist_item, itemInfoList)
        binding.recyclerView2.apply {
            setAdapter(adapter)
            layoutManager = LinearLayoutManager(context)
            adapter.onListItemClicked = object : CommonAdapter.OnListItemClicked {
                override fun onItemClick(view: View, pos: Int) {
                    val intent = Intent(this@ProListActivity, ProDetailsActivity::class.java)
                    intent.putExtra("id", itemInfoList[pos].id)
                    startActivity(intent)
                }
            }
        }

        MainScope().launch(Dispatchers.Main) {
            viewModel.isLoading.value = true
            val list = withContext(Dispatchers.IO) {
                viewModel.getProList(requireNotNull(intent.getStringExtra("category"))) as ArrayList<ItemInfo>
            }
            viewModel.itemList.value = list
            itemInfoList.addAll(list)
            adapter.notifyDataSetChanged()
            viewModel.isLoading.value = false
        }
    }

    private fun initView() {
        binding.apply {
            proListViewModel = viewModel
            lifecycleOwner = this@ProListActivity
        }
    }

    fun backToProMain(view: View?) {
        onBackPressed()
    }
}