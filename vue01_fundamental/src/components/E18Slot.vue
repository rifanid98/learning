<template>
    <div>
        <!-- slot merupakan cara untuk menyisipkan component yang
             berasal dari parent component ke child component -->
        <p>header</p>
        <!-- default slot -->
        <!-- <slot />  -->
        <slot name="default" />
        <p>footer</p>
        <!-- named slot -->
        <slot name="slot1" />
        <slot name="slot2" />
    </div>
</template>

<script>
export default {
    name: 'E18Slot',
    data() {
        return {

        }
    }
}
</script>