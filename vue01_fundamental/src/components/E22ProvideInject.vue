<template>
    <div>
        <SubComponent1 />
    </div>
</template>

<script>
import SubComponent1 from './SubComponent/SubComponent1.vue'

export default {
    name: 'E22ProvideInject',
    components: {
        SubComponent1
    },
    data() {
        return {
            message: 'message'
        }
    },
    // provide inject itu mirip seperti state management, tapi
    // untuk studi kasus yang tidak kompleks. 
    // di react seperti reactContext.
    provide() {
        return {
            providedMessage: 'provided ' + this.message
        }
    }
}
</script>