var http = require('http');  
var os = require("os");
var hostname = os.hostname();
  
http.createServer(function (req, res) { 
	res.writeHead(200, { 'Content-Type': 'text/html' }); 
	res.write (`<h1>${process.env.MESSAGE}</h1>`); 
    res.write('Mi primer App Desplegada en K8S'+'<br>'); 
    res.write(hostname);  
    res.end(); 
}).listen(5000); 
  

console.log('port:5000'); 