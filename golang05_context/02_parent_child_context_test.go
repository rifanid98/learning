package golang05_context

// # Parent dan Child di Context
// - Context menganut konsep parent dan child
// - Artinya, saat kita membuat context, kita bisa membuat child context
// 	 dari context yang sudah ada
// - Parent context bisa memiliki banyak child, namun child hanya bisa
// 	 memiliki satu parent context
// - Konsep ini mirip dengan pewarisan di pemrograman berorientasi object

// # Hubungan Antara Parent dan Child Context
// - Parent dan Child context akan selalu terhubung
// - Saat nanti kita melakukan misal pembatalan context A, maka semua child
// 	 dan sub child dari context A akan ikut dibatalkan
// - Namun jika misal kita membatalkan context B, hanya context B dan semua
// 	 child dan sub child nya yang dibatalkan, parent context B tidak akan
//	 ikut dibatalkan
// - Begitu juga nanti saat kita menyisipkan data ke dalam context A, semua
//	 child dan sub child nya bisa mendapatkan data tersebut
// - Namun jika kita menyisipkan data di context B, hanya context B dan
// 	 semua child dan sub child nya yang mendapat data, parent context B
// 	 tidak akan mendapat data

// # Immutable
// - Context merupakan object yang Immutable, artinya setelah Context dibuat,
// 	 dia tidak bisa diubah lagi
// - Ketika kita menambahkan value ke dalam context, atau menambahkan
// 	 pengaturan timeout dan yang lainnya, secara otomatis akan membentuk
// 	 child context baru, bukan merubah context tersebut

// # Cara Membuat Child Context
// - Cara membuat child context ada banyak caranya, yang akan kita bahas di
// 	 materi-materi selanjutnya
