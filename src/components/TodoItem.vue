<template>
  <div>
    <md-card>
      <md-card-header>
        <div class="md-title">{{ todo.name }}</div>
      </md-card-header>
      <md-card-actions>
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
      default: () => {}
    }
  },
  methods: {
    emitDeleteTodo() {
      this.$emit("deleteTodoById", this.todo);
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
