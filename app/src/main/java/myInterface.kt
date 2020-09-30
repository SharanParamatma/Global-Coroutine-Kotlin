import com.srkpindia.coroutine.Comments
import com.srkpindia.coroutine.ExamModel

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface myInterface {

    @FormUrlEncoded
    @POST("app_api.php")
   suspend fun GetExamList(
        @Field("tag") tag: String?,
        @Field("customer_id") customer_id: String?
    ): Response<List<ExamModel?>?>?

    @GET
   suspend fun getComments(): Response<List<Comments>>

    companion object {
        const val Base_URl = "http://192.168.100.68/"
    }
}