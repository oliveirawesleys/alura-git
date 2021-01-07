package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.MediaComData;

import javax.persistence.*;
import java.util.List;

public class TestaMediaDiariaDasMovimentacoes {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String jpql = "select  new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

        TypedQuery query = em.createQuery(jpql, MediaComData.class);
        List<MediaComData> mediaDasMovimentacoes = query.getResultList();

        for (MediaComData resultado : mediaDasMovimentacoes) {
            System.out.println("A média das movimentações do dia " + resultado.getDia() + "/" + resultado.getMes() + " é: " + resultado.getValor());
        }

    }
}
