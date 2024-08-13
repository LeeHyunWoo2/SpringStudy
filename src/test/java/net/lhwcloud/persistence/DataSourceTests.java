package net.lhwcloud.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.lhwcloud.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 메서드 별로 테스트하는 기능을 활성화시킴
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참조할 파일. 괄호에 "" 만들고 컨+스페하면 됨
@Log4j2 // log 출력용
public class DataSourceTests {
	
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	
	@Test
	public void testGetTimeXml() {
		log.info(timeMapper.getTimeXml());
		// INFO  net.lhwcloud.persistence.DataSourceTests(testGetTimeXml39) - 2024-08-13 16:29:39
		
		// log4jdbc 적용 후 결과
		
		// |--------------------|
		// |sysdate             |
		// |--------------------|
		// |2024-08-13 16:42:28 |
		// |--------------------|

	}
	
	
	@Test
	public void testGetTime() {
		
			log.info(timeMapper.getClass().getName()); // 클래스의 이름을 출력
			// INFO  net.lhwcloud.persistence.DataSourceTests(testGetTime41) - com.sun.proxy.$Proxy36
			log.info(timeMapper.getTime()); // select 쿼리가 있는 메서드
			// INFO  net.lhwcloud.persistence.DataSourceTests(testGetTime42) - 2024-08-13 15:58:43
	}
	
	@Test
	public void testMyBatis() {
		// 동적 쿼리문을 처리해주는 sql 매핑용 테스트
		
	try {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Connection connection = sqlSession.getConnection();
		log.info(sqlSession);
		// INFO  net.lhwcloud.persistence.DataSourceTests(testMyBatis54) - org.apache.ibatis.session.defaults.DefaultSqlSession@3c4262d1
		log.info(connection);
		// INFO  net.lhwcloud.persistence.DataSourceTests(testMyBatis55) - HikariProxyConnection@269244031 wrapping oracle.jdbc.driver.T4CConnection@9f6e406
	} catch (Exception e) {
		fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testConnection() {
		
		Connection connection;
		try {
			connection = dataSource.getConnection();
			log.info(connection); // 성공시 처리되는 로그
			// INFO  net.lhwcloud.persistence.DataSourceTests(testConnection70) - HikariProxyConnection@1069531012 wrapping oracle.jdbc.driver.T4CConnection@9f6e406
		} catch (SQLException e) {
			fail(e.getMessage()); // 실패시 처리되는 로그
		}
	}

}
