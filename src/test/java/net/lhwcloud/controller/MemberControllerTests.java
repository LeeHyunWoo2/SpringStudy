package net.lhwcloud.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 프론트라서 서블릿컨텍스트도 참조
@Log4j2
@WebAppConfiguration
public class MemberControllerTests {

	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx; // 톰캣 대타

	private MockMvc mockMvc; // 크롬 대타

	@Before // junit껄로 import해야함. 구동 전에 선행해야하는 코드 작성
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/member/registerMember").param("id", "dsa").param("pw", "333")
						.param("name", "테스트맨"))
				.andReturn() // 결과를
				.getModelAndView().getViewName(); // 리턴값을 받아서 String 처리

		log.info("결과 url : " + resultPage);
	}

	@Test // bno가 넘어가면 돌아오는 값은 객체
	public void testGet() throws Exception {
		log.info("결과 : "
				+ mockMvc.perform(MockMvcRequestBuilders.get("/member/getMember").param("id", "dsa")).andReturn() // 결과를
						.getModelAndView().getModelMap() // select들은 모델맵으로 리턴함
		);
	}

	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/member/modifyMember").param("id", "dsa")
				.param("pw", "123").param("name", "크악")).andReturn().getModelAndView().getViewName();

		log.info("결과 url : " + resultPage);

	}

	@Test
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/member/removeMember").param("id", "dsa"))
				.andReturn().getModelAndView().getViewName(); // 리턴값을 받아 String 처리
		log.info("결과 url : " + resultPage);
	}

}
