
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="list" value="${purcahselist}"></c:set>

<c:set var="index" value="${f:length(list)}"></c:set>

[

	<c:forEach items="${list}" var="x" varStatus="counter">

		{
			  "id":"${x.creditorid}",
              "name":"${x.Name}"
              <%-- System.out.println(${x.Name}); --%>
              
              <c:out value="${x.Name}"/> 
		}

		<c:if test="${index ne counter.count}">,</c:if>

	</c:forEach>

]

