package com.billgaag.jcdecaux.bicyclestations.ui.liststations

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bill_gaag.jcdecaux.bicyclestations.R
import com.billgaag.jcdecaux.bicyclestations.di.component.DaggerFragmentComponent
import com.billgaag.jcdecaux.bicyclestations.di.module.FragmentModule
import com.billgaag.jcdecaux.bicyclestations.models.Station
import com.billgaag.jcdecaux.bicyclestations.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject


/**
 * Created by bill_gaag on 31/08/2018.
 */
class ListStationsFragment : Fragment(), ListStationsContract.View, ListStationsAdapter.onItemClickListener {

    @Inject
    lateinit var presenter: ListStationsContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): ListStationsFragment {
        return ListStationsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(activity,error,Toast.LENGTH_LONG).show()
    }

    override fun loadDataSuccess(list: List<Station>) {
        var adapter = ListStationsAdapter(this!!.activity!!, list.toMutableList(), this)
        recyclerView!!.setLayoutManager(LinearLayoutManager(activity))
        recyclerView!!.setAdapter(adapter)

    }


    override fun itemDetail(station: Station) {
        if (activity is MainActivity)
            (activity as MainActivity).showInfoStationFragment(station)
    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule())
                .build()

        listComponent.inject(this)
    }

    private fun initView() {
        presenter.loadData()
    }

    companion object {
        val TAG: String = "ListStationsFragment"
    }
}