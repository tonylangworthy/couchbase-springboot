package com.example.couchbasedemo.service;

import com.example.couchbasedemo.dto.EnrollmentDto;
import com.example.couchbasedemo.dto.StudentRecordDto;
import com.example.couchbasedemo.exception.StudentNotFoundException;
import com.example.couchbasedemo.model.Enrollment;
import com.example.couchbasedemo.model.StudentRecord;
import com.example.couchbasedemo.repository.StudentRecordRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("StudentService")
public class StudentService {

    private final StudentRecordRepository studentRecordRepository;

    public StudentRecord create(StudentRecordDto studentRecordDto) {
        List<Enrollment> enrollments = studentRecordDto.getEnrollments().stream().map(enrollment ->
                new Enrollment(
                        enrollment.getCourseId(), enrollment.getDateEnrolled(), enrollment.getDateCompleted())
        ).collect(Collectors.toList());

        StudentRecord newStudentRecord = new StudentRecord(
                studentRecordDto.getId(), studentRecordDto.getName(), studentRecordDto.getDateOfBirth(), enrollments);

        return studentRecordRepository.save(newStudentRecord);
    }

    public StudentRecordDto update(StudentRecordDto studentRecordDto) {
        List<Enrollment> enrollmentList = studentRecordDto.getEnrollments().stream().map(enrollment ->
                new Enrollment(enrollment.getCourseId(), enrollment.getDateEnrolled(), enrollment.getDateCompleted())
        ).collect(Collectors.toList());

        StudentRecord studentRecord = new StudentRecord(studentRecordDto.getId(), studentRecordDto.getName(),
                studentRecordDto.getDateOfBirth(), enrollmentList);

        StudentRecord savedStudentRecord = studentRecordRepository.save(studentRecord);

        List<EnrollmentDto> savedEnrollments = savedStudentRecord.getEnrollments().stream()
                .map(enrollment -> new EnrollmentDto(enrollment.getCourseId(), enrollment.getDateEnrolled(),
                        enrollment.getDateCompleted())).collect(Collectors.toList());

        return new StudentRecordDto(savedStudentRecord.getId(), savedStudentRecord.getName(), savedStudentRecord.getDateOfBirth(), savedEnrollments);
    }

    public List<StudentRecordDto> fetchAllStudents() {
        List<StudentRecord> studentRecordList = studentRecordRepository.findAll();

        return studentRecordList.stream().map(studentRecord -> {
            List<EnrollmentDto> enrollmentDtos = studentRecord.getEnrollments().stream().map(enrollment ->
                    new EnrollmentDto(enrollment.getCourseId(), enrollment.getDateEnrolled(),
                            enrollment.getDateCompleted())).collect(Collectors.toList());

            return new StudentRecordDto(studentRecord.getId(), studentRecord.getName(),
                    studentRecord.getDateOfBirth(), enrollmentDtos);

            }).collect(Collectors.toList());
    }

    public StudentRecordDto findByStudentId(String studentId) {
        Optional<StudentRecord> optionalStudentRecord = studentRecordRepository.findById(studentId);

        StudentRecord studentRecord = optionalStudentRecord.orElseThrow(StudentNotFoundException::new);

        List<EnrollmentDto> enrollmentDtos = studentRecord.getEnrollments().stream().map(enrollment ->
                new EnrollmentDto(
                        enrollment.getCourseId(), enrollment.getDateEnrolled(), enrollment.getDateCompleted())
        ).collect(Collectors.toList());

        return new StudentRecordDto(studentRecord.getId(), studentRecord.getName(),
                studentRecord.getDateOfBirth(), enrollmentDtos);
    }
}
