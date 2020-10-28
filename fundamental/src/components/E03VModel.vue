<template>
    <div>
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
const E03VModel = {
    name: 'E03VModel',
    data() {
        return {
            message: '',
            placeholder: 'Type text here...'
        }
    }
}

export default E03VModel;
</script>