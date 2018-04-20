<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/user/login" var="userLoginUrl" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Главная</title>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="theme-color" content="#000000">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet/less" href="styles.less">
	<script>less = { env: 'development' };</script>
	<script src="less.js"></script>
	<script>less.watch()</script>
    <script src="https://unpkg.com/react@16/umd/react.development.js"></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js"></script>
    <script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
    <style type="text/css">
	    .bs-example{
	    	margin: 20px;
	    }
	</style>
</head>
    <body>

		<div style="text-align: center;"><img src='<spring:url value="/resources/th1.jpeg"/>'></div><br>
    
        <div class="bs-example">
		    <form action="${userLoginUrl}" method="post">
		        <div class="form-group">
		            <label for="inputEmail">Логин</label>
		            <input type="text" class="form-control" id="login" name="login" placeholder="Логин" required>
		        </div>
		        <div class="form-group">
		            <label for="inputPassword">Пароль</label>
		            <input type="password" class="form-control" id="password" name="password" placeholder="Пароль" required>
		        </div>
		        <button type="submit" class="btn btn-primary">Войти</button>
		    </form>
		</div>
        <div id="root"></div>
	    <script type="text/babel">
            class App extends React.Component {
			  render() {
				return (
				  <div className="App">
					<header className="App-header">
					  <img src={logo} className="App-logo" alt="logo" />
					  <h1 className="App-title">Welcome to React</h1>
					</header>
					<p className="App-intro">
					  To get started, edit <code>src/App.js</code> and save to reload.
					</p>
				  </div>
				);
			  }
			}
		
            ReactDOM.render(
                <App />,
                document.getElementById('root')
            );

        </script>
    </body>
</html>