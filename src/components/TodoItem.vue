<template>
  <div>
    <md-card>
      <md-card-header>
        <div class="md-title">
          <div class="md-title" v-if="todo.editing">
            <input type="text" id="todoTitle" v-model="editInput"/>
          </div>
          <div v-else>{{todo.name}}</div>
        </div>
      </md-card-header>
      <md-card-actions>
        <div v-if="todo.editing">
          <md-button class="md-primary" @click="emitEditTodo">Save</md-button>
        </div>
        <md-button @click="todo.editing = !todo.editing">Edit</md-button>
        <md-button @click="emitDeleteTodo">Delete</md-button>
        <!-- <md-button>Edit</md-button> -->
        <!-- <md-checkbox>Complete</md-checkbox> -->
      </md-card-actions>
    </md-card>
  </div>
</template>

<script>

export default {
  name: "TodoItem",
  props: {
    todo: {
      Object: String,
      editing: true,
      default: () => {}
    }
  },
  data() {
    return {
      editInput: '',
    };
  },
  methods: {
    emitDeleteTodo() {
      this.$emit("deleteTodoById", this.todo);
    },
    emitEditTodo() {
      if (this.editInput != "") {
        this.todo.name = this.editInput;
        this.todo.editing = false;
        this.$emit("editTodoById", this.todo);
      } else {
        alert("please enter a name")
      }
    },
  }
};
</script>

<style lang="scss" scoped>
.md-card {
  width: 320px;
  margin: 4px;
  display: inline-block;
  vertical-align: top;
}
</style>
