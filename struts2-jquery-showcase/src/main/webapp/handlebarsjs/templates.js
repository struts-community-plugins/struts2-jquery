(function () {
// Source: D:\flore\git\struts2-jquery\struts2-jquery-showcase\src\main\webapp\handlebarsjs\customer-template.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<h3>Customer Data</h3>\r\n<p>ID        : "
    + container.escapeExpression(container.lambda(((stack1 = (depth0 != null ? depth0.myCustomer : depth0)) != null ? stack1.id : stack1), depth0))
    + " </p>\r\n<p>Name      : "
    + container.escapeExpression(container.lambda(((stack1 = (depth0 != null ? depth0.myCustomer : depth0)) != null ? stack1.name : stack1), depth0))
    + " </p>\r\n<p>Last Name : "
    + container.escapeExpression(container.lambda(((stack1 = (depth0 != null ? depth0.myCustomer : depth0)) != null ? stack1.lastName : stack1), depth0))
    + " </p>";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['customer-template'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['customer-template'] = template;


// Source: D:\flore\git\struts2-jquery\struts2-jquery-showcase\src\main\webapp\handlebarsjs\simple-template.hbs

  var template = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "Hello from a remote Handlebar.js template !\r\n\r\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},depth0,{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"1":function(container,depth0,helpers,partials,data) {
    return "<li>"
    + container.escapeExpression(container.lambda(depth0, depth0))
    + "</li>\r\n";
},"useData":true});
  var templates = Handlebars.templates = Handlebars.templates || {};
  templates['simple-template'] = template;
  var partials = Handlebars.partials = Handlebars.partials || {};
  partials['simple-template'] = template;



})();