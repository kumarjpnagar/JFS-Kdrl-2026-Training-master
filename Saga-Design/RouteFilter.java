package com.honeywell.redsapigateway.filters;

import static com.hon.constant.Constant.AUTHORIZATION_HEADER;
import static com.hon.constant.Constant.BEARER;
import static com.hon.constant.Constant.ROUTE;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulHeaders;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Component;

@Component
public class RouteFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return ROUTE;
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();

    final String originalXForwardedProto = ctx.getRequest().getHeader(ZuulHeaders.X_FORWARDED_PROTO.toLowerCase());
    final String originalXForwardedPort = ctx.getRequest().getHeader("x-forwarded-port");

    if (!StringUtils.isEmpty(originalXForwardedProto)) {
      ctx.addZuulRequestHeader(ZuulHeaders.X_FORWARDED_PROTO.toLowerCase(), originalXForwardedProto);
    }

    if (!StringUtils.isEmpty(originalXForwardedPort)) {
      ctx.addZuulRequestHeader("x-forwarded-port", originalXForwardedPort);
    }

    if (ctx.getRequest().getHeader(AUTHORIZATION_HEADER) == null) {
      addKeycloakTokenToHeader(ctx);
    }
    return null;
  }

  public void addKeycloakTokenToHeader(RequestContext ctx) {
    HttpServletRequest req = ctx.getRequest();
    KeycloakSecurityContext session =
        (KeycloakSecurityContext) req.getAttribute(KeycloakSecurityContext.class.getName());
    if (session != null)
      ctx.addZuulRequestHeader(AUTHORIZATION_HEADER, BEARER + session.getTokenString());
  }
}
