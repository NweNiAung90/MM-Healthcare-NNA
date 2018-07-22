/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.network
//------------------------------------------------------------------------------
import com.padcmyannmar.mmhealthcare.network.responses.GetHealthCareInfoResponse
import com.padcmyannmar.mmhealthcare.utils.HealthCareConstants
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
//------------------------------------------------------------------------------
interface HealthCareApi {
    @FormUrlEncoded
    @POST(HealthCareConstants.GET_HEALTHCARE_INFO)
    fun loadMMHealthCareInfo(
            //@Field("page") pageIndex: Int,
            @Field(HealthCareConstants.PARAM_ACCESS_TOKEN) accessToken: String) : Call<GetHealthCareInfoResponse>
//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------