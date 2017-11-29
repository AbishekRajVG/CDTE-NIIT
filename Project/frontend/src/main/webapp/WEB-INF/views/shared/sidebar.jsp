


<h1 class="my-4"></h1>
<div class="list-group">



	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products"
			class="list-group-item ${category.status}">${category.name}</a>
		</c:forEach>	
			
			

<c:forEach items="${categories}" var="category">
			${category.status=null};
	</c:forEach>
</div>

<!-- yolo -->