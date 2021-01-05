<template>
  <div>
    <p>Counter : {{nilai}}</p>
    <button @click="add">+</button>
  </div>
</template>

<script>
import { reactive, ref, toRef, toRefs, watchEffect } from 'vue';

export default {
  setup() {
    const counter = reactive({
      nilai: 0,
      value: 0,
    });

    const add = () => {
      counter.nilai++;
    };

    /**
     * watchEffect() hampir mirip dengan useEffect() 
     * di react.js. Namun watchEffect() melisten seluruh
     * state, sedangkan useEffect() kita tentukan ingin
     * melisten state yang mana.
     */
    watchEffect(() => {
      console.log(counter.nilai);
      console.log(counter.value);
      console.log(counter)
    },
    /**
     * watchEffect() options
     */
    {
      /**
       * flush: 'pre' (default)
       * watchEffect() akan dijalankan sebelum state
       * berubah.
       * 
       * flush: 'post'
       * watchEffect() akan dijalankan sesudah state
       * berubah
       * 
       * onTrigger(e)
       * callback ketika state tertrigger
       *  
       * onTrack()
       * callback ketika state tertrack
       */
      flush: "pre",
    })

    return {
      ...toRefs(counter),
      add
    }
  }
}
</script>