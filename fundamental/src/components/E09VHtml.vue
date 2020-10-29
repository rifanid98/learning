<template>
    <div>
        <h1>{{ tag }}</h1>
        <h1 v-html="tag"></h1>
    </div>
</template>

<script>
const E08VHtml = {
    name: 'E08VHtml',
    data() {
        return {
            tag: '<p style="color: blue">Ini isi dari tag</p>'
        }
    }
}

export default E08VHtml;
</script>