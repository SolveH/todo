import * as axios from "axios";

const getTodos = async function() {
  try {
    const res = await axios.get("http://localhost:8888/todos");
    return parseList(res);
  } catch (e) {
    console.log(e);
    return [];
  }
};

const getTodo = async function(id) {
  try {
    const res = await axios.get(`http://localhost:8888/todos/${id}`);
    let todo = parseItem(res, 200);
    return todo;
  } catch (e) {
    console.log(e);
    return null;
  }
};

//Parse response functions

const parseList = response => {
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
  getTodo
};
