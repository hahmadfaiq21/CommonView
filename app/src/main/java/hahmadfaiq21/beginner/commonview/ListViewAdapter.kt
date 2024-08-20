package hahmadfaiq21.beginner.commonview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewAdapter(private val listView: ArrayList<ItemView>): RecyclerView.Adapter<ListViewAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_view, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = listView.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo) = listView[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}