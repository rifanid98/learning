<template>
    <div>
        <p>{{ name }}</p>
        <p>{{ age }}</p>
    </div>
</template>

<script>
export default {
    name: 'E21PropTypes',
    props: {
        name: String,
        age: {
            type: Number,   // prop type
            default: 0     // default prop value
        }
    }
}
</script>