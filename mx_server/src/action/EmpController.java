package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import pojo.Emp;

@SuppressWarnings("deprecation")
public class EmpController extends AbstractCommandController {  
    protected ModelAndView handle(HttpServletRequest request,  
      HttpServletResponse response, Object command, BindException errors) throws Exception {  
      Emp emp = (Emp)command;  
      
      System.out.println(emp.getName()+"  "+emp.getAge()+"  phone:"+request.getParameter("phone"));  
      return null;  
    }  
  }  
