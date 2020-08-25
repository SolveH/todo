<template>
  <div>
    <TodoItem
      v-for="todo in todos"
      :key="todo.id"
      :todo="todo"
      @deleteTodoById="deleteTodo"
      @editTodoById="editTodo"
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
    },
  },
  data() {
    return {
      inputText: "",
    };
  },
  components: {
    TodoItem,
  },
  methods: {
    addTodo() {
      if (this.inputText != "") {
        const newTodo = {
          name: this.inputText,
          complete: false,
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
    editTodo(todo) {
      this.$store.dispatch("editTodo", todo);
    },
  },
  async created() {
    await this.loadTodos();
  },
};
</script>
