package com.pakis.pinus.core.utils

import androidx.lifecycle.MutableLiveData
import com.pakis.pinus.core.domain.model.Article
import com.pakis.pinus.core.domain.model.Video

object DataDummy {
    fun generateVideos(): MutableLiveData<ArrayList<Video>> {
        val videosMlb = MutableLiveData<ArrayList<Video>>()
        val videos = ArrayList<Video>()

        videos.add(
            Video(
                "VID_01",
                "https://hantu.bo.satupersen.net/content/images/2020/12/Love-Language-Mengenal-Bahasa-Cinta-1.png",
                "https://www.youtube.com/watch?v=_KzHGbpxMOY"
            )
        )

        videos.add(
            Video(
                "VID_02",
                "https://mojok.co/terminal/wp-content/uploads/2021/04/Bagaimana-The-Penthouse-Menggambarkan-Terciptanya-Lingkaran-Kekerasan-Akibat-Toxic-Parenting-terminal-mojok-800x540.jpg",
                "https://www.youtube.com/watch?v=yMH5HnEpgsU"
            )
        )

        videos.add(
            Video(
                "VID_03",
                "https://mmc.tirto.id/image/otf/700x0/2018/09/12/ilustrasi-kekerasan-anak--istockphoto_ratio-16x9.jpg",
                "https://www.youtube.com/watch?v=ba-XAIskH_g"
            )
        )

        videosMlb.postValue(videos)

        return videosMlb
    }

    fun generateArticles(): MutableLiveData<ArrayList<Article>> {
        val articlesMlb = MutableLiveData<ArrayList<Article>>()
        val articles = ArrayList<Article>()

        articles.add(
            Article(
                "AID_01",
                "Dampak pada Anak dengan Pola Asuh Helicopter Parenting",
                "Setiap orangtua tentu ingin melindungi dan memastikan semua urusan anaknya berjalan dengan baik. Namun, jika upaya melindungi tersebut berlebihan, justru dampak buruk yang akan didapat. Pola asuh semacam ini disebut helicopter parenting atau dikenal dengan overprotective parenting.",
                "https://www.halodoc.com/artikel/dampak-pada-anak-dengan-pola-asuh-helicopter-parenting",
                "https://d1bpj0tv6vfxyp.cloudfront.net/articles/8f24c0a3-3443-450f-999c-c91950510ab2_article_image_url.webp"
            )
        )

        articles.add(
            Article(
                "AID_02",
                "Gaya Asuh dan Pengaruhnya Pada Perkembangan Anak",
                "Apakah kalian menyadari bahwa setiap anak memiliki perilaku dan sifat yang berbeda? Tentu, jawabannya pasti iya. Kalian mungkin menyadari bahwa ada seorang anak yang memiliki sifat percaya diri, mudah bergaul, dan cenderung berperilaku baik, namun seorang anak laiinya memiliki sifat yang pemalu, penakut, dan bahkan cenderung nakal.",
                "https://lm.psikologi.ugm.ac.id/2020/07/gaya-asuh-dan-pengaruhnya-pada-perkembangan-anak/",
                "https://lm.psikologi.ugm.ac.id/wp-content/uploads/sites/383/2020/07/FUNFACT1-1024x683.jpg"
            )
        )

        articles.add(
            Article(
                "AID_03",
                "Tanda Toxic Parents Orang Tua dan Dampaknya Terhadap Anak",
                "Tak selamanya keluarga dapat digambarkan sebagai mutiara atau harta yang paling berharga. Sebab, bagi sebagian orang, keluarga justru dapat menghambat perkembangan diri individu. Situasi demikian dikenal dengan disfungsi keluarga, yang awalnya diharapkan menjadi hubungan harmonis, malahan berujung tekanan mental yang melelahkan.",
                "https://tirto.id/tanda-toxic-parents-orang-tua-dan-dampaknya-terhadap-anak-eCBD",
                "https://mmc.tirto.id/image/otf/700x0/2018/09/12/ilustrasi-kekerasan-anak--istockphoto_ratio-16x9.jpg"
            )
        )

        articlesMlb.postValue(articles)

        return articlesMlb
    }
}