import { createApp } from 'vue'
import App from './App.vue'
// import './index.css'
import E20GlobalComponent from './components/E20GlobalComponent.vue';

// createApp(App).mount('#app')
const app = createApp(App);
app.component("E20GlobalComponent", E20GlobalComponent);
app.mount("#app");

