package dao;

import modelo.Usuario;
import util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // LISTAR USUARIOS
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFechaCreacion(rs.getDate("fecha_creacion"));
                u.setEstado(rs.getBoolean("estado"));

                lista.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // GUARDAR USUARIO
   public int guardar(Usuario u) {
    String sql = "INSERT INTO usuario(nombre, email, password, fecha_creacion, estado) VALUES (?, ?, ?, ?, ?)";

    try {
        con = Conexion.getConexion();
        ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, u.getNombre());
        ps.setString(2, u.getEmail());
        ps.setString(3, u.getPassword());
        ps.setDate(4, new java.sql.Date(u.getFechaCreacion().getTime()));
        ps.setBoolean(5, u.isEstado());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // ID DEL USUARIO
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

}
