package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {

	private IUserService userService;
	
	@Before
	public void setup(){
		userService = new UserServiceImpl();
	}
	
	/**
	 * Method : testGetAllUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 전체 사용자 조회 테스트
	 */
	@Test
	public void testGetAllUser() {
		/***Given***/
			
		/***When***/
		List<UserVo> userList = userService.getAllUser();
		for(UserVo userVo : userList)
			System.out.println(userVo);

		/***Then***/
		assertNotNull(userList);
		assertEquals(105, userList.size());
	}
	
	/**
	 * Method : testSelectUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 조회 테스트
	 */
	@Test
	public void testSelectUser(){
		/***Given***/
			
		/***When***/
		UserVo userVo = userService.selectUser("brown");

		/***Then***/
		assertEquals("brown", userVo.getUserId());
		assertEquals("brown1234", userVo.getPass());
	}
	
	/**
	 * Method : testSelectUserPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void testSelectUserPagingList(){
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);
		
		/***When***/
		Map<String, Object> resultMap =
				userService.selectUserPagingList(pageVo);
		
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		int userCnt = (Integer)resultMap.get("userCnt");
		
		for(UserVo user : userList)
			System.out.println(user);
		
		System.out.println("userCnt : " + userCnt);
		
		/***Then***/
		//userList
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		//userCnt
		assertEquals(105, userCnt);
	}

}





