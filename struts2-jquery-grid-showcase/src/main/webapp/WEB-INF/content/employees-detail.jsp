<%@ taglib prefix="s" uri="/struts-tags"%>

<table>
	<tr>
		<td>Number : </td>
		<td><s:property value="employee.employeenumber"/></td>
	</tr>
	<tr>
		<td>Lastname : </td>
		<td><s:property value="employee.lastname"/></td>
	</tr>
	<tr>
		<td>Firstname : </td>
		<td><s:property value="employee.firstname"/></td>
	</tr>
	<tr>
		<td>Jobtitle : </td>
		<td><s:property value="employee.jobtitle"/></td>
	</tr>
	<tr>
		<td>Email : </td>
		<td><s:property value="employee.email"/></td>
	</tr>
</table>
