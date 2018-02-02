package org.topjava.training.web;

import org.topjava.training.model.UserMeal;
import org.topjava.training.repository.InMemoryUserMealRepository;
import org.topjava.training.repository.UserMealRepository;
import org.topjava.training.util.UserMealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

public class MealServlet extends HttpServlet {

    private UserMealRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryUserMealRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if(action == null){
            //LOG.info("get all");
            request.setAttribute("mealList", UserMealsUtil.getWithExceeded(repository.getAll(), 2000));
            repository.getAll().stream().forEach(m -> System.out.println(m.getId()));
            System.out.println(UserMealsUtil.getWithExceeded(repository.getAll(), 2000));
            request.getRequestDispatcher("/mealList.jsp").forward(request,response);
        }else if(action.equals("delete")){
            Integer id = getId(request);
            //LOG.info("Delete {}, id");
            repository.delete(id);
            response.sendRedirect("meals");
        }else{
            final UserMeal meal = action.equals("create") ?
                    new UserMeal(LocalDateTime.now(), "", 1000) :
                    repository.get(getId(request));
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("mealEdit.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        UserMeal userMeal = new UserMeal(id.isEmpty() ? null : Integer.valueOf(id),
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("calories")));
        //LOG.info(userMeal.isNew() ? "Create {}" : "Update {}", userMeal);
        repository.save(userMeal);
        response.sendRedirect("meals");


    }

    private Integer getId(HttpServletRequest request) {
        String id = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(id);
    }
}

