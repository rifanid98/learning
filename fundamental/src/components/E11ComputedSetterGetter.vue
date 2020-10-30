<template>
    <div>
        <h1>Total: {{ discount }}</h1>
        <label for="num1">Num 1:</label>
        <input type="number" name="num1" v-model="num1"/>
        <br>
        <label for="num2">Num 2:</label>
        <input type="number" name="num2" v-model="num2"/>
        <br>
        <label for="disc">Discount (%)</label>
        <input type="num" name="disc" v-model="disc">
        <br>
        <button @click="setDiscount">+ Discount</button>
    </div>
</template>

<script>
export default {
    name: 'E11ComputedSetterGetter',
    data() {
        return {
            num1: 10,
            num2: 10,
            disc: 0
        }
    },
    computed: {
        discount: {
            // otomatis akan dieksekusi ketika {{ discount }} digunakan
            get() {
                return this.stringToNumber(this.num1) + this.stringToNumber(this.num2)
            },
            // penggunaannya sama seperti assingment pada variable
            // this.discount = XX
            set(discount) {
                discount = discount/100;
                this.num1 = this.num1-(this.num1*discount);
                this.num2 = this.num2-(this.num2*discount);
            }
        }
    },
    methods: {
        stringToNumber(number) {
            return parseInt(number);
        },
        setDiscount() {
            this.discount = this.disc
        }
    }
}
</script>