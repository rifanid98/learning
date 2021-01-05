<template>
    <div>
        <button v-if="!value" @click="childClick">child click</button>
        <button v-if="value" @click="childClickWithValue">child click with value</button>
    </div>
</template>

<script>
export default {
    name: 'E14Emits',
    props: {
        value: Boolean,
    },
    data() {
        return {

        }
    },
    mounted() {
        console.log(typeof this.value)
    },
    // emits itu untuk memberikan event ke parent component,
    // kemudian di parent component event tersebut diterima
    // yang kemudian akan mengeksekusi kode yang ada di parent
    // component
    emits: ['child-click', 'child-click-with-value'],
    methods: {
        childClick() {
            this.$emit('child-click');
        },
        childClickWithValue() {
            this.$emit('child-click-with-value', 'awesome!');
        }
    }
}
</script>