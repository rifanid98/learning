<template>
    <div>
        <h1>Total: {{ total }}</h1>
        <label for="num1">Num 1:</label>
        <input type="number" name="num1" v-model="num1"/>
        <br>
        <label for="num2">Num 2:</label>
        <input type="number" name="num2" v-model="num2"/>
    </div>
</template>

<script>
export default {
    name: 'E10Computed',
    data() {
        return {
            num1: 10,
            num2: 10
        }
    },
    // Computed digunakan untuk mengeksekusi business logic
    // dari suatu aplikasi secara reaktif atau real time.
    computed: {
        total() {
            return this.stringToNumber(this.num1) + this.stringToNumber(this.num2)
        }
    },
    methods: {
        stringToNumber(number) {
            return parseInt(number);
        }
    }
}
</script>