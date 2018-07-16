package com.shop.fuelcoupons.web.user;

import com.shop.fuelcoupons.model.User;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/users")
public class JspUserController extends AbstractUserController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

/*    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "email", required = true) String email,
                          @RequestParam(value = "password", required = true) String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        if(user.isNew()){
            super.create(user);
        }
        else{
            super.update(user,user.getId());
        }
        return "redirect:/users";
    }*/

    @PostMapping()
    public String createOrUpdate(User user) {
        if (user.isNew()) {
            super.create(user);
        } else {
            super.update(user, user.getId());
        }
        return "redirect:/users";
    }

    @GetMapping("update/{id}")
    public String updateUser(@PathVariable("id")int id, Model model){
        User user = super.get(id);
        model.addAttribute("user", user);
        model.addAttribute("users",super.getAll());

        return "users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        super.delete(id);
        return "redirect:/users";
    }
}
