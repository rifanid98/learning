<template>
    <div>
        <!-- v-once hanya akan dirender sekali ketika component dimount -->
        <p>berubah: {{ message }}</p>
        <p v-once>tetap: {{ message }}</p>
        <button @click="message = !message">change message</button>
    </div>
</template>

<script>
export default {
    name: 'E08VOnce',
    data() {
        return {
            message: true
        }
    }
}
</script>