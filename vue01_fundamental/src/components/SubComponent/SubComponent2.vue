<template>
    <div>
        <p>Sub Component 2</p>
        <SubComponent3 />
    </div>
</template>

<script>
import SubComponent3 from '../SubComponent/SubComponent3.vue'

export default {
    name: 'SubComponent2',
    components: {
        SubComponent3
    }
}
</script>