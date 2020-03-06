package com.yyy.housingtransactions.controller;

import com.yyy.housingtransactions.model.common.CommonObjectResponse;
import com.yyy.housingtransactions.service.HouseService;
import com.yyy.housingtransactions.service.UserService;
import com.yyy.housingtransactions.util.AESUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private String password = "yyy";

    @Resource
    private HouseService houseService;

    @Resource
    private UserService userService;

    private void validateAdmin(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            throw new RuntimeException("没有权限");
        }
        for (Cookie cookie : cookies) {
            if ("_admin_token".equals(cookie.getName())) {
                String value = cookie.getValue();
                String pass = AESUtil.decode(value);
                if (pass.equals(password)) {
                    return;
                }
            }
        }
        throw new RuntimeException("没有权限");
    }

    private void addCookie(HttpServletResponse response, Cookie cookie, boolean isHttpOnly) {
        String name = cookie.getName();
        String value = cookie.getValue();
        int maxAge = cookie.getMaxAge();
        String path = cookie.getPath();
        String domain = cookie.getDomain();
        boolean isSecure = cookie.getSecure();
        StringBuilder buffer = new StringBuilder();
        buffer.append(name).append("=").append(value).append(";");

        if (maxAge == 0) {
            buffer.append("Expires=Thu Jan 01 08:00:00 CST 1970;");
        } else if (maxAge > 0) {
            buffer.append("Max-Age=").append(maxAge).append(";");
        }
        if (domain != null) {
            buffer.append("domain=").append(domain).append(";");
        }
        if (path != null) {
            buffer.append("path=").append(path).append(";");
        }
        if (isSecure) {
            buffer.append("secure;");
        }
        if (isHttpOnly) {
            buffer.append("HTTPOnly;");
        }
        response.addHeader("Set-Cookie", buffer.toString());
    }

    @GetMapping("/login")
    public CommonObjectResponse login(@RequestParam("pass") String pass, HttpServletResponse response) {
        if (pass.equals(password)) {
            Cookie cookie = new Cookie("_admin_token", AESUtil.encode(pass));
            cookie.setMaxAge(24 * 60 * 60);
            cookie.setPath("/");
            addCookie(response, cookie, true);
            return CommonObjectResponse.ok();
        } else {
            return CommonObjectResponse.notOk("口令错误");
        }
    }

    @GetMapping("/isAdmin")
    public CommonObjectResponse isAdmin(HttpServletRequest request) {
        validateAdmin(request);
        return CommonObjectResponse.ok();
    }

    @GetMapping("/getAllHouse")
    public CommonObjectResponse getAllHouse(@RequestParam("pageNum") int pageNum, @RequestParam(value = "content", required = false) String content, HttpServletRequest request) {
        validateAdmin(request);
        if (StringUtils.isBlank(content)) {
            content = null;
        }
        return CommonObjectResponse.ok(houseService.getAll(pageNum, content));
    }

    @GetMapping("/delHouse")
    public CommonObjectResponse delHouse(@RequestParam("id") Long id, HttpServletRequest request){
        validateAdmin(request);
        houseService.del(id);
        return CommonObjectResponse.ok();
    }

    @GetMapping("/getAllUser")
    public CommonObjectResponse getAllUser(@RequestParam("pageNum") int pageNum, @RequestParam(value = "content", required = false) String content, HttpServletRequest request) {
        validateAdmin(request);
        if (StringUtils.isBlank(content)) {
            content = null;
        }
        return CommonObjectResponse.ok(userService.getAll(pageNum,content));
    }

    @GetMapping("/delUser")
    public CommonObjectResponse delUser(@RequestParam("id") Long id, HttpServletRequest request){
        validateAdmin(request);
        userService.delUser(id);
        return CommonObjectResponse.ok();
    }
}
