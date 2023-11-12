package com.guntermg.colorblindnessapp.ui.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guntermg.colorblindnessapp.databinding.ItemQuestionsBinding
import com.guntermg.colorblindnessapp.ui.model.IshiharaPlate

class TestResultAdapter(
    var answerList: ArrayList<Int> = ArrayList()
) : RecyclerView.Adapter<TestResultAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemQuestionsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val resposta = answerList[position].toString()
        val esperado = IshiharaPlate.questions12Plate[position].number.toString()

        holder.binding.let { binding ->
            binding.tvItemTitle.text = "Palheta ${position+1}"
            binding.tvEsperado.text = "Esperado: ${esperado}"
            binding.tvResposta.text = "Sua resposta: ${resposta}"
            binding.ivPlate.setImageResource(IshiharaPlate.questions12Plate[position].src)
        }
    }

    override fun getItemCount(): Int {
        return answerList.size
    }

    inner class MyViewHolder(val binding: ItemQuestionsBinding) :
        RecyclerView.ViewHolder(binding.root)
}