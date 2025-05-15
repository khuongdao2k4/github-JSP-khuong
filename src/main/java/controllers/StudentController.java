package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = new ArrayList<>();

        // Thêm dữ liệu mẫu
        students.add(new Student("SV001", "Nguyễn Văn A", "0909123456", "Hà Nội"));
        students.add(new Student("SV002", "Trần Thị B", "0912345678", "Hồ Chí Minh"));
        students.add(new Student("SV003", "Lê Văn C", "0987654321", "Đà Nẵng"));

        model.addAttribute("students", students);
        return "student_list";  // Trả về view student _list.jsp
    }
}