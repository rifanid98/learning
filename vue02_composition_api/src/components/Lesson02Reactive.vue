<template>
  <div>
    <!-- User 1 -->
    <pre>Raw data user 1 :</pre>
    <pre>{{ user1 }}</pre>

    <!-- User 2 -->
    <pre>Raw data user 2 :</pre>
    <pre>{{ user2 }}</pre>
  </div>
</template>

<script>
import {reactive, ref} from "vue";

export default {
  setup() {
    /**
     * Ref
     */
    const user1 = ref({
      name: "Adnin",
      age: 22
    })

    setTimeout(() => {
      // mengubah value object
      user1.value.name = "Adnin Rifandi"
    }, 1000);

    /**
     * Reactive
     * 
     * Digunakan untuk mengakses data (read/write) dari 
     * suatu variable tanpa harus mengakses object value
     * terlebih dahulu dari variable tersebut.
     */
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
      user2
    }
  }
}
</script>