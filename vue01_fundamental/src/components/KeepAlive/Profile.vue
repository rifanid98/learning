<template>
    <div>
        <p>{{ title }}</p>

        <ul>
            <li 
                v-for="planet in planets" 
                :key="planet"
            >
                {{ planet.name }}
            </li>
        </ul>
    </div>
</template>

<script>

export default {
    name: 'Profile',
    data() {
        return {
            title: 'Profile Component',
            planets: []
        }
    },

    async created() {
        const planets = await fetch('https://swapi.dev/api/planets/');
        const { results } = await planets.json();
        this.planets = results;
    }
}
</script>