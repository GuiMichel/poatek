package ChallengeOne.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class ChallengeOne {
    public static void main(String[] args) {
        int soma = 0;
        double media = 0;

        List<Student> students = getStudent();



        List<Student> result = students.stream()
                .filter(student -> student.getAge().intValue() > 13)
                .filter(student -> student.getHeight()>calcAvarage(students))
                .collect(Collectors.toList());

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
