package br.com.frwk.gateway.filter;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthenticatedFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		SecurityContext context = SecurityContextHolder.getContext();
		return context.getAuthentication() != null && context.getAuthentication().isAuthenticated();
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		SecurityContext securityContext = SecurityContextHolder.getContext();
		User principal = (User) securityContext.getAuthentication().getPrincipal();
		requestContext.addZuulRequestHeader("X-username", principal.getUsername());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 6;
	}

}
