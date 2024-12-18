package datos;

import java.sql.ResultSet;

public class ConsultasSQL {

    ConexionSQL cn = new ConexionSQL();
    ResultSet rs;
    String sql;

    public ConsultasSQL() {
        this.sql = "";
    }

    public ResultSet mostrarPacientes() {
        sql = "SELECT * FROM paciente;";
        return cn.mostrar(sql);
    }

    public void nuevoPaciente(int ci, String nombre, String apell, String fechaNac, String genero, int cel, int fijo, String seguro) {
        sql = "INSERT INTO paciente VALUES (" + ci + ", '" + nombre + "', '" + apell + "', '" + fechaNac + "', '"
                + genero + "', " + cel + ", " + fijo + ", '" + seguro + "');";
        cn.ejecutar(sql);
    }

    public void editarPaciente(int ci1, int ci2, String nombre, String apell, String fechaNac, String genero, int cel, int fijo, String seguro) {
        sql = "UPDATE paciente SET ci = " + ci2 + ", nombre = '" + nombre + "', apellidos = '" + apell
                + "', fechaNac = '" + fechaNac + "', genero = '" + genero + "', telfMovil = " + cel + ", telfFijo = " + fijo
                + ", seguroMedico = '" + seguro + "' WHERE ci = " + ci1 + ";";
        cn.ejecutar(sql);
    }

    public void eliminarPaciente(String nombre) {
        sql = "DELETE FROM paciente WHERE nombre = '" + nombre + "';";
        cn.ejecutar(sql);
    }

    public ResultSet mostrarDentista() {
        sql = "SELECT * FROM dentista;";
        return cn.mostrar(sql);
    }

    public ResultSet obtenerNombrePacienteConCI(int ci) {
        sql = "SELECT nombre FROM paciente WHERE ci = " + ci;
        return cn.mostrar(sql);
    }

    public ResultSet mostrarDentista_Especialidad(int ciDent) {
        sql = "SELECT d.nombre, e.especialidad FROM dentista AS d, especialidad AS e, dentista_especialidad AS de "
                + "WHERE de.ciDent = d.ci AND de.idEsp = e.id AND d.ci = " + ciDent + ";";
        return cn.mostrar(sql);
    }

    public void nuevoDentista(int ci, String nombre, String apell, String dir, String fechaNac, String fechaIngr, String genero,
            int cel, int fijo, String ciudad, String email) {
        sql = "INSERT INTO dentista VALUES (" + ci + ", '" + nombre + "', '" + apell + "', '" + dir + "', '" + fechaNac + "', '"
                + fechaIngr + "', '" + genero + "', " + cel + ", " + fijo + ", '" + ciudad + "', '" + email + "', NULL);";
        cn.ejecutar(sql);
    }

    public ResultSet obtenerNombreDentistaConCI(int ci) {
        sql = "SELECT nombre FROM dentista WHERE ci = " + ci;
        return cn.mostrar(sql);
    }

    public void guardarEspecialidad(int ciDent, int idEsp) {
        sql = "INSERT INTO dentista_especialidad VALUES (" + ciDent + ", " + idEsp + ");";
        cn.ejecutar(sql);
    }

    public ResultSet obtenerIdEsp(String especialidad) {
        sql = "SELECT id FROM especialidad WHERE especialidad = '" + especialidad + "';";
        return cn.mostrar(sql);
    }

    public void eliminarDentista(String nombre) {
        sql = "DELETE FROM dentista WHERE nombre = '" + nombre + "';";
        cn.ejecutar(sql);
    }

    public void eliminarFKdent_esp(int ciDent) {
        sql = "DELETE FROM dentista_especialidad WHERE ciDent = " + ciDent;
        cn.ejecutar(sql);
    }

    public ResultSet mostrarEspecialidades() {
        sql = "SELECT especialidad FROM especialidad;";
        return cn.mostrar(sql);
    }

    public ResultSet mostrarConsulta() {
        sql = "SELECT * FROM consulta;";
        return cn.mostrar(sql);
    }

    public ResultSet obtenerNombreTratamiento(int id) {
        sql = "SELECT tratamiento FROM tratamiento WHERE id = " + id;
        return cn.mostrar(sql);
    }
    
    public ResultSet mostrarTratamientos() {
        sql = "SELECT * from tratamiento;";
        return cn.mostrar(sql);
    }
    
    public void nuevaFactura(String formaPago) {
        sql = "INSERT INTO factura VALUES (NULL, '" + formaPago + "', 'Pendiente');";
        cn.ejecutar(sql);
    }
    
    public void nuevaConsulta(String fecha, String hora, double importe, String sintomas,
            int ciPac, int ciDent, int idTrat) {
        sql = "INSERT INTO consulta VALUES(NULL, '" + fecha + "', '" + hora + "', 'Pendiente', " + importe 
                + ", '" + sintomas + "', " + ciPac + ", " + ciDent + ", " + idTrat + ", NULL);";
        cn.ejecutar(sql);
    }
    
    public ResultSet obtenerCIPaciente(String nombre) {
        sql = "SELECT ci FROM paciente WHERE nombre = '" + nombre + "';";
        return cn.mostrar(sql);
    }
    
    public ResultSet obtenerCIDentista(String nombre) {
        sql = "SELECT ci FROM dentista WHERE nombre = '" + nombre + "';";
        return cn.mostrar(sql);
    }
    
    public ResultSet obtenerIDTratamiento(String tratamiento) {
        sql = "SELECT id FROM tratamiento WHERE tratamiento = '" + tratamiento + "';";
        return cn.mostrar(sql);
    }
    
}
