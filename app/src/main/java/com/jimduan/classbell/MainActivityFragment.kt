package com.jimduan.classbell

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.jimduan.classbell.bean.AlarmInfoBean
import com.jimduan.classbell.utils.toString1
import com.jimduan.classbell.utils.toString2
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.item_alarminfo.view.*

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {
    lateinit var data: MutableList<AlarmInfoBean>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val timePicker = TimePickerBuilder(context, OnTimeSelectListener { date, v ->
            Toast.makeText(context, date.toString1(), Toast.LENGTH_LONG).show()
        }).setType(BooleanArray(6, { i -> i > 2 }))
                .build()
        view.btPickTime.setOnClickListener { timePicker.show() }
        data = mutableListOf()
        view.recyclerView.adapter = MyAdapter(data);
        return view
    }

    private class MyViewHolder(view: View) : ViewHolder(view)
    private class MyAdapter(var data: MutableList<AlarmInfoBean>) : RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarminfo, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val alarm = data[position]
            holder.itemView.tvTime.text = alarm.time.toString2()
            holder.itemView.tvRepeatType.text = alarm.repeatType
            holder.itemView.tvRemarks.text = alarm.remarks
            holder.itemView.cbEnable.isChecked = alarm.state

        }
    }
}
