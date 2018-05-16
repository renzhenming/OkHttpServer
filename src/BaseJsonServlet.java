import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.ResponseEntity;


public abstract class BaseJsonServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void onResponse(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		ResponseEntity entity = null;
		try {
			entity = onHandle(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity();
		}
		PrintWriter writer = resp.getWriter();
		writer.write(JSON.toJSONString(entity));
		writer.flush();
		writer.close();
	}

	protected abstract ResponseEntity onHandle(HttpServletRequest req,
			HttpServletResponse resp) throws Exception;

}
