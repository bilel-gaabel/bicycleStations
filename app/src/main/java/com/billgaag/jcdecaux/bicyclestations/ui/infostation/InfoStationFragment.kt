package com.billgaag.jcdecaux.bicyclestations.ui.infostation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bill_gaag.jcdecaux.bicyclestations.R
import com.billgaag.jcdecaux.bicyclestations.di.component.DaggerFragmentComponent
import com.billgaag.jcdecaux.bicyclestations.di.module.FragmentModule
import com.billgaag.jcdecaux.bicyclestations.models.Station
import kotlinx.android.synthetic.main.fragment_info_station.*
import javax.inject.Inject

/**
 * Created by bill_gaag on 31/08/2018.
 */
class InfoStationFragment : Fragment(), InfoStationContract.View {

    private val stationTag: String = "stationTag"

    @Inject
    lateinit var presenter: InfoStationContract.Presenter

    private lateinit var rootView: View


    fun newInstance(station: Station): InfoStationFragment {
        var infoStationInstance = InfoStationFragment()
        var arg = Bundle()
        arg.putParcelable(stationTag, station)
        infoStationInstance.arguments = arg
        return infoStationInstance
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_info_station, container, false)
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
            infoProgressBar.visibility = View.VISIBLE
        } else {
            infoProgressBar.visibility = View.GONE
        }
    }

    private fun injectDependency() {
        val aboutComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule())
                .build()

        aboutComponent.inject(this)
    }

    private fun initView() {
        infoLayout.visibility = View.GONE
        showProgress(true)
        val station: Station = arguments!!.getParcelable(stationTag)
        info_station_name.text = station.name
        info_station_address.text = station.address
        infoLayout.visibility = View.VISIBLE
        showProgress(false)
    }

    companion object {
        val TAG: String = "InfoStationFragment"
    }

}