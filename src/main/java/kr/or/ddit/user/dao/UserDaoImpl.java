package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserDaoImpl implements IUserDao{
	
	/**
	 * Method : getAllUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 조회
	 */
	public List<UserVo> getAllUser(){
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession =sqlSessionFactory.openSession();
		List<UserVo> userList = sqlSession.selectList("user.getAllUser");
		sqlSession.close();
		
		return userList;
	}

	/**
	 * Method : selectUser
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 조회
	 */
	@Override
	public UserVo selectUser(String userId) {
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession =sqlSessionFactory.openSession();
		UserVo userVo = sqlSession.selectOne("user.selectUser", userId);
		sqlSession.close();
		
		return userVo;
	}

	/**
	 * Method : selectUserPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public List<UserVo> selectUserPagingList(PageVo pageVo) {
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession =sqlSessionFactory.openSession();
		List<UserVo> userList = sqlSession.selectList("user.selectUserPagingList", pageVo);
		sqlSession.close();
		
		return userList;
	}

	/**
	 * Method : getUserCnt
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 수를 조회
	 */
	@Override
	public int getUserCnt() {
		SqlSessionFactory sqlSessionFactory =
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int userCnt = sqlSession.selectOne("user.getUserCnt");
		sqlSession.close();
		
		return userCnt;
	}
}









