<template>
    <div>
        <p>{{ name }}</p>
        <p>{{ age }}</p>
    </div>
</template>

<script>
export default {
    name: 'E21PropTypes',
    // prop types, tipe-tipe property, atau lebih jelasnya
    // prop types adalah penentuan tipe data untuk masing-
    // masing property
    props: {
        name: String,
        age: {
            type: Number,   // prop type
            default: 0     // default prop value
        }
    }
}
</script>