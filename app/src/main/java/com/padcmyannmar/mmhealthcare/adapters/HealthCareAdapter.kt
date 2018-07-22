/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.adapters
//------------------------------------------------------------------------------
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyannmar.mmhealthcare.R
import com.padcmyannmar.mmhealthcare.data.vos.HealthCareVO
import com.padcmyannmar.mmhealthcare.delegates.HealthCareItemDelegates
import com.padcmyannmar.mmhealthcare.viewholders.BaseViewHolder
import com.padcmyannmar.mmhealthcare.viewholders.HealthCareInfoViewHolder
//------------------------------------------------------------------------------
/* 1 Adapter tightly connected with 1 View Holder */
class HealthCareAdapter (context: Context,
private val mHealthCareItemDelegates: HealthCareItemDelegates) : BaseRecyclerAdapter<HealthCareInfoViewHolder, HealthCareVO>(context) {
    //Framework call these methods.
    //call onCreateViewHolder() when Recycler View needs to create item view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthCareInfoViewHolder {
        val healthCareItemView = mLayoutInflator.inflate(R.layout.view_holder_healthcare_info, parent, false)
        return HealthCareInfoViewHolder(healthCareItemView, mHealthCareItemDelegates)
    }
//------------------------------------------------------------------------------

}
//------------------------------------------------------------------------------
//
//		End Of File
//
//------------------------------------------------------------------------------
