import * as axios from "axios";

const apiUrl = "http://localhost:8888";

const getTodos = async function () {
  try {
    const res = await axios.get(`${apiUrl}/todo`);
    return parseList(res);
  } catch (e) {
    console.log(e);
    return [];
  }
};

const getTodo = async function (id) {
  try {
    const res = await axios.get(`${apiUrl}/todo/${id}`);
    let todo = parseItem(res, 200);
    return todo;
  } catch (e) {
    console.log(e);
    return null;
  }
};
const addTodo = async function (todo) {
  try {
    const res = await axios.post(`${apiUrl}/todo/`, todo);
    const addedTodo = parseItem(res, 201);
    return addedTodo;
  } catch (e) {
    console.log(e);
    return null;
  }
};
const deleteTodo = async function (todo) {
  try {
    const res = await axios.delete(`${apiUrl}/todo/${todo.id}`);
    parseItem(res, 200);
    return todo.id;
  } catch (e) {
    console.log(e);
    return null;
  }
};
const editTodo = async function (todo) {
  try {
    const res = await axios.put(`${apiUrl}/todo/${todo.id}`, todo);
    const editedTodo = parseItem(res, 200);
    return editedTodo;
  } catch (e) {
    console.log(e);
    return null;
  }
};

//Parse response functions

const parseList = (response) => {
  if (response.status !== 200) throw Error(response.message);
  if (!response.data) return [];
  let list = response.data;
  if (typeof list !== "object") {
    list = [];
  }
  return list;
};

const parseItem = (response, code) => {
  if (response.status !== code) throw Error(response.message);
  let item = response.data;
  if (typeof item !== "object") {
    item = undefined;
  }
  return item;
};

export const dataService = {
  getTodos,
  getTodo,
  addTodo,
  deleteTodo,
  editTodo,
};
