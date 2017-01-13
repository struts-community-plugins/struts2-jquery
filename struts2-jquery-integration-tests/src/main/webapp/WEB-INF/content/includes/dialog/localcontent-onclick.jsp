<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<sj:dialog id="mydialog" title="Dialog with local content" modal="true" autoOpen="false">
  This is the local content.
</sj:dialog>
<sj:a id="modalOpenLink" openDialog="mydialog" button="true" buttonIcon="ui-icon-newwin" >
    Open modal dialog
</sj:a>

