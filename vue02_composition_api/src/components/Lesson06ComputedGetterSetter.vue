<template>
  <div>
    <!-- getter -->
    {{ name }} <br>
    <input type="text" :input="tempName" @value="tempName">
    <!-- setter -->
    <button @click="name = tempName">set!</button>
  </div>
</template>

<script>
import {computed, reactive, ref, toRefs} from "vue";

export default {
  setup() {
    const tempName = ref("");
    /* private _name */
    const _name = ref("Adnin");
    // getter setter
    const name = computed({
      get: (_) => _name.value,
      set: val => _name.value = val
    });

    return {
      name
    }
  }
}
</script>