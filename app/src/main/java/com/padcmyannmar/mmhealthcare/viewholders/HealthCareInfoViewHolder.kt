/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.padcmyannmar.mmhealthcare.data.vos.HealthCareVO
import com.padcmyannmar.mmhealthcare.delegates.HealthCareItemDelegates
import kotlinx.android.synthetic.main.view_holder_healthcare_info.view.*
//------------------------------------------------------------------------------
class HealthCareInfoViewHolder(itemView: View, private val mDelegate: HealthCareItemDelegates) : BaseViewHolder<HealthCareVO>(itemView) {
    override fun setData(data: HealthCareVO) {
        mData = data

        itemView.tvTitle!!.text = data.title

        itemView.tvType!!.text = data.infoType


        if (!data.image!!.isEmpty()) {
            itemView.ivImage!!.visibility = View.VISIBLE
            Glide.with(itemView.context)
                    .load(data.image)
                    .into(itemView.ivImage)
        } else {
            itemView.ivImage!!.visibility = View.GONE
        }
    }

    override fun onClick(v: View?) {
        mDelegate.onTapItem(mData)
    }
//------------------------------------------------------------------------------
//
}
////------------------------------------------------------------------------------
////
////		End Of File
////
////------------------------------------------------------------------------------
