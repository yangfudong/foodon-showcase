require.config({
    baseUrl: "../lib/",
    paths: {
        domReady: "require/1.2.26/domReady.js",
        jquery: "jquery/1.10.2/jquery.min",
        angular: "angular/1.2.26/angular.min",
        angularResource: "angular/1.2.26/angular-resource.min",
        twitter: "bootstrap/2.3.2/js/bootstrap.min"
    }
});

require(["jquery"], function ($) {
    alert($().jquery);
});