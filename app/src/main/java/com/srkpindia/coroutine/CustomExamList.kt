package com.srkpindia.coroutine

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CustomExamList internal constructor(
    private val context: Context,
    private val android: List<ExamModel>
) :
    RecyclerView.Adapter<CustomExamList.ViewHolder?>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.custom_examlist, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        try {
            viewHolder.tv_examtitle.text = android[i].title
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return android.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var lin_bg: LinearLayout
        val tv_examtitle: TextView

        init {
            tv_examtitle = view.findViewById(R.id.tv_examtitle)
            lin_bg = view.findViewById(R.id.lin_bg)
        }
    }
}
