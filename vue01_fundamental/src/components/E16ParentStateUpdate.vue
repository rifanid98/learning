<template>
    <div>
        <input  type="text" @value="modelValue" @input="$emit('update:modelValue', $event.target.value)">
    </div>
</template>

<script>
export default {
    name: 'E16ParentStateUpdate',
    props: {
        modelValue: String
    },
}
</script>