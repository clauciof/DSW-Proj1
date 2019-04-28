package bean;

import DAO.PromocaoDAO;
import DAO.SalaDAO;
import DAO.SiteDAO;
import java.util.List;
import model.SalaTeatro;

public class DynamicSelectBean {

    public List<SalaTeatro> getTeatros() {
        SalaDAO saladao = new SalaDAO();
        return saladao.getAlmostAll();
    }

   
}
