<template>
    <div>
        <h1 :class="status ? 'success' : 'failed'">{{ status ? 'success' : 'failed' }}</h1>
        <button @click="status = !status">change</button>
        <!-- 
            [
                'success',  -> css class property name
                'bold',     -> css class property name
                bigFont     -> data, returning css class property name
            ] 
        -->
        <h1 :class="['success', 'bold', bigFont]">mix style</h1>
    </div>
</template>

<script>
export default {
    name: 'E13DynamicCSSPropertyValue',
    data() {
        return {
            status: true,
            bigFont: 'big_font',
        }
    }
}
</script>

<style scoped>
    .success {
        color: green;
    }
    .failed {
        color: red;
    }
    .bold {
        font-weight: 700;
    }
    .big_font {
        font-size: 100px;
    }
</style>