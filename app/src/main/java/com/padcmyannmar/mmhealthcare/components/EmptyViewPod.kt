/*------------------------------------------------------------------------------

This source is part of the assignment of the PADC Fun5 class.

Modification History


Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
21 07 2018	1.0			Nwe Ni Aung		Initial Version.
------------------------------------------------------------------------------*/
package com.padcmyannmar.mmhealthcare.components
//------------------------------------------------------------------------------
import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_pod_empty.view.*
//------------------------------------------------------------------------------
/*Composite Custom View */
class EmptyViewPod : RelativeLayout {
    // click Alt+Enter to get these 3 constructors.
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    //Composite Custom View
    fun setEmptyData(emptyImageId: Int, emptyMsg: String) {
        ivEmpty!!.setImageResource(emptyImageId)
        tvEmpty!!.text = emptyMsg
    }

    /*method override
      resource type is default int type
      Composite Custom View*/
    fun setEmptyData(emptyMsg: String) {
        tvEmpty!!.text = emptyMsg
    }
//--------------------------------------------------------------------------

}
//------------------------------------------------------------------------------
//
//		End Of File
//
//------------------------------------------------------------------------------