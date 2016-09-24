package com.tuiku.service;

import com.tuiku.dao.Theme;
import com.tuiku.dao.ThemeDao;
import com.tuiku.util.AuthenticationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * ThemeService - 主题服务类
 */
@Controller
@RequestMapping
public class ThemeService {

    @Autowired
    ThemeDao themeDao;

    @RequestMapping("/theme")
    public String theme(HttpServletRequest request, Map<String, Object> map) {
        AuthenticationUtil.hasCookieAndSession(request, map);

        List<Theme> themes = themeDao.getAllByCategory(0);
        map.put("themes", themes);

        return "theme";
    }

}
