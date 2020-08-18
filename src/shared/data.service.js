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

const parseList = (response) => {
  if (response.status !== 200) throw Error(response.message);
  if (!response.data) return [];
  let list = response.data;
  if (typeof list !== "object") {
    list = [];
  }
  return list;
};

export const dataService = {
  getTodos,
};
