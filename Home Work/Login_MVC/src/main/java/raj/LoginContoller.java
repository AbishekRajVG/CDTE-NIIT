package raj;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginContoller {
	
	@RequestMapping("/hello")
	public String getMsg() {
		
			return "Success.jsp";
		
	}
	
	@RequestMapping("/hello1")
	public ModelAndView something() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("key", new Date(0));
		mav.setViewName("date.jsp");
		return mav;	
	}

	@RequestMapping("/getlogin")
	public String getLogin() {
		return "Login.jsp";
	}
	
	@RequestMapping("/login")
	public ModelAndView Validate(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String Uname = request.getParameter("uname");
		String Pwd = request.getParameter("pwd");
			if(Uname.equals("Raj") && Pwd.equals("123") ) {
				mav.setViewName("Success.jsp");
				mav.addObject("uname",Uname);}
			else
			{
				mav.setViewName("Failed.jsp");
			}
			return mav;
	}
}