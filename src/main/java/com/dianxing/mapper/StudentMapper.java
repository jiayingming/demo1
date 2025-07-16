package com.dianxing.mapper;

import com.dianxing.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> getAll();

    @Delete("delete from student where id = #{id}")
    void delete(Integer id);

    @Insert("insert into student(studentId, name, age, gender) " +
            "value (#{studentId},#{name},#{age},#{gender})")
    void add(Student s);

    @Select("select * from student where id =#{id}")
    Student getById(Integer id);

    @Update("UPDATE Student SET studentId = #{studentId}, name = #{name}, age = #{age}, gender = #{gender} WHERE id = #{id}")
    void update(Student s);

    @Select("SELECT * FROM student WHERE studentId = #{studentId}")
    List<Student> findByStudentId(String studentId);

    @Select("SELECT * FROM student WHERE name LIKE #{name}")
    List<Student> findByNameLike(String name);

    @Select("SELECT * FROM student WHERE studentId = #{studentId} AND name LIKE #{name}")
    List<Student> findByStudentIdAndNameLike(String studentId, String name);
}
