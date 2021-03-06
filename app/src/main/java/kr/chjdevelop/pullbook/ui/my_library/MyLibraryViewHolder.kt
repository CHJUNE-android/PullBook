package kr.chjdevelop.pullbook.ui.my_library

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.MyBook
import kr.chjdevelop.pullbook.ui.my_book.MyBookActivity

class MyLibraryViewHolder (private val activity : Activity, view: View) : RecyclerView.ViewHolder(view) {

    //val rv_homeFind_item: View = view.findViewById(R.id.rv_homeFind)
    val ll_item_library = view.findViewById<LinearLayout>(R.id.ll_item_library)
    val img_book = view.findViewById<ImageView>(R.id.img_book)
    val tv_book_title = view.findViewById<TextView>(R.id.tv_book_title)
    val tv_book_author = view.findViewById<TextView>(R.id.tv_book_author)
    val tv_read_date = view.findViewById<TextView>(R.id.tv_read_date)

    fun bind(data: MyBook) {
        ll_item_library.setOnClickListener{
            val intent = Intent(activity,
                MyBookActivity::class.java)
            intent.putExtra("item_book_data",data)
            activity.startActivity(intent)
        }
        if (data.thumbnail!!.isEmpty()){
            img_book.setImageResource(R.drawable.no_img)
        }else{
            Glide.with(itemView).load(data.thumbnail).into(img_book)
        }
        tv_book_title.text = data.title
        tv_book_author.text = data.author
        tv_read_date.text = data.date
    }

}