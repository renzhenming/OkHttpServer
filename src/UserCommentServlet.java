import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ResponseEntity;

@WebServlet("/UserCommentServlet")
public class UserCommentServlet extends BaseJsonServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected ResponseEntity onHandle(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		//判断该用户有没有登录，没有或cookie过期都不让评论
		ResponseEntity entity = new ResponseEntity();
		entity.code = "0033";
		entity.msg = "评论失败，用户未登录";
		Cookie cookies[] = req.getCookies();
		if (cookies != null) {
			for(Cookie cookie:cookies){
				String userName = cookie.getName();
				if (userName != null) {
					entity.code = "0000";
					entity.msg = "评论成功";
				}
			}
		}
		
		return entity;
	}

}
