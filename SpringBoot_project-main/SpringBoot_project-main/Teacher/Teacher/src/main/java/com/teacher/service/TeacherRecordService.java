package com.teacher.service;

import com.teacher.entities.TeacherRecord;
import com.teacher.repository.TeacherRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherRecordService {

    @Autowired
    private TeacherRecordRepo teacherRecordRepo;

    // Create
    public TeacherRecord saveTeacher(TeacherRecord receivedData) {
        TeacherRecord teacherRecord = new TeacherRecord();

        teacherRecord.setTeacherName(receivedData.getTeacherName());
        teacherRecord.setMobileNo(receivedData.getMobileNo());

        return this.teacherRecordRepo.save(teacherRecord);
    }

    // Read
    public TeacherRecord getTeacherById(int id) {
        return this.teacherRecordRepo.findById(id).get();
    }

    public List<TeacherRecord> getAllTeacher() {
        return this.teacherRecordRepo.findAll();
    }

    // Update
    public TeacherRecord updateTeacherById(int id, TeacherRecord newData) {
        TeacherRecord existingData = this.teacherRecordRepo.findById(id).orElse(null);

        if (existingData != null) {
            existingData.setTeacherName(newData.getTeacherName());
            existingData.setMobileNo(newData.getMobileNo());

            return this.teacherRecordRepo.save(existingData);
        }

        return null;
    }

    // Delete
    public void deleteTeacherById(int id) {
        this.teacherRecordRepo.deleteById(id);
    }

    public void deleteAllTeacher() {
        this.teacherRecordRepo.deleteAll();
    }
}
