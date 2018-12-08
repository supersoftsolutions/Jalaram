<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<head>

							<f:form class="cmxform form-horizontal" modelAttribute="list"
								id="signupForm" method="post" action="form.html"
								novalidate="">
								<f:hidden path="ID" />
								<div class="form-group ">
									<label for="name" class="control-label col-lg-3">Name*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" name="name" path="name"
											readOnly="true" type="text" required="required" />
									</div>
								</div>

								<div class="form-group ">
									<label for="address1" class="control-label col-lg-3">Address1*</label>
									<div class="col-lg-6">
										<f:input path="address1" class=" form-control" readOnly="true"
											type="text" required="required" />
									</div>
								</div>

								<div class="form-group ">
									<label for="address2" class="control-label col-lg-3">Address2</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="address2" readOnly="true"
											path="address2" type="text" />
									</div>
								</div>

								<div class="form-group ">
									<label for="address3" class="control-label col-lg-3">Address3</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="address3" readOnly="true"
											path="address3" type="text" />
									</div>
								</div>

								<div class="form-group ">
									<label for="mobile" class="control-label col-lg-3">Mobile*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="mobile" path="mobile"
											readOnly="true" type="text" required="required" />
									</div>
								</div>

								
								<div class="form-group ">
									<label for="mobile" class="control-label col-lg-3">Priority*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="priority" path="priority"
											readOnly="true" type="text" required="required" />
									</div>
								</div>
								<div class="form-group ">
									<label for="patra" class="control-label col-lg-3">Patra*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="patra" path="patra"
											readOnly="true" type="text" required="required" />
									</div>
								</div>

								<div class="form-group ">
									<label for="khaman" class="control-label col-lg-3">Khaman*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="khaman" path="khaman"
											readOnly="true" type="text" required="required" />
									</div>
								</div>

								<div class="form-group ">
									<label for="nylon" class="control-label col-lg-3">Nylon*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="nylon" path="nylon"
											readOnly="true" type="text" required="required" />
									</div>
								</div>

								<div class="form-group ">
									<label for="idada" class="control-label col-lg-3">Idada*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="idada" path="idada"
											readOnly="true" type="text" required="required" />
									</div>
								</div>

								<div class="form-group ">
									<label for="khandvi" class="control-label col-lg-3">Khandvi*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="khandvi" path="khandvi"
											readOnly="true" type="text" required="required" />
									</div>
								</div>

								<div class="form-group ">
									<label for="sandwich_dhokla" class="control-label col-lg-3">Sandwich
										Dhokla*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="sandwich_dhokla"
											path="sandwich_dhokla" readOnly="true" type="text"
											required="required" />
									</div>
								</div>

								<div class="form-group ">
									<label for="sp_patra" class="control-label col-lg-3">SP
										Patra*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="sp_patra" path="sp_patra"
											readOnly="true" type="text" required="required" />
									</div>
								</div>
	

								<div class="form-group ">
									<label for="samosa" class="control-label col-lg-3">Samosa*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="samosa" path="samosa"
											readOnly="true" type="text" required="required" />
									</div>
								</div>

								<div class="form-group ">
									<label for="balance" class="control-label col-lg-3">Opening
										Balance*</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="balance" path="balance"
											readOnly="true" type="text" required="required" />
									</div>
								</div>


							
							</f:form>
					
</body>
</html>