const basic = {
    data() {
        return {
            name: 'Adnin'
        }
    },
    mounted() {
        console.log('ini basic mixins');
    },

    methods: {
        console() {
            console.log('console!');
        }
    }
}

export default basic;