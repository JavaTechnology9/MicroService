package com.javatechnology.filters;

import org.springframework.stereotype.Component;

import com.javatechnology.utils.UserContextHolder;
import com.netflix.zuul.context.RequestContext;
@Component
public class FilterUtils {
	public static final String CORRELATION_ID="tmx-correlation_id";
	public static final String AUTH_TOKEN= "tmx-auth-token";
	public static final String USER_ID="tmx-user-id";
	public static final String ORG_ID="tmx-org-id";
	public static final String PRE_FILTER_TYPE="pre";
	public static final String POST_FILTER_TYPE="post";
	public static final String ROUTE_FILTER_TYPE="route";
	
	public String getCorrelationId() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		if(currentContext.getRequest().getHeader(CORRELATION_ID)!=null) {
			return currentContext.getRequest().getHeader(CORRELATION_ID);
		}else {
			//return currentContext.getZuulRequestHeaders().get(CORRELATION_ID);
			return UserContextHolder.getContext().getCorrelationId();
		}
	}
	public void setCorrelationId(String correlationId) {
		RequestContext currentContext = RequestContext.getCurrentContext();
		currentContext.addZuulRequestHeader(CORRELATION_ID, correlationId);
	}
	
	public final String getOrgId() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		if(currentContext.getRequest().getHeader(ORG_ID)!=null) {
			return currentContext.getRequest().getHeader(ORG_ID);
		}else {
			return currentContext.getZuulRequestHeaders().get(ORG_ID);
		}
		
	}
	public void setOrgId(String orgId) {
		RequestContext currentContext = RequestContext.getCurrentContext();
		currentContext.addZuulRequestHeader(ORG_ID, orgId);
		
	}
	public void setUserId(String userId) {
		RequestContext currentContext = RequestContext.getCurrentContext();
		currentContext.addZuulRequestHeader(USER_ID, userId);
	}
	
	public final String getUserId() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		if(currentContext.getRequest().getHeader(USER_ID)!=null) {
			return currentContext.getRequest().getHeader(USER_ID);
		}else {
			return currentContext.getZuulRequestHeaders().get(USER_ID);
		}
	}
	public final String getAuthToken() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		return currentContext.getRequest().getHeader(AUTH_TOKEN);
		
	}
	
	public String getServiceId() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		if(currentContext.get("serviceId")==null) return "";
		return currentContext.get("serviceId").toString();
		
	}

}
