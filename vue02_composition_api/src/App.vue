<template>
  <Lesson01RefVue />
</template>

<script>
import Lesson01RefVue from './components/Lesson01Ref.vue';

export default {
  setup() {
    const message = "Hello World";

    return {
      message
    }
  },
  components: {
    Lesson01RefVue
  }
}
</script>
