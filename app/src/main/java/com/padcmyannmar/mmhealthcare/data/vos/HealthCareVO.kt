/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.data.vos
//------------------------------------------------------------------------------
import com.google.gson.annotations.SerializedName
//------------------------------------------------------------------------------
//primary constructor
class HealthCareVO ( @SerializedName("id") val id: Int = 0,
                     @SerializedName("title") val title: String = "",
                     @SerializedName("image") val image: String = "",
                     @SerializedName("author") val author: AuthorVO? = null,
                     @SerializedName("short-description") val shortDescription: String = "",
                     @SerializedName("published-date") val publishedDate: String = "",
                     @SerializedName("complete-url") val completedUrl:String = "",
                     @SerializedName("info-type") val infoType: String = "") {
//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------