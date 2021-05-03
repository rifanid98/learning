package golang07_embed

// # Hasil Embed di Compile
// - Perlu diketahui, bahwa hasil embed yang dilakukan oleh package embed
// 	 adalah permanent dan data file yang dibaca disimpan dalam binary file
// 	 golang nya
// - Artinya bukan dilakukan secara realtime membaca file yang ada diluar
// - Hal ini menjadikan jika binary file golang sudah di compile, kita tidak
// 	 butuh lagi file external nya, dan bahkan jika diubah file external nya,
// 	 isi variable nya tidak akan berubah lagi
