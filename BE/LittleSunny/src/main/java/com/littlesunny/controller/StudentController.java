package com.littlesunny.controller;

import com.littlesunny.dto.request.StudentClassRequest;
import com.littlesunny.dto.request.StudentRequest;
import com.littlesunny.dto.response.ResponseApi;
import com.littlesunny.dto.response.StudentResponse;
import com.littlesunny.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class StudentController {
	StudentService studentService;
	
	@PostMapping
	public ResponseApi<StudentResponse> createStudent(@RequestBody StudentRequest request) {
		return ResponseApi.<StudentResponse>builder()
				.result(studentService.createStudent(request))
				.build();
	}
	
	@PutMapping("/{id}")
	public ResponseApi<StudentResponse> updateStudent(@PathVariable String id, @RequestBody StudentRequest request) {
		return ResponseApi.<StudentResponse>builder()
				.result(studentService.updateStudent(id, request))
				.build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseApi<?> deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
		return ResponseApi.builder()
				.result("Student has been deleted")
				.build();
	}
	
	@GetMapping
	public ResponseApi<List<StudentResponse>> getStudents(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return ResponseApi.<List<StudentResponse>>builder()
				.result(studentService.getStudents(page, size))
				.build();
	}
	
	@GetMapping("/not-enrolled-in-course/{courseId}")
	public ResponseApi<List<StudentResponse>> getStudentsNotEnrolled(
			@PathVariable Long courseId,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return ResponseApi.<List<StudentResponse>>builder()
				.result(studentService.getStudentsNotEnrolled(courseId, page, size))
				.build();
	}
	
	@PutMapping("/update-payment-status")
	public ResponseApi<StudentResponse> updatePaymentStatus(@RequestBody StudentClassRequest request) {
		return ResponseApi.<StudentResponse>builder()
				.result(studentService.updatePaymentStatus(request))
				.build();
	}
	
	@DeleteMapping("delete-student-from-class")
	public ResponseApi<?> deleteStudentFromClass(@RequestBody StudentClassRequest request) {
		studentService.deleteStudentFromClass(request);
		return ResponseApi.builder()
				.result("Đã xóa học viên khỏi lớp")
				.build();
	}
}
