<template>
    <div>
        <p>berubah: {{ message }}</p>
        <p v-once>tetap: {{ message }}</p>
        <button @click="message = !message">change message</button>
    </div>
</template>

<script>
const E08VOnce = {
    name: 'E08VOnce',
    data() {
        return {
            message: true
        }
    }
}

export default E08VOnce;
</script>