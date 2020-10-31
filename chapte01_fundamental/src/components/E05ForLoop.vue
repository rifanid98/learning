<template>
    <ol>
        <!-- cara 1 -->
        <li v-for="todo in todos" :key="todo.id" >
            {{ todo.activity }}
        </li>
        <br>
        <!-- cara 2 -->
        <li v-for="(todo, index) in todos" :key="todo.id" >
            {{ todo.activity }} -> index {{ index }}
        </li>
    </ol>
</template>

<script>
export default {
    name: 'E05ForLoop',
    data() {
        return {
            todos: [
                {id: 1, activity: 'Learning'},
                {id: 2, activity: 'Ngoding'}
            ]
        }
    }
}
</script>