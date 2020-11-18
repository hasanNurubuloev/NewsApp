import com.geektech.newsapp.model.Articles
import com.google.gson.annotations.SerializedName

data class NewsBase (

	@SerializedName("status") val status : String,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("articles") val articles : MutableList<Articles>
)
