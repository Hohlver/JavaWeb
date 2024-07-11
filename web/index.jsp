<%-- 
    Document   : index
    Created on : 08-07-2024, 16:48:02
    Author     : Ethan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesion</title>
        <link rel="stylesheet" href="css/materialize.css"/>
    </head>
    
        <nav>
            <div class="nav-wrapper">  
                <a href="#" class="brand-logo">Minimarket</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                </ul>
            </div>
        </nav>
        

            <div class="row center">
                <h4>Iniciar sesion</h4>
                <div class="row">
                    <form class="col s12" method="post" name="datosUs" action="Login.do">
                        <div class="row">
                            <input id="rutUs" type="text" onchange="javascript:return Rut(document.datosUser.txt_rut.value)" name="txtRut" class="validate">
                            <label for="rutUs">Rut</label>
                        </div>
                        <div class="row">
                            <input id="passUs" type="password" name="txtPass" class="validate">
                            <label for="passUs">Contraseña</label>
                        </div>
                        <div>
                            <button class="btn waves-effect waves-light" type="submit" name="action">Ingresar</button>
                        </div>
                   </form>    
                    <%
                    
                        String err= request.getParameter("err");
                        if (err!=null) {
                    %>
                    <p style="color: red">Credenciales invalidas...</p>
                    <%
                            }
                    %>
                    
                </div>               
            </div>
        
    <footer class="page-footer">
        <div class="container">
            <div class="row">
                <div class="col l6 s12">
                    <h5 class="white-text">Footer Content</h5>
                    <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
                </div>
                <div class="col l4 offset-l2 s12">
                    <h5 class="white-text">Links</h5>
                </div>
            </div>
        </div>
        <div class="footer-copyright">
            <div class="container">
                © 2024 Copyright Text
                <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
        </div>
    </footer>
    
</html>
