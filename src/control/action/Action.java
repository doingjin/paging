package control.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	// ActionForward 앞에 abstract public이 생략될 수 있는 이유는 interface라서
}
