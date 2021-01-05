<template>
  <div>
    <pre>Raw data :</pre>
    <pre>{{user1}}</pre>
    <!-- user2 tidak bisa diakses karena sudah
         didestructure -->
    <pre>{{user2}}</pre>
    <p>Mengakses user1 dengan destructuring object :</p>
    <p>Name: {{name}}</p>
    <p>Age: {{age}}</p>
  </div>
</template>

<script>
import {reactive, ref, toRefs} from "vue";

export default {
  setup() {
    const user1 = reactive({
      name: "Adnin",
      age: 22
    })

    setTimeout(() => {
      // mengubah value object
      user1.name = "Adnin Rifandi"
    }, 1000);

    const user2 = reactive({
      name: "Adnin",
      age: 22
    })

    setTimeout(() => {
      // mengubah value object
      user2.name = "Adnin Rifandi"
    }, 1000);

    return {
      user1,
      /**
       * Jika object di destructure seperti ini
       * ketika return, destructure berhasil namun
       * reactivity dari composition api menjadi
       * tidak bekerja
       */
      // ...user2,
      /**
       * Reactivity akan bekerja jika menggunakan
       * toRefs() ketika destructuring object dan
       * direturn.
       * 
       * toRefs() akan mengkonversi reactive() 
       * menjadi ref()
       */
      ...toRefs(user2)
    }
  }
}
</script>