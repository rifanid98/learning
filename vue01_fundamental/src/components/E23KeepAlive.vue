<template>
    <div>
        <div>
            <p>Current Tab : {{ currentTab }}</p>
            <button 
                v-for="tab in tabs"
                :key="tab"
                @click="currentTab = tab"
            >
            {{ tab }}
            </button>
        </div>

        <p>Keep Alive : </p>
        <keep-alive>
            <component :is="currentTabComponent" />
        </keep-alive>
        <hr>
        <p>Rerender : </p>
        <component :is="currentTabComponent" />
    </div>
</template>

<script>
import Home from './KeepAlive/Home.vue';
import Profile from './KeepAlive/Profile.vue';
import About from './KeepAlive/About.vue';

export default {
    name: 'E23KeepAlive',
    components: {
        Home,
        Profile,
        About
    },
    data() {
        return {
            currentTab: 'Home',
            tabs: ['Home', 'Profile', 'About']
        }
    },
    computed: {
        currentTabComponent() {
            return this.currentTab;
        }
    }
}
</script>