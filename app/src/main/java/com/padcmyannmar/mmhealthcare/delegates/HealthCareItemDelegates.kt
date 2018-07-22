/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.delegates
//------------------------------------------------------------------------------
import com.padcmyannmar.mmhealthcare.data.vos.HealthCareVO
//------------------------------------------------------------------------------
/*1st step of Controller Pattern */
interface HealthCareItemDelegates {
    // add param to know user tap which itemView
    fun onTapItem(news: HealthCareVO?)
//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------