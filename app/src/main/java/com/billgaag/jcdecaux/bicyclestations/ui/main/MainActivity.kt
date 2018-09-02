package com.billgaag.jcdecaux.bicyclestations.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bill_gaag.jcdecaux.bicyclestations.R
import com.billgaag.jcdecaux.bicyclestations.di.component.DaggerActivityComponent
import com.billgaag.jcdecaux.bicyclestations.di.module.ActivityModule
import com.billgaag.jcdecaux.bicyclestations.models.Station
import com.billgaag.jcdecaux.bicyclestations.ui.infostation.InfoStationFragment
import com.billgaag.jcdecaux.bicyclestations.ui.liststations.ListStationsFragment
import javax.inject.Inject

/**
 * Created by bill_gaag on 31/08/2018.
 */
class MainActivity : AppCompatActivity(), MainActivityContract.View {
    override fun showInfoStationFragment(station: Station) {
        if (supportFragmentManager.findFragmentByTag(InfoStationFragment.TAG) == null) {
            supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .setCustomAnimations(AnimType.FADE.getAnimPair().first, AnimType.FADE.getAnimPair().second)
                    .replace(R.id.frame, InfoStationFragment().newInstance(station), InfoStationFragment.TAG)
                    .commit()
        } else {
            // Maybe an animation like shake hello text
        }
    }

    override fun showListStationsFragment() {
        supportFragmentManager.beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(AnimType.SLIDE.getAnimPair().first, AnimType.SLIDE.getAnimPair().second)
                .replace(R.id.frame, ListStationsFragment().newInstance(), ListStationsFragment.TAG)
                .commit()
    }

    @Inject lateinit var presenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }

    override fun onResume() {
        super.onResume()
        test()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
       /* when(item!!.itemId) {
            R.id.nav_item_info -> {
                presenter.onDrawerOptionAboutClick()
                return true
            }
            else -> {

            }
        }*/

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(InfoStationFragment.TAG)

        if (fragment == null) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.inject(this)
    }

    private fun test() {
        //hello.setText("Hello world with kotlin extensions")
    }

    enum class AnimType() {
        SLIDE,
        FADE;

        fun getAnimPair(): Pair<Int, Int> {
            when(this) {
                SLIDE -> return Pair(R.anim.slide_left, R.anim.slide_right)
                FADE -> return Pair(R.anim.fade_in, R.anim.fade_out)
            }

            return Pair(R.anim.slide_left, R.anim.slide_right)
        }
    }
}