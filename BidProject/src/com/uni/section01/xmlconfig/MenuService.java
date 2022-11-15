package com.uni.section01.xmlconfig;

import static com.uni.section01.xmlconfig.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MenuService {
	//dao를 사용할꺼임 - 한번 생성해놓고 돌려쓸꺼임
	private final MenuDAO menuDAO;
	
	public MenuService() {
		menuDAO = new MenuDAO(); // 생성자 주입 방법
	}
	
	public List<MenuDTO> selectAllMenu() {
		
		SqlSession sqlSession = getSqlSession();
		
		System.out.println(sqlSession);
		
		List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
		
		sqlSession.close();
		
		return menuList;
	}

	public MenuDTO selectMenuByCode(int code) {
		
		SqlSession sqlSession = getSqlSession();
		
		System.out.println(sqlSession);
		
		MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);
		
		sqlSession.close();
		
		return menu;
	}

	
	public boolean registMenu(MenuDTO menu) {
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.insertMenu(sqlSession, menu);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result > 0 ? true : false;
	}

	public boolean modifyMenu(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.updateMenu(sqlSession, menu);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
		
	}

	public boolean deleteMenu(int code) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.deleteMenu(sqlSession, code);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
		
	}

	
}
