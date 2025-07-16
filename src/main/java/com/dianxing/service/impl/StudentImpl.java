package com.dianxing.service.impl;

import com.dianxing.mapper.StudentMapper;
import com.dianxing.pojo.Student;
import com.dianxing.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }

    @Override
    public void delete(Integer id) {
        studentMapper.delete(id);
    }

    @Override
    public void add(Student s) {
        studentMapper.add(s);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student s) {
        studentMapper.update(s);
    }

    @Override
    public List<Student> search(String studentId, String name) {
        // 构建查询条件
        if (StringUtils.hasText(studentId) && StringUtils.hasText(name)) {
            // 同时按学号和姓名查询
            return studentMapper.findByStudentIdAndNameLike(studentId, "%" + name + "%");
        } else if (StringUtils.hasText(studentId)) {
            // 精确学号查询
            return studentMapper.findByStudentId(studentId);
        } else if (StringUtils.hasText(name)) {
            // 模糊姓名查询
            return studentMapper.findByNameLike("%" + name + "%");
        }
        // 无查询条件返回空列表
        return Collections.emptyList();
    }


}
