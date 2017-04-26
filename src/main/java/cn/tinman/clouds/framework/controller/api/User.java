package cn.tinman.clouds.framework.controller.api;

import cn.tinman.clouds.framework.response.ResponseMap;
import cn.tinman.clouds.framework.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class User {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMap getParams() {
        Integer userCount = userService.countUser();

        Map data = new HashMap<>();
        data.put("userCount", userCount);
        return ResponseMap.SuccessResponse(data);
    }
}
