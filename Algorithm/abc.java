import java.io.*;

class Student{
    int grade = 0;
    int age = 0;

    Student(int grade, int age){ //학년 나이 
        this.grade = grade;
        this.age = age;
    }

    void callclass(){
        System.out.println("학년 : " + grade);
    }

    void callage(){
        System.out.println("나이 : " + age);
    }
}

class abc{
    public static void main(String[] args) throws IOException{
        Student chae;
        Student Lee;
        chae = new Student(3,25);
        Lee = new Student(3, 24);
        chae.callage();
        chae.callclass();
        Lee.callage();
        Lee.callclass();
    }
}