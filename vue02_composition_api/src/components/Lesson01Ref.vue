<template>
  <h1>{{ message }}</h1>
</template>

<script>
import {ref} from "vue";

export default {
  setup() {
    const message = ref("Hello World");
    
    setTimeout(() => {
      message.value = "Hallo Dunia";
    }, 500);
    
    return {
      message
    }
  }
}
</script>