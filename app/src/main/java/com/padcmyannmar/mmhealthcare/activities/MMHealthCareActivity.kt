/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.activities

//------------------------------------------------------------------------------

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.padcmyannmar.mmhealthcare.R
import com.padcmyannmar.mmhealthcare.adapters.HealthCareAdapter
import com.padcmyannmar.mmhealthcare.components.SmartScrollListener
import com.padcmyannmar.mmhealthcare.data.models.HealthCareAppModel
import com.padcmyannmar.mmhealthcare.data.vos.HealthCareVO
import com.padcmyannmar.mmhealthcare.delegates.HealthCareItemDelegates
import com.padcmyannmar.mmhealthcare.events.DataEvent
import com.padcmyannmar.mmhealthcare.events.ErrorEvent
import kotlinx.android.synthetic.main.activity_mm_healthcare_list.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

//------------------------------------------------------------------------------
/*2nd step of Controller Pattern HealthCareItemDelegates */
class MMHealthCareActivity : BaseActivity(), HealthCareItemDelegates {

    private lateinit var mHealthCareAdapter: HealthCareAdapter

    private var mSmartScrollListener: SmartScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mm_healthcare_list)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowTitleEnabled(false)

        rvHealthCare.layoutManager = LinearLayoutManager(applicationContext
                , LinearLayoutManager.VERTICAL
                , false)

        //Load More Data and calculate user scroll reach end of the list

        mSmartScrollListener = SmartScrollListener(object : SmartScrollListener.OnSmartScrollListener {
            override fun onListEndReach() {
                Snackbar.make(rvHealthCare, "Loading more data.", Snackbar.LENGTH_LONG).show()
                swipeRefreshLayout.isRefreshing = true
                HealthCareAppModel.getInstance().loadHealthCareInfo()
            }
        })
        rvHealthCare.addOnScrollListener(mSmartScrollListener)

        mHealthCareAdapter = HealthCareAdapter(applicationContext, this)
        rvHealthCare.adapter = mHealthCareAdapter

        //show loading jatster but never disappear this loading jaster

        swipeRefreshLayout.isRefreshing = true
        //Load Response Data
        HealthCareAppModel.getInstance().loadHealthCareInfo()

        // load data when user pull down
        swipeRefreshLayout.setOnRefreshListener {
            /*val newsAdapterVal = mNewsAdapter
            newsAdapterVal!!.clearData()*/
            HealthCareAppModel.getInstance().forceLoadHealthCareInfo()
        }


        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/
    }

    /*2nd step of Controller Pattern */
    override fun onTapItem(news: HealthCareVO?) {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /* 2n Step Event Bus Listen Method */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onHealthCareLoadedEvent(healthCareLoadedEvent: DataEvent.HealthCareInfoLoadedEvent) {
        //make disappear after loading
        swipeRefreshLayout.isRefreshing = false
        // pass data to Adapter.
        mHealthCareAdapter!!.appendHealthCareData(healthCareLoadedEvent.loadedHealthCareInfo as MutableList<HealthCareVO>)
        //Hide Empty View
        vpEmpty.visibility = View.GONE
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorHealthCareLoadedEvent(errorEvent: ErrorEvent.ApiErrorEvent) {
        //don't show loading jatster because it doesn't make sense loading jaster appear when data cannot load
        swipeRefreshLayout.isRefreshing = false
        //solve bad experience while loading fail
        Snackbar.make(rvHealthCare, "ERROR : " + errorEvent.getMsg(), Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show()
        //Show Empty View
        //emptyViewPod!!.setEmptyData(R.drawable.empty_data_placeholder, getString(R.string.empty_msg))

        vpEmpty.visibility = View.VISIBLE

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEmptyHealthCareLoadedEvent(emptyDataLoadedEvent: DataEvent.EmptyDataLoadedEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvHealthCare, "ERROR : " + emptyDataLoadedEvent.errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show()
        //Show Empty View
        vpEmpty.visibility = View.VISIBLE

    }
//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------