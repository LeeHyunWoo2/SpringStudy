package net.lhwcloud.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

// 테스트 코드에는 필수사항 3가지가 있다.
// 필수!!!!!! pom.xml에 spring-test 코드가 필수로 필요함. 없어서 자동완성 안되고 난리났었음

@RunWith(SpringJUnit4ClassRunner.class) // 메서드 별로 테스트하는 기능을 활성화시킴
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참조할 파일. 괄호에 "" 만들고 컨+스페하면 됨
@Log4j2 // log 출력용

public class SampleTests {
	
	@Setter(onMethod_ = @Autowired) // setRestaurant(Restaurant)
	private Restaurant restaurant;  // Restaurant restaurant = new Restaurant(restaurant);
	
	@Test // import org.junit.Test; 메서드 별로 테스트가 진행됨. (메서드명 블럭 -> 우클릭 -> run as -> junit)
	public void textExist() {
		
		assertNotNull(restaurant); // assertNotNull() 객체가 null인지 여부
		log.info(restaurant);
		log.info("--------------------");
		log.info(restaurant.getChef()); // restaurant 객체에 있는 Chef 필드를 가져와 출력
		
		// INFO  net.lhwcloud.sample.SampleTests(textExist30) - Restaurant(chef=Chef(name=null, age=0, regDate=null), restaurantName=null, openTime=null, closeTime=null)
		// INFO  net.lhwcloud.sample.SampleTests(textExist31) - --------------------
		// INFO  net.lhwcloud.sample.SampleTests(textExist32) - Chef(name=null, age=0, regDate=null)
		
	}
	
}
