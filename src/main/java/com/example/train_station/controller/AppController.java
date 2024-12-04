package com.example.train_station.controller;

import com.example.train_station.service.RouteService;
import jakarta.validation.Valid;
import com.example.train_station.dto.UserDto;
import com.example.train_station.entity.User;
import com.example.train_station.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.train_station.service.ScheduleService;
import com.example.train_station.service.TrainService;
import com.example.train_station.entity.Schedule;
import com.example.train_station.entity.Train;
import com.example.train_station.entity.Route;
import java.util.List;

@Controller
public class AppController {
    private UserService userService;
    public AppController(UserService userService) {
        this.userService = userService;
    }

    // метод обработки запроса на вход в систему
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // отправка формы
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    // список юзеров
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @Autowired
    private ScheduleService service;

    @RequestMapping("/")
    // Аннотация @RequestMapping используется для мапинга с URL для всего класса или для конкретного метода обработчика.
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Schedule> listSchedule = service.listAll(keyword);
        model.addAttribute("listSchedule", listSchedule);
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @RequestMapping("/index")
    public String viewHome(Model model, @Param("keyword") String keyword) {
        List<Schedule> listSchedule = service.listAll(keyword);
        model.addAttribute("listSchedule", listSchedule);
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @RequestMapping("/admin")
    public String viewAdmin(Model model, @Param("keyword") String keyword) {
        List<Schedule> listSchedule = service.listAll(keyword);
        model.addAttribute("listSchedule", listSchedule);
        model.addAttribute("keyword", keyword);
        return "admin";
    }

    @RequestMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/admin";
    }

    @Autowired
    private TrainService trainService;
    @RequestMapping("/trains")
    public String viewTrains(Model model, @Param("keyword") String keyword) {
        List<Train> listTrain = trainService.listAll(keyword);
        model.addAttribute("listTrain", listTrain);
        model.addAttribute("keyword", keyword);
        return "trains";
    }
    @RequestMapping("/admin_trains")
    public String viewAdminTrains(Model model, @Param("keyword") String keyword) {
        List<Train> listTrain = trainService.listAll(keyword);
        model.addAttribute("listTrain", listTrain);
        model.addAttribute("keyword", keyword);
        return "admin_trains";
    }

    @RequestMapping("/train_delete/{id}")
    public String deleteTrain(@PathVariable(name = "id") Long id) {
        trainService.delete(id);
        return "redirect:/admin_trains";
    }

    @Autowired
    private RouteService routeService;
    @RequestMapping("/route/{id}")
    public String viewRoute(Model model,@PathVariable(name = "id") Long id) {
        List<Route> listRoute = routeService.listFiltered(id);
        model.addAttribute("listRoute", listRoute);
        return "route";
    }

    @RequestMapping("/all_routes")
    public String viewAllRoutes(Model model, @Param("keyword") String keyword) {
        List<Route> listRoute = routeService.listAll(keyword);
        model.addAttribute("listRoute", listRoute);
        model.addAttribute("keyword", keyword);
        return "all_routes";
    }

    @RequestMapping("/route_delete/{id}")
    public String deleteRoute(@PathVariable(name = "id") Long id) {
        routeService.delete(id);
        return "redirect:/all_routes";
    }

}