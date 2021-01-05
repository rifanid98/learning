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

        <!-- keep-alive digunakan untuk meng-cache component
             sehingga tidak perlu untuk dirender ulang. 
             
             hampir sama dengan v-one, bedanya v-once itu 
             mempertahankan nilai atau value dari state ketika
             pertama kali dirender.
             
             v-once : statenya yang tidak dirender ulang
             keep-alive : componentnya yang tidak dirender ulang -->
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