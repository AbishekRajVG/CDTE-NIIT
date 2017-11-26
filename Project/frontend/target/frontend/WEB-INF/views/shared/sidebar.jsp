<h1 class="my-4">Shop Name</h1>
<div class="list-group">

	<c:forEach items="${categories}" var="cat">
		<a href="#" class="list-group-item">${cat.name}</a>
	</c:forEach>
</div>

