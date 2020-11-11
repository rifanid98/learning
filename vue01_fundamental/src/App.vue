<template>
    <div class="container">
        <div class="card mt-4">
            <div class="card-body">
                <h5 class="card-title">SIMPLE TODO APP</h5>
                <div class="row">
                    <div class="col-10">
                        <input v-model="todo" @keyup.enter="addTodo" type="text" class="form-control" required="required">
                    </div>
                    <div class="col-2">
                        <button @click="addTodo" class="btn btn-success">ADD</button>
                    </div>
                </div>
                <div>
                    <div class="list-group">
                        <div v-for="todo in todos" :key="todo" class="list-group-item d-flex flex-row justify-content-between">
                            <p>{{ todo }}</p>
                            <button @click="deleteTodo(todo)" type="button" class="btn btn-outline-danger">X</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'App',
    data() {
        return {
            todo: '',
            todos: []
        }
    },
    methods: {
        addTodo() {
            if (!this.validate()) {
                alert(`Todo must be at least 3 characters`);
                return;
            }
            if (this.todoExists()) {
                alert(`Todo ${this.todo} is already added`);
                return;
            }
            this.todos.push(this.todo);
            this.clean();
        },
        deleteTodo(value) {
            // yang diharapkan
            let todos = this.todos;
            this.todos.forEach((todo, index) => {
                if (todo === value) {
                    todos.splice(index, 1);
                }
            });
            this.todos = todos;

            // yang terjadi, apakah ini pass by reference di vue?
            let todos = this.todos;
            todos.forEach((todo, index) => {
                if (todo === value) {
                    todos.splice(index, 1);
                }
            });
        },
        todoExists() {
            if (this.todos.find(todo => todo === this.todo)) {
                return true;
            }
        },
        validate() {
            if (this.todo !== '' &&  this.todo !== null && this.todo.length >= 3) {
                return true;
            }

            return false;
        },
        clean() {
            this.todo = [];
        }
    }
}
</script>