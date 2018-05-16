import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 为什么eclipse不识别HttpServlet

因为没有servlet架包，要在项目中导入这个架包。

工程上右键，选择properties，然后选择java build path，library选项卡，add external jars，在tomcat的lib目录下找到servlet-api.jar，加载进来就可以了

 * @author renzhenming
 *
 */
@WebServlet("/TestServlet")//这里如果不加/服务器启动不了（start failed）
public class TestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doPost(req, resp);
		PrintWriter writer = resp.getWriter();
		writer.write("server data is coming");
		writer.flush();
		writer.close();
	}
}
