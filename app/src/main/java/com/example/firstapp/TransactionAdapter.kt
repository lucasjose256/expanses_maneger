package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(private val transaction:ArrayList<Transaction>):
RecyclerView.Adapter<TransactionAdapter.TransactionHolder>() {
    class TransactionHolder(view: View) : RecyclerView.ViewHolder(view) {

        val label: TextView = view.findViewById(R.id.label)
        val amount: TextView = view.findViewById(R.id.amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionHolder {
//Get the layout that will be used in for create a single item
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.transaction_layout, parent, false)
        return TransactionHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionHolder, position: Int) {

        val transation: Transaction = transaction[position]
        val context = holder.amount.context
        if (transation.amount >= 0) {
            holder.amount.text = "+$%.2f".format(Math.abs(transation.amount))
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.green))

        } else {
            holder.amount.text = "+$%.2f".format(transation.amount)
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.red))

        }
holder.label.text=transation.label
    }

    override fun getItemCount(): Int {
        return transaction.size
    }
}