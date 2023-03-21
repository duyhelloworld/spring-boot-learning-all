// @ts-nocheck
import * as API from "./api.js";
import { Student } from "./model.js";

let sectionC = document.querySelector('.section-C');
let sectionRD = document.querySelector(".section-RD");
let sectionU = document.querySelector(".section-U");

let students = await API.getStudents();
console.log(students);

const App = () => {
    // showAll(students)
    showTable(students)
}
App()

function showAll(students) {
    if (students === null) {
        alert("Not found any student!!!")
    } else {
        if (sectionRD != null) {
            let html = "";
            students.students.map(std => {
                html += "<td>" + std + "</td>"
            });
            sectionRD.innerHTML = html
            console.log(students);
        }
    }
}

function showTable(students, CStudent = Student) {
    let table = document.createElement("table");
    
    const fields = Object.keys(new Student);
    let tr = document.createElement("tr");
    fields.map(property => {
        let th = document.createElement('th');
        th.innerText = property;
        tr.appendChild(th);
        table.appendChild(tr);
    })
    
    students.students.map(std => {
        let row = document.createElement("tr");
        Object.keys(std).forEach(function (key, index) {
            let td = document.createElement('td');
            td.innerText = std[key];
            row.appendChild(td);
            table.appendChild(row);
        });
    })

    sectionRD.appendChild(table)
}

function showGetByIdButton() {
    let subBtn = document.createElement("button");
    subBtn.innerText = "Get this student";
    let tickBox = document.querySelector(".idStudent");
    subBtn.addEventListener("click", callStudentById(tickBox.value));
    sectionRD.appendChild(subBtn);
}

function showIdTickBox(showGetIdBtn) {
    if (sectionRD != null) {
        let tickBox = document.createElement("input");
        tickBox.className = "idStudent";
        tickBox.setAttribute("type", "number");
        sectionRD.append(tickBox);
        showGetIdBtn();
    }
}