<template>
    <div>
        <!-- E21PropTypes -->
            <!-- use default prop value -->
            <!-- <E21PropTypes /> -->
            <!-- use custom props value / props assignment -->
            <!-- <E21PropTypes name="Adnin" :age="22" /> -->

        <!-- E22ProvideInject -->
            <!-- <E22ProvideInject /> -->

        <!-- E23KeepAlive -->
            <E23KeepAlive />
    </div>
</template>

<script>
// import E21PropTypes from './components/E21PropTypes.vue';
// import E22ProvideInject from './components/E22ProvideInject.vue';
import E23KeepAlive from './components/E23KeepAlive.vue';

export default {
    name: 'App',
    components: {
        // E21PropTypes,
        // E22ProvideInject,
        E23KeepAlive
    },
    data() {
        return {
            
        }
    }
}
</script>