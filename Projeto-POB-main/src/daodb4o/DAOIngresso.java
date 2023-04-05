package daodb4o;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;
import modelo.Ingresso;

import java.util.List;

public class DAOIngresso extends DAO<Jogo> {
    public Ingresso read(Object chave) {
        int id = (int) chave;
        Query q = manager.query();
        q.constrain(Ingresso.class);
        q.descend("codigo").constrain(id);
        List<Time> result = q.execute();
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }
}
