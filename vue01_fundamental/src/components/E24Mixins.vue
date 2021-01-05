<template>
    <div>
        <!-- $ symbol is mixins -->
        <pre>{{ $data }}</pre>
        <button @click="console">console</button>
    </div>
</template>

<script>
/**
 * Semua yang ada di basic akan diimport ke file ini.
 * Pada bagian data() {} apabila ada property yang sama,
 * akan diutamakan yang sudah ada di file ini. apabila
 * belum ada, maka akan dimerge
 */
import basic from './Mixins/basic';

export default {
    name: 'E24Mixins',
    // mixins berguna untuk meng-include kodingan logic vue dari
    // file lain ke file ini (dimana mixins tersebut digunakan)
    mixins: [basic],
    data() {
        return {
            message: 'this is a message'
        }
    },
    methods: {
        sayHello() {
            return this.$data;
        }
    }
}
</script>