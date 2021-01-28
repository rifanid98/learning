# Urutan Eksekusi Test

- Secara default, urutan eksekusi unit test tidak ditentukan, jadi jangan
  berharap  jika sebuah function berada diatas function lainnya, maka akan
  dijalankan lebih dulu.
- Hal ini karena memang sebaiknya function unit test itu harus independen,
  tidak saling ketergantungan.
- Secara default pun, object class unit test akan selalu dibuat ulang tiap
  function, jadi jangan berharap kita bisa menyimpan data di variable untuk
  digunakan di unit test function selanjutnya.

# Mengubah Urutan Eksekusi Test

- JUnit mendukung perubahan urutan eksekusi test jika kita mau menggunakan
  annotation @TestMethodOrder, ada beberapa cara yang bisa kita lakukan.
- Alphanumeric, artinya urutan eksekusi unit test akan diurutkan berdasarkan
  alphanumeric.
- Random, artinya urutan urutan eksekusi unit test akan dieksekusi secara
  random.
- OrderAnnotation, artinya urutan eksekusi  unit  test akan mengikuti
  annotation @Order yang ada di tiap function unit test.
    