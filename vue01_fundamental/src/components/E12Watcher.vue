<template>
    <div>
        <label for="">Watcher is like useState() in react.js</label>
        <br>
        <input type="text" v-model="message">
    </div>
</template>

<script>
export default {
    name: 'E12Watcher',
    data() {
        return {
            message: ''
        }
    },
    // watcher selalu mengawasi setiap perubahan yang terjadi
    // pada data()
    watch: {
        message(value) {
            console.log(`message: ${value}`);
        }
    }
}
</script>