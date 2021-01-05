<template>
  <div>
    <p>Counter1 : {{counter1}}</p>
    <p>Counter2 : {{nilai}}</p>
    <button @click="add">+</button>
  </div>
</template>

<script>
import {reactive, ref, toRefs} from "vue";

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

    return {
      counter1,
      ...toRefs(counter2),
      add
    }
  }
}
</script>