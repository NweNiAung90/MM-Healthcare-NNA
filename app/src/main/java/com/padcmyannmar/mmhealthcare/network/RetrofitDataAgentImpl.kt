/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 007 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.network
//------------------------------------------------------------------------------
import com.google.gson.Gson
import com.padcmyannmar.mmhealthcare.events.ErrorEvent
import com.padcmyannmar.mmhealthcare.events.DataEvent
import com.padcmyannmar.mmhealthcare.network.responses.GetHealthCareInfoResponse
import com.padcmyannmar.mmhealthcare.utils.HealthCareConstants
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
//------------------------------------------------------------------------------
class RetrofitDataAgentImpl private constructor() :  HealthCareDataAgent{

    companion object {
        /*Factory Logic
         * only one obj for this class type
        */
        private var INSTANCE: RetrofitDataAgentImpl? = null
        fun getInstance(): RetrofitDataAgentImpl {
            if (INSTANCE == null) {
                INSTANCE = RetrofitDataAgentImpl()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private val mHealthCareApi: HealthCareApi

    /*    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
       val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        mNewsApi = retrofit.create(NewsApi::class.java)
    }*/

    override fun loadMMHealthCareInfo(accessToken: String) {
        /* call Interface Type method with param and get Call object*/
        val newsResponseCall = mHealthCareApi.loadMMHealthCareInfo(accessToken)
        // pass Callback Interface as Anonymous Inner Class

        newsResponseCall.enqueue(object : Callback<GetHealthCareInfoResponse> {

            override fun onResponse(call: Call<GetHealthCareInfoResponse>, response: Response<GetHealthCareInfoResponse>) {
                //Retrieve Response Body
                val healthCareResponse: GetHealthCareInfoResponse? = response.body()
                //Response is ok.
                if (healthCareResponse != null
                        && healthCareResponse.getCode() == 200
                        && healthCareResponse.getHealthCareList().isNotEmpty()) {
                    val newsLoadedEvent = DataEvent.HealthCareInfoLoadedEvent(healthCareResponse.getHealthCareList())
                    EventBus.getDefault().post(newsLoadedEvent)
                } else { //Response is not ok. Error Case. Response Null Case
                    if(healthCareResponse != null)
                    //For 200OK
                    EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent(healthCareResponse.getMessage()))
                    else
                    //shows server message
                    EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                }
            }

            override fun onFailure(call: Call<GetHealthCareInfoResponse>?, t: Throwable?) {
                //cannot get internet connection or  serer down or api crush
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

        })
    }

    // add required initialization for Retrofit
    init {
        //configure okHtttpClient
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        /* configure Retrofit Object
        API_BASE = "http://padcmyanmar.com/padc-5/mm-healthcare/"
        */
        val retrofit = Retrofit.Builder()
                .baseUrl(HealthCareConstants.API_BASE)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        /*pass interface type from retrofit object and take interface object
         HealthCareApi Object Initialization
         */
        mHealthCareApi = retrofit.create(HealthCareApi::class.java)
    }
//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------