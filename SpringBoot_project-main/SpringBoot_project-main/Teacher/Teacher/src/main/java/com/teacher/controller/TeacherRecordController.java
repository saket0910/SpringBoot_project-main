package com.teacher.controller;

import com.teacher.entities.TeacherRecord;
import com.teacher.service.TeacherRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherRecordController {

    @Autowired
    private TeacherRecordService teacherRecordService;

    @PostMapping("/newTeacher")
    public TeacherRecord createTeacher(@RequestBody TeacherRecord teacherRecord) {
        return this.teacherRecordService.saveTeacher(teacherRecord);
    }

    @GetMapping("/getById/{id}")
    public TeacherRecord getByTeacherId(@PathVariable Integer id) {
        return this.teacherRecordService.getTeacherById(id);
    }

    @GetMapping("/getAllRecord")
    public List<TeacherRecord> allRecords() {
        return this.teacherRecordService.getAllTeacher();
    }

    @PutMapping("/updateById/{id}")
    public TeacherRecord updateByTeacherId(@PathVariable Integer id, @RequestBody TeacherRecord teacherRecord) {
        return this.teacherRecordService.updateTeacherById(id, teacherRecord);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteByTeacherId(@PathVariable Integer id) {
        this.teacherRecordService.deleteTeacherById(id);
    }

    @DeleteMapping("/deleteAllRecord")
    public void clearRecord() {
        this.teacherRecordService.deleteAllTeacher();
    }
}
