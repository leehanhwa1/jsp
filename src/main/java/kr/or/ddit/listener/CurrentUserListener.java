package kr.or.ddit.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentUserListener implements HttpSessionAttributeListener{
	
	private Logger logger = LoggerFactory
			.getLogger(CurrentUserListener.class);
	
	private List<UserVo> currentLoginUserList;

	public CurrentUserListener() {
		currentLoginUserList = new ArrayList<UserVo>();
		
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// 
		if("userVo".equals(event.getName())) {
			UserVo uservo = (UserVo) event.getValue();
			currentLoginUserList.add(uservo);
			
			ServletContext application = event.getSession().getServletContext();
			
			
			application.setAttribute("currentLoginUserList", currentLoginUserList);
		}
		
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		attributeAdded(event);
		
		
	}
	
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if("userVo".equals(event.getName())) {
			UserVo uservo = (UserVo) event.getValue();
			currentLoginUserList.remove(uservo);
		}
	}


}