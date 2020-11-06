<template>
    <div>
        <p>Sub Component 1</p>
        <SubComponent2 />
    </div>
</template>

<script>
import SubComponent2 from '../SubComponent/SubComponent2.vue'

export default {
    name: 'SubComponent1',
    components: {
        SubComponent2
    }
}
</script>