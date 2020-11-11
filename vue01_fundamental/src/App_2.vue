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
            <!-- <E23KeepAlive /> -->

        <!-- E24Mixins -->
            <!-- <E24Mixins /> -->

        <!-- E25Teleport -->
            <teleport to="#teleport">
                <E25Teleport />
            </teleport>
    </div>
</template>

<script>
// import E21PropTypes from './components/E21PropTypes.vue';
// import E22ProvideInject from './components/E22ProvideInject.vue';
// import E23KeepAlive from './components/E23KeepAlive.vue';
// import E24Mixins from './components/E24Mixins.vue';
import E25Teleport from './components/E25Teleport.vue';

export default {
    name: 'App',
    components: {
        // E21PropTypes,
        // E22ProvideInject,
        // E23KeepAlive,
        // E24Mixins,
        E25Teleport
    },
    data() {
        return {
            
        }
    }
}
</script>