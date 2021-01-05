<template>
  <div>
    <p>Counter : {{nilai}}</p>
    <button @click="add1">+ counter1</button>
    <button @click="add2">+ counter2</button>
  </div>
</template>

<script>
import { reactive, toRefs, watch } from 'vue';

export default {
  setup() {
    const counter1 = reactive({
      nilai: 0,
      value: 0,
    });

    const counter2 = reactive({
      nilai: 0,
      value: 0,
    });

    const add1 = () => {
      counter1.nilai++;
    };

    const add2 = () => {
      counter2.nilai++;
    };

    /**
     * watch
     * 
     * watch itu seperti watchEffect() tapi hanya
     * melisten state yang sudah ditentukan.
     * ini sama seperti useEffect()  di react.js.
     */
    // cara 1
    // listen 1 object
    // listen objectnya
    watch(counter1, (after, before) => {
      console.log("counter1 changed! -> " + counter1.nilai)
    })
    // listen lebih dari 1 object
    watch([counter1, counter2], (after, before) => {
      console.log("counter2 changed! -> " + counter2.nilai)
    })

    // cara 2
    // listen salah satu key dari objectnya
    watch(() => counter1.nilai, (current, before) => {
      console.log(counter1.nilai, '<<< counter1')
    })

    return {
      ...toRefs(counter1),
      add1,
      add2
    }
  }
}
</script>