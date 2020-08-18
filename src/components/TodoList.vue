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
        this.$store.dispatch("addTodo", this.inputText);
        console.log(this.$store.getTodos);
        this.inputText = "";
      } else {
        alert("Please write a todo text!");
      }
    },
    deleteTodo(todo) {
      this.$store.dispatch("deleteTodo", todo);
    }
  }
};
</script>
