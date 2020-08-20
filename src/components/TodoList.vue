<template>
  <div>
    <TodoItem
      v-for="todo in todos"
      :key="todo.id"
      :todo="todo"
      @deleteTodoById="deleteTodo"
      @toggleEditing="toggleEditing"
      @editTodoById="editTodo"
    />
    <input type="text" name="todoText" v-model="inputText" v-on:keyup.enter="addTodo"/>
    <md-button class="md-raised md-primary" @click="addTodo">Add todo</md-button>
  </div>
</template>

<script>
import TodoItem from "@/components/TodoItem";
import { v4 as uuidv4 } from "uuid";

export default {
  name: "TodoList",
  computed: {
    todos() {
      return this.$store.getters.getTodos;
    }
  },
  data() {
    return {
      inputText: ""
    };
  },
  components: {
    TodoItem
  },
  methods: {
    addTodo() {
      if (this.inputText != "") {
        let randomId = uuidv4();
        const newTodo = {
          id: randomId,
          name: this.inputText,
          editing: false,
          complete: false
        };
        this.$store.dispatch("addTodo", newTodo);
        this.inputText = "";
      } else {
        alert("Please write a todo text!");
      }
    },
    async loadTodos() {
      await this.$store.dispatch("getTodos");
    },
    deleteTodo(todo) {
      this.$store.dispatch("deleteTodo", todo);
    },
    toggleEditing(todo) {
      this.$store.dispatch("toggleEditing", todo);
    },
    editTodo(todo) {
      this.$store.dispatch("editTodo", todo);
    }
  },
  async created() {
    await this.loadTodos();
  }
};
</script>
