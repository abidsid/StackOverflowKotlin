package com.example.stackoverflowkotlin.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowkotlin.data.remote.response.Question
import com.example.stackoverflowkotlin.databinding.ItemQuestionBinding

class QuestionAdapter(
    private val listener: QuestionsInterface
) : RecyclerView.Adapter<QuestionAdapter.MyViewHolder>() {

    private val questionsList = ArrayList<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewBinding.apply {
            question = questionsList[position]
            listener = this@QuestionAdapter.listener
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int = questionsList.size

    fun updateList(updatedList: List<Question>) {
        questionsList.clear()
        questionsList.addAll(updatedList)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val viewBinding: ItemQuestionBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    fun interface QuestionsInterface {
        fun onShowButtonClick(link: String)
    }

}