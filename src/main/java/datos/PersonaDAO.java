/*
    Video 192
 */
package datos;

import domain.PersonaDTO;
import java.sql.SQLException;
import java.util.List;

public interface PersonaDAO {

    public List<PersonaDTO> select() throws SQLException;

    public int insert(PersonaDTO persona) throws SQLException;

    public void update(int idPersona, PersonaDTO persona) throws SQLException;

    public void delete(int idPersona) throws SQLException;
}
