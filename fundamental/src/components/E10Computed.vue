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
const E10Computed = {
    name: 'E10Computed',
    data() {
        return {
            num1: 10,
            num2: 10
        }
    },
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

export default E10Computed;
</script>