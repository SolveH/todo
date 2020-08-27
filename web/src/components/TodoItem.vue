<template>
  <div>
    <md-card>
      <md-card-header>
        <div class="md-title">
          <div class="md-title" v-if="editing">
            <input type="text" v-model="editInput" />
          </div>
          <div v-else v-bind:class="{ completeText: checked }">{{ todo.name }}</div>
          <md-checkbox
            type="checkbox"
            id="checkbox"
            v-model="checked"
            @change="emitCompleteTodo()"
          />
        </div>
      </md-card-header>
      <md-card-actions>
        <div v-if="editing">
          <md-button class="md-primary" @click="emitEditTodo">Save</md-button>
        </div>
        <md-button @click="editing = !editing">Edit</md-button>
        <md-button @click="emitDeleteTodo">Delete</md-button>
      </md-card-actions>
    </md-card>
  </div>
</template>

<script>
import { cloneDeep } from "lodash";

export default {
  name: "TodoItem",
  data() {
    return {
      editInput: "",
      editing: false,
      localTodo: {},
      checked: false,
    };
  },
  props: {
    todo: {
      Object: String,
      default: () => {},
    },
  },
  created() {
    this.localTodo = cloneDeep(this.todo);
    this.editInput = this.localTodo.name;
    this.checked = this.localTodo.complete;
  },
  computed: {
    editInputComputed() {
      return this.name;
    },
  },
  methods: {
    emitDeleteTodo() {
      this.$emit("deleteTodoById", this.todo);
    },
    emitEditTodo() {
      if (this.editInput != "") {
        this.localTodo.name = this.editInput;
        this.editing = false;
        this.$emit("editTodoById", this.localTodo);
      } else {
        alert("please enter a name");
      }
    },
    emitCompleteTodo() {
      this.localTodo.complete = this.checked;
      this.$emit("editTodoById", this.localTodo);
    },
  },
};
</script>

<style lang="scss" scoped>
.md-card {
  width: 320px;
  margin: 4px;
  display: inline-block;
  vertical-align: top;
}
.completeText {
  text-decoration: line-through;
}
</style>
