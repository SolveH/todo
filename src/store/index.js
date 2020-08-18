import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    todos: []
  },
  getters: {
    getTodos: state => state.todos
  },
  mutations: {
    addTodo: (state, id, text) => {
      const newTodo = {
        id: id,
        name: text,
        complete: false
      };
      state.todos.push(newTodo);
    },
    deleteTodo: (state, todo) => {
      var index = state.todos.indexOf(todo);
      state.todos.splice(index, 1);
    }
  },
  actions: {
    addTodo: (context, id, text) => {
      context.commit("addTodo", id, text);
    },
    deleteTodo: (context, todo) => {
      context.commit("deleteTodo", todo);
    }
  },
  modules: {}
});
