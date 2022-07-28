package dev.kanini.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.kanini.myposts.databinding.ActivityMainBinding
import dev.kanini.myposts.databinding.RetrofitListPostsBinding
import retrofit2.Retrofit

class RetrofitRvAdapter (var context:Context, var postList:List<Post>
) : RecyclerView.Adapter<RetrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RetrofitViewHolder {
       var binding =RetrofitListPostsBinding
           .inflate(LayoutInflater.from(context),parent,false)
        return  RetrofitViewHolder(binding)

    }


    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentPost= postList.get(position)
        with(holder.binding){
            tvUserId.text=currentPost.userId.toString()
            tvId.text=currentPost.id.toString()
            tvtitle3.text=currentPost.title
            tvbody.text=currentPost.body
        }
    }

    override fun getItemCount(): Int {
        return  postList.size
    }
}
class RetrofitViewHolder(var binding: RetrofitListPostsBinding):RecyclerView.ViewHolder(binding.root){

}
