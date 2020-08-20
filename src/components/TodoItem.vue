<template>
  <div>
    <md-card>
      <md-card-header>
        <div class="md-title">
          <div class="md-title" v-if="todo.editing">
            <input type="text" id="todoTitle" v-model="editInput" />
          </div>
          <div v-else>{{todo.name}}</div>
        </div>
      </md-card-header>
      <md-card-actions>
        <div v-if="todo.editing">
          <md-button class="md-primary" @click="emitEditTodo">Save</md-button>
        </div>
        <md-button @click="toggleEditing">Edit</md-button>
        <md-button @click="emitDeleteTodo">Delete</md-button>
        <!-- <md-button>Edit</md-button> -->
        <!-- <md-checkbox>Complete</md-checkbox> -->
      </md-card-actions>
    </md-card>
  </div>
</template>

<script>
import { cloneDeep } from "lodash";

export default {
  name: "TodoItem",
  props: {
    todo: {
      Object: String,
      editing: Boolean,
      default: () => {}
    }
  },
  data() {
    return {
      editInput: ""
    };
  },
  methods: {
    emitDeleteTodo() {
      this.$emit("deleteTodoById", this.todo);
    },
    toggleEditing() {
      this.$emit("toggleEditing", this.todo);
    },
    emitEditTodo() {
      if (this.editInput != "") {
        const todoCopy = cloneDeep(this.todo);
        todoCopy.name = this.editInput;
        todoCopy.editing = false;

        this.$emit("editTodoById", todoCopy);
      } else {
        alert("please enter a name");
      }
    }
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
