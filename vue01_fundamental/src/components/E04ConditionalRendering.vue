<template>
    <div>
        <!-- component akan dirender jika memenuhi kondisi tertentu -->
        <h1 v-if="state">Hidup</h1>
        <h1 v-else-if="state === false">Mati</h1>
        <h1 v-else>Error</h1>
        <button @click="state = !state">Toggle</button>
        <button @click="state = ''">SabotageState Toggle</button>
        <br>
        <button @click="turnOnState">Hidup</button>
        <button @click="turnOffState">Mati</button>
        <button @click="toggleState">Hidup/Mati</button>
        <button @click="turnErrorState">Sabotage</button>
    </div>
</template>

<script>
export default {
    name: 'E04ConditionalRendering',
    data() {
        return {
            state: true
        }
    },
    methods: {
        turnOnState() {
            this.state = true;
        },
        turnOffState() {
            this.state = false;
        },
        turnErrorState() {
            this.state = '';
        },
        toggleState() {
            if (this.state) {
                this.state = !this.state;
                return;
            }

            this.state = true;
        }
    }
}
</script>