TypeScript resource plugin 
This plugin can help you compile typescript source in your grails application. 

This plugin used:

	nodejs >= v0.8.10
	npm >= 1.1.60
	typescript >= 0.8.3.0
	grails >= 2.2.0
	grails resources >= 1.1.0 

Dependency :

	runtime ":typescript:0.3"

Instalation:

	1. node.js (http://nodejs.org/)
	2. npm (http://nodejs.org/download/)
	3. typescript (http://www.typescriptlang.org/#Download)

Check typescript:
	
	tsc -v //0.8.x

Create grails application:
	
	grails create-app [APP_NAME]
 
Configure:
Open /grails-app/conf/BuildConfig.groovy. In plugins hash after runtime ":resources:1.1.6" add 		

	runtime ":typescript:0.3"

And start your application: 

	grails run-app 

Start using: 
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

And when you will review your html source in browser you could see <script src="/js/app.js" />

app.js source:

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