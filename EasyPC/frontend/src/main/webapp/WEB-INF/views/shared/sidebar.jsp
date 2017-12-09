


<h1 class="my-4"></h1>
<div class="list-group">




	<c:forEach items="${categories}" var="category">

		<c:choose>
			<c:when test="${category.id==1}">
				<c:set var="ActiveStat" value="${Status1}" />
			</c:when>
			
			<c:when test="${category.id==2}">
				<c:set var="ActiveStat" value="${Status2}" />
			</c:when>
			
			<c:when test="${category.id==3}">
				<c:set var="ActiveStat" value="${Status3}" />
			</c:when>
			
			<c:when test="${category.id==4}">
				<c:set var="ActiveStat" value="${Status4}" />
			</c:when>
			
			<c:when test="${category.id==5}">
				<c:set var="ActiveStat" value="${Status5}" />
			</c:when>
			
			<c:when test="${category.id==6}">
				<c:set var="ActiveStat" value="${Status6}" />
			</c:when>
			
			<c:when test="${category.id==7}">
				<c:set var="ActiveStat" value="${Status7}" />
			</c:when>
			
			<c:when test="${category.id==8}">
				<c:set var="ActiveStat" value="${Status8}" />
			</c:when>
			
			<c:when test="${category.id==9}">
				<c:set var="ActiveStat" value="${Status9}" />
			</c:when>
			

			<c:otherwise>
				<c:set var="ActiveStat" value="null" />
			</c:otherwise>

		</c:choose>

			<a href="${contextRoot}/show/category/${category.id}/products"
			class="list-group-item ${ActiveStat}">${category.name}</a>

	</c:forEach>




</div>


