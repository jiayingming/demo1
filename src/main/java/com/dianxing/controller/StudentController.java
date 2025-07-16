package com.dianxing.controller;


import com.dianxing.pojo.Result;
import com.dianxing.pojo.Student;
import com.dianxing.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@Tag(name = "学生管理界面")
@RequestMapping("api/user")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping

    public Result gteAll()
    {
        List<Student> list = studentService.getAll();
        return Result.success(list);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Student s = studentService.getById(id);
        return Result.success(s);
    }



    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id)
    {
        log.info(" 根据ID删除学生信息：{}",id);
        studentService.delete(id);
        return Result.success();
    }


    @PostMapping
    public Result add(@RequestBody Student s)
    {
        log.info("新增学生信息：{}",s);
        studentService.add(s);
        return Result.success();
    }


    @PutMapping
    public Result update(@RequestBody Student s) {
        log.info("更新学生信息：{}", s);
        studentService.update(s);
        return Result.success();
    }

    @GetMapping("/search")
    public Result searchStudents(
            @RequestParam(required = false) String studentId,
            @RequestParam(required = false) String name) {

        log.info("查询学生: 学号={}, 姓名={}", studentId, name);
        List<Student> students = studentService.search(studentId, name);
        return Result.success(students);
    }


}
