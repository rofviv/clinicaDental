package presentacion;

import datos.ConsultasSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClinicaDental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConsultasSQL c = new ConsultasSQL();
        ResultSet rs = c.mostrarPacientes();
        try {
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicaDental.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
