package dev.kanini.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.nio.file.attribute.PosixFileAttributes

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/posts/{id}")
    fun getPostsById(@Path("id")postId: Int):Call<Post>
}