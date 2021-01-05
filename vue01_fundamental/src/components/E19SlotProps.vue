<template>
    <div>
        <!-- kita bisa menyisipkan props atau properties ke dalam 
             slot component yang dikirim ke child component -->
        <slot name="slot-props" :data="slotProps" :slotProps="slotProps" />
        <slot name="divider" />
        <slot name="slot-props-data" :data="slotProps" :slotProps="slotProps" />
    </div>
</template>

<script>
export default {
    name: 'E19SlotProps',
    data() {
        return {
            slotProps: 'Slot Props'
        }
    }
}
</script>