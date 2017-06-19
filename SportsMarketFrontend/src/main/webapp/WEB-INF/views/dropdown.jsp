 <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><c:forEach items="${categories}" var="category">
          <a href="${contextRoot}/show/category/${category.id}/products" id="a_${category.name}">${category.name}</a>
          </c:forEach>
          </li>
        </ul>     
         </li>