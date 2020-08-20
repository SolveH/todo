<template>
  <div>
    <md-card>
      <md-card-header>
        <div class="md-title">
          <div class="md-title" v-if="editing">
            <input type="text" v-model="editInput" />
          </div>
          <div v-else>{{todo.name}}</div>
        </div>
      </md-card-header>
      <md-card-actions>
        <div v-if="editing">
          <md-button class="md-primary" @click="emitEditTodo">Save</md-button>
        </div>
        <md-button @click="editing = !editing">Edit</md-button>
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
      default: () => {}
    }
  },
  created() {
    this.editInput = this.todo.name;
    this.localTodo = cloneDeep(this.todo)
  },
  data() {
    return {
      editInput: "",
      editing: false,
      localTodo: this.todo,
    };
  },
  computed: {
    editInputComputed() {
      return this.name;
    }
  },
  methods: {
    emitDeleteTodo() {
      this.$emit("deleteTodoById", this.todo);
    },
    toggleEditing() {
      this.editing = !this.editing;

      if (this.editing == true) {
        this.editInput = this.localTodo.name;
      }

      this.$emit("toggleEditing", this.localTodo);
    },
    emitEditTodo() {
      if (this.editInput != "") {
        this.localTodo.name = this.editInput;
        this.editing = false;
        this.$emit("editTodoById", this.localTodo);
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
