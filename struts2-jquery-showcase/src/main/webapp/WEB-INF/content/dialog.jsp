<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<h2>Dialog</h2>
<p class="text">
    A simple Dialog with local content.
</p>
<sj:dialog id="mydialog_%{sequence}" title="Dialog with local content">
 Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
</sj:dialog>

<sj:dialog title="Dialog with autogenerated ID">
 Dialog has autogenerated ID
</sj:dialog>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
    <pre>
    <code class="html">
&lt;sj:dialog id="mydialog_<s:text name="%{sequence}"/>" title="Dialog with local content"&gt;
    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
&lt;/sj:dialog&gt;
    </code>
    </pre>
    <pre>
    <code class="html">
&lt;sj:dialog title="Dialog with autogenerated ID"&gt;
    Dialog has autogenerated ID
&lt;/sj:dialog&gt;
    </code>
    </pre>
</div>
