package be.aware.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HtmlResource {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = {"/main"}, method = RequestMethod.GET)
    public String main(Model model) {
        return "main";
    }

    @RequestMapping(value = {"/student"}, method = RequestMethod.GET)
    public String student(Model model) {
        return "student";
    }

    @RequestMapping(value = {"/account"}, method = RequestMethod.GET)
    public String account(Model model) {
        return "personal";
    }

    @RequestMapping(value = {"/server"}, method = RequestMethod.GET)
    public String server(Model model) {
        return "server";
    }

    @RequestMapping(value = {"/channel"}, method = RequestMethod.GET)
    public String channel(Model model) {
        return "channel";
    }
}
