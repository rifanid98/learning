<template>
    <div>
        <h1>{{ message }}</h1>
        <span :title='message'>hover me to get the message!</span>
    </div>
</template>

<script>
const E01DeclarativeRendering = {
    name: 'E01DeclarativeRendering',
    data() {
        return {
            message: 'Message: Declarative Rendering'
        }
    }
}

export default E01DeclarativeRendering;
</script>