package com.csesteel.common.request;

import java.io.Serializable;

public class RequestHeader  implements Serializable{
	private String requestURI;
	private StringBuffer requestURL;
	private String contextPath;
	private String servletPath;
	private String remoteAddr;
	private String localAddr;
	private String serverName;
	private int serverPort;
	private String scheme;
	private String remoteHost;
	private String method;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getRequestURI() {
		return requestURI;
	}
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	public StringBuffer getRequestURL() {
		return requestURL;
	}
	public void setRequestURL(StringBuffer requestURL) {
		this.requestURL = requestURL;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public String getServletPath() {
		return servletPath;
	}
	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}
	public String getRemoteAddr() {
		return remoteAddr;
	}
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	public String getLocalAddr() {
		return localAddr;
	}
	public void setLocalAddr(String localAddr) {
		this.localAddr = localAddr;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getRemoteHost() {
		return remoteHost;
	}
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	@Override
	public String toString() {
		return "RequestHeader [requestURI=" + requestURI + ", requestURL=" + requestURL + ", contextPath=" + contextPath
				+ ", servletPath=" + servletPath + ", remoteAddr=" + remoteAddr + ", localAddr=" + localAddr
				+ ", serverName=" + serverName + ", serverPort=" + serverPort + ", scheme=" + scheme + ", remoteHost="
				+ remoteHost + "]";
	}
}
