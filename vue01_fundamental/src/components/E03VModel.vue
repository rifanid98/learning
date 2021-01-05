<template>
    <div>
        <!-- v-model adalah gabungan dari :value dan @input -->
        <h1>{{ message }}</h1>
        <input v-model="message" :placeholder="placeholder">

        <!-- sebenarnya itu v-model adalah shorthand dari : -->
        <!-- <input 
            :value="message" 
            @input="message = $event.target.value"
            :placeholder="placeholder"
        > -->
    </div>
</template>

<script>
export default {
    name: 'E03VModel',
    data() {
        return {
            message: '',
            placeholder: 'Type text here...'
        }
    }
}
</script>