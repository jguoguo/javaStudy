Struts2的Action访问Servlet API

可以通过ServletActionContext提供的静态方法取得Servlet API

	*getPageContext()
	*getRequest();
	*getResponse();
	*getServletContext();