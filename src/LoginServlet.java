import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.ResponseEntity;
import bean.UserInfoEntity;

@WebServlet("/LoginServlet")
public class LoginServlet extends BaseJsonServlet{

	private static final long serialVersionUID = 1L;
 
	@Override
	protected ResponseEntity onHandle(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		
		ResponseEntity entity = new ResponseEntity();
		entity.code = "0022";
		entity.msg = "用户名或密码错误";
		
		String userName = req.getParameter("userName");
		if ("rzm".equals(userName)) {
			entity.code = "0000";
			entity.msg = "登录成功";
			
			UserInfoEntity usEntity = new UserInfoEntity();
			usEntity.userName = userName;
			usEntity.userSex = "男";
			
			entity.data = JSON.toJSONString(usEntity);
			Cookie cookie = new Cookie("userName", "rzm");
			//设置cookie过期时间
			cookie.setMaxAge(10);
			resp.addCookie(cookie);
		}
		return entity;
	}

}
