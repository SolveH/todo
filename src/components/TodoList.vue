<template>
  <div>
    <TodoItem
      v-for="todo in todos"
      :key="todo.id"
      :todo="todo"
      @deleteTodoById="deleteTodo"
    />
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
export default {
  name: "TodoList",
  data() {
    return {
      inputText: "",
      todos: [
        {
          id: 0,
          name: "Go to the gym",
          complete: false
        },
        {
          id: 1,
          name: "Walk the dog",
          complete: false
        },
        {
          id: 2,
          name: "Get some pizza",
          complete: false
        }
      ]
    };
  },
  components: {
    TodoItem
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
    deleteTodo(todo) {
      var index = this.todos.indexOf(todo);
      this.todos.splice(index, 1);
    }
  }
};
</script>
