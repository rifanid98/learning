<template>
    <div>
        <!-- v-html berguna untuk merender string html menjadi component html -->
        <h1>{{ tag }}</h1>
        <h1 v-html="tag"></h1>
    </div>
</template>

<script>
export default {
    name: 'E08VHtml',
    data() {
        return {
            tag: '<p style="color: blue">Ini isi dari tag</p>'
        }
    }
}
</script>