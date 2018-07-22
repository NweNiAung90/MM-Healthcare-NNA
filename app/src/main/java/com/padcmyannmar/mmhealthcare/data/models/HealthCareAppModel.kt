/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.data.models
//------------------------------------------------------------------------------
import com.padcmyannmar.mmhealthcare.data.vos.HealthCareVO
import com.padcmyannmar.mmhealthcare.events.DataEvent
import com.padcmyannmar.mmhealthcare.network.HealthCareDataAgent
import com.padcmyannmar.mmhealthcare.network.RetrofitDataAgentImpl
import com.padcmyannmar.mmhealthcare.utils.HealthCareConstants
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
//------------------------------------------------------------------------------
class HealthCareAppModel {
    companion object {
        // private var mNewsPage: Int = 1
        private var mHealthCareData: HashMap<Int, HealthCareVO> = HashMap()

        private val DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916"

        private var mDataAgent: HealthCareDataAgent = RetrofitDataAgentImpl.getInstance()

        /* Singleton Design Pattern */
        //2. static class type attribute
        private var INSTANCE: HealthCareAppModel? = null
        fun getInstance(): HealthCareAppModel {
            if (INSTANCE == null) {
                INSTANCE = HealthCareAppModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    //1. private constructor
    private constructor() {
        /* 2 steps for listen  broadcast event from EventBus
           1. register event
           2. define Event listen method
        * */
        EventBus.getDefault().register(this)
    }

    /*
     * loadHealthCareInfo - This method is called load Health Care Info List from network call
     *
     * @param accessToken
     * @return void         listen response asynchronously
     */
    fun loadHealthCareInfo() {
        mDataAgent.loadMMHealthCareInfo(DUMMY_ACCESS_TOKEN)
    }

    fun forceLoadHealthCareInfo() {
        //mNewsPage = 1
        mHealthCareData = HashMap()
        mDataAgent.loadMMHealthCareInfo(DUMMY_ACCESS_TOKEN)
    }

    /*Send Id to details activity
      Retrieve data from data Repository
    */
    fun getHealthCareById(healthCareId: Int): HealthCareVO? {
        // return null //TODO remove this after testing empty view layout in news details screen.
        return mHealthCareData[healthCareId]
    }

    //composite
    /* Define Event Listen Method */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onHealthCareLoadedEvent(healthCareLoadedEvent: DataEvent.HealthCareInfoLoadedEvent) {
        for (healthcareinfo: HealthCareVO in healthCareLoadedEvent.loadedHealthCareInfo) {
            mHealthCareData[healthcareinfo.id] = healthcareinfo
        }
        //mNewsPage = healthCareLoadedEvent.loadedPageIndex + 1
    }

//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------