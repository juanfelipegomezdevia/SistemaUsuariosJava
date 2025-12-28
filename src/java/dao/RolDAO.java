package dao;

import modelo.Rol;
import util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RolDAO {

    public List<Rol> listar() {
        List<Rol> lista = new ArrayList<>();
        String sql = "SELECT * FROM rol";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Rol r = new Rol();
                r.setIdRol(rs.getInt("id_rol"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                lista.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void guardar(Rol r) {
        String sql = "INSERT INTO rol(nombre, descripcion) VALUES (?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getNombre());
            ps.setString(2, r.getDescripcion());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
