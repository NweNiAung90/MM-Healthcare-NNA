/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.events
//------------------------------------------------------------------------------
import com.padcmyannmar.mmhealthcare.data.vos.HealthCareVO
//------------------------------------------------------------------------------
class DataEvent {
    // start define event broadcast
    class HealthCareInfoLoadedEvent( val loadedHealthCareInfo: List<HealthCareVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Body Response")
    // end define event broadcast
//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------
