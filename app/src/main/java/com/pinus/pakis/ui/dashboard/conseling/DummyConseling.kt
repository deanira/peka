package com.pinus.pakis.ui.dashboard.conseling


data class Conselling(
    val name : String,
    val phone : String,
    val website : String,
    val address : String
)

object DummyConseling {


    fun getDummyConcelling() : ArrayList<Conselling> {
        val listConselling : ArrayList<Conselling> = arrayListOf()

        listConselling.add(
            Conselling(
                "RS Eka Hospital Pekanbaru",
                "(0761) 6989999",
                "www.ekahospital.com",
                "Jalan Mangga Sukajadi No.Km, RW.5, Tangkerang Bar., Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28292"
            )
        )

        listConselling.add(
            Conselling(
                "Syafira Hospital",
                "0822-1000-3636",
                "www.SyafiraHospital.co.id",
                "Jl. Jend. Sudirman No.134, Tengkerang Tengah, Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28282"
            )
        )
        listConselling.add(
            Conselling(
                "RS Prima Pekanbarul",
                "(0761) 8419007",
                "primapekanbaru.co.id",
                "Jl. Bima No.1, Delima, Kec. Tampan, Kota Pekanbaru, Riau 28292"
            )
        )

        return  listConselling
    }

}

