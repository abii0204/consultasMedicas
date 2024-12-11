package org.dam47.DAO;

import org.dam47.database.Conexion;
import org.dam47.models.MedicoModel;

import java.sql.*;
import java.util.ArrayList;

public class ConsultasDAO extends Conexion {

//    public ArrayList<String> getMedicos() throws SQLException {
//        ArrayList<String>medicos=new ArrayList<>();
//
//        if(!initDBConnection()){
//            throw new SQLException("Error al conectar con la base de datos");
//        }
//        try {
//            String consulta = "SELECT nombre FROM medicos";
//            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//                    medicos.add(resultSet.getString("nombre"));
//            }
//        }catch (SQLException e){
//            throw new SQLException("Error al conectar con la base de datos");
//        }finally {
//            closeDBConnection();
//        }
//
//        return medicos;
//    }



    public ArrayList<MedicoModel> getMedicosLista() throws SQLException {
        ArrayList<MedicoModel> medicosLista = new ArrayList<>();

        if (!initDBConnection()) {
            throw new SQLException("Error al conectar con la base de datos");
        }
        try {
            String consulta = "SELECT id_medico, nombre FROM medicos";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MedicoModel medico = new MedicoModel();
                medico.setId(resultSet.getInt("id_medico"));
                medico.setNombre(resultSet.getString("nombre"));
                medicosLista.add(medico);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al consultar los médicos", e);
        } finally {
            closeDBConnection();
        }

        return medicosLista;
    }

    public boolean crearConsulta(String token, String usuario, int idMedico, Date fecha, Time hora) throws SQLException {
        boolean resultado = false;

        try {
            // Inicializar la conexión a la base de datos
            if (!initDBConnection()) {
                throw new SQLException("Error al conectar con la base de datos");
            }

            // Preparar la consulta SQL
            String sql = "SELECT crearConsulta(?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, token);
            ps.setString(2, usuario);
            ps.setInt(3, idMedico);
            ps.setDate(4, fecha);
            ps.setTime(5, hora);

            // Imprimir consulta y parámetros para depuración
            System.out.println("Ejecutando consulta SQL: " + sql);
            System.out.println("Parámetros: token=" + token + ", usuario=" + usuario + ", idMedico=" + idMedico + ", fecha=" + fecha + ", hora=" + hora);

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = rs.getBoolean(1); // Obtener el resultado de la función
                System.out.println("Resultado de la función: " + resultado);
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta:");
            e.printStackTrace();
            throw e;
        } finally {
            closeDBConnection(); // Cerrar la conexión
        }

        return resultado;
    }



}





