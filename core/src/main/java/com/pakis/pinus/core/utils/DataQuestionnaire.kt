package com.pakis.pinus.core.utils

import androidx.lifecycle.MutableLiveData
import com.pakis.pinus.core.domain.model.Questionnaire

object DataQuestionnaire {
    fun generateQuestionnaire(): MutableLiveData<ArrayList<Questionnaire>> {
        val questionsMlb = MutableLiveData<ArrayList<Questionnaire>>()
        val questions = ArrayList<Questionnaire>()

        questions.add(
            Questionnaire(
                "AE1",
                "Orang Tua menyadari masalah atau yang menjadi pusat perhatian saya di sekolah"
            )
        )

        questions.add(
            Questionnaire(
                "AE2",
                "Orang Tua menyadari masalah atau yang menjadi pusat perhatian saya di sekolah"
            )
        )

        questions.add(
            Questionnaire(
                "AE3",
                "Orang Tua memberi pengahargaan kepada saya ketika saya menjadi anak yang baik."
            )
        )

        questions.add(
            Questionnaire(
                "AE4",
                "Orang Tua memberikan kenyamanan dan pemahaman ketika saya sedang kecewa."
            )
        )

        questions.add(
            Questionnaire(
                "AE5",
                "Orang Tua mengekspresikan afeksi melalui memeluk, mencium dan menggendong anak."
            )
        )

        questions.add(
            Questionnaire(
                "AE6",
                "Orang Tua menunjukkan simpati ketika saya terluka atau frustasi."
            )
        )

        questions.add(
            Questionnaire(
                "AE7",
                "Orang Tua sering mengapresiasi apa yang telah saya coba atau tugas yang saya selesaikan."
            )
        )

        questions.add(
            Questionnaire(
                "AE8",
                "Orang Tua responsif terhadap perasaan atau kebutuhan saya."
            )
        )

        questions.add(
            Questionnaire(
                "AE9",
                "Orang Tua mendorong saya untuk membicarakan kesulitan saya."
            )
        )

        questions.add(
            Questionnaire(
                "AE10",
                "Orang Tua memiliki kehangatan dan keintiman dengan saya."
            )
        )

        questions.add(
            Questionnaire(
                "AE11",
                "Orang Tua meminta maaf kepada saya ketika membuat suatu kesalahan dalam pengasuhan."
            )
        )

        questions.add(
            Questionnaire(
                "AE12",
                "Orang Tua menjelaskan kepada saya akibat dari perilaku saya."
            )
        )

        questions.add(
            Questionnaire(
                "AE13",
                "Orang Tua memberikan alasan mengapa saya harus patuh."
            )
        )

        questions.add(
            Questionnaire(
                "AE14",
                "Orang Tua menekankan alasan-alasan tentang aturan yang ada."
            )
        )

        questions.add(
            Questionnaire(
                "AE15",
                "Orang Tua membantu saya untuk memahami dampak dari perilaku dengan memberi dukungan terhadap saya."
            )
        )

        questions.add(
            Questionnaire(
                "AE16",
                "Orang Tua menjelaskan bagaimana kita merasakan perilaku baik dan buruk."
            )
        )

        questions.add(
            Questionnaire(
                "AE17",
                "Orang Tua membicarakan dengan saya lebih lanjut dan alasan - alasannya ketika saya berperilaku salah."
            )
        )

        questions.add(
            Questionnaire(
                "AE18",
                "Orang Tua memberitahu perilaku saya yang diharapkannya sebelum saya terlibat dalam aktivitas"
            )
        )

        questions.add(
            Questionnaire(
                "AE19",
                "Orang Tua memperhitungkan pilihan pilihan saya dalam membuat rencana keluarga."
            )
        )

        questions.add(
            Questionnaire(
                "AE20",
                "Orang Tua mengijinkan saya untuk memberi masukan dalam aturan keluarga."
            )
        )

        questions.add(
            Questionnaire(
                "AE21",
                "Orang Tua memperhitungkan keinginan saya sebelum meminta saya melakukan sesuatu."
            )
        )

        questions.add(
            Questionnaire(
                "AE22",
                "Orang Tua mendorong saya mengekspresikan diri secara bebas bahkan ketika saya tidak setuju kepada orang tua."
            )
        )

        questions.add(
            Questionnaire(
                "AE23",
                "Orang Tua mudah dan rileks dengan saya."
            )
        )

        questions.add(
            Questionnaire(
                "AE24",
                "Orang Tua menunjukkan kesabaran kepada saya."
            )
        )

        questions.add(
            Questionnaire(
                "AE25",
                "Orang Tua senang bercanda dan bermain dengan saya."
            )
        )

        questions.add(
            Questionnaire(
                "AE26",
                "Orang Tua menunjukkan penghargaan terhadap pendapat-pendapat saya melalui mendorong saya untuk berekspresi."
            )
        )

        questions.add(
            Questionnaire(
                "AN1",
                "Orang Tua sering meledakkan kemarahan terhadap saya."
            )
        )

        questions.add(
            Questionnaire(
                "AN2",
                "Orang Tua berteriak ketika saya berperilaku salah."
            )
        )

        questions.add(
            Questionnaire(
                "AN3",
                "Orang Tua sering bertengkar dengan saya."
            )
        )

        questions.add(
            Questionnaire(
                "AN4",
                "Orang Tua sering berdebat dengan saya"
            )
        )

        questions.add(
            Questionnaire(
                "AN5",
                "Orang Tua menggunakan hukuman fisik sebagai cara memdisiplinkan anak."
            )
        )

        questions.add(
            Questionnaire(
                "AN6",
                "Orang Tua memukul (pantat) saya ketika saya tidak patuh."
            )
        )

        questions.add(
            Questionnaire(
                "AN7",
                "Orang Tua menampar saya ketika saya berperilaku salah."
            )
        )

        questions.add(
            Questionnaire(
                "AN8",
                "Orang Tua menarik saya dengan paksa ketika saya tidak taat."
            )
        )

        questions.add(
            Questionnaire(
                "AN9",
                "Orang Tua lebih sering membimbing saya dengan hukuman daripada dengan nasehat."
            )
        )

        questions.add(
            Questionnaire(
                "AN10",
                "Orang Tua mengesampingkan saya ketika saya tidak patuh."
            )
        )

        questions.add(
            Questionnaire(
                "AN11",
                "Orang Tua menghukum saya dengan mengambil hak saya dan hanya memberikan sedikit penjelasan."
            )
        )

        questions.add(
            Questionnaire(
                "AN12",
                "Orang Tua menghukum dengan menempatkan saya di suatu tempat sendirian dan hanya memberikan sedikit penjelasan."
            )
        )

        questions.add(
            Questionnaire(
                "AN13",
                "Orang Tua menggunakan ancaman sebagai hukuman dan hanya memberikan sedikit atau tidak ada pembenaran."
            )
        )

        questions.add(
            Questionnaire(
                "AN14",
                "Orang Tua menghukum saya dengan mengambil hak saya dan hanya memberikan sedikit penjelasan."
            )
        )

        questions.add(
            Questionnaire(
                "AN15",
                "Orang Tua menghukum dengan menempatkan saya di suatu tempat sendirian dan hanya memberikan sedikit penjelasan."
            )
        )

        questions.add(
            Questionnaire(
                "PE1",
                "Orang Tua menyatakan kepada saya akan menghukum saya dan tidak benar-benar dilakukan."
            )
        )

        questions.add(
            Questionnaire(
                "PE2",
                "Orang Tua lebih sering mengancam saya dengan hukuman daripada yang benar-benar dilakukan."
            )
        )

        questions.add(
            Questionnaire(
                "PE3",
                "Orang Tua melepaskan tanggung jawab kepada anak ketika anak menyebabkan suatu keributan."
            )
        )

        questions.add(
            Questionnaire(
                "PE4",
                "Orang Tua menyuap saya supaya saya patuh."
            )
        )

        questions.add(
            Questionnaire(
                "PE5",
                "Orang Tua membiarkan saya mengganggu orang lain."
            )
        )

        questions.add(
            Questionnaire(
                "PE6",
                "Orang Tua membiarkan saya sebagai penyebab orang lain marah."
            )
        )

        questions.add(
            Questionnaire(
                "PE7",
                "Orang Tua mengabaikan perilaku saya yang salah."
            )
        )

        questions.add(
            Questionnaire(
                "PE8",
                "Orang Tua tidak yakin tentang cara mengatasi perilaku saya yang salah."
            )
        )

        questions.add(
            Questionnaire(
                "PE9",
                "Orang Tua merasa sulit mendisiplinkan saya."
            )
        )

        questions.add(
            Questionnaire(
                "PE10",
                "Orang Tua menyatakan kepada saya akan menghukum saya dan tidak benar-benar dilakukan."
            )
        )

        questionsMlb.postValue(questions)
        return questionsMlb
    }
}