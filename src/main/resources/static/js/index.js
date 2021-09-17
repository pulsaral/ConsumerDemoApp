$( window ).ready(function() {
  connect();
});

function connect() {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
      stompClient.subscribe('/topic/pushNotification', function (notification) {
      	  var message = JSON.parse(notification.body);
      	  
      	  console.log(message);
      	 
      	  if(message.topic === 'testtopic') {
      	  	$('#first-topic').append('<tr><td>' + message.message + '</td></tr>');
      	  } else {
      	  	$('#second-topic').append('<tr><td>' + message.message + '</td></tr>');
      	  }
       });
  });
}