package com.practise.spboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpbootApplication.class, args);
	}

}


@RestController
@RequestMapping("/api/students")
class StudentController {

    @PostMapping("/top")
    public List<Student> getTopStudents(@RequestBody List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .limit(3)
                .collect(Collectors.toList());
    }
}

class Student {
    private String name;
    private int score;

    public Student() {}
    public Student(String name, int score) {
        this.name = name; this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }
    public void setName(String name) { this.name = name; }
    public void setScore(int score) { this.score = score; }
}