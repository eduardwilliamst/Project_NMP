package com.example.project_nmp

object Global {

    var username: String = ""
    var email: String = ""
    var password: String = ""
    var url: String = ""

    var genre: ArrayList<Genre> = arrayListOf()

//    val genre = arrayOf(
//        Genre(1, "Action"),
//        Genre(2, "Anime"),
//        Genre(3, "Comedy"),
//        Genre(4, "Crime"),
//        Genre(5, "Drama"),
//        Genre(6, "History"),
//        Genre(7, "Horror"),
//        Genre(8, "Kids"),
//        Genre(9, "Romance"),
//        Genre(10, "Sci-Fi & Fantasy"),
//        Genre(11, "Thriller")
//    )

    val dataCerbung: Array<Cerbung> = arrayOf(
        Cerbung(
            1,
            "Misteri Lirikan Mata Bibi",
            "Namaku Alin, aku hidup bertiga bersama Bibi dan Sisil boneka ku, tapi tunggu,,, lebih tepatnya aku hanya hidup berdua bersama sisil, ya,,, Sisil, dia adalah boneka ku, dia sudah ku anggap sebagai teman dekat ku.",
            1,
            "https://img.wattpad.com/cover/130582718-416-k206500.jpg",
            "chorrorindonesia",
            40,
            13,
            "private",
            "Namaku Alin, aku hidup bertiga bersama Bibi dan Sisil boneka ku, tapi tunggu,,, lebih tepatnya aku hanya hidup berdua bersama sisil, ya,,, Sisil, dia adalah boneka ku, dia sudah ku anggap sebagai teman dekat ku.",
        ),
        Cerbung(
            2,
            "Global Reincarnation: Only I Know The Plot ",
            "Ini adalah dunia virtual yang terdiri dari berbagai film dan televisi. Semua orang di dunia bekerja keras untuk menaklukkan setiap salinan, berharap mendapatkan hadiah salinan dan menjadi lebih kuat. Chen Ye, yang datang, terkejut menemukan bahwa",
            2,
            "https://img.wattpad.com/cover/281378647-416-k906679.jpg",
            "Dezel-Kun",
            32,
            8,
            "public",
            "Ini adalah dunia virtual yang terdiri dari berbagai film dan televisi. Semua orang di dunia bekerja keras untuk menaklukkan setiap salinan, berharap mendapatkan hadiah salinan dan menjadi lebih kuat. Chen Ye, yang datang, terkejut menemukan bahwa",
        ),
        Cerbung(
            3,
            "Transmigrasi Istri Tak Dianggap",
            "Daisy Mahesa, seorang model terkenal. Ia juga merupakan putri tunggal dari keluarga Mahesa. Menjadi seorang model merupakan mimpinya, namun sayang karena sebuah kecelakaan yang dialaminya membuat ia harus terdampar ditubuh Diana Maheswari.",
            3,
            "https://img.wattpad.com/cover/326586438-416-k518399.jpg",
            "zersela",
            51,
            5,
            "public",
            "Seorang wanita yang selalu menerima perlakuan buruk dari keluarga suaminya. Bahkan suaminya sendiri tidak pernah menganggapnya. Dan disini lah Daisy, bertekad untuk merubah kehidupan Diana, karena bagaimanapun ia adalah pemilik tubuh Diana yang sekarang. \n" +
                    "\n" +
                    "Lalu bagaimanakah cara Daisy mengubah hidup Diana?\n",
        )
    )

}