package mapstruct

class StudentSchool {
  constructor() {}

  constructor(name: String) {
    this.name = name
  }

  var name: String = ""
}

class TeacherSchool {
  constructor() {}

  constructor(name: String) {
    this.name = name
  }

  var name: String = ""

  override fun toString(): String {
    return "TeacherSchool(name='$name')"
  }


}

class Student {
  constructor() {}

  constructor(name: String, age: Int, school: StudentSchool) {
    this.age = age
    this.name = name
    this.school = school
  }

  var age: Int = 0
  var name: String = ""
  lateinit var school: StudentSchool

  override fun toString(): String {
    return "Student(age=$age, name='$name')"
  }
}

class Teacher {
  constructor() {}

  constructor(fullName: String, age: Int, school: TeacherSchool) {
    this.age = age
    this.fullName = fullName
    this.school = school
  }

  var age: Int = 0
  var fullName: String = ""
  var brithYear: Int = 0
  lateinit var school: TeacherSchool

  override fun toString(): String {
    return "Teacher(age=$age, fullName='$fullName', brithYear=$brithYear, school=$school)"
  }


}