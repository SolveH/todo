import Vue from "vue";
import Vuex from "vuex";

import { dataService } from "../shared/data.service";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    todos: [],
  },
  getters: {
    getTodos: (state) => state.todos,
  },
  mutations: {
    getTodos: (state, todos) => {
      state.todos = todos;
    },
    addTodo: (state, addedTodo) => {
      state.todos.push(addedTodo);
    },
    deleteTodo: (state, removedTodoId) => {
      state.todos.splice(removedTodoId, 1);
    },
  },
  actions: {
    async getTodos({ commit }) {
      const todos = await dataService.getTodos();
      commit("getTodos", todos);
    },
    async addTodo(context, newTodo) {
      const addedTodo = await dataService.addTodo(newTodo);
      context.commit("addTodo", addedTodo);
    },
    async deleteTodo(context, todo) {
      const removedTodoId = await dataService.deleteTodo(todo);
      context.commit("deleteTodo", removedTodoId);
    },
  },
  modules: {},
});
