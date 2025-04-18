package cn.seifly.module.wp.web.utils;


import cn.seifly.common.exception.ServiceException;
import cn.seifly.common.utils.ServletUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * JwtUtil类提供了JWT（JSON Web Token）相关的实用方法
 * 它们主要用于处理与JWT生成、解析和验证相关的操作
 *
 * @author www.seifly.cn
 */
public class JwtUtil {
    private static String secret = "Zd+aZozTI5OgURLbagP8E6KTPghNNe/tEFwuLxd2UNw=";
    private static long expire = 1000 * 60 * 60 * 8;

    public static String getToken() {
        HttpServletRequest request = ServletUtils.getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            token = request.getParameter("token");
        }
        return token;
    }

    public static String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expire * 1000);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        if (!validateToken(token)) {
            throw new ServiceException("token无效或已过期");
        }
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception ex) {
            throw new ServiceException("token无效");
        }
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

