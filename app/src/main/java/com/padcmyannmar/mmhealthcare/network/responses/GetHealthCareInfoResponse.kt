/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.network.responses

//------------------------------------------------------------------------------
import com.google.gson.annotations.SerializedName
import com.padcmyannmar.mmhealthcare.data.vos.HealthCareVO
import java.util.*

//------------------------------------------------------------------------------
/*
 This VOs component the response json objects to save with object format for Charles & Keith App.
 */
class GetHealthCareInfoResponse {
    /* API specific data key name and attribute name are different.
     * Manually link to get same key and attribute. */

    /*
     * This field indicates code.
     */
    @SerializedName("code")
    private val code: Int = 0

    /*
     * This field indicates Message.
     */
    @SerializedName("message")
    private val message: String? = null

    /*
  * This field indicates API Version.
  */
    /*@SerializedName("apiVersion")
    private val apiVersion: String? = null

    /*
     * This field indicates Page.
     */
    @SerializedName("page")
    private val pageNo: Int = 0*/

    /*
 * This field indicates a reference to  the objects of NewProductsVO
 * which stores overview details of all tag information.
 */
    @SerializedName("healthcare-info")
    private var healthCareList: List<HealthCareVO>? = null

    fun getCode(): Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }

    /*fun getApiVersion(): String? {
        return apiVersion
    }

    fun getPageNo(): Int {
        return pageNo
    }*/

    fun getHealthCareList(): List<HealthCareVO> {
        if (healthCareList == null) {
            healthCareList = ArrayList<HealthCareVO>()
        }
        val healthCareListVal = healthCareList
        return healthCareListVal!!
    }

    /* Check Response is Ok or not */
    fun isResponseOK(): Boolean {
        //expression
        return code == 200 && healthCareList != null
    }
//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------