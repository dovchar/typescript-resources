<h1>TypeScript resource plugin</h1>

This plugin can help you compile typescript source in your grails application.

<h3>Dependency:</h3>

	nodejs >= v0.8.10
	npm >= 1.1.60
	typescript >= 0.8.3.0
	grails >= 2.2.0
	grails resources >= 1.1.0
	typescript resources >= 0.3.7

<h3>Instalation:</h3>

1. <a href="http://nodejs.org/">node.js</a>
2. <a href="http://nodejs.org/download/">npm</a>
3. <a href="http://www.typescriptlang.org/#Download">typescript</a>

Check typescript:

	tsc -v //0.8.x

Create grails application:

	grails create-app [APP_NAME]

<h3>Configure:</h3>

Open /grails-app/conf/BuildConfig.groovy. In plugins hash after runtime ":resources:1.1.6" add

	runtime ":typescript:0.3.9"

And start your application:

	grails run-app

<h3>Using:</h3>

Open /grails-app/conf/ApplicationResources.groovy. Put this lines in to it:

	modules = {
    	application {
        	resource url:'js/application.js'
        	resource url:'js/app.ts', attrs: [type:'js']
        	resource url:'js/main.ts', attrs: [type:'js']
    	}
	}

After go to your web-app/js folder and create app.ts and main.ts

app.ts example:

	module Sayings {
    	export class Greeter {
        	greeting: string;
        	constructor(message: string) {
            	this.greeting = message;
        	}
        	greet() {
            	return "Hello, " + this.greeting;
        	}
			}
	}

	var greeter = new Sayings.Greeter("world");
	var button = document.createElement('button');

	button.innerText = "Say Hello";

	button.onclick = function() {
    	alert(greeter.greet());
	};

	document.body.appendChild(button);

And when you will review your html source in browser you could see

	<script src="/js/app.js" />

app.js file:

	var Sayings;
	(function (Sayings) {
    var Greeter = (function () {
        function Greeter(message) {
            this.greeting = message;
        }
        Greeter.prototype.greet = function () {
            return "Hello, " + this.greeting;
        };
        return Greeter;
    })();
    Sayings.Greeter = Greeter;
	})(Sayings || (Sayings = {}));
	var greeter = new Sayings.Greeter("world");
	var button = document.createElement('button');
	button.innerText = "Say Hello";
	button.onclick = function () {
    	alert(greeter.greet());
	};
	document.body.appendChild(button);

Contributing

Fork it
Create your feature branch (git checkout -b my-new-feature)
Commit your changes (git commit -am 'Added some feature')
Push to the branch (git push origin my-new-feature)
Create new Pull Request

<h3>License</h3>
Copyright (c) 2013 Dmytro Ovcharenko Licensed under the MIT license.