<template>
</template>

<script>
export default {
    name: 'E15Refs',
    data() {
        return {

        }
    },
    // refs adalah kemampuan vue untuk mengeksekusi method milik
    // child component dari parent component.
    // mirip seperti emits, namun ini kebalikannya. jika emit u/
    // mengeksekusi method si parent, maka refs u/ mengeksekusi
    // method si child.
    methods: {
        ExecE15RefsMethods() {
            console.log('E15Refs methods executed!');
        }
    }
}
</script>