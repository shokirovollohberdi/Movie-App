package RvAdapters

import Cash.MySharePreference
import RvModels.Position
import RvModels.RvModels
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.AboutActivty
import com.example.movieapp.Edit_Activity
import com.example.movieapp.R
import kotlinx.android.synthetic.main.item_rv.view.*
import java.lang.Exception

class RvAdapters(var context: Context, val list: ArrayList<RvModels>) : RecyclerView.Adapter<RvAdapters.Vh>() {
    inner class Vh(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(rvModels: RvModels, position: Int) {
            itemView.item_name.text = rvModels.name
            itemView.item_actor.text = rvModels.actor
            itemView.item_date.text = rvModels.date
            var anim1:Animation = AnimationUtils.loadAnimation(context,R.anim.anim1)
            itemView.startAnimation(anim1)


            try {
                itemView.setOnClickListener {
                    Position.position = position
                    context.startActivity(Intent(context, AboutActivty::class.java))
                }
            } catch (e: Exception) {
                Toast.makeText(context, "$e", Toast.LENGTH_SHORT).show()
            }

            itemView.item_edit.setOnClickListener {
                val intent = Intent(context, Edit_Activity::class.java)
                intent.putExtra("model", rvModels)
                intent.putExtra("position", position)
                context.startActivity(intent)

            }
            itemView.item_delete.setOnClickListener {
                MySharePreference.init(context)
                list.remove(list[position])
                MySharePreference.obektString = list
                notifyDataSetChanged()
                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapters.Vh {

        return Vh(
                LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RvAdapters.Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}