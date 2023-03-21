import { Student, Students } from "./model.js";
// https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch

const url = "http://localhost:8080/api/v1/student"


let get = {
  method: "GET",
  headers: {
    "Content-Type": "application/json",
  },
  credentials: "same-origin",
  mode: "cors",
};

export async function getStudents(URL = url) {
    const response = await fetch(URL, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "same-origin",
      mode: "cors"
    });

    let listStudents = new Students();
    return response.json().then(datas => {
      
      for (const data of datas) {
        let stu = new Student(data)
        listStudents.push(stu)
      }
      return listStudents;
      })
    .catch(err => {
      console.error(err);
      return null;
    });
}

export async function getStudentById(URL = url, id = 0) {
  let _id = Number(id);
  const response = await fetch(URL + `/?id=${id}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "same-origin",
    mode: "cors",
  });

  response.json();
}

export async function registerNewStudent(URL = url, student = {}) {
  const response = await fetch(URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "same-origin",
    mode: "cors",
    body: JSON.stringify(student)
  });

  response.json();
}

export async function updateNameOrMail(URL = url, id = 0, name = "unknown", mail = "unknown") {
  let _id = Number(id);
  const response = await fetch(URL + `/${id}&`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "same-origin",
    mode: "cors",
  });

  response.json();
}