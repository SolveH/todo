<template>
  <div>
    <TodoItem v-for="todo in todos" :key="todo.id" :todo="todo" />
    <input
      type="text"
      name="todoText"
      v-model="inputText"
      v-on:keyup.enter="addTodo"
    />
    <md-button class="md-raised md-primary" @click="addTodo"
      >Add todo</md-button
    >
  </div>
</template>

<script>
import TodoItem from "@/components/TodoItem";
import { v4 as uuidv4 } from "uuid";
import { dataService } from "../shared/data.service";

export default {
  name: "TodoList",
  data() {
    return {
      inputText: "",
      todos: [],
    };
  },
  components: {
    TodoItem,
  },
  methods: {
    addTodo() {
      if (this.inputText != "") {
        let randomId = uuidv4();
        let newTodo = { id: randomId, name: this.inputText, complete: false };
        this.todos.push(newTodo);
        this.inputText = "";
      } else {
        alert("Please write a todo text!");
      }
    },
    async loadTodos() {
      this.todos = await dataService.getTodos();
    },
  },
  async created() {
    await this.loadTodos();
  },
};
</script>
