<template>
  <div>
    <p>Counter1 : {{counter1}}</p>
    <p>Counter2 : {{nilai}}</p>
    <button @click="add">+</button>
    <br>
    <p>Computed Result : {{result}}</p>
  </div>
</template>

<script>
import {computed, reactive, ref, toRefs} from "vue";

export default {
  setup() {
    // ref
    const counter1 = ref(0);
    // reactive
    const counter2 = reactive({
      nilai: 0
    });

    /**
     * Methods
     */
    const add = () => {
      counter1.value++;
      counter2.nilai++;
    }

    const one = 1;
    /**
     * Computed
     * 
     * Computed akan mengeksekusi kode kemudian
     * mengembalikan nilainya. 
     * Computed akan dijalankan setiap kali state 
     * atau data berubah.
     */
    const result = computed(() => {
      return (counter1.value+one) + (counter2.nilai+one);
    })

    return {
      counter1,
      ...toRefs(counter2),
      add,
      result
    }
  }
}
</script>