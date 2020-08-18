import Vue from "vue";
import Vuex from "vuex";
import { v4 as uuidv4 } from "uuid";
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
    addTodo: (state, text) => {
      let randomId = uuidv4();
      const newTodo = {
        id: randomId,
        name: text,
        complete: false,
      };
      state.todos.push(newTodo);
    },
    deleteTodo: (state, todo) => {
      var index = state.todos.indexOf(todo);
      state.todos.splice(index, 1);
    },
  },
  actions: {
    async getTodos({ commit }) {
      const todos = await dataService.getTodos();
      commit("getTodos", todos);
    },
    addTodo: (context, id, text) => {
      context.commit("addTodo", id, text);
    },
    deleteTodo: (context, todo) => {
      context.commit("deleteTodo", todo);
    },
  },
  modules: {},
});
