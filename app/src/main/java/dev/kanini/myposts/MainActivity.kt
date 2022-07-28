package dev.kanini.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.kanini.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()
    }
    fun getPosts(){
        val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
        val request=retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
               if (response.isSuccessful){
                   val posts = response.body()!!
                   Toast.makeText(baseContext,"fetched ${posts!!.size} posts",
                       Toast.LENGTH_LONG).show()
                   var postAdapter= RetrofitRvAdapter(baseContext,posts)
                   binding.rvPosts.layoutManager= LinearLayoutManager(baseContext)
                   binding.rvPosts.adapter= postAdapter
               }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO()
            }

        })


    }

}