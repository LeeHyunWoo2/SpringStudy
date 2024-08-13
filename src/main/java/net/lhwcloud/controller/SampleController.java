package net.lhwcloud.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;
import net.lhwcloud.domain.ExamDTO;
import net.lhwcloud.domain.ExamList;
import net.lhwcloud.domain.TodoDTO;

@Controller
@RequestMapping("/exam/*") // localhost:80/exam/* 그냥 이 밑으로 전부 이 하위라서 링크가 다 /exam/ 뒤에 붙음
@Log4j2
public class SampleController {

	@RequestMapping("") // 80/ 뒤에 아무것도 안적으면
	public void basic() {
		// 리턴이 void면 경로와 똑같은 jsp 를 찾아감
		log.info("SampleController.basic 실행");
	}

	// !!!!!!!!!!!! 이 밑으로 어노테이션 () 안에 들어가는건 모두!!!!!!!!!!!!!!!!!
	// !!!!!!!!!!!! http://localhost:80/exam 뒤에 들어가는 내용임!!!!!!!!!!!!!!!!

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST }) // 겟 포스트 둘다
	public void basicGet() {
		log.info("get방식 베이직");
	}

	// 요즘방식
	@GetMapping("/bazic")
	public void basicGetOnly() {
		log.info("SampleController.basicGetonly 호출");
	}

	@PostMapping("/baxic")
	public void basicPostOnly() {
		log.info("SampleController.basicPostOnly 호출");
	}

	@GetMapping("/ex01")
	public String ex01(ExamDTO examDTO) {
		log.info("ex01메서드");
		return "ex01"; // 이런식의 리턴은 /WEB-INF/views/sample/ex01.jsp 이걸 뜻함
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("id") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}

	// 리스트, 배열 처리
	@GetMapping("/ex02List") // http://localhost:80/sample/ex02List?idx=111&idx=222&idx=333
	public String ex02List(@RequestParam("idx") ArrayList<String> idx) {
		log.info("idx : " + idx);

		return "ex02List";
	}

	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("idx") String[] idx) {
		log.info("idx + " + Arrays.toString(idx));
		return "ex02Array";
	}

	@GetMapping("/ex02Bean") // http://localhost:80/sample/ex02Bean?list[0].name=kkk&list[0].age=30
	// URL에서 대괄호는 안되니까 %5B %5D 이걸로 대체함. %5B는 [ , %5D는 ]
	public String ex02Bean(ExamList list) {
		log.info("리스트 : " + list);
		return "ex02Bean";
	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todoDTO) {
		log.info("todo : " + todoDTO);
		return "ex03";
	}

	@GetMapping
	public String ex04(ExamDTO dto, @ModelAttribute("page") int page) { // http://localhost:80/sample/ex04?name=asd&age=123&page=3
		log.info("dto : " + dto);
		log.info("page : " + page);

		return "/sample/ex04"; // http://localhost:80/sample/ex04.jsp
		// view : servlet-context.xml에서 담당 -> 실제 경로 /WEB-INF/views/sample/ex04.jsp 가
		// 있어야함.
	}

	// 리턴 타입에 대한 테스트
	@GetMapping("/ex05") // http://localhost:80/sample/ex05
	public void ex05() { // -> /WEB-INF/views/sample/ex05.jsp 를 찾음 (void이기 때문에 URL과 똑같은 jsp를 따라감)
		log.info("/ex05 메서드 실행");
	}

	// 컨트롤러에서 처리한 값을 json으로 출력 테스트
	@GetMapping("/ex06") // http://localhost:80/sample/ex06
	public @ResponseBody ExamDTO ex06() { // @ResponseBody ExamDTO 응답바디 영역에 객체를 담아 리턴
		ExamDTO dto = new ExamDTO(); // 빈객체 생성
		dto.setName("엠비씨");
		dto.setAge(999);

		return dto; // json {"name":"엠비씨","age":999} -> 백 개발자는 json으로만 보냄
		// 프론트 개발자는 화면에 div, table 등을 이용해서 보여줌
	}

	@GetMapping("/ex07") // http://localhost:80/sample/ex07
	public ResponseEntity<String> ex07() {

		log.info("/ex07 메서드 실행");

		String msg = "{\"name\":\"엠비씨\",\"age\":20}"; // json "{\"name\":\"엠비씨\",\"age\":20}"
		HttpHeaders header = new HttpHeaders(); // httpheaders 객체 생성
		header.add("Context-Type", "application/json;charset=UTF-8"); // 헤더에 타입 추가 json임을 명시

		return new ResponseEntity<String>(msg, header, HttpStatus.OK); // Httpstatus.OK 200 정상코드임을 보냄
	}

	@GetMapping("/exUpload") // http://localhost:80/sample/exUpload
	public void exUpload() {
		log.info("/exUpload 메서드 실행");
		// 리턴이 void -> http://localhost:80/sample/exUpload.jsp
	}

	@PostMapping("exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("--------------------");
			log.info("name : " + file.getOriginalFilename()); // 원본 파일명 출력
			log.info("size : " + file.getSize()); // 파일 크기
			log.info("toString : " + file.toString());
		});
	}
}
