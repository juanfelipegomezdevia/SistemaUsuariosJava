package dao;

import util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioRolDAO {

    public void asignar(int idUsuario, int idRol) {
        String sql = "INSERT INTO usuario_rol(id_usuario, id_rol) VALUES (?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ps.setInt(2, idRol);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
