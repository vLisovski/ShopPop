package org.homework.servlets.exception;

import com.google.gson.Gson;
import org.homework.servlets.dto.ExceptionDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ExceptionHandler extends HttpServlet {
    private Gson gson;

    public ExceptionHandler(){
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String statusCode = request.getAttribute("javax.servlet.error.status_code").toString();
        String exceptionType = request.getAttribute("javax.servlet.error.exception_type").toString();
        String errorMessage = request.getAttribute("javax.servlet.error.message").toString();

        ExceptionDto exceptionDto = new ExceptionDto(statusCode,exceptionType,errorMessage);

        String exceptionAsJson = gson.toJson(exceptionDto);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(exceptionAsJson);
    }
}
