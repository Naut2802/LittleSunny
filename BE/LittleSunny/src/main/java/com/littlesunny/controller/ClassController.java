package com.littlesunny.controller;

import com.littlesunny.dto.request.ClassRequest;
import com.littlesunny.dto.request.StudentClassRequest;
import com.littlesunny.dto.response.ClassResponse;
import com.littlesunny.dto.response.ResponseApi;
import com.littlesunny.service.ClassService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/class")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ClassController {
	ClassService classService;
	
	@PostMapping
	public ResponseApi<ClassResponse> createClass(@RequestBody ClassRequest request) {
		return ResponseApi.<ClassResponse>builder()
				.result(classService.createClass(request))
				.build();
	}
	
	@PutMapping("/{id}")
	public ResponseApi<ClassResponse> updateClass(@PathVariable long id, @RequestBody ClassRequest request) {
		return ResponseApi.<ClassResponse>builder()
				.result(classService.updateClass(id, request))
				.build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseApi<?> deleteClass(@PathVariable long id) {
		classService.deleteClass(id);
		return ResponseApi.builder()
				.result("Class has been deleted")
				.build();
	}
	
	@DeleteMapping("delete-student-from-class")
	public ResponseApi<?> deleteStudentFromClass(@RequestBody StudentClassRequest request) {
		classService.deleteStudentFromClass(request);
		return ResponseApi.builder()
				.result("Đã xóa học viên khỏi lớp")
				.build();
	}
	
	@GetMapping
	public ResponseApi<List<ClassResponse>> getClasses(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return ResponseApi.<List<ClassResponse>>builder()
				.result(classService.getClasses(page, size))
				.build();
	}
	
	@GetMapping("/count-students-by-class/{classId}")
	public ResponseApi<Long> countStudentsByClassId(@PathVariable long classId) {
		return ResponseApi.<Long>builder()
				.result(classService.countStudentsInClass(classId))
				.build();
	}
}
