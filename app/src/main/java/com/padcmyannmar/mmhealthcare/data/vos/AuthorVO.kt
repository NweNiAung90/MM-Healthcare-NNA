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
/*
 This VOs component the response json objects to save with object format for CK App.
 */
class AuthorVO( @SerializedName("author-id") val authorId:Int = 0,
                @SerializedName("author-name") val authorName:String = "",
                @SerializedName("author-picture") val authorPhoto:String = "") {
//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------