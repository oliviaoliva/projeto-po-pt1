package daodb4o;


import com.db4o.query.Query;
import modelo.Time;

import java.util.List;

public class DAOTime extends DAO<Time> {
    public Time read(Object chave) {
        String name = (String) chave;
        Query q = manager.query();
        q.constrain(Time.class);
        q.descend("nome").constrain(name);
        List<Time> result = q.execute();
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    public List<Time> LocalTeam (String local) {
        Query q = manager.query();
        q.constrain(Time.class);
        q.descend("jogos").descend("local").constrain(local);
        return q.execute();
        
        
    }
    public List<Time> DataTeam(String data) {
        Query q = manager.query();
        q.constrain(Time.class);
        q.descend("jogos").descend("data").constrain(data);
    }

    public List<Time> EstoqueTeam(int n) {
        Query q = manager.query();
        q.constrain(Time.class);
        q.descend("jogos").descend("estoque").constrain();
    }

    class Filtro implements Evaluation {
        public Filtro() {}

        public void evaluate(Candidate candidate) {
            Time time = (Time) candidate.getObject();
            candidate.include(> 0);
        }
    }
}
