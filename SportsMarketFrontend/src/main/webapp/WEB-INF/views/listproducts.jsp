<div class="container">


	<div class="row">
	
	    <c:if test="${not empty message}">
     
     <div class=col-xs-12>
     
       <div class="alert alert-success alert-dismissible">
       
        <button type="button" class="close" data-dismiss="alert">&times;</button>    
         
         ${message}
       
       </div>
         
     </div>  
       </c:if>

		<div class="col-md-9">
			<!-- added breadcrumb component -->
			<div class="row">

				<div class="co-lg-12">

					<c:if test="${userClickAllProducts==true}">
						<ol class="breadcrumb">
                         
                        <script>
						window.categoryId = '';
						</script>

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Products</li>


						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts==true}">
						<ol class="breadcrumb">
                          
                        <script>
						window.categoryId= '${category.id}';
						</script>
                          
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if>


				</div>

			</div>

  
            <div class="container">

               <div class="table-responsive">
               
               
					<table id="productListTable"
						class="table table-striped table-borderd">


						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty.Available</th>
								<th></th>

							</tr>
						</thead>
						<tfoot>
							<tr>
                                <th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty.Available</th>
                                <th></th>
							</tr>
						</tfoot>
					</table>
                 </div>
			
			
				</div>

			</div>

		</div>



	</div>



    	