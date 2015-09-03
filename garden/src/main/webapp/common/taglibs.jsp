<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${pageContext.request.contextPath == '/'}">
	<c:set var="ctx" value="" />
</c:if>
<c:if test="${pageContext.request.contextPath != '/'}">
	<c:set var="ctx" value="${pageContext.request.contextPath }" />
</c:if>

