package ChallengeOne.Lists;

import java.util.List;

public class ChallengeOneLists {
    public static void main(String[] args) {

        List<Student> students = getStudent();

        List<Student> result = students.stream()
                .filter(student -> student.getAge() > 13)
                .filter(student -> student.getHeight() > calcAvarage(students))
                .toList();

        result.forEach(System.out::println);
    }

    private static List<Student> getStudent(){
        return List.of(
                new Student("Bruno", 170, 14)
                ,new Student("Leonardo", 174, 21)
                ,new Student("Juan",156, 12)
                ,new Student("Juliana",166, 13)
                ,new Student("Wagner",184, 17)
                ,new Student("Micaela",172, 18)
                ,new Student("Bento",150, 14)
                ,new Student("Lucia",162, 13)
                ,new Student("Pedro",169, 14)
                ,new Student("Carla",158, 16)
        );
    }

    private static Integer calcAvarage(List<Student> students){
        Integer soma=0;

        for (Student stud:students) soma += stud.getHeight();
        return soma/students.size();
    }

}
