import Vue from "vue";
import Vuex from "vuex";

import {
  dataService
} from "../shared/data.service";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    todos: [],
  },
  strict: process.env.NODE_ENV !== 'production',
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
      state.todos = [
        ...state.todos.filter((todo) => todo.id !== removedTodoId),
      ];
    },
    editTodo: (state, editTodo) => {
      const index = state.todos.findIndex(t => t.id == editTodo.id);
      state.todos.splice(index, 1, editTodo);
      state.todos = [...state.todos];
    }
  },
  actions: {
    async getTodos({
      commit
    }) {
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
    async editTodo(context, todo) {
      const editedTodo = await dataService.editTodo(todo);
      context.commit("editTodo", editedTodo);
    },
  },
  modules: {},
});