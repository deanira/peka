package com.pakis.pinus.core.utils

import androidx.lifecycle.MutableLiveData
import com.pakis.pinus.core.domain.model.Article
import com.pakis.pinus.core.domain.model.Conselor
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

    fun generateConselor(): ArrayList<Conselor> {
        val conselor = ArrayList<Conselor>()

        conselor.add(
            Conselor(
                "CID_01",
                "RS Eka Hospital Pekanbaru",
                "(0761) 6989999",
                "www.ekahospital.com",
                "Address: Jalan Mangga Sukajadi No.Km, RW.5, Tangkerang Bar., Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28292"
            )
        )

        conselor.add(
            Conselor(
                "CID_02",
                "RS Prima Pekanbaru",
                "(0761) 8419007",
                "https://rsprimapekanbaru.com",
                "Address: Jl. Bima No.1, Delima, Kec. Tampan, Kota Pekanbaru, Riau 28292"
            )
        )

        conselor.add(
            Conselor(
                "CID_03",
                "Psikologi Pekanbaru",
                "0813-7853-7379",
                "www.ekahospital.com",
                "Address: Jl. Harapan Sari No.11E, Tangkerang Sel., Kec. Bukit Raya, Kota Pekanbaru, Riau 28288"
            )
        )

        conselor.add(
            Conselor(
                "CID_04",
                "Biro Konsultasi Psikologi PSIKODATA",
                "0852-6525-9009",
                "facebook.com/541632456243525",
                "Address: Kampung Tengah, Sukajadi, Pekanbaru City, Riau 28121"
            )
        )

        conselor.add(
            Conselor(
                "CID_05",
                "Psiko-Power Psikolog",
                "0822-4523-4569",
                "www.starofservice.co.id",
                "Address: Gg. Kartini 1 No.11 F, Sumahilang, Kec. Pekanbaru Kota, Kota Pekanbaru, Riau 28156"
            )
        )

        conselor.add(
            Conselor(
                "CID_06",
                "KLINIK HIPNOTERAPI PEKANBARU, Minda Brilliant Indonesia",
                "0813-7853-7379",
                "https://www.hipnoterapipekanbaru.com/",
                "Address: Jl. Harapan Sari No.11 E, Tengkerang Sel., Kec. Bukit Raya, Kota Pekanbaru, Riau 28125"
            )
        )

        conselor.add(
            Conselor(
                "CID_07",
                "Psychology Bureau Indiana Solution",
                "0813-6529-1181",
                "http://www.indienasolution.com/",
                "Address: Gg. Kartini 1 No.11 F, Sumahilang, Kec. Pekanbaru Kota, Kota Pekanbaru, Riau 28156"
            )
        )

        conselor.add(
            Conselor(
                "CID_08",
                "HUMANIKA Psychology Center",
                "0822-5777-2221",
                "www.ekahospital.com",
                "Jl. Arifin Ahmad No.4, Sidomulyo Tim., Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28125"
            )
        )

        conselor.add(
            Conselor(
                "CID_09",
                "Biro Psikologi",
                "+6281365291181",
                "www.ekahospital.com",
                "JL. Harapan Raya, No. 256 A, Tangkerang Tim., Kec. Tenayan Raya, Kota Pekanbaru, Riau 28131"
            )
        )

        conselor.add(
            Conselor(
                "CID_10",
                "Fety Nurhidayati, S.Psi., Psikolog., M.Si.",
                "0853-7527-8790",
                "www.ekahospital.com",
                "Jl. Utama, Rejosari, Kec. Tenayan Raya, Kota Pekanbaru, Riau 28281"
            )
        )

        conselor.add(
            Conselor(
                "CID_11",
                "Biro Psikologi Atma Veda Consultant",
                "0853-7527-8790",
                "www.ekahospital.com",
                "Jl. Utama No.23, Rejosari, Kec. Tenayan Raya, Kota Pekanbaru, Riau 28281"
            )
        )

        conselor.add(
            Conselor(
                "CID_12",
                "Psychology Bureau Indiana Soluti",
                "0813-6529-1181",
                "www.ekahospital.com",
                "Jl. Samarinda No.56C, Tangkerang Utara, Kec. Bukit Raya, Kota Pekanbaru, Riau 28126"
            )
        )

        conselor.add(
            Conselor(
                "CID_13",
                "Praktek Psikolog",
                "0812-7649-4818",
                "www.ekahospital.com",
                "Jl. Tuanku Tambusai No.118 E, Kp. Melayu, Kec. Sukajadi, Kota Pekanbaru, Riau 28214"
            )
        )

        conselor.add(
            Conselor(
                "CID_14",
                "Biro Psikologi Persona Quality",
                "(0761) 848844",
                "www.ekahospital.com",
                "Jalan Parit Indah, komplek Perkantoran Grand Sudirman, Gg. Damai Blk. B No.7, Tengkerang Labuai, Bukit Raya, Pekanbaru City, Riau 28289"
            )
        )

        conselor.add(
            Conselor(
                "CID_15",
                "RS Jiwa Tampan",
                "082348407513",
                "https://rsjiwatampan.riau.go.id/",
                "Address: Jl. HR. Soebrantas Panam No.KM 12.5, Simpang Baru, Kec. Tampan, Kota Pekanbaru, Riau 28293"
            )
        )

        conselor.add(
            Conselor(
                "CID_16",
                "RS Syafira",
                "0822-1000-3636",
                "https://www.rs-syafira.com/",
                "Address: Jl. Jend. Sudirman No.134, Tengkerang Tengah, Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28282"
            )
        )

        conselor.add(
            Conselor(
                "CID_17",
                "RS Bhayangkara Pekanbaru",
                "0823-9181-4274",
                "https://rsbhayangkarapku.com/",
                "Address: Jalan RA Kartini No.14, Simpang Empat, Pekanbaru Kota, Simpang Empat, Kec. Pekanbaru Kota, Kota Pekanbaru, Riau 28156"
            )
        )

        conselor.add(
            Conselor(
                "CID_18",
                "Yossy Zulvianti, M.Psi",
                "(0761) 62105",
                "www.ekahospital.com",
                "Address: Jl. Inpres No.57, Rintis, Kec. Lima Puluh, Kota Pekanbaru, Riau 28155"
            )
        )

        conselor.add(
            Conselor(
                "CID_19",
                "Rumah Sakit Ibu dan Anak Zainab",
                "(0761) 24000",
                "http://rsiazainab.co.id/",
                "Address: Jl. Ronggo Warsito No.1, Suka Maju, Kec. Sail, Kota Pekanbaru, Riau 28127"
            )
        )

        conselor.add(
            Conselor(
                "CID_20",
                "Nindy Amita, S.Psi, M.Psi, Psikolog",
                "(0761) 6989999",
                "https://www.instagram.com/nindyamita/?hl=en",
                "Address: Jl Budi Utomo No 1/84 RT. 03 RW. 04, Kel. Labuh Baru Timur, Kec. Payung Sekaki, Pekanbaru - Riau, Depan SMA 2 Pekanbaru, Kota Pekanbaru, Indonesia"
            )
        )

        return conselor
    }
}