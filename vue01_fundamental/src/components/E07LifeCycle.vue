<template>
    <div>
        <p v-if="runCounter">semua component akan dihapus dalam {{ counter }} detik</p>
        <h1 v-if="component">{{ message }}</h1>
        <button @click="unmountComponent">unmount H1</button>
        <button v-if="component" @click="changeMessage">change message</button>
    </div>
</template>

<script>
export default {
    name: 'E07LifeCycle',
    // state
    data() {
        return {
            runCounter: false,
            counter: 5,
            message: 'Mounted',
            component: true
        }
    },

    // life cycle
    beforeCreate() {
        console.log('before created');
    },
    created() {
        console.log('created');
    },
    beforeMount() {
        console.log('before mount')
    },
    mounted() {
        console.log('mounted');
    },
    beforeUpdate() {
        console.log('before update');
    },
    updated() {
        console.log('updated');
    },
    beforeUnmount() {
        console.log('before unmount');
        alert('Yakin mau hapus componentnya?');
    },
    unmounted() {
        console.log('unmounted')
    },

    // methods
    methods: {
        changeMessage() {
            this.message = 'New Message';
        },
        unmountComponent() {
            this.component = false;
        }
    }
}
</script>