class Student {
    String name;

    public Student(String name) {
        name = name;
    }

    public void printName() {
        System.out.println("이름: " + name);
    }
    
public static void main(String[] args) {
    Student student = new Student("홍길동");
    student.printName();  // "이름: null" 출력
}
}
