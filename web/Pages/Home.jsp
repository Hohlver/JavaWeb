<%-- 
    Document   : Home
    Created on : 08-07-2024, 16:48:41
    Author     : Ethan
--%>

<%@page import="java.util.List"%>
<%@page import="model.Usuario"%>
<%@page import="service.DAOUsuario"%>
<%@page import="db.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Usuarios</title>
    <link rel="stylesheet" href="../css/materialize.css"/>
</head>
<body>
    
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Minimarket</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="#">Usuarios</a></li>
                <li><a href="../Logout.do">Cerrar Sesion</a></li>
            </ul>
        </div>
    </nav>

    <%
        Usuario oUsuario1 = (Usuario) session.getAttribute("Usuario");
        if (oUsuario1==null) {
                response.sendRedirect("../index.jsp?error=1");
                return;
            }
    %>
    
    <%
        Conexion oConexion= Conexion.getInstance();
        DAOUsuario oDAOUsuario = new DAOUsuario(oConexion);
        List<Usuario> oList = oDAOUsuario.getAll().get();
    %>

    <div class="container">   
        <h3>Sesion Activa: <%=oUsuario1.getNombreUs()%></h3>
        <div class="row">
            <div class="col s12 m4 l4">
                <div class="card-panel">
                    <h4>Crear usuario</h4>
                    <form name="datosUs" method="post" action="../InsertarUsuario.do">
                        <div class="input-field">
                            <input id="nombreUsuario" type="text" name="txtNombre" placeholder="Nombre">
                            
                        </div>
                        <div class="input-field">
                            <input id="rutUsuario" type="text" name="txtRut" placeholder="Rut">
                            
                        </div>
                        <div class="input-field">
                            <input id="correoUsuario" type="email" name="txtCorreo" placeholder="Correo">
                           
                        </div>
                        <div class="input-field">
                            <input id="passUsuario" type="password" name="txtPass" placeholder="Contraseña">
                            
                        </div>
                        <button class="btn waves-effect waves-light" type="submit" name="action">Crear</button>
                    </form>
                </div>
            </div>

          
            <div class="col s12 m8 l8">
                <div class="card-panel">
                    <h4>Lista Usuarios</h4>
                    <table class="responsive-table">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Rut</th>
                                <th>Correo</th>
                                <th>Contraseña</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Usuario oUsuario : oList) { %>
                            <tr>
                                <td><%= oUsuario.getId() %></td>
                                <td><%= oUsuario.getNombreUs() %></td>
                                <td><%= oUsuario.getRutUs() %></td>
                                <td><%= oUsuario.getCorreoUs() %></td>
                                <td><%= oUsuario.getPassUs() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
       
        <div class="row">
            <div class="col s12 m6">
                <div class="card-panel">
                    <h4>Actualizar Usuario</h4>
                    <form method="post" action="../ActualizarUsuario.do">
                        <div class="input-field">
                            <input id="idAct" type="number" name="txtIdAct" placeholder="Id">
                        </div>
                        <div class="input-field">
                            <input id="nombreAct" type="text" name="txtNombreAct" placeholder="Nombre">
                        </div>
                        <div class="input-field">
                            <input id="rutAct" type="text" name="txtRutAct" placeholder="Rut">
                        </div>
                        <div class="input-field">
                            <input id="correoAct" type="email" name="txtCorreoAct" placeholder="Correo">
                        </div>
                        <div class="input-field">
                            <input id="passAct" type="password" name="txtPassAct" placeholder="Contraseña">
                        </div>
                        <button class="btn waves-effect waves-light" type="submit" name="action">Actualizar</button>
                    </form>
                </div>
            </div>
            <div class="col s12 m6">
                <div class="card-panel">
                    <h4>Eliminar Usuario</h4>
                    <form method="post" action="../EliminarUsuario.do">
                        <div class="input-field">
                            <input id="idUsuarioE" type="number" name="txtIdE" placeholder="Id">
                        </div>
                        <button class="btn waves-effect waves-light" type="submit" name="action">Eliminar</button>
                    </form>
                </div>
            </div>
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
</body>
</html>

