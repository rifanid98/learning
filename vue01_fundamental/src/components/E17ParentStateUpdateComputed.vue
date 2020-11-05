<template>
    <div>
        <!-- :vallue="message" is getter -->
        <!-- @input="$emit('update:modelValue', $event.target.value)" is setter -->
        <input type="text"
            :value="modelValue"
            @input="$emit('update:modelValue', $event.target.value)"
        >

        <input 
            type="text" 
            v-model="value"
        >
    </div>
</template>

<script>
export default {
    name: 'E17ParentStateUpdateComputed',
    props: {
        modelValue: String
    },
    computed: {
        value: {
            get() {
                return this.modelValue;
            },
            set(value) {
                this.$emit('update:modelValue', value);
            }
        }
    }
}
</script>