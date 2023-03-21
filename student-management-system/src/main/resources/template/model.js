export class Student {
    id; name; age; dob; email; definition;
    
    constructor(obj) {
        Object.assign(this, obj)
    }

    toString() {
        return `{
            id = ${this.id},
            name = ${this.name},
            age = ${this.age},
            date of birth = ${this.dob},
            email = ${this.email}, 
            description = ${this.definition}
            }`
    }
}

export class Students {
  constructor() {
    this.students = [];
  }

push(student) {
    this.students.push(student);
}

  pop() {
    return this.students.pop();
  }
}
