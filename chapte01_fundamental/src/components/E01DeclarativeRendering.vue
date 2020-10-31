<template>
    <div>
        <h1>{{ message }}</h1>
        <span :title='message'>hover me to get the message!</span>
    </div>
</template>

<script>
export default {
    name: 'E01DeclarativeRendering',
    data() {
        return {
            message: 'Message: Declarative Rendering'
        }
    }
}
</script>