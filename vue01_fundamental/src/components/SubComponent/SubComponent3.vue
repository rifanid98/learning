<template>
    <div>
        <p>Sub Component 3</p>
        <span>{{ providedMessage }}</span>
    </div>
</template>

<script>

export default {
    name: 'SubComponent3',
    inject: ['providedMessage']
}
</script>