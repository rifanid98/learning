<template>
    <div>
        <div>{{ count }}</div>
        <button @click="decrement">-</button>
        <button @click="increment">+</button>
        <p>{{ minus }}</p>
    </div>
</template>

<script>
export default {
    name: 'E02Methods',
    data() {
        return {
            count: 0,
            minus: true
        }
    },
    methods: {
        increment() {
            this.count++;
            this.checkCount();
        },
        decrement() {
            this.count--;
            this.checkCount();
        },
        checkCount() {
            console.log(this.minus);
            if (this.count < 1) {
                this.minus = false;
                return; // exit from this function
            } 

            this.minus = true;
            return; // exit from this function
        }
    }
}
</script>